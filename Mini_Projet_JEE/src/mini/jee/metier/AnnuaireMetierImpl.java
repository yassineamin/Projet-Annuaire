package mini.jee.metier;

import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mini.jee.entities.Group;
import mini.jee.entities.Person;
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

}
