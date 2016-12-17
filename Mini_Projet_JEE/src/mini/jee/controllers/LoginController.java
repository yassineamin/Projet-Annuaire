package mini.jee.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import mini.jee.entities.Group;
import mini.jee.entities.Person;
import mini.jee.entities.User;
import mini.jee.metier.IAnnuaireMetier;

@Controller()
@RequestMapping("/user")
@SessionAttributes(value = "user", types = { User.class })
public class LoginController {

	@Autowired
	IAnnuaireMetier manager;

	@RequestMapping(value = "/loginForm")
	public String loginForm(Model model) {
		model.addAttribute("loginuser", new Person());
		return "loginForm";
	}

	Collection<Group> g = new ArrayList<Group>();
	int count =0;
	@ModelAttribute("group")
	Collection<Group> groups() throws SQLException {
		g = manager.findAllGroups();
		count = manager.countGroups();
		System.out.println(count);
		return g;
	}
	
	@RequestMapping(value="/grouplist/{pageid}")
	public ModelAndView groupList(@PathVariable int pageid, Model model) throws SQLException{
		model.addAttribute("recherche", new Person());
		model.addAttribute("person", null);
		 int total=10;  
	        if(pageid==1){}  
	        else{  
	            pageid=(pageid-1)*total+1;  
	        }  
	        
	       List<Integer> nbrepage = new ArrayList<>();
	       
	        if(count%2==0){
	        	for(int i = 1; i<=count/10;i++){
	        		nbrepage.add(i);
	        	}
	        }else{
	        	for(int i=1; i<count/10;i++){
	        		nbrepage.add(i);
	        	}
	        	nbrepage.add(nbrepage.size()+1);
	        }
	        
	        List<Group> list=manager.getGroupByPage(pageid,total); 
		return new ModelAndView("GroupList","list",list).addObject("nbrepage", nbrepage);  
	}

	@RequestMapping(value = "/login.php")
	public String login(Person p,String chaine, Model model, HttpSession session) throws SQLException {
		Person p1 = manager.get_Email_Pwd_Person(p.getEmailPerson(), p.getPswPerson());
		model.addAttribute("recherche", new Person());
		if (p1 != null) {
			session.setAttribute("user", new User(p1.getEmailPerson(), p1.getPswPerson()));
			model.addAttribute("person", null);
			return "Accueil";
		}

		else {
			model.addAttribute("loginuser", new Person());
			return "loginForm";
		}

	}

}