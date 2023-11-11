package com.claytonpereira.springproject01.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.claytonpereira.springproject01.entities.Order;
import com.claytonpereira.springproject01.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource { //resource é um controlador REST
	
	//Injecao de dependencia do framework com @Autowired
	//@Autowired
	private OrderService userService;
	
	//Injecao de dependencia por construtor
	OrderResource(OrderService userService){
		this.userService = userService;
	}
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> listOrder = userService.findAll();
		return ResponseEntity.ok().body(listOrder);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id ) {
		Order user = userService.findById(id);
		return ResponseEntity.ok().body(user);
	}

}
