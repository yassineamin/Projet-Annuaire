package mini.jee.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectionJdbc {

	private String url = "jdbc:mysql://localhost/bd-projet-jee";
	private String login = "root";
	private String password = "";
	Connection conn;
	
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
	
	
	
}
