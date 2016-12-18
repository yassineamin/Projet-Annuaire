package mini.jee.metier;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import mini.jee.entities.Group;
import mini.jee.entities.Person;
import mini.jee.entities.User;

public interface IAnnuaireMetier {

	// récupérer les groupes
	Collection<Group> findAllGroups() throws SQLException;

	// récupérer un groupe
	Group findGroup(int idGroup) throws SQLException;

	// récupérer les personnes d'un groupe
	Collection<Person> findPersonsInGroup(int idGroup) throws SQLException;

	// récupérer les personnes
	Collection<Person> findAllPersons() throws SQLException;

	// lire une personne
	Person findPerson(int idPerson) throws SQLException;

	// ajout d'une nouvelle personne
	Person savePerson(Person p) throws SQLException;

	// ajout d'un nouveau groupe
	Group saveGroup(Group g) throws SQLException;

	// modification d'une personne
	Person updatePerson(Person p) throws SQLException;

	// modification d'un groupe
	Group updateGroup(Group g) throws SQLException;

	// ajout d'une personne
	Person deletePerson(Person p) throws SQLException;

	// suppression d'un groupe
	Group deleteGroup(Group g) throws SQLException;

	Person get_Email_Pwd_Person(String emailPerson, String pswPerson) throws SQLException;

	public User get_Password_User(String emailPerson) throws SQLException;

	Person get_Pwd_Person(String emailPerson) throws SQLException;

	Collection<Person> get_Person_by_LastName(String lastName) throws SQLException;

	List<Group> getGroupByPage(int pageid, int total) throws SQLException;

	List<Group> findAllGroupsByPage(int pageid, int total);
	int countGroups() throws SQLException;
	
	Collection<Person> findAllPersonsByPage(int pageid, int total) throws SQLException;

	int countPersons()throws SQLException;
	
	List<Person> getPersonByPage(int pageid, int total)throws SQLException;

}
