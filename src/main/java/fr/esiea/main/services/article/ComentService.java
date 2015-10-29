package fr.esiea.main.services.article;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.esiea.main.dao.articles.ComentDao;
import fr.esiea.main.domain.articles.Coment;
import fr.esiea.main.domain.users.User;
import fr.esiea.main.services.user.CredentialsService;
import fr.esiea.main.services.user.UsersService;

@Component
public class ComentService {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ComentDao comentDao;
	
	@Autowired
	private CredentialsService credService;
	
	@Autowired
	private UsersService usersService;
	
	public List<Coment> getComentByArticleId(Long articleId) {

		List<Coment> result = null;
		try {
			logger.info("Retrieve coments for article " + articleId);
			result = comentDao.getComentByArticleId(articleId);
			logger.info("Coments for article " + articleId + "has been retrieved");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Can't retrieve comment for articles " + articleId);
		}
		
		return result;
	}

	public List<Coment> addComent(String authorisation, String login, Long articleId, String content) {

		logger.info("User " + login + " add coment to " + articleId);
		List<Coment> result = null;
		
		if (!credService.isAthorized(login, authorisation)){
			logger.error("User " + login + " is not authorized to add coment");
		} else {
			User user = usersService.getUser(login);
			Coment coment = new Coment(user.getId(),articleId,0,content,new Date());
			try {
				comentDao.insertComment(coment);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Can't insert coment");
			}
			
			result = this.getComentByArticleId(articleId);
		}
		
		return result;
	}

}
