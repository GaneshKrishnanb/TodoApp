package com.example.webapp.firstWebApp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.validation.Valid;

import com.example.webapp.firstWebApp.entity.*;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	static List<Todo> todos = new ArrayList<>();
	private static int todosCount = 0;
	/* static {
		todos.add(new Todo(++todosCount, "Udemy","Learn core Java",LocalDate.now().plusDays(50),false));
		todos.add(new Todo(++todosCount, "Udemy","Learn functional programming",LocalDate.now().plusDays(90),false));
		todos.add(new Todo(++todosCount, "Udemy","Learn spring framework",LocalDate.now().plusDays(120),false));
		todos.add(new Todo(++todosCount, "Udemy","Learn Spring Boot",LocalDate.now().plusDays(160),false));
		todos.add(new Todo(++todosCount, "Udemy","Learn Microservices",LocalDate.now().plusDays(200),false));
	} */
	public static List<Todo> findByUsername(String name) {
		return todos;
	}
	
	public static void addtodo(String name, String description, LocalDate targetDate, boolean done){
		Todo todo = new Todo(++todosCount, name, description, targetDate, done );
		todos.add(todo);
	}

	public static void deleteByID(int id) {
		// TODO Auto-generated method stub
		// todo.id == this.id
		
		Predicate<? super Todo> predicate = (Todo) -> Todo.getId() == id;
		todos.removeIf(predicate );
	}

	public Todo findByID(int id) {
		// TODO Auto-generated method stub
		Predicate<? super Todo> predicate = (Todo) -> Todo.getId()==id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo updatedtodo) {
		// TODO Auto-generated method stub
		deleteByID(updatedtodo.getId());
		todos.add(updatedtodo);
	}
}
