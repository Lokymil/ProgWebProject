package fr.esiea.main.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.esiea.main.domain.users.User;

@RestController
public class TestController {
	
	@RequestMapping("/test")
	public User test(){
		User user = new User(42,"11yolo","22l","33'","44asti","ADMIN");
		return user;
	}
}
