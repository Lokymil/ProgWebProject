package fr.esiea.main.dao.users;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import fr.esiea.main.domain.users.User;
import fr.esiea.main.utils.SqlScriptUtils;

@Component
public class UserDao {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	@Qualifier(value="NPJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public void insertUser(User user) throws Exception{
		Exception insertException = new Exception("Can't insert user : " + user.toString());
		
		try {
			
			String script = SqlScriptUtils.getScript("sqlTemplates/users/insertUser.sql", getClass());
			logger.debug("script : " + script);
			
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("lastName",user.getLastName());
			param.put("firstName",user.getFirstName());
			param.put("userName",user.getUserName());
			param.put("email",user.getEmail());
			param.put("level",user.getLevel().toString());
			
			int numberLine = jdbcTemplate.update(script, param);
			
			if (numberLine != 1){
				logger.error("Number of line affected : " + numberLine + " for user " + user.toString());
				throw insertException;
			}
			
			logger.info("User " + user.toString() + " has been inserted");
			
		} catch (IOException e) {
			logger.error("Can't retrieve sql script" );
			throw insertException;
		}
	}
	
}
