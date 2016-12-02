package mini.jee.test;
import java.sql.SQLException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mini.jee.entities.Group;
import mini.jee.metier.IAnnuaireMetier;

public class MainTest {
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		
		String conf = "spring.xml";
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(conf);
        context.registerShutdownHook();

        // recuperer les beans
        
        IAnnuaireMetier metier=(IAnnuaireMetier) context.getBean("metier");
        Group g=new Group(2, "oooooo");
        metier.saveGroup(g);
        System.out.println("success");
		
		

	}

}
