package fr.esiea.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.esiea.main.dao.users.CredentialDao;
import fr.esiea.main.domain.users.User;

@Component
public class CredentialsService {
	
	@Autowired
	private CredentialDao credDao;

	public String createNewCred(User user, String password) {
		try {
			String authorisation = credDao.createCredentials(user.getId(), user.getUserName(), password);
			return authorisation;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
