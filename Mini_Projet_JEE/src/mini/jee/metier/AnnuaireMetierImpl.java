package mini.jee.metier;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mini.jee.entities.Group;
import mini.jee.entities.Person;
import mini.jee.entities.User;
import mini.jee.dao.IDao;

@Service
public class AnnuaireMetierImpl implements IAnnuaireMetier{

	private IDao dao ;
	
	@Autowired
	public void setDao(IDao dao) {
		this.dao = dao;
	}

	@Override
	public Collection<Group> findAllGroups() throws SQLException {

		return dao.findAllGroups();
	}

	@Override
	public Group findGroup(int idGroup) throws SQLException {
		return dao.findGroup(idGroup);
	}

	@Override
	public Collection<Person> findPersonsInGroup(int idGroup) throws SQLException {
		return dao.findPersonsInGroup(idGroup);
	}

	@Override
	public Collection<Person> findAllPersons() throws SQLException {
		return dao.findAllPersons();
	}

	@Override
	public Person findPerson(int idPerson) throws SQLException {
		return dao.findPerson(idPerson);
	}

	@Override
	public Person savePerson(Person p) throws SQLException {
		return dao.savePerson(p);
	}

	@Override
	public Group saveGroup(Group g) throws SQLException {
		return dao.saveGroup(g);
	}

	@Override
	public Person updatePerson(Person p) throws SQLException {
		return dao.updatePerson(p);
	}

	@Override
	public Group updateGroup(Group g) throws SQLException {
		return dao.updateGroup(g);
	}

	@Override
	public Person deletePerson(Person p) throws SQLException {
		return dao.deletePerson(p);
	}

	@Override
	public Group deleteGroup(Group g) throws SQLException {
		return dao.deleteGroup(g);
	}

	@Override
	public Person get_Email_Pwd_Person(String emailPerson, String pswPerson) throws SQLException {
		// TODO Auto-generated method stub
		return dao.get_Email_Pwd_Person(emailPerson, pswPerson);
	}

	@Override
	public User get_Password_User(String emailPerson) throws SQLException {
		// TODO Auto-generated method stub
		return dao.get_Password_User(emailPerson);
	}

	@Override
	public Person get_Pwd_Person(String emailPerson) throws SQLException {
		// TODO Auto-generated method stub
		return dao.get_Pwd_Person(emailPerson);
	}

	@Override
	public Collection<Person> get_Person_by_LastName(String lastName) throws SQLException {
		// TODO Auto-generated method stub
		return dao.get_Person_by_LastName(lastName);
	}

	@Override
	public List<Group> getGroupByPage(int pageid, int total) throws SQLException {
		
		return dao.getGroupByPage(pageid, total);
	}

	@Override
	public List<Group> findAllGroupsByPage(int pageid, int total) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countGroups() throws SQLException {
		// TODO Auto-generated method stub
		return dao.countGroups();
	}

	@Override
	public Collection<Person> findAllPersonsByPage(int pageid, int total) throws SQLException {
		// TODO Auto-generated method stub
		return dao.findAllPersonsByPage(pageid, total);
	}

	@Override
	public int countPersons() throws SQLException {
		// TODO Auto-generated method stub
		return dao.countPersons();
	}

	@Override
	public List<Person> getPersonByPage(int pageid, int total) throws SQLException {
		// TODO Auto-generated method stub
		return dao.getPersonByPage(pageid, total);
	}

}
