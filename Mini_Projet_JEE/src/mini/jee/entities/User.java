package mini.jee.entities;

public class User {
	
	private String email;
	private String pwd;
	
	
	
	public User(String email, String pwd) {
		super();
		this.email = email;
		this.pwd = pwd;
	}
	
	public User() {

	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	

}
