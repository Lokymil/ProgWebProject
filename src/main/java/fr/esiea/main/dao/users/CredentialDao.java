package fr.esiea.main.dao.users;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import fr.esiea.main.utils.SqlScriptUtils;

@Component
public class CredentialDao {

	Logger logger = LoggerFactory.getLogger(getClass());

	private final String scriptFolder = "sqlTemplates/credentials/";

	@Autowired
	@Qualifier(value = "NPJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;

	public String createCredentials(Long userId, String login, String password) throws Exception {
		Exception insertException = new Exception("Can't insert credentials : " + login);

		try {
			String authorisation = this.getAuthorisation();
			Date lastUse = new Date();

			logger.debug("Insert credentials " + login);

			String script = SqlScriptUtils.getScript(scriptFolder + "insertCredential.sql", getClass());
			logger.debug("script : " + script);

			Map<String, Object> param = new HashMap<String, Object>();
			param.put("userId", userId);
			param.put("login", login);
			param.put("password", password);
			param.put("authorisation", authorisation);
			param.put("lastUse", lastUse);

			int numberLine = jdbcTemplate.update(script, param);

			if (numberLine != 1) {
				logger.error("Number of line affected : " + numberLine + "for credential " + login);
				throw insertException;
			}
			
			logger.debug("credentials " + login + "has been created");
			
			return authorisation;

		} catch (IOException ioe) {
			logger.error("Can't retrieve sql script");
			throw insertException;
		}
	}

	
	
	private String getAuthorisation() {
		String authorisation = UUID.randomUUID().toString();
		logger.debug("authorisation : " + authorisation);
		return authorisation;
	}
}
