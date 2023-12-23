package com.example.webapp.firstWebApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.webapp.firstWebApp.service.AuthenticationService;

@Controller
//@SessionAttributes("name")
public class LoginController {
	AuthenticationService authenticationService;
	
	public LoginController(AuthenticationService authenticationService) {
		// TODO Auto-generated constructor stub
		this.authenticationService = authenticationService;
	}
	
	
	
    @RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginPage() {
		// TODO Auto-generated method stub
		return "login";
	}
    
    // To authenticate the user credentials and to redirect to welcome page with the username displayed in the screen if the credentials matches 
    @RequestMapping(value = "welcome", method = RequestMethod.POST)
    public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
		if(authenticationService.authenticate(name, password)) {
			model.put("name", name);
			return "welcome";
		}
    	
    	return "login";
    	
    }
	

}
