package fr.esiea.main.dao.articles;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import fr.esiea.main.domain.articles.Coment;
import fr.esiea.main.utils.SqlScriptUtils;

@Component
public class ComentDao {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	private String scriptFolder = "sqlTemplates/coments/";

	@Autowired
	@Qualifier(value = "NPJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public List<Coment> getComentByArticleId(Long articleId) throws Exception {

		Exception retrievingComentException = new Exception("Can't retrieve coment");
		
		try {
			String script = SqlScriptUtils.getScript(scriptFolder + "getCosmentByArticleId.sql", getClass());
			logger.debug("SCript : " + script);
			
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("articleId", articleId);
			
			List<Coment> result = jdbcTemplate.query(script, param, new BeanPropertyRowMapper<Coment>(Coment.class));
			
			if (result == null){
				logger.error("There is no comment to retieve");
			}
			
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("Can't retrieve script");
			throw retrievingComentException;
		}
	}

	public void insertComment(Coment coment) throws Exception{
		Exception insertException = new Exception("Can't insert coment");
		
		try {
			String script = SqlScriptUtils.getScript(scriptFolder + "insertComent.sql", getClass());
			logger.debug("Script : " + script);
			
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("authorId", coment.getCreatorId());
			param.put("articleId", coment.getArticleId());
			param.put("content", coment.getContent());
			param.put("creationDate", new Date());
			
			int numberLine = jdbcTemplate.update(script, param);
			if (numberLine != 1){
				logger.error("The number of affected line is " + numberLine);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("Can't retrieve ");
			throw insertException;
		}
	}
	
}
