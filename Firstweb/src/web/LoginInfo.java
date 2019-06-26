package web;

public class LoginInfo {
	
	private String id;
	private String name;
	private String photo;
	private String nicname;
	private int grade;
	private String pNum;
	
	public LoginInfo(String id) {
		this.id = id;
		this.name = "욱표";
		this.photo = "noimg";
		this.nicname = "uk";
		this.grade = 1;
		this.pNum = "010-0000-0000";
	}

	public LoginInfo(String id, String name, String photo, String nicname, int grade, String pNum) {
		this.id = id;
		this.name = name;
		this.photo = photo;
		this.nicname = nicname;
		this.grade = grade;
		this.pNum = pNum;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPhoto() {
		return photo;
	}

	public String getNicname() {
		return nicname;
	}

	public int getGrade() {
		return grade;
	}

	public String getpNum() {
		return pNum;
	}
	
	
}
