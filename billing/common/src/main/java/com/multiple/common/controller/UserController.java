package com.multiple.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.multiple.common.exception.NoSuchUserException;
import com.multiple.common.model.User;
import com.multiple.common.model.location.CountryMaster;
import com.multiple.common.service.UserService;

@Controller
@RequestMapping("/User/*")
public class UserController {
	
	@Autowired
	private UserService userServiceImpl;

	@RequestMapping("/")
	public String showHome(HttpServletRequest request, HttpServletResponse response,Model model){
		return "home";
	}
	
	@RequestMapping("/User")
	public ModelAndView userView(HttpServletRequest request, HttpServletResponse response,Model model){
		
		ModelAndView mv = new ModelAndView("/common/user/view","user",new User());
//		mv.addObject("users",userServiceImpl.findByStatus());
		return mv;
	}
	
	
	@RequestMapping(value="/User",method=RequestMethod.POST)
	public String saveCountry(@ModelAttribute("user") User user, BindingResult result){
		userServiceImpl.save(user);
		return "/common/user/view";
	}
	
	 @RequestMapping("/User/{userId}")
	 public @ResponseBody User getUser(@PathVariable("userId") Long userId) throws NoSuchUserException {
	        return userServiceImpl.findById(userId);
	    }
}
