package mini.jee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mini.jee.metier.IAnnuaireMetier;

@Controller
@RequestMapping("/personne")
public class PersonneController {
	
	@Autowired
    IAnnuaireMetier manager;
	

}
