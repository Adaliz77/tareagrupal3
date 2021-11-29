package com.springboot.thymeleaf.models.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.thymeleaf.models.entity.User;
import com.springboot.thymeleaf.models.repository.IUserRepository;

@Service
public class UserService implements IUserService{
	
	 private IUserRepository userRepository;

	 public UserService(IUserRepository userRepository) {
	        this.userRepository = userRepository;
	    }
	 
	 @Override
		public List<User> getAllUsers() {
			
			return userRepository.findAll();
		}

	    @Override
	    public User saveUser(User user) {
	        return userRepository.save(user);
	    }

	    @Override
	    public User getUserById(Long id) {
	        return userRepository.findById(id).get();
	    }

	    @Override
	    public User updateUser(User user) {
	        return userRepository.save(user);
	    }

	    @Override
	    public void deleteUserById(Long id) {
	        userRepository.deleteById(id);
	    }

	    @Override
	    public List<User> getUserByName(String name) {
	        return userRepository.findByNameContaining(name);
	    }

		
}
