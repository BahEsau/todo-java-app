package com.in28minutes.springboot.myFirstWebApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	private static int todoCount = 0;
	//to initialize a static variable we crate a static block
	static {
		todos.add(new Todo(++todoCount, "Bah Esau", "learn AWS 1", 
					       LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todoCount, "Bah Esau", "learn learn Devops 1", 
			       LocalDate.now().plusYears(3), false));
		todos.add(new Todo(++todoCount, "in28minutes", "learn full stack development 1", 
			       LocalDate.now().plusYears(2), false));
	}
	
	public List<Todo> findByUsername(String username){ 
		Predicate<? super Todo>predicate =
				todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username, 
						String description, 
						LocalDate targetDate,
						boolean done ) {
		Todo todo = new Todo(++todoCount, username, description, targetDate, done);
		todos.add(todo);
	}
	
	public void deleteById(int id) {
		Predicate<? super Todo>predicate =
				todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}
	
	public Todo findById(int id) {
		Predicate<? super Todo>predicate = todo -> todo.getId() == id;
			Todo todo = todos.stream().filter(predicate).findFirst().get();
			return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}
}
