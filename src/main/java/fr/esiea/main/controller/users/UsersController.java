package fr.esiea.main.controller.users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.esiea.main.services.user.UsersService;

@Controller
public class UsersController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UsersService usersService;

	// This service web is for test
	@RequestMapping(value = "/subscribe", method = RequestMethod.GET)
	public @ResponseBody String subscribeTest(HttpServletRequest req, HttpServletResponse res) {

		String authorisation = usersService.createNewUser("test", "test", "test", "test", "test");

		String authorisation2 = usersService.login("test", "test");
		
		return authorisation2;
	}

	// first subscribtion for a user
	@RequestMapping(value = "/subscribe", method = RequestMethod.POST)
	public @ResponseBody String subscribe(HttpServletRequest req,
			@RequestParam(value = "firstName", required = true) String firstName,
			@RequestParam(value = "lastName", required = true) String lastName,
			@RequestParam(value = "userName", required = true) String userName,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "password", required = true) String password, HttpServletResponse res) {

		String authorisation = usersService.createNewUser(firstName, lastName, userName, email, password);
		
		return authorisation;
	}
	
	// login method for subscribed user
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public @ResponseBody String login(HttpServletRequest req,
			@RequestParam(value = "userName", required = true) String userName,
			@RequestParam(value = "password", required = true) String password){
		logger.debug("/login has been called with " + userName);
		String authorisation = usersService.login(userName, password);
		
		return authorisation;
	}
}
