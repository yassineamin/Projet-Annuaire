package mini.jee.test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import mini.jee.dao.DaoImpJdbc;
import mini.jee.entities.*;
import mini.jee.metier.AnnuaireMetierImpl;;

public class DaoImpJdbcTest {

	DaoImpJdbc d = new DaoImpJdbc();
	
	@Test
	public void testfindAllGroups() throws SQLException {

		Collection<Group> maliste = new ArrayList<>();
		maliste = d.findAllGroups();

	}

	@Test
	public void testfindAllPersons() throws SQLException {

		Collection<Person> maliste = new ArrayList<>();
		maliste = d.findAllPersons();
	}
	
	@Test
	public void testSaveGroup() throws SQLException {
		Group g=new Group("Goupe1");
		d.saveGroup(g);
	}
	
	@Test
	public void testSavePerson() throws SQLException, ParseException {

		Person p=new Person("mmmmmmmmm", "bbbbbbbbbb", "gggg", "gggg", "2012-12-12", "ffff", 40);
		d.savePerson(p);
	}
	
	@Test
	public void testdeletegroup()throws SQLException, ParseException {
		Group p=new Group(40,"ffff");
		d.deleteGroup(p);
	}
	
	@Test
	public void testdeleteAllGroup() throws SQLException{
		
		d.deleteAllGroup();
		
	}
	
	@Test
	public void testFindgroup() throws SQLException{
		
		 d.findGroup(40) ;
	}
	
	@Test
	public void testFindPerson() throws SQLException{
		
		 d.findPerson(2) ;
	}
	
	@Test
	public void testupdatePerson() throws SQLException{
		
		 Person p=new Person("mmmmmmmmm", "bbbbbbbbbb", "gggg", "gggg", "2012-12-12", "ffff", 40);
	}
}
