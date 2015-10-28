package fr.esiea.main.dao.articles;

import java.io.IOException;
import java.util.ArrayList;
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

import fr.esiea.main.domain.articles.Article;
import fr.esiea.main.utils.SqlScriptUtils;

@Component
public class ArticleDao {

	Logger logger = LoggerFactory.getLogger(getClass());

	private final String scriptFolder = "sqlTemplates/articles/";

	@Autowired
	@Qualifier(value = "NPJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;

	public void insertArticle(Article article) throws Exception {
		Exception insertException = new Exception("Can't insert article : " + article.toString());

		try {
			String script = SqlScriptUtils.getScript(scriptFolder + "insertArticle.sql", getClass());
			logger.debug("script : " + script);
			
			Map<String, Object> param = new HashMap<String,Object>();
			param.put("authorId", article.getAuthorId());
			param.put("title", article.getTitle());
			param.put("content", article.getContent());
			param.put("creationDate", article.getDateCreation());
			param.put("lastModified", article.getLastModified());
			
			int numberLine = jdbcTemplate.update(script, param);
			
			if (numberLine != 1){
				logger.error("Number of line affected : " + numberLine
						+ " for article " + article.toString());
				throw insertException;
			}
			
			logger.info("Article " + article.toString() + "has been inserted");
			
		} catch (IOException ioe) {
			logger.error("Can't retrieve sql script");
			throw insertException;
		}
	}

	// pagination will be 10 articles by page
	public List<Article> getArticlesByPage(int pageNumber) throws Exception {
		Exception noArticleException = new Exception("Can't retrieve article");
		
		try {
			String script = SqlScriptUtils.getScript(scriptFolder + "getArticlesByPage.sql", getClass());
			logger.debug("Script : " + script);
			int infBound = (pageNumber-1)*10;
			int supBound = pageNumber*10;
			
			List<Article> result = jdbcTemplate.query(script, new BeanPropertyRowMapper<Article>(Article.class));
			if (result == null || result.size() <= 0) {
				logger.error("Can't retrieve article");
				throw noArticleException;
			}
			
			List<Article> toReturn = result.subList(infBound, supBound); 
			
			return toReturn;
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("Can't retrieve script");
			throw noArticleException;
		}
	}
}
