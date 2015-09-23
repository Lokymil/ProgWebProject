package fr.esiea.main.controller.users;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsersController {

	@RequestMapping(value="/subscribe",method=RequestMethod.GET)
	public @ResponseBody String getSubcribeForm(HttpServletResponse res){
		
		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");
		return "<p>wololololo</p>";
	}
	
}
