package com.springboot.thymeleaf.models.service;

import java.util.List;

import com.springboot.thymeleaf.models.entity.User;

public interface IUserService {
	
	List<User> getAllUsers();
    
    List<User> getUserByName(String name);
    
    User saveUser(User user);
    
    User getUserById(Long id);
    
    User updateUser(User student);
    
    void deleteUserById(Long id);

}
