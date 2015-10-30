package fr.esiea.main.services.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.esiea.main.dao.users.UserDao;
import fr.esiea.main.domain.users.ExistingUserException;
import fr.esiea.main.domain.users.User;

@Component
public class UsersService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	private String basicUserLevel = "BASIC";
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CredentialsService credService;

	public String createNewUser(String firstName, String lastName, String userName, String email, String password) {
		try {
			User user = new User(lastName, firstName, userName, email, basicUserLevel);
			logger.info("Creating user");
			Long id;
			id = userDao.createUser(user);
			user.setId(id);
			

			logger.info("User created");
			logger.info("Creating credential");
			
			String authorisation = credService.createNewCred(user, password);
			
			logger.info("Credential created");
			
			return authorisation;
			
		} catch (ExistingUserException euException) {
			logger.error("User " + userName + " already exist and cannot be created");
			return "User name " + userName + " already exists";
		}
		catch (Exception e) {
			e.printStackTrace();
			return "Can't create user due to an internal error";
		}
	}

	public String login(String userName, String password) {
		try {
			logger.info("Login for " + userName);
			User user = userDao.getUserByUserName(userName);
			if (user == null){
				throw new Exception("User does not exist");
			}
			String authorisation = credService.getCredByUser(userName, password);
			logger.info("User " + userName + " loged in with " + authorisation);
			return authorisation;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public User getUser(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
