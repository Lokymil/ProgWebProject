package fr.esiea.main.dao.users;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import fr.esiea.main.domain.users.Credential;
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
			logger.debug("Date added to credential authorisation : " + lastUse);

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

	public boolean isAuthorized(String login, String authorisation){
		logger.debug("Seek for " + login + " authorisation");
		
		try{
			String script = SqlScriptUtils.getScript(scriptFolder + "isAuthorized.sql", getClass());
			
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("authorisation", authorisation);
			param.put("login", login);
			
			List<Credential> result = jdbcTemplate.query(script, param, new BeanPropertyRowMapper<Credential>(Credential.class));
			if (result.size() != 1){
				logger.error("multiples lines are used for " + login);
				return false;
			}
			
			Date lastUse  = result.get(0).getLastUse();
			Calendar cal = Calendar.getInstance();
			cal.setTime(lastUse);
			cal.add(Calendar.MINUTE, 30);
			Date lastUseAuthorized = cal.getTime();
			logger.debug("Date retrieved from database : " + lastUse);
			logger.debug("Date with 30 min added " + lastUseAuthorized);
			if (lastUseAuthorized.after(new Date())){
				logger.info(login + " is authorized");
				return true;
			}
			
			logger.info(login + " is NOT authorized");
			
			return false;
			
		} catch(IOException ioe){
			logger.error("Can't retrieve sql script");
			return false;
		}
		
	}
	
	private String getAuthorisation() {
		String authorisation = UUID.randomUUID().toString();
		logger.debug("authorisation : " + authorisation);
		return authorisation;
	}
}
