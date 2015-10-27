package fr.esiea.main.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.esiea.main.dao.users.CredentialDao;
import fr.esiea.main.domain.users.User;

@Component
public class CredentialsService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private CredentialDao credDao;

	public String createNewCred(User user, String password) {
		try {
			String authorisation = credDao.createCredentials(user.getId(), user.getUserName(), password);
			return authorisation;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getCredByUser(String userName, String password) {
		
		String authorisation;
		try {
			logger.info("Retrieving authorisation for " + userName);
			authorisation = credDao.getAuthorisationByUserName(userName, password);
			logger.info("Retrieved authorisation : " + authorisation);
			return authorisation;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
