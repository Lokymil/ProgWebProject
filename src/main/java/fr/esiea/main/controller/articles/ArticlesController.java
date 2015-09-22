package fr.esiea.main.controller.articles;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.esiea.main.domain.users.User;

@RestController
public class ArticlesController {

	@RequestMapping(method = RequestMethod.POST, value = "/new_article")
	public User newArticle(@RequestParam(value="name", required=false) String name){
		User user = new User(42,name,"firstName","userName","email","ADMIN");
		return user;
	}
	
}
