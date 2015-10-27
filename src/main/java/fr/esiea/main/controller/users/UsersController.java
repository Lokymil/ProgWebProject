package fr.esiea.main.controller.users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.esiea.main.services.UsersService;

@Controller
public class UsersController {

	@Autowired
	private UsersService usersService;

	@RequestMapping(value = "/subscribe", method = RequestMethod.GET)
	public @ResponseBody String subscribeTest(HttpServletRequest req, HttpServletResponse res) {

		String authorisation = usersService.createNewUser("test", "test", "test", "test", "test");

		return authorisation;
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
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public @ResponseBody String login(HttpServletRequest req,
			@RequestParam(value = "userName", required = true) String userName,
			@RequestParam(value = "password", required = true) String password){
		
		String authorisation = usersService.login(userName, password);
		
		return authorisation;
	}
}
