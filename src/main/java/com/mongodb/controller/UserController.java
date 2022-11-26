package com.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.model.User;
import com.mongodb.service.UserService;

@RestController
@RequestMapping("/usuarios")
public class UserController {
	
	@Autowired
	private UserService userServiceImpl;
	
	@GetMapping
	public List<User> obterTodos() {		
		return userServiceImpl.obterTodos();		
	}
	
	@GetMapping
	@RequestMapping("/{id}")
	public User buscarPorId(@PathVariable String id) {
		return userServiceImpl.obterPorId(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User salvarUsuario(@RequestBody User user) {
		return userServiceImpl.salvar(user);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarUsuario(@PathVariable String id) {
		userServiceImpl.deletarPorId(id);
	}
	
	
}
