package com.claytonpereira.springproject01.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.claytonpereira.springproject01.entities.Order;
import com.claytonpereira.springproject01.repositories.OrderRepository;

@Service
public class OrderService {
	
	//Injecao de dependencia do framework com @Autowired
	//@Autowired
	private OrderRepository userRepository;
	
	//Injecao de dependencia por construtor
	public OrderService(OrderRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<Order> findAll() {
		return userRepository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> user = userRepository.findById(id);
		return user.get();
	}
}
