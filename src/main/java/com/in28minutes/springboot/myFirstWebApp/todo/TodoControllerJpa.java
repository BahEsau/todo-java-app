package com.in28minutes.springboot.myFirstWebApp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
	private TodoRepository todoRepository;
	
	public TodoControllerJpa( TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String username = getloggedinUsername();
		List<Todo> todos = todoRepository.findByUsername(username);
		model.addAttribute("todos", todos);
		
		return "ListTodos";
	}


	
	@RequestMapping(value="add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username = getloggedinUsername();
		Todo todo = new Todo(0, username, "", LocalDate.now(), false);
		model.put("todo", todo);
		return "Todo";
	}
	
	@RequestMapping(value="add-todo", method = RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "Todo";
		}
		
		String username = getloggedinUsername();
		todo.setUsername(username);
		todoRepository.save(todo);
		return "redirect:list-todos";
	}
	

	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoRepository.deleteById(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="update-todo", method = RequestMethod.GET)
	public String showTodoPage(@RequestParam int id, Todo todo, ModelMap model, BindingResult result) {
		 todo = todoRepository.findById(id).get();
		model.addAttribute("todo", todo);
		return "Todo";
	}
	
	@RequestMapping(value="update-todo", method = RequestMethod.POST)
	public String updateTodo( ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "Todo";
		}
		
		String username = getloggedinUsername();
		todo.setUsername(username);
		todoRepository.save(todo);
		return "redirect:list-todos";
	}
	
	private String getloggedinUsername() {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		
		return authentication.getName();
	}
}
