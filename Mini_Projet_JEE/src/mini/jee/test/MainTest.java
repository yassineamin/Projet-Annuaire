package mini.jee.test;
import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mysql.jdbc.PreparedStatement;
import com.sun.activation.registries.MailcapParseException;

import mini.jee.entities.Group;
import mini.jee.metier.IAnnuaireMetier;


public class MainTest {
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		
//		String conf = "spring.xml";
//        AbstractApplicationContext context = new ClassPathXmlApplicationContext(conf);
//        context.registerShutdownHook();
//
//        // recuperer les beans
//        
//        IAnnuaireMetier metier=(IAnnuaireMetier) context.getBean("metier");
//	
//		
//        Group g=new Group(2, "oooooo");
//        metier.saveGroup(g);
//        System.out.println("success");
		
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
					InternetAddress.parse("amin.yassine93@gmail.com"));
			message.setSubject("Testing Subject");
			message.setText("Wash a 7imari," 
);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			//throw new RuntimeException(e);
			System.out.println(e.getMessage());
		}
	}

}
