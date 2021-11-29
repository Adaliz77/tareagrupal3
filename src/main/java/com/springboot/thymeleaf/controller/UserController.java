package com.springboot.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.thymeleaf.models.entity.User;
import com.springboot.thymeleaf.models.service.UserService;

@Controller
public class UserController {
	
	@Autowired
    private UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }    
    
    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }
    
    @GetMapping("/users/new")
    public String createUserForm(Model model){
        
        // este objeto Student almacenara los valores 
        User user = new User();
       
        model.addAttribute("user", user);
        
        return "create_user";
    }
    
    @PostMapping("/users")
    public String saveUsers(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
    
    @GetMapping("/users/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        User us = userService.getUserById(id);
        
        model.addAttribute("user", us);
        return "edit_user";
    }
    
    @PostMapping("/users/{id}")
    public String updateUser(@PathVariable Long id, 
            @ModelAttribute("user") User user,
            Model model) {
        //sacar el esudiante de la b.d. por el id
    	User existentUser = userService.getUserById(id);
        // cargarlo
        existentUser.setId(id);
        existentUser.setName(user.getName());
        existentUser.setSurname(user.getSurname());
        existentUser.setAge(user.getAge());
        

        // guardar el estudiante actualizado
        userService.updateUser(existentUser);
        
        return "redirect:/users";
    }
    
    @GetMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

}
