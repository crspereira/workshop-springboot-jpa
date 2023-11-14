package com.claytonpereira.springproject01.resources;

import com.claytonpereira.springproject01.entities.Category;
import com.claytonpereira.springproject01.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource { //resource é um controlador REST
	
	//Injecao de dependencia do framework com @Autowired
	//@Autowired
	private CategoryService categoryService;
	
	//Injecao de dependencia por construtor
	CategoryResource(CategoryService categoryService){
		this.categoryService = categoryService;
	}
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> listCategory = categoryService.findAll();
		return ResponseEntity.ok().body(listCategory);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category user = categoryService.findById(id);
		return ResponseEntity.ok().body(user);
	}

}
