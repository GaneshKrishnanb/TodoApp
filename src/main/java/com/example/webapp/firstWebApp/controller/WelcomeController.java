package com.example.webapp.firstWebApp.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.webapp.firstWebApp.entity.*;
import com.example.webapp.firstWebApp.repository.EntityRepository;
import com.example.webapp.firstWebApp.service.TodoService;
@Controller
@SessionAttributes("userName")
public class WelcomeController {
	
	EntityRepository entityRepository;
	
	public WelcomeController(EntityRepository entityRepository) {
		// TODO Auto-generated constructor stub
		this.entityRepository = entityRepository;
	}
	
    @GetMapping("/welcome")
    public String welcome(@AuthenticationPrincipal OidcUser user, Model model) {
        String name = user.getFullName();
        System.out.println(name);// Change this according to your user details
        model.addAttribute("userName", name);
        System.out.println("name is" + name);
        return "welcome";
    }
	
	/*@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String redirectToTodoList(ModelMap map) {
		map.addAttribute("name", "name");
	    return "welcome";
	} */

	@RequestMapping(value = "/list-to-do", method = RequestMethod.GET)
	public String listAllTodo(@ModelAttribute("userName") String name, ModelMap map) {
		//String name = (String) map.get("userName");
		System.out.println("name is"+ name);
		List<Todo> todo = null;
		try {
		 todo = entityRepository.findByName(name);
		 System.out.println("Todo is"  + todo);
		} catch (Exception e) {
			System.out.println("Error fetching data from DB");
			e.printStackTrace();
		}
		
	    map.addAttribute("todo", todo);
	    return "todo";
	}


}
