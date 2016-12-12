//package mini.jee.controllers;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Collection;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.support.AbstractApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//
//import mini.jee.dao.DaoImpJdbc;
//import mini.jee.dao.IDao;
//import mini.jee.entities.Group;
//import mini.jee.metier.IAnnuaireMetier;
//
//@Controller
//@RequestMapping("/personne")
//public class AnnuaireController {	
//	
//    @Autowired
//    IAnnuaireMetier manager;
//	
////    
////	IAnnuaireMetier  run() {
////        String conf = "spring.xml";
////        AbstractApplicationContext context = new ClassPathXmlApplicationContext(conf);
////        context.registerShutdownHook();
////        
////        IAnnuaireMetier manager=(IAnnuaireMetier) context.getBean("metier");
////        return manager;
////        
////    }
////	
//    @ModelAttribute("group")
//     Collection<Group> products() throws SQLException {
//    	
//		Collection <Group> g = new ArrayList<Group>();
//		 g = manager.findAllGroups();
//        return g;
//    }
//    
//	@RequestMapping(value="/GroupList")
//	public String index(){
//		return "GroupList";
//		
//	}
//	
//	@RequestMapping(value="/connect")
//	public String login(){
//		return "login";
//		
//	}
//    
////    @RequestMapping(value = "/welcome")
////    public ModelAndView sayHello() {
////        String now = (new Date()).toString();
////        return new ModelAndView("hello", "now", now);
////    }
//		
//}
