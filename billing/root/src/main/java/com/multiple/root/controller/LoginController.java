package com.multiple.root.controller;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.multiple.common.exception.NoSuchCityException;
import com.multiple.common.exception.NoSuchUserException;
import com.multiple.common.model.Bill;
import com.multiple.common.model.Customer;
import com.multiple.common.model.ProductMaster;
import com.multiple.common.model.User;
import com.multiple.common.model.VariantMaster;
import com.multiple.common.service.BillService;
import com.multiple.common.service.CustomerService;
import com.multiple.common.service.ForgotPasswordAndLoginService;
import com.multiple.common.service.PaymentService;
import com.multiple.common.service.ProductService;
import com.multiple.common.service.UserService;
import com.multiple.common.service.VariantService;
import com.multiple.common.util.PropsValues;
import com.multiple.kernel.exception.BusinessException;
import com.multiple.root.config.MyWebAuthenticationDetails;
import com.multiple.root.util.CustomEncryptorDecryptor;

@Controller
public class LoginController {

//	@Autowired
//	private CaptchaUtil captchaUtil;
// Test
	@Autowired
	private UserService userService;
	@Autowired
	CustomerService customerservice;
	@Autowired
	ProductService productservice;
	@Autowired
	VariantService variantservice;
	@Autowired
	BillService billservice;
	@Autowired
	PaymentService paymentservice;
	
	
	private SimpleDateFormat ddmmyyyy = new SimpleDateFormat("dd/MM/yyyy");
	
	@Autowired
	private ForgotPasswordAndLoginService forgotPasswordAndLoginService;
	
	@Autowired
	@Qualifier("authManager")
	protected AuthenticationManager authenticationManager;
	
	@Autowired
	private PropsValues propsValue;
	
	@RequestMapping("/LoginPage")
	public String LoginPage(@RequestParam(value = "success", required = false, defaultValue = "") String success,
			@RequestParam(value = "error", required = false, defaultValue = "") String error,
			Map<String, Object> model){
		model.put("error", error);
		model.put("success", success);
		return "esign/login";
	}
	
/*	@RequestMapping("/showLog")
	public String showLog(
			@RequestParam("id") Long id, HttpServletRequest request, HttpServletResponse response,
			Map<String, Object> model){
		List<AadhaarAuditDetails> listAadhar = aadharService.findByProjectOrderByCreatedOnDesc("esign");
		model.put("ID", id.toString());
		model.put("listAadhar", listAadhar);
		return "esign/showLog";
	}*/

