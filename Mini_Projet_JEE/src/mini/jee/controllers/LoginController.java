package mini.jee.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
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

	@ModelAttribute("group")
	Collection<Group> products() throws SQLException {
		Collection<Group> g = new ArrayList<Group>();
		g = manager.findAllGroups();
		return g;
	}

	@RequestMapping(value = "/login.php")
	public String login(Person p, Model model, HttpSession session) throws SQLException {
		Person p1 = manager.get_Email_Pwd_Person(p.getEmailPerson(), p.getPswPerson());
		if (p1 != null) {
			session.setAttribute("user", new User(p1.getEmailPerson(), p1.getPswPerson()));
			return "GroupList";
		}

		else {
			model.addAttribute("loginuser", new Person());
			return "loginForm";
		}

	}

}