package mini.jee.entities;

public class Group {

	private int idGroup;
	private String NameGroup;

	public Group() {
		super();
	}

	public Group(String nameGroup) {
		super();
		NameGroup = nameGroup;
	}

	public Group(int idGroup, String nameGroup) {
		super();
		this.idGroup = idGroup;
		NameGroup = nameGroup;
	}

	public int getIdGroup() {
		return idGroup;
	}

	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}

	public String getNameGroup() {
		return NameGroup;
	}

	public void setNameGroup(String nameGroup) {
		NameGroup = nameGroup;
	}

}