	@RequestMapping("/Home")
	public String biomInput(
			@RequestParam("ID") Long id, HttpServletRequest request, HttpServletResponse response,
			Map<String, Object> model){
		model.put("ID", id.toString());
		return "esign/index";
	}
/*	@RequestMapping("/bfdResponse")
	public String bfdResponse(
			@RequestParam("ID") Long id, HttpServletRequest request, HttpServletResponse response,
			Map<String, Object> model){
		model.put("ID", (String)request.getAttribute("ID"));
		request.setAttribute("Uid", (String)request.getAttribute("Uid"));
		request.setAttribute("bfdResponse", (String)request.getAttribute("bfdResponse"));
		return "esign/response";
	}
	@RequestMapping(value="/Response1",method=RequestMethod.POST)
	public String Response(
			@RequestParam("ID") Long id, HttpServletRequest request, HttpServletResponse response,
			Map<String, Object> model){
		model.put("ID", (String)request.getAttribute("ID"));
		request.setAttribute("AuthenticateAadhaar", (String)request.getAttribute("AuthenticateAadhaar"));
		request.setAttribute("AuthenticateStatus", (String)request.getAttribute("AuthenticateStatus"));
		return "esign/response";
	}*/
	@RequestMapping(value="/LoginServlet",method=RequestMethod.POST)
	public String PostLogin(@RequestParam("id")String id,HttpServletRequest request, HttpServletResponse response,Map<String,Object> model,
			@RequestParam("user")String username,@RequestParam("pwd")String pwd){

		HttpSession session = request.getSession(true);
	
		User user1 = new User();
		try {
			user1.setMobile(username);
			user1.setPassword(pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		authenticateUserAndSetSession(user1, request);
		session.setAttribute("user",user1.getUsername() );
		session.setAttribute("id", id);
		model.put("ID", id);
		List<ProductMaster> allProducts = productservice.findAllProducts();
		model.put("allProducts", allProducts);
		
		return "billing/landingPage";
	}

	@RequestMapping("/landingPage")
	public String landingPage(HttpServletRequest request, HttpServletResponse response,
			Map<String, Object> model){
		return "billing/landingPage";
	}
	
	@RequestMapping("/customerList")
	public String customerList(HttpServletRequest request, HttpServletResponse response,
			Map<String, Object> model){
		List<Customer> allCustomers = customerservice.findAllCustomers();
		model.put("allCustomers", allCustomers);
		Customer customer = new Customer();
		model.put("customer", customer);
		return "billing/customerList";
	}
	
	
	@RequestMapping(value="/addCustomer",method=RequestMethod.POST)
	public String addCustomer(@ModelAttribute("customer")Customer customer,HttpServletRequest request, HttpServletResponse response,Map<String,Object> model){

		try {
			customerservice.save(customer);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("****  Error while adding product ****");
		}
		List<Customer> allCustomers = customerservice.findAllCustomers();
		model.put("allCustomers", allCustomers);
		return "billing/customerList";
	}
	
	@RequestMapping("/productList")
	public String productList(@RequestParam(name="id", required=false) Long productId,HttpServletRequest request, HttpServletResponse response,
			Map<String, Object> model){
		List<ProductMaster> allProducts = productservice.findAllProducts();
		model.put("allProducts", allProducts);
		ProductMaster product = new ProductMaster();
		if(productId !=null){
			product = productservice.findById(productId);
		}
		model.put("product", product);
		return "billing/productList";
	}
	
	
	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
	public String addProduct(@ModelAttribute("product")ProductMaster product,HttpServletRequest request, HttpServletResponse response,Map<String,Object> model){

		try {
			if(product.getProductId() ==null){
				productservice.save(product);
			}else{
				productservice.update(product);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("****  Error while adding product ****");
		}
		List<ProductMaster> allProducts = productservice.findAllProducts();
		model.put("allProducts", allProducts);
		return "billing/productList";
	}
	
	@RequestMapping("/variantList")
	public String variantList(HttpServletRequest request, HttpServletResponse response,
			Map<String, Object> model){
		List<ProductMaster> allProducts = productservice.findAllProducts();
		VariantMaster variant = new VariantMaster();
		model.put("allProducts", allProducts);
		model.put("variant", variant);
		return "billing/variantList";
	}
	
	
	@RequestMapping(value="/addVariant",method=RequestMethod.POST)
	public String addVariant(@ModelAttribute("variant")VariantMaster variant,@RequestParam("productId") Long productId,
			HttpServletRequest request, HttpServletResponse response,Map<String,Object> model){

		try {
			ProductMaster product = productservice.findById(productId);
			variant.setProductMaster(product);
			variantservice.save(variant);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("****  Error while adding product ****");
		}
		List<ProductMaster> allProducts = productservice.findAllProducts();
		List<VariantMaster> allVariants = variantservice.findAllVariants();
		model.put("allVariants", allVariants);
		model.put("allProducts", allProducts);
		return "billing/variantList";
	}
	
	@RequestMapping("/billList")
	public String billList(HttpServletRequest request, HttpServletResponse response,
			Map<String, Object> model){
		Bill bill = new Bill();
		List<ProductMaster> allProducts = productservice.findAllProducts();
		List<VariantMaster> allVariants = variantservice.findAllVariants();
		List<Bill> allBills =billservice.findAllBills(); 
		List<Customer> allCustomers = customerservice.findAllCustomers();
		model.put("allCustomers", allCustomers);
		model.put("allVariants", allVariants);
		model.put("allProducts", allProducts);
		model.put("allBills", allBills);
		model.put("bill", bill);
		return "billing/billList";
	}
	
	
	@RequestMapping(value="/addBill",method=RequestMethod.POST)
	public String addbill(@ModelAttribute("bill")Bill bill,@RequestParam("customerId") Long customerId,
			@RequestParam("productId") Long productId,@RequestParam("variantId") Long variantId,
			HttpServletRequest request, HttpServletResponse response,Map<String,Object> model){

		try {
			bill.setCustomer(customerservice.findById(customerId));
			List<ProductMaster> productList = new ArrayList<>();
			productList.add(productservice.findById(productId));
			bill.setProduct(productList);
			List<VariantMaster> variantList = new ArrayList<>();
			variantList.add(variantservice.findById(variantId));
			bill.setVariant(variantList);
			
			billservice.save(bill);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("****  Error while adding product ****");
		}
		List<Bill> allBills =billservice.findAllBills(); 
		List<ProductMaster> allProducts = productservice.findAllProducts();
		List<VariantMaster> allVariants = variantservice.findAllVariants();
		List<Customer> allCustomers = customerservice.findAllCustomers();
		model.put("allVariants", allVariants);
		model.put("allProducts", allProducts);
		model.put("allBills", allBills);
		model.put("allCustomers", allCustomers);
		return "billing/billList";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/demoInput",method=RequestMethod.GET)
	public String demoInput(@RequestParam("id")String id,Map<String,Object> model){
		model.put("ID",id);
		return "esign/demoInput";
	}
	
	@RequestMapping(value="/demoInput2",method=RequestMethod.GET)
	public String demoInput2(@RequestParam("id")String id,Map<String,Object> model){
//		model.put("ID",id);
		return "esign/demoInput";
	}

	@RequestMapping("/customLogin")
	public String customLogin(@RequestParam("userName") String mobileNo,
			@RequestParam("otp") String otp, HttpServletRequest request,HashMap<String, Object> model,
			final RedirectAttributes redirect){
		User user = null; 
		try {
			user = userService.findByMobile(mobileNo);
		} catch (NoSuchUserException e) {
			user = null;
		}
		if(user == null){
			redirect.addFlashAttribute("error", "004");
			return "redirect:/LoginPage";
		} else {
			authenticateUserAndSetSession(user, request);
			return "redirect:/LoanApplicantDetails";
		}
	}
	
	@RequestMapping("/GenerateOTP")
	public String generateOTP() {
		return "common/login/memberLogin";
	}
	
	@ExceptionHandler(BusinessException.class)
	public String handleBusinessException(HttpServletRequest request,
			BusinessException ex) {
		request.setAttribute("errorMsg", ex.getErrorCode());
		return "common/error";
	}

	@RequestMapping("/Index")
	public String home(HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> model)
			throws NoSuchCityException, NoSuchUserException {
		

		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		if(user == null){
			return "redirect:/LoginPage";
		} else {
			return "redirect:/LoanApplicantNavigate";
		}
	}

	@RequestMapping("/ForgotLogin")
	public String forgotLogin(HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> model) {
		return "common/login/forgotLogin";
	}
	
	private User getLogedInUser() {
		User user = null;
		Object object = SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		if (object instanceof User)
			user = (User) object;

		return user;
	}

	@RequestMapping(value = "/Error400")
	public String error400() {
		return "errors/error_400";
	}

	@RequestMapping(value = "/Error401")
	public String error401() {
		return "errors/error_401";
	}

	@RequestMapping(value = "/Error403")
	public String error403() {
		return "errors/error_403";
	}

	@RequestMapping(value = "/Error404")
	public String error404() {
		return "errors/error_404";
	}

	@RequestMapping(value = "/Error500")
	public String error500() {
		return "errors/error_500";
	}

	@RequestMapping(value = "/Error503")
	public String error503() {
		return "errors/error_503";
	}

	private void authenticateUserAndSetSession(User user,
			HttpServletRequest request) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
				user.getUsername(), user.getPassword());

		// generate session if one doesn't exist
		request.getSession();

		token.setDetails(new MyWebAuthenticationDetails(request));
		Authentication authenticatedUser = authenticationManager
				.authenticate(token);

		SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
	}
	
	@RequestMapping(value="/AdminPassword")
	public String adminPass(@RequestParam("id")String id,@RequestParam(value = "success", required = false, defaultValue = "") String success,
			@RequestParam(value = "error", required = false, defaultValue = "") String error,
			Map<String, Object> model){
		model.put("ID", id);
		model.put("error", error);
		model.put("success", success);
		return "esign/adminPasschng";
	}
	
	@RequestMapping(value="/ChangePassword")
	public String changePassAction(@RequestParam("id")String id,@RequestParam(value = "success", required = false, defaultValue = "") String success,
			@RequestParam(value = "error", required = false, defaultValue = "") String error,
			Map<String, Object> model){
		model.put("ID", id);
		model.put("error", error);
		model.put("success", success);
		return "esign/adminPasschng";
	}
	
	
	@RequestMapping(value="/Index",method=RequestMethod.POST)
	public @ResponseBody void afterServiceLogin(HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> model) throws IOException{
		response.getWriter().println("SUCCESS");
	}
}
