package com.in28minutes.springboot.myFirstWebApp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * The ModelMap implementation of java.util.Map for use when building model data
 * for use with UI tools. Supports chained calls and generation of model
 * attribute names. This class serves as generic model holder for Servlet MVC
 * but is not tied to it.Check out the Model interface for an interface variant.
 *
 * The @RequestParam Annotation which indicates that a method parameter should
 * be bound to a web request parameter.
 * 
 * The ModelMap (Request Scope) sends data to the view with the limited scope
 * range of the request. However the @SessionAttributes (Session Scope) data
 * is not limited to just the request range. it is stored across
 * multiple requests.
 */
@Controller
@SessionAttributes("name")
public class WelcomController {
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String goToWelcomePage(ModelMap model) {
		model.put("name", getLoggedinUsername());
		return "welcome";
	}
	
	public String getLoggedinUsername() {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		
		return authentication.getName();
	}
	
}
