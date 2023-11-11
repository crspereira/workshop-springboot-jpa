package com.claytonpereira.springproject01.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.claytonpereira.springproject01.entities.User;
import com.claytonpereira.springproject01.repositories.UserRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

	/* ## Injeçao por camao utilizando o Framework Spring ## */
//	@Autowired
//	private UserRepository userRepository;
	
	/* ## Injecao por construtor ## */
	  // 1. declaracao da dependecia
	private final UserRepository userRepository; //atributo
	  // 2. injecao da dependencia
	TesteConfig(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override //comandLineRunner method
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}

}
