package mi.billing.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ProductController {

    @GetMapping("/product")
    @ResponseStatus(value = HttpStatus.OK)
    @Secured({"ROLE_ADMIN"})
    String addProduct(HttpServletRequest request,HttpServletResponse response) {
	   return "product/add";
    }

}
