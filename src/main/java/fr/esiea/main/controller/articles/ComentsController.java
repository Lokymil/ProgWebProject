package fr.esiea.main.controller.articles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.esiea.main.domain.articles.Coment;
import fr.esiea.main.services.article.ComentService;

@Controller
public class ComentsController {
	
	@Autowired
	private ComentService comentService;
	
	@RequestMapping(value="/coments/{articleId}")
	public @ResponseBody List<Coment> getCommentByArticleId(@PathVariable("articleId") Long articleId){
		
		List<Coment> result = comentService.getComentByArticleId(articleId);
		
		return result;
	}
	
	@RequestMapping(value="/new_comments")
	public @ResponseBody List<Coment> addComent(@RequestParam("authorisation") String authorisation,
			@RequestParam("login") String login,
			@RequestParam("articleId") Long articleId,
			@RequestParam("content") String content){
		
		List<Coment> result = comentService.addComent(authorisation,login,articleId,content);
		
		return result;
	}
}
