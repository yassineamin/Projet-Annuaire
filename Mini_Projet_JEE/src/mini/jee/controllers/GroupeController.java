package mini.jee.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mini.jee.entities.Group;
import mini.jee.entities.Person;
import mini.jee.metier.IAnnuaireMetier;

@Controller
@RequestMapping("/groupe")
public class GroupeController {	
	
    @Autowired
    IAnnuaireMetier manager;

    
    @ModelAttribute("group")
     Collection<Group> products() throws SQLException {
		Collection <Group> g = new ArrayList<Group>();
		 g = manager.findAllGroups();
        return g;
    }
    
    @RequestMapping(value="/GroupList")
    public String toGroupList(){
    	return "GroupList";
    }
}
