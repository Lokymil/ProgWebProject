package fr.esiea.main.controller.articles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.esiea.main.services.article.ArticleService;
import fr.esiea.main.services.user.CredentialsService;

@RestController
public class ArticlesController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ArticleService articleService;
	
	// for test urpose
	@Autowired
	private CredentialsService credService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/new_article")
	public void newArticle(/*@RequestParam(value="name", required=false) String name*/){
		logger.debug("WS new article");
		String result = articleService.createArticle("test", credService.getCredByUser("test", "test"), "test", "test");
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/new_article")
	public @ResponseBody String newArticle(@RequestParam(value="userName", required=true) String userName,
			@RequestParam(value="authorisation", required=true) String authorisation,
			@RequestParam(value="title", required=true) String title,
			@RequestParam(value="content", required=true) String content){
		
		String result = articleService.createArticle(userName, authorisation, title, content); 
		
		return result;
	}
}
