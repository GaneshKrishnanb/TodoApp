package com.example.webapp.firstWebApp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.webapp.firstWebApp.entity.Todo;
import com.example.webapp.firstWebApp.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {

	TodoService todoService;

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	
	@RequestMapping(value = "list-to-do", method = RequestMethod.GET)
	public String allListofTodo(ModelMap map){
		List<Todo> todo = todoService.findByUsername("Udemy");
		map.addAttribute("todo", todo);
		return "todo";	
	}
	
	@RequestMapping(value = "list-to-do", method = RequestMethod.POST)
	public String addNewTodo(@RequestParam String description, ModelMap map) {
		String name = (String) map.get("name");
		TodoService.addtodo(name, description, 
				LocalDate.now().plusYears(1), false);
		return "redirect: add-todo";
	}
}
