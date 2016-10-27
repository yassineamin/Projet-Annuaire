package mini.jee.dao;

import java.sql.SQLException;
import java.util.Collection;

import mini.jee.entities.Group;
import mini.jee.entities.Person;

public interface IDao {
	
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
	   Person savePerson(Person p);

	   // ajout d'un nouveau groupe
	   Group saveGroup(Group g);
	   
	   // modification d'une personne
	   Person updatePerson(Person p);

	   // modification d'un groupe
	   Group updateGroup(Group g);
	   
	   // ajout d'une personne
	   Person deletePerson(Person p) throws SQLException;

	   // suppression d'un groupe
	   Group deleteGroup(Group g) throws SQLException;

}
