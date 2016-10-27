package mini.jee.entities;

import java.util.Date;

public class Person {

	private int idPerson;
	private String firstNamePerson;
	private String lastNamePerson;
	private String emailPerson;
	private String webSitePerson;
	private Date birthayPerson;
	private int idGroupPerson;

	public Person() {
		super();
	}

	public Person(int idPerson, String firstNamePerson, String lastNamePerson, String emailPerson, String webSitePerson,
			Date birthayPerson, int idGroupPerson) {
		super();
		this.idPerson = idPerson;
		this.firstNamePerson = firstNamePerson;
		this.lastNamePerson = lastNamePerson;
		this.emailPerson = emailPerson;
		this.webSitePerson = webSitePerson;
		this.birthayPerson = birthayPerson;
		this.idGroupPerson = idGroupPerson;
	}

	public int getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public String getFirstNamePerson() {
		return firstNamePerson;
	}

	public void setFirstNamePerson(String firstNamePerson) {
		this.firstNamePerson = firstNamePerson;
	}

	public String getLastNamePerson() {
		return lastNamePerson;
	}

	public void setLastNamePerson(String lastNamePerson) {
		this.lastNamePerson = lastNamePerson;
	}

	public String getEmailPerson() {
		return emailPerson;
	}

	public void setEmailPerson(String emailPerson) {
		this.emailPerson = emailPerson;
	}

	public String getWebSitePerson() {
		return webSitePerson;
	}

	public void setWebSitePerson(String webSitePerson) {
		this.webSitePerson = webSitePerson;
	}

	public Date getBirthayPerson() {
		return birthayPerson;
	}

	public void setBirthayPerson(Date birthayPerson) {
		this.birthayPerson = birthayPerson;
	}

	public int getIdGroupPerson() {
		return idGroupPerson;
	}

	public void setIdGroupPerson(int idGroupPerson) {
		this.idGroupPerson = idGroupPerson;
	}


}
