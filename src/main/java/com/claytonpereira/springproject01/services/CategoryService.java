package com.claytonpereira.springproject01.services;

import com.claytonpereira.springproject01.entities.Category;
import com.claytonpereira.springproject01.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
	
	//Injecao de dependencia do framework com @Autowired
	//@Autowired
	private CategoryRepository categoryRepository;
	
	//Injecao de dependencia por construtor
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		return category.get();
	}
}
