package mini.jee.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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

//	@Override
//	public Collection<Group> findAllGroups() throws SQLException {
//		Collection<Group> listGroup = new ArrayList<Group>();
//		String findAllGroupsQuery = "select * from group_person";
//
//		try (Connection conn = newConnection()) {
//			st = (PreparedStatement) conn.prepareStatement(findAllGroupsQuery);
//			ResultSet rs = st.executeQuery();
//
//			while (rs.next()) {
//				Group g = new Group(rs.getInt(1), rs.getString(2));
//				listGroup.add(g);
//			}
//		}
//		return listGroup;
//	}
	
    final private RowMapper<Group> messageMapper = new RowMapper<Group>() {

        @Override
        public Group mapRow(ResultSet arg0, int arg1) throws SQLException {
        	Group m = new Group();
            m.setIdGroup(arg0.getInt("idGroup"));
            m.setNameGroup(arg0.getString("nameGroup"));
            return m;
        }

    };
	
	@Override
	public Collection<Group> findAllGroups() throws SQLException {
		//Collection<Group> listGroup = new ArrayList<Group>();
		
		return this.jdbcTemplate.query("select * from group_person", messageMapper) ;
	}

	@Override
	public Group findGroup(int idGroup) throws SQLException {
		String findGroupQuery = "select * from group_person where idGroup = ?";
		Group g;
		try (Connection conn = newConnection()) {
			st = (PreparedStatement) conn.prepareStatement(findGroupQuery);
			st.setInt(1, idGroup);
			ResultSet rs = st.executeQuery();
			g = new Group(rs.getInt(1), rs.getString(2));
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

			while (rs.next()) {
				Person p = new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getDate(6), rs.getString(7), rs.getInt(8));
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
				Person p = new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getDate(6), rs.getString(7), rs.getInt(8));
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
			p = new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getDate(6), rs.getString(7), rs.getInt(8));
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
	public Person updatePerson(Person p) throws SQLException {
		String updatePersonQuery = "update person set firstnameperson=?, lastnameperson=?, emailPerson=?, "
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
	
	@Override
	public  void deleteAllGroup() throws SQLException {
		this.jdbcTemplate.update("delete from group_person");
	
	}
	
}
