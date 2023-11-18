package com.claytonpereira.springproject01.resources;

import com.claytonpereira.springproject01.entities.User;
import com.claytonpereira.springproject01.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = userService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

}
