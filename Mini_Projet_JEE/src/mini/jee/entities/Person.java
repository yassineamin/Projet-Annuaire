package mini.jee.entities;

import java.util.Date;

public class Person {

	private int idPerson;
	private String firstNamePerson;
	private String lastNamePerson;
	private String emailPerson;
	private String webSitePerson;
	private String birthayPerson;
	private String pswPerson;
	private int idGroupPerson;

	public Person() {
		super();
	}

	
	public Person(String firstNamePerson, String lastNamePerson, String emailPerson, String webSitePerson,
			String birthayPerson, String pswPerson, int idGroupPerson) {
		super();
		this.firstNamePerson = firstNamePerson;
		this.lastNamePerson = lastNamePerson;
		this.emailPerson = emailPerson;
		this.webSitePerson = webSitePerson;
		this.birthayPerson = birthayPerson;
		this.pswPerson = pswPerson;
		this.idGroupPerson = idGroupPerson;
	}



	public Person(int idPerson, String firstNamePerson, String lastNamePerson, String emailPerson, String webSitePerson,
			String birthayPerson, String pswPerson, int idGroupPerson) {
		super();
		this.idPerson = idPerson;
		this.firstNamePerson = firstNamePerson;
		this.lastNamePerson = lastNamePerson;
		this.emailPerson = emailPerson;
		this.webSitePerson = webSitePerson;
		this.birthayPerson = birthayPerson;
		this.pswPerson = pswPerson;
		this.idGroupPerson = idGroupPerson;
	}



	public String getPswPerson() {
		return pswPerson;
	}



	public void setPswPerson(String pswPerson) {
		this.pswPerson = pswPerson;
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

	public String getBirthayPerson() {
		return birthayPerson;
	}

	public void setBirthayPerson(String birthayPerson) {
		this.birthayPerson = birthayPerson;
	}

	public int getIdGroupPerson() {
		return idGroupPerson;
	}

	public void setIdGroupPerson(int idGroupPerson) {
		this.idGroupPerson = idGroupPerson;
	}


	@Override
	public String toString() {
		return "Person [idPerson=" + idPerson + ", firstNamePerson=" + firstNamePerson + ", lastNamePerson="
				+ lastNamePerson + ", emailPerson=" + emailPerson + ", webSitePerson=" + webSitePerson
				+ ", birthayPerson=" + birthayPerson + ", pswPerson=" + pswPerson + ", idGroupPerson=" + idGroupPerson
				+ "]";
	}

	
}
