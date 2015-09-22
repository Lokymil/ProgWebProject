package fr.esiea.main.dao.users;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import fr.esiea.main.domain.users.User;
import fr.esiea.main.utils.SqlScriptUtils;

@Component
public class UserDao {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	private final String scriptFolder = "sqlTemplates/users/"; 

	@Autowired
	@Qualifier(value = "NPJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;

	public void insertUser(User user) throws Exception {
		Exception insertException = new Exception("Can't insert user : "
				+ user.toString());

		try {

			String script = SqlScriptUtils.getScript(
					scriptFolder + "insertUser.sql", getClass());
			logger.debug("script : " + script);

			Map<String, Object> param = new HashMap<String, Object>();
			param.put("lastName", user.getLastName());
			param.put("firstName", user.getFirstName());
			param.put("userName", user.getUserName());
			param.put("email", user.getEmail());
			param.put("level", user.getLevel().toString());

			int numberLine = jdbcTemplate.update(script, param);

			if (numberLine != 1) {
				logger.error("Number of line affected : " + numberLine
						+ " for user " + user.toString());
				throw insertException;
			}

			logger.info("User " + user.toString() + " has been inserted");

		} catch (IOException ioe) {
			logger.error("Can't retrieve sql script");
			throw insertException;
		}
	}

	public User getUserByUserName(String userName) throws Exception {
		Exception getUserException = new Exception(
				"Can't retrieve user with user name : " + userName);
		User user = null;

		try {
			
			String script = SqlScriptUtils.getScript(scriptFolder + "getUserByUserName.sql", getClass());
			
			Map<String,Object> param = Collections.singletonMap("userName", userName);
			List<User> result = jdbcTemplate.query(script, param, new BeanPropertyRowMapper<User>(User.class));
			
			if (result == null || result.size() <= 0) {
				throw getUserException;
			}
			
			user = result.get(0);
			
		} catch (IOException ioe) {
			logger.error("Can't retrieve sql script");
			throw getUserException;
		}
		
		return user;
	}

}
