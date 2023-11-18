package com.claytonpereira.springproject01.services;

import com.claytonpereira.springproject01.entities.User;
import com.claytonpereira.springproject01.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	
	//Injecao de dependencia do framework com @Autowired
	//@Autowired
	private UserRepository userRepository;
	
	//Injecao de dependencia por construtor
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.get();
	}

	public User insert(User obj) {
		return userRepository.save(obj);
	}
}
