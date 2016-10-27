package mini.jee.test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import mini.jee.dao.DaoImpJdbc;
import mini.jee.entities.*;;

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
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter.parse("2012-12-12");

		Person p=new Person("yassine", "meskaoui", "gggg", "gggg", date, "ffff", 2);
		d.savePerson(p);
	}
}
