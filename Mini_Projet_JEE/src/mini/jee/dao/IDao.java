package mini.jee.dao;

import java.sql.SQLException;
import java.util.Collection;

import mini.jee.entities.Group;
import mini.jee.entities.Person;

public interface IDao {
	
	   // r�cup�rer les groupes
	   Collection<Group> findAllGroups() throws SQLException;
	   
	   // r�cup�rer un groupe
	   Group findGroup(int idGroup) throws SQLException;

	   // r�cup�rer les personnes d'un groupe
	   Collection<Person> findPersonsInGroup(int idGroup) throws SQLException;
	   
	   // r�cup�rer les personnes 
	   Collection<Person> findAllPersons() throws SQLException;

	   // lire une personne
	   Person findPerson(int idPerson) throws SQLException;

	   // ajout d'une nouvelle personne
	   Person savePerson(Person p)throws SQLException;

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

	void deleteAllGroup() throws SQLException;

	Person get_Email_Pwd_Person(String emailPerson, String pswPerson) throws SQLException;

}
