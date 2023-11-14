package com.claytonpereira.springproject01.services;

import com.claytonpereira.springproject01.entities.Order;
import com.claytonpereira.springproject01.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
		Optional<Order> order = userRepository.findById(id);
		return order.get();
	}
}
