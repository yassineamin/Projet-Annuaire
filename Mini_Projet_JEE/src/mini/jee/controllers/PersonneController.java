package mini.jee.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mini.jee.entities.Group;
import mini.jee.entities.Person;
import mini.jee.entities.User;
import mini.jee.metier.IAnnuaireMetier;

@Controller
@RequestMapping("/personne")
public class PersonneController {

	@Autowired
	IAnnuaireMetier manager;

	// @ModelAttribute("person")
	// public Collection<Person> toPersonsInGroup() throws SQLException {
	// Collection <Person> p = new ArrayList<Person>();
	// p = manager.findPersonsInGroup(2);
	// return p;
	// }

	@RequestMapping(value = "/personsInGroup", method = RequestMethod.GET)
	public String personsInGroup(@RequestParam("id") int id, Model model) throws SQLException {
		model.addAttribute("person", manager.findPersonsInGroup(id));
		return "PersonsInGroup";
	}

	@ModelAttribute("listeIDGroup")
	public Map<Integer, String> productTypes() throws SQLException {
	    Map<Integer, String> types = new LinkedHashMap<>();
	    ArrayList<Group> liste= (ArrayList<Group>) manager.findAllGroups();
	    
	    for(int i=0 ; i<liste.size() ; i++){
	    	types.put(liste.get(i).getIdGroup(),liste.get(i).getNameGroup() );
	    }
	    
	  //  types.put("type1", "Type 1");

	    return types;
	}
	@RequestMapping(value="/savePerson")
	public String savePerson(Model model){
		model.addAttribute("savePersonDbA", new Person());
		return "savePerson";
		}

	@RequestMapping(value = "/profil")
	public String profil(Model model, HttpSession session) throws SQLException {
		User u = (User) session.getAttribute("user");
		Person p = manager.get_Email_Pwd_Person(u.getEmail(), u.getPwd());
		model.addAttribute("profilPersonne", p);
		return "profil";
	}
	
	@RequestMapping(value = "/modifyPerson")
	public String modifyPerson(Person p, Model model) throws SQLException {
		model.addAttribute("profilPersonne", p);
		System.out.println(p.getIdPerson());
		manager.updatePerson(p);

		return "profil";
	}

	@ModelAttribute("group")
	Collection<Group> products() throws SQLException {
		Collection<Group> g = new ArrayList<Group>();
		g = manager.findAllGroups();
		return g;
	}

	@RequestMapping(value = "/savePersonDb")
	public String savePersonDb(Person p, Model model) throws SQLException {
		model.addAttribute("savePersonDb", p);
		manager.savePerson(p);

		return "GroupList";
	}

}