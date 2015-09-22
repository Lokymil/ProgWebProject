package fr.esiea.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.esiea.main.dao.users.UserDao;
import fr.esiea.main.domain.users.User;

@RestController
public class TestController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping("/test")
	public User test(){
		User user = new User(42,"11yolo","22l","33'","44asti","ADMIN");
		return user;
	}
	
	@RequestMapping("/testDB")
	public void testDB(){
		User user = new User(0,"last","first","user","email","admin");
		logger.debug("user created : " + user);
		try {
			userDao.insertUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
