package fr.esiea.main.services.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.esiea.main.dao.articles.ComentDao;
import fr.esiea.main.domain.articles.Coment;

@Component
public class ComentService {

	@Autowired
	private ComentDao comentDao;
	
	public List<Coment> getComentByArticleId(Long articleId) {

		List<Coment> result = null;
		try {
			result = comentDao.getComentByArticleId(articleId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
