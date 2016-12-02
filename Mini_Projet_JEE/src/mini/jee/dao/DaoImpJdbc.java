package mini.jee.dao;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Service;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import mini.jee.entities.Group;
import mini.jee.entities.Person;

public class DaoImpJdbc implements IDao {

	Connection conn;
	DaoImpJdbc dij;
	PreparedStatement st = null;	
	private ConnectionJdbc my_conn ;
	
	
	
	public void setMy_conn(ConnectionJdbc my_conn) {
		this.my_conn = my_conn;
	}
	public Connection newConnection() throws SQLException {
		return my_conn.newConnection();
	}

	@Override
	public Collection<Group> findAllGroups() throws SQLException {
		Collection<Group> listGroup = new ArrayList<Group>();
		String findAllGroupsQuery = "select * from group_person";
		
		try (Connection conn = newConnection()) {
			st = (PreparedStatement) conn.prepareStatement(findAllGroupsQuery);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				Group g = new Group(rs.getInt(1), rs.getString(2));
				listGroup.add(g);
			}
		}
		return listGroup;
	}

	@Override
	public Group findGroup(int idGroup) throws SQLException {
		String findGroupQuery = "select * from group_person where idGroup = ?";
		Group g;
		try (Connection conn = newConnection()) {
			st = (PreparedStatement) conn.prepareStatement(findGroupQuery);
			st.setInt(1, idGroup);
			ResultSet rs = st.executeQuery();
			g = new Group(rs.getInt(1),rs.getString(2));
		}
		return g;
	}

	@Override
	public Collection<Person> findPersonsInGroup(int idGroup) throws SQLException {
		Collection<Person> listPersonsInGroup = new ArrayList<Person>();
		String findPersonsInGroupQuery = "select * from person where idGroup = ?";
		try (Connection conn = newConnection()) {
			st = (PreparedStatement) conn.prepareStatement(findPersonsInGroupQuery);
			st.setInt(1, idGroup);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
				Person p = new Person(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
						rs.getDate(6),rs.getString(7),rs.getInt(8));
				listPersonsInGroup.add(p);
			}
		}
		return listPersonsInGroup;
	}

	@Override
	public Collection<Person> findAllPersons() throws SQLException {
		Collection<Person> listAllPersons = new ArrayList<Person>();
		String findAllPersonsQuery = "select * from person";
		
		try (Connection conn = newConnection()) {
			st = (PreparedStatement) conn.prepareStatement(findAllPersonsQuery);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				Person p = new Person(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
						rs.getDate(6),rs.getString(7),rs.getInt(8));
				listAllPersons.add(p);
			}
		}
		return listAllPersons;
	}

	@Override
	public Person findPerson(int idPerson) throws SQLException {
		Person p;
		String findPersonQuery = "select * from person where idPerson = ?";
		try (Connection conn = newConnection()) {
			st = (PreparedStatement) conn.prepareStatement(findPersonQuery);
			st.setInt(1, idPerson);
			ResultSet rs = st.executeQuery();
			p = new Person(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
					rs.getDate(6),rs.getString(7),rs.getInt(8));
		}
		return p;
	}

	@Override
	public Person savePerson(Person p) throws SQLException {
		String savePersonQuery = "insert into person (firstnameperson,lastnameperson,"
				+ "emailPerson,siteWebPerson,birthdayPerson,pswPerson,idGroup) values(?,?,?,?,?,?,?)";
		try (Connection conn = newConnection()) {
			st = (PreparedStatement) conn.prepareStatement(savePersonQuery);
			st.setString(1, p.getFirstNamePerson());
			st.setString(2, p.getLastNamePerson());
			st.setString(3, p.getEmailPerson());
			st.setString(4, p.getWebSitePerson());
			st.setObject(5, p.getBirthayPerson());
			st.setString(6, p.getPswPerson());
			st.setInt(7, p.getIdGroupPerson());
			st.executeUpdate();
		}
		return p;
	}

	@Override
	public Group saveGroup(Group g) throws SQLException {
		String saveGroupQuery = "insert into group_person(namegroup) values(?)";
		try (Connection conn = newConnection()) {
			st = (PreparedStatement) conn.prepareStatement(saveGroupQuery);
			st.setString(1, g.getNameGroup());
			st.execute();
		}
		return g;
	}

	@Override
	public Person updatePerson(Person p)  throws SQLException{
		String updatePersonQuery ="update person set firstnameperson=?, lastnameperson=?, emailPerson=?, "
				+ "siteWebPerson=?, birthdayPerson=?, pswPerson=?, idGroup=? where idperson=?";
		try (Connection conn = newConnection()) {
			st = (PreparedStatement) conn.prepareStatement(updatePersonQuery);
			st.setString(1, p.getFirstNamePerson());
			st.setString(2, p.getLastNamePerson());
			st.setString(3, p.getEmailPerson());
			st.setString(4, p.getWebSitePerson());
			st.setObject(5, p.getBirthayPerson());
			st.setString(6, p.getPswPerson());
			st.setInt(7, p.getIdGroupPerson());
			st.setInt(8, p.getIdPerson());
			st.execute();
		}
		return p;
	}

	@Override
	public Group updateGroup(Group g) throws SQLException {
		String updateGroupQuery = "update group_person set namegroup=? where idgroup=?";
		try (Connection conn = newConnection()) {
			st = (PreparedStatement) conn.prepareStatement(updateGroupQuery);
			st.setString(1, g.getNameGroup());
			st.setInt(2, g.getIdGroup());
			st.execute();
		}
		return g;
	}

	@Override
	public Person deletePerson(Person p) throws SQLException {
		String deletePersonQuery = "delete from person where idperson = ?";
		try (Connection conn = newConnection()) {
			st = (PreparedStatement) conn.prepareStatement(deletePersonQuery);
			st.setInt(1, p.getIdPerson());
			st.execute();
		}
		return p;
	}

	@Override
	public Group deleteGroup(Group g) throws SQLException {
		String deleteGroupQuery = "delete from group_person where idgroup=?";
		try (Connection conn = newConnection()) {
			st = (PreparedStatement) conn.prepareStatement(deleteGroupQuery);
			st.setInt(1, g.getIdGroup());
			st.executeUpdate();
		}
		return g;
	}
}
