package com.tenzaWeb.admin.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tenzaWeb.security.model.entity.Role;
import com.tenzaWeb.security.model.entity.User;
import com.tenzaWeb.security.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
/* @RestController */	
@Slf4j
public class AUserController {

	@Autowired 
	UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable("id") String  userId, Model model , @ModelAttribute("userForm")User userForm) {
        User user = userService.get(userId);
        List<Role> listRoles = userService.listRoles();
        model.addAttribute("user", user);
        model.addAttribute("listRoles", listRoles);
        model.addAttribute("userForm", user);
        return "updateUser";
    }
	
    @GetMapping("/employeelist.html")
    public String listUsers(Model model) {
        List<User> listUsers = userService.listAll();
        model.addAttribute("listUsers", listUsers);
         
        return "admin/userlist";
    }
    
    @PostMapping("/saveee")
	public String saveUser(User user) {
	  
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userService.save(user);
	     
	    return "redirect:/employeelist.html";
	}
	@RequestMapping("/role")
	public String saveRole(Role role) {
		userService.saveRole(role);
		return "redirect:/";
	}
	
}
