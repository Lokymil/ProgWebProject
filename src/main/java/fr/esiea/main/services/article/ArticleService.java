package fr.esiea.main.services.article;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.esiea.main.dao.articles.ArticleDao;
import fr.esiea.main.domain.articles.Article;
import fr.esiea.main.domain.users.User;
import fr.esiea.main.services.user.CredentialsService;
import fr.esiea.main.services.user.UsersService;

@Component
public class ArticleService {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private CredentialsService credService;
	
	@Autowired
	private UsersService userService;
	
	@Autowired
	private ArticleDao articleDao;
	
	public String createArticle(String userName, String authorisation, String title, String content) {
		String result;
		try {
			logger.info("Creating article " + title + " by " + userName);
			if (credService.isAthorized(userName, authorisation)){
				User user = userService.getUser(userName);
				Article article = new Article(0,0,title,content,new Date(), new Date());
				articleDao.insertArticle(article);
				result = "Article has been created";
				logger.info("Article " + title + " has been created");
			} else {
				result = "Unauthorized user, must reconnect";
				logger.info("Can't create article " + title + ", unauthorised user");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Can't insert article due to an internal error");
			result =  "Can't insert article due to an internal error";
		}
		return result;
	}

	public List<Article> getArticlesByPage(int pageNumber){
		try {
			List<Article> result = articleDao.getArticlesByPage(pageNumber);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
