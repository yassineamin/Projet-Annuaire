package mini.jee.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import mini.jee.entities.Group;
import mini.jee.entities.Person;

@Service
public class DaoImpJdbc implements IDao {

	private String url = "jdbc:mysql://localhost/bd-projet-jee";
	private String login = "root";
	private String password = "";
	Connection conn;
	DaoImpJdbc dij;
	PreparedStatement st = null;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private JdbcTemplate jdbcTemplate;

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

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
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

	// @Override
	// public Collection<Group> findAllGroups() throws SQLException {
	// Collection<Group> listGroup = new ArrayList<Group>();
	// String findAllGroupsQuery = "select * from group_person";
	//
	// try (Connection conn = newConnection()) {
	// st = (PreparedStatement) conn.prepareStatement(findAllGroupsQuery);
	// ResultSet rs = st.executeQuery();
	//
	// while (rs.next()) {
	// Group g = new Group(rs.getInt(1), rs.getString(2));
	// listGroup.add(g);
	// }
	// }
	// return listGroup;
	// }

	final private RowMapper<Group> GroupMapper = new RowMapper<Group>() {

		@Override
		public Group mapRow(ResultSet arg0, int arg1) throws SQLException {
			Group m = new Group();
			m.setIdGroup(arg0.getInt("idGroup"));
			m.setNameGroup(arg0.getString("nameGroup"));
			return m;
		}

	};
	
	final private RowMapper<Group> OneGroupMapper = new RowMapper<Group>() {

		@Override
		public Group mapRow(ResultSet arg0, int arg1) throws SQLException {
			Group m = new Group();
			m.setIdGroup(arg0.getInt("idGroup"));
			m.setNameGroup(arg0.getString("nameGroup"));
			return m;
		}

	};

	final private RowMapper<Person> PersonMapper = new RowMapper<Person>() {

		@Override
		public Person mapRow(ResultSet arg0, int arg1) throws SQLException {
			Person m = new Person();
			m.setIdPerson(arg0.getInt("idPerson"));
			m.setFirstNamePerson(arg0.getString("firstNamePerson"));
			m.setLastNamePerson(arg0.getString("lastNamePerson"));
			m.setEmailPerson(arg0.getString("emailPerson"));
			m.setWebSitePerson(arg0.getString("webSitePerson"));
			m.setBirthayPerson(arg0.getDate("birthayPerson"));
			m.setPswPerson(arg0.getString("pswPerson"));
			m.setIdGroupPerson(arg0.getInt("idGroup"));

			return m;
		}

	};
	
	final private RowMapper<Person> PersonInGroupMapper = new RowMapper<Person>() {

		@Override
		public Person mapRow(ResultSet arg0, int arg1) throws SQLException {
			Person m = new Person();
			m.setIdPerson(arg0.getInt("idPerson"));
			m.setFirstNamePerson(arg0.getString("firstNamePerson"));
			m.setLastNamePerson(arg0.getString("lastNamePerson"));
			m.setEmailPerson(arg0.getString("emailPerson"));
			m.setWebSitePerson(arg0.getString("webSitePerson"));
			m.setBirthayPerson(arg0.getDate("birthayPerson"));
			m.setPswPerson(arg0.getString("pswPerson"));
			m.setIdGroupPerson(arg0.getInt("idGroupPerson"));

			return m;
		}

	};
	
	final private RowMapper<Person> FindPersonMapper = new RowMapper<Person>() {

		@Override
		public Person mapRow(ResultSet arg0, int arg1) throws SQLException {
			Person m = new Person();
			m.setIdPerson(arg0.getInt("idPerson"));
			m.setFirstNamePerson(arg0.getString("firstNamePerson"));
			m.setLastNamePerson(arg0.getString("lastNamePerson"));
			m.setEmailPerson(arg0.getString("emailPerson"));
			m.setWebSitePerson(arg0.getString("siteWebPerson"));
			m.setBirthayPerson(arg0.getDate("birthdayPerson"));
			m.setPswPerson(arg0.getString("pswPerson"));
			m.setIdGroupPerson(arg0.getInt("idGroup"));

			return m;
		}

	};
	
	final private RowMapper<Person> FindPersonLoginMapper = new RowMapper<Person>() {

		@Override
		public Person mapRow(ResultSet arg0, int arg1) throws SQLException {
			Person m = new Person();
			m.setIdPerson(arg0.getInt("idPerson"));
			m.setFirstNamePerson(arg0.getString("firstNamePerson"));
			m.setLastNamePerson(arg0.getString("lastNamePerson"));
			m.setEmailPerson(arg0.getString("emailPerson"));
			m.setWebSitePerson(arg0.getString("webSitePerson"));
			m.setBirthayPerson(arg0.getDate("birthayPerson"));
			m.setPswPerson(arg0.getString("pswPerson"));
			m.setIdGroupPerson(arg0.getInt("idGroupPerson"));

			return m;
		}

	};

