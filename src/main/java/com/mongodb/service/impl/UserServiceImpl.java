package com.mongodb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.model.User;
import com.mongodb.repository.UserRepository;
import com.mongodb.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRep;

	@Override
	public List<User> obterTodos() {
		return userRep.findAll();
	}

	@Override
	public User obterPorId(String id) {
		return userRep
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
	}

	@Override
	public User salvar(User user) {
		User esposa = userRep
						.findById(user.getEsposa().getId())
						.orElseThrow(() -> new RuntimeException("Esposa não encontrada."));
		
		user.setEsposa(esposa);
		return userRep.save(user);
	}

	@Override
	public void deletarPorId(String id) {
		userRep
			.findById(id)
			.map(user -> {
				userRep.delete(user);
				return user;
			}).orElseThrow(() -> new RuntimeException("User não encontrado"));
		
	}

	@Override
	public List<User> obterPorRangeIdade(Integer de, Integer ate) {
		return userRep.obterUsuariosPorRangeDeIdade(de, ate);
	}

	@Override
	public List<User> obterPorNome(String nome) {
		return userRep.findByNome(nome);
	}

}
