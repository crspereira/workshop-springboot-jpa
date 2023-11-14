package com.claytonpereira.springproject01.resources;

import com.claytonpereira.springproject01.entities.User;
import com.claytonpereira.springproject01.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource { //resource é um controlador REST
	
	//Injecao de dependencia do framework com @Autowired
	//@Autowired
	private UserService userService;
	
	//Injecao de dependencia por construtor
	UserResource(UserService userService){
		this.userService = userService;
	}
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> listUser = userService.findAll();
		return ResponseEntity.ok().body(listUser);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User user = userService.findById(id);
		return ResponseEntity.ok().body(user);
	}

}
