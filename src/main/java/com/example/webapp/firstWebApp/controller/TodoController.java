package com.example.webapp.firstWebApp.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.webapp.firstWebApp.entity.Todo;
import com.example.webapp.firstWebApp.repository.EntityRepository;
import com.example.webapp.firstWebApp.service.TodoService;



@Controller
@SessionAttributes("userName")
public class TodoController {

	TodoService todoService;
	EntityRepository entityRepository;
	
	public TodoController(TodoService todoService, EntityRepository entityRepository) {
		// TODO Auto-generated constructor stub
		this.todoService = todoService;
		this.entityRepository = entityRepository;
	}

	
	
	/*@RequestMapping(value = "list-to-do", method = RequestMethod.GET)
	public String listAlltodo(ModelMap map){
		String name = (String) map.get("name");
		List<Todo> todo = entityRepository.findByName(name);
		map.addAttribute("todo", todo);
		return "todo";	
	} */
	
	@RequestMapping(value = "add-to-do", method = RequestMethod.GET)
	public String showTodo(@ModelAttribute("userName") String name, ModelMap model){
		//String name1 = (String) model.get("name");
		System.out.println("Name from session " + name);
		Todo todo = new Todo(0, name, "", 
		LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "add-todo";	
	}
	@RequestMapping(value = "add-to-do", method = RequestMethod.POST)
	public String addNewTodo(@ModelAttribute("userName") String name, ModelMap map, @Valid Todo todo, BindingResult result) {
		todo.setName(name);
		if(result.hasErrors()) {
			return "add-todo";
		}
		//String name1 = (String) map.get("name");
		try{
			entityRepository.save(todo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//TodoService.addtodo(name1, todo.getDescription(), 
		//LocalDate.now().plusYears(1), false);
		return "redirect:/list-to-do";//Instead of duplicating the logic of listAlltodo 
	}
	@RequestMapping(value = "delete-todo")
	public String deleteTodo(@RequestParam int id) {
		// TODO Auto-generated method stub
		entityRepository.deleteById(id);
		//todoService.deleteByID(id);
		return "redirect:/list-to-do";
	}
	
	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String ShowUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Optional<Todo> todo = entityRepository.findById(id); //todoService.findByID(id);
		model.addAttribute("todo", todo);
		return "update-todo";
	}
	
	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String UpdateTodo(@ModelAttribute("userName") String name, ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "update-todo";
		}
		todo.setName(name);
		Todo todoFromModel = (Todo) model.get("todo");
		//String name2 = (String) model.get("name");
		entityRepository.save(todo);
		//todoService.updateTodo(todo);
		return "redirect:/list-to-do";
	}
	
}
