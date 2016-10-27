package mini.jee.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import mini.jee.entities.Group;
import mini.jee.entities.Person;

public class DaoImpJdbc implements IDao{
	
	private String nom = "bd-projet-jee";
	private String url = "jdbc:mysql://localhost/bd-projet-jee";
	private String login = "root";
	private String password = "";
	Connection conn;
	DaoImpJdbc dij;
	Group group;
	Person person;
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void init() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
	}
	
	public void close() throws SQLException {
		conn.close();
	}
	
	public Connection newConnection() throws SQLException {
		conn = (Connection) DriverManager.getConnection(url, login, password);
		return conn;
	}

	@Override
	public Collection<Group> findAllGroups() throws SQLException {
		String query = "select * from group_person";
		Collection<Group> listGroup = new ArrayList<Group>();

		try (Connection conn = newConnection()) {
			
			Statement st= (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs= st.executeQuery(query);
			
			while(rs.next()){
				group = new Group(rs.getInt(1),rs.getString(2));
				listGroup.add(group);
			}
		} 
		return listGroup;
	}

	@Override
	public Group findGroup(int idGroup) throws SQLException {
		String query = "select * from group_person where idGroup="+idGroup;
				
		try (Connection conn = newConnection()) {
			
			Statement st= (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs= st.executeQuery(query);
			group = new Group(rs.getInt(1),rs.getString(2));
		}
		return group;
	}

	@Override
	public Collection<Person> findAllPersons(int idGroup) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Person> findAllPersons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person findPerson(int idPerson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person savePerson(Person p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group saveGroup(Group g) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person updatePerson(Person p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group updateGroup(Group g) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person deletePerson(Person p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group deleteGroup(Group g) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
