package com.mongodb.service;

import java.util.List;

import com.mongodb.model.User;

public interface UserService {
	
	public List<User> obterTodos();
	
	public User obterPorId(String id);
	
	public User salvar(User user);
	
	public void deletarPorId(String id);

}
