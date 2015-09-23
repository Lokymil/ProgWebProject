package fr.esiea.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import fr.esiea.main.dao.users.UserDao;

@Component
public class UsersService {
	
	@Autowired
	private UserDao usersDao;
	
}