	@Override
	public Collection<Group> findAllGroups() throws SQLException {

		return this.jdbcTemplate.query("select * from group_person", GroupMapper);
	}

//	@Override
//	public Group findGroup(int idGroup) throws SQLException {
//		String findGroupQuery = "select * from group_person where idGroup = "+idGroup;
//		Group g;
//		try (Connection conn = newConnection()) {
//			Statement st = conn.createStatement();
//			ResultSet rs = st.executeQuery(findGroupQuery);
//			rs.next();
//			g = new Group(rs.getInt(1), rs.getString(2));
//		}
//		return g;
//	}
	
	@Override
	public Group findGroup(int idGroup) throws SQLException {
		
		ArrayList<Group> maliste=new ArrayList<Group>();
		String findGroupQuery = "select  from group_person where idGroup ="+idGroup;
		maliste = (ArrayList<Group>) this.jdbcTemplate.query(findGroupQuery,OneGroupMapper);
		
		return maliste.get(0);
	}

//	@Override
//	public Collection<Person> findPersonsInGroup(int idGroup) throws SQLException {
//		Collection<Person> listPersonsInGroup = new ArrayList<Person>();
//		String findPersonsInGroupQuery = "select * from person where idGroup = ?";
//		try (Connection conn = newConnection()) {
//			st = (PreparedStatement) conn.prepareStatement(findPersonsInGroupQuery);
//			st.setInt(1, idGroup);
//			ResultSet rs = st.executeQuery();
//
//			while (rs.next()) {
//				Person p = new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
//						rs.getDate(6), rs.getString(7), rs.getInt(8));
//				listPersonsInGroup.add(p);
//			}
//		}
//		return listPersonsInGroup;
//	}

	@Override
	public Collection<Person> findPersonsInGroup(int idGroup) throws SQLException {
		String findPersonsInGroupQuery = "select * from person where idGroup = ?";
		return this.jdbcTemplate.query(findPersonsInGroupQuery, PersonInGroupMapper);
	}
	
	// @Override
	// public Collection<Person> findAllPersons() throws SQLException {
	// Collection<Person> listAllPersons = new ArrayList<Person>();
	// String findAllPersonsQuery = "select * from person";
	//
	// try (Connection conn = newConnection()) {
	// st = (PreparedStatement) conn.prepareStatement(findAllPersonsQuery);
	// ResultSet rs = st.executeQuery();
	//
	// while (rs.next()) {
	// Person p = new Person(rs.getInt(1), rs.getString(2), rs.getString(3),
	// rs.getString(4), rs.getString(5),
	// rs.getDate(6), rs.getString(7), rs.getInt(8));
	// listAllPersons.add(p);
	// }
	// }
	// return listAllPersons;
	// }

	@Override
	public Collection<Person> findAllPersons() throws SQLException {
		String query = "select * from person";
		return this.jdbcTemplate.query(query, PersonMapper);
	}

//	@Override
//	public Person findPerson(int idPerson) throws SQLException {
//		Person p;
//		String findPersonQuery = "select * from person where idPerson = "+idPerson;
//		try (Connection conn = newConnection()) {
//			Statement st = conn.createStatement();
//			ResultSet rs = st.executeQuery(findPersonQuery);
//			rs.next();
//			p = new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
//					rs.getDate(6), rs.getString(7), rs.getInt(8));
//		}
//		return p;
//	}

	@Override
	public Person findPerson(int idPerson) throws SQLException {

		ArrayList<Person> maliste=new ArrayList<>();
		String findPersonQuery = "select * from person where idPerson = "+idPerson;
		maliste = (ArrayList<Person>) this.jdbcTemplate.query(findPersonQuery, FindPersonMapper);
		
		return maliste.get(0);
	}
	
