package com.claytonpereira.springproject01.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.claytonpereira.springproject01.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource { //resource é um controlador REST
	
	@GetMapping
	public ResponseEntity<User> findAll() {
		User user = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");
		return ResponseEntity.ok().body(user);
	}

}
