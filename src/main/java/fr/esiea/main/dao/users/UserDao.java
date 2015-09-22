package fr.esiea.main.dao.users;

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
		try {
			String script = SqlScriptUtils.getScript("sqlTemplates/users/insertUser.sql", getClass());
			logger.debug("script : " + script);
		} catch (Exception e) {
			logger.error("Can't retrieve sql script" );
			e.printStackTrace();
		}
	}
	
}
