package com.claytonpereira.springproject01.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.claytonpereira.springproject01.entities.Order;
import com.claytonpereira.springproject01.entities.User;
import com.claytonpereira.springproject01.repositories.OrderRepository;
import com.claytonpereira.springproject01.repositories.UserRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

	//Injecao de dependencia do framework com @Autowired
	//@Autowired
	// 1. declaracao da dependecia
	private final UserRepository userRepository;
	private final OrderRepository orderRepository;
	
	//Injecao de dependencia por construtor
	// 2. injecao da dependencia
	TesteConfig(UserRepository userRepository, OrderRepository orderRepository) {
		this.userRepository = userRepository;
		this.orderRepository = orderRepository;
	}
	
	@Override //comandLineRunner method
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}

}
