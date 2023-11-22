package com.claytonpereira.springproject01.services;

import com.claytonpereira.springproject01.entities.User;
import com.claytonpereira.springproject01.repositories.UserRepository;
import com.claytonpereira.springproject01.services.execeptions.ResourceDataViolationIntegrityException;
import com.claytonpereira.springproject01.services.execeptions.ResourceNotFoundException;
import com.claytonpereira.springproject01.services.execeptions.ServiceEntityNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	
	//Injecao de dependencia do framework com @Autowired
	//@Autowired
	private UserRepository userRepository;
	
	//Injecao de dependencia por construtor
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User obj) {
		return userRepository.save(obj);
	}

	public void delete(Long id) {
		try {
			if (userRepository.existsById(id)) {
				userRepository.deleteById(id);
			} throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new ResourceDataViolationIntegrityException(e.getMessage());
		}
	}

	public User update(Long id, User obj) {
		try {
			User entity = userRepository.getReferenceById(id);
			updateData(entity, obj);
			return userRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ServiceEntityNotFoundException(id);
		}
	}

	//método auxiliar
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}

}
