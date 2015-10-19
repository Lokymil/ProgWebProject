package fr.esiea.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.esiea.main.dao.users.UserDao;
import fr.esiea.main.domain.users.User;

@RestController
@RequestMapping("/testing")
public class TestController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping("/test")
	public User test(){
		User user = new User("11yolo","22l","33'","44asti","ADMIN");
		return user;
	}
	
	@RequestMapping("/testDB")
	public void testDB(){
		User user = new User("last","first","user","email","admin");
		logger.debug("user created : " + user);
		try {
//			userDao.insertUser(user);
			User result = userDao.getUserByUserName("user");
			logger.debug("result : " + result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
