package mini.jee.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mini.jee.entities.Group;
import mini.jee.entities.Person;
import mini.jee.entities.User;
import mini.jee.metier.IAnnuaireMetier;

@Controller
@RequestMapping("/personne")
public class PersonneController {

	@Autowired
	IAnnuaireMetier manager;

	Collection<Person> p = new ArrayList<Person>();
	int count =0;
	@ModelAttribute("person")
	Collection<Person> groups() throws SQLException {
		p = manager.findAllPersons();
		count = manager.countPersons();
		System.out.println(count);
		return p;
	}
	
	@RequestMapping(value="/personlist/{pageid}")
	public ModelAndView personList(@PathVariable int pageid, Model model) throws SQLException{
		model.addAttribute("recherche", new Person());
		model.addAttribute("person", null);
		 int total=20;  
	        if(pageid==1){}  
	        else{  
	            pageid=(pageid-1)*total+1;  
	        }  
	        
	       List<Integer> nbrepage = new ArrayList<>();
	       
	        if(count%2==0){
	        	for(int i = 1; i<=count/20;i++){
	        		nbrepage.add(i);
	        	}
	        }else{
	        	for(int i=1; i<count/20;i++){
	        		nbrepage.add(i);
	        	}
	        	nbrepage.add(nbrepage.size()+1);
	        }
	        
	        List<Person> list=manager.getPersonByPage(pageid, total); 
	        System.out.println(list.get(1));
		return new ModelAndView("PersonList","list",list).addObject("nbrepage", nbrepage);  
	}

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

	    return types;
	}
	
	@RequestMapping(value="/savePerson")
	public String savePerson(Model model){
		model.addAttribute("savePersonDbA", new Person());
		return "savePerson";
		}
	
	@RequestMapping(value="/passWordRecover")
	public String passWordRecover(Person p,Model model){
		
		model.addAttribute("currEmail",new User());
		return "recoverPwd";
		}
	

	@RequestMapping(value="/passWordRecover2")
	public String passWordRecover2(User u,Model model) throws SQLException{
		
		Person p=manager.get_Pwd_Person(u.getEmail());
		
		model.addAttribute("loginuser", new Person());
		
		String userName = "javatestyassine@gmail.com";
		String pwd = "yassinetestjava";
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication(userName, pwd);
		    }
		});
		
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(userName));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(p.getEmailPerson()));
			message.setSubject("Récupération du mot de passe ");
			message.setText(" Bonjour "+p.getFirstNamePerson()+"\n"+"voila votre mot de passe : "+p.getPswPerson());

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			//throw new RuntimeException(e);
			System.out.println(e.getMessage());
		}
		
		return "loginForm";
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

		return "Accueil";
	}

	@ModelAttribute("group")
	Collection<Group> products() throws SQLException {
		Collection<Group> g = new ArrayList<Group>();
		g = manager.findAllGroups();
		return g;
	}

	@RequestMapping(value = "/savePersonDb")
	public String savePersonDb(Person p, Model model) throws SQLException {
		manager.savePerson(p);
		model.addAttribute("recherche", new Person());
		model.addAttribute("person",null);
		return "GroupList";
	}
	
	@RequestMapping(value = "/rechercher")
	public String rechercher(Person p, Model model) throws SQLException {
		
		model.addAttribute("person", manager.get_Person_by_LastName(p.getLastNamePerson()));
		model.addAttribute("recherche", p);
		return "GroupList";
	}
	
	

}