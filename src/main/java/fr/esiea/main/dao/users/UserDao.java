package fr.esiea.main.dao.users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	@Qualifier(value="NPJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	
	
}
