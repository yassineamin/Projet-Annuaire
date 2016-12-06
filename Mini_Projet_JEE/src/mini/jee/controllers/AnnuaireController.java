package mini.jee.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mini.jee.metier.IAnnuaireMetier;

@Controller
@RequestMapping("/personne")
public class AnnuaireController {	

    @Autowired
    IAnnuaireMetier manager;
	
	@RequestMapping(value="/welcome")
	public String index(){
		return "hello";
		
	}
	
	@RequestMapping(value="/connect")
	public String login(){
		return "login";
		
	}
    
//    @RequestMapping(value = "/welcome")
//    public ModelAndView sayHello() {
//        String now = (new Date()).toString();
//        return new ModelAndView("hello", "now", now);
//    }
		
}
