package fr.esiea.main.controller.articles;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.esiea.main.dao.articles.ArticleDao;
import fr.esiea.main.domain.articles.Article;

@RestController
public class ArticlesController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ArticleDao articleDao;
	
	@RequestMapping(method = RequestMethod.GET, value = "/new_article")
	public void newArticle(/*@RequestParam(value="name", required=false) String name*/){
		Article article = new Article(12,1,"test","wololo",new Date(),new Date(),5);
		logger.debug(article.toString());
		try {
			articleDao.insertArticle(article);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