	@Override
	public Person get_Email_Pwd_Person(String emailPerson, String pswPerson) throws SQLException {
		
		Person p;
		String findPersonQuery = "select * from person where emailPerson = '"+emailPerson+"' and pswPerson = '"+pswPerson+"'";
		try (Connection conn = newConnection()) {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(findPersonQuery);
			rs.next();
			p = new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getDate(6), rs.getString(7), rs.getInt(8));
		}
		return p;
	}
	
	 @Override
	 public Person savePerson(Person p) throws SQLException {
	 String savePersonQuery = "insert into person (firstnameperson,lastnameperson,emailPerson,siteWebPerson,birthdayPerson,pswPerson,idGroup) values(?,?,?,?,?,?,?)";
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

//	@Override
//	public Person savePerson(Person p) throws SQLException {
//		String query = "insert into person (firstnameperson,lastnameperson,"
//				+ "emailPerson,siteWebPerson,birthdayPerson,pswPerson,idGroup) values(?,?,?,?,?,?,?)";
//
//		this.jdbcTemplate.update(query, p.getFirstNamePerson(), p.getLastNamePerson(), p.getEmailPerson(),
//				p.getWebSitePerson(), p.getBirthayPerson(), p.getPswPerson(), p.getIdGroupPerson());
//
//		return p;
//	}

	// @Override
	// public Group saveGroup(Group g) throws SQLException {
	// String saveGroupQuery = "insert into group_person(namegroup) values(?)";
	// try (Connection conn = newConnection()) {
	// st = (PreparedStatement) conn.prepareStatement(saveGroupQuery);
	// st.setString(1, g.getNameGroup());
	// st.execute();
	// }
	// return g;
	// }

	@Override
	public Group saveGroup(Group g) throws SQLException {
		String query = "insert into group_person(namegroup) values(?)";
		this.jdbcTemplate.update(query, g.getNameGroup());
		return g;
	}

	@Override
	// public Person updatePerson(Person p) throws SQLException {
	// String updatePersonQuery = "update person set firstnameperson=?,
	// lastnameperson=?, emailPerson=?, "
	// + "siteWebPerson=?, birthdayPerson=?, pswPerson=?, idGroup=? where
	// idperson=?";
	// try (Connection conn = newConnection()) {
	// st = (PreparedStatement) conn.prepareStatement(updatePersonQuery);
	// st.setString(1, p.getFirstNamePerson());
	// st.setString(2, p.getLastNamePerson());
	// st.setString(3, p.getEmailPerson());
	// st.setString(4, p.getWebSitePerson());
	// st.setObject(5, p.getBirthayPerson());
	// st.setString(6, p.getPswPerson());
	// st.setInt(7, p.getIdGroupPerson());
	// st.setInt(8, p.getIdPerson());
	// st.execute();
	// }
	// return p;
	// }

	public Person updatePerson(Person p) throws SQLException {
		String query = "update person set firstnameperson=?, lastnameperson=?, emailPerson=?, "
				+ "siteWebPerson=?, birthdayPerson=?, pswPerson=?, idGroup=? where idperson=?";

		this.jdbcTemplate.update(query, p.getFirstNamePerson(), p.getLastNamePerson(), p.getEmailPerson(),
				p.getWebSitePerson(), p.getBirthayPerson(), p.getPswPerson(), p.getIdGroupPerson(), p.getIdPerson());

		return p;
	}

	// @Override
	// public Group updateGroup(Group g) throws SQLException {
	// String updateGroupQuery = "update group_person set namegroup=? where
	// idgroup=?";
	// try (Connection conn = newConnection()) {
	// st = (PreparedStatement) conn.prepareStatement(updateGroupQuery);
	// st.setString(1, g.getNameGroup());
	// st.setInt(2, g.getIdGroup());
	// st.execute();
	// }
	// return g;
	// }

	@Override
	public Group updateGroup(Group g) throws SQLException {

		this.jdbcTemplate.update("update group_person set namegroup=? where idgroup=?", g.getIdGroup());
		return g;
	}

	// @Override
	// public Person deletePerson(Person p) throws SQLException {
	// String deletePersonQuery = "delete from person where idperson = ?";
	// try (Connection conn = newConnection()) {
	// st = (PreparedStatement) conn.prepareStatement(deletePersonQuery);
	// st.setInt(1, p.getIdPerson());
	// st.execute();
	// }
	// return p;
	// }

	@Override
	public Person deletePerson(Person p) throws SQLException {
		this.jdbcTemplate.update("delete from person where idperson = ?", p.getIdPerson());
		return p;
	}

	// @Override
	// public Group deleteGroup(Group g) throws SQLException {
	// String deleteGroupQuery = "delete from group_person where idgroup=?";
	// try (Connection conn = newConnection()) {
	// st = (PreparedStatement) conn.prepareStatement(deleteGroupQuery);
	// st.setInt(1, g.getIdGroup());
	// st.executeUpdate();
	// }
	// return g;
	// }

	@Override
	public Group deleteGroup(Group g) throws SQLException {
		this.jdbcTemplate.update("delete from group_person where idgroup=?", g.getIdGroup());
		return g;
	}

	@Override
	public void deleteAllGroup() throws SQLException {
		this.jdbcTemplate.update("delete from group_person");

	}




}
