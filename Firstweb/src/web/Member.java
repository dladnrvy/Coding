package web;

public class Member {

	private String name;
	private String id;
	private String pNum;

	public Member(String id,String name,String pNum) {
		this.id = id;
		this.name = name;
		this.pNum = pNum;
}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpNum() {
		return pNum;
	}

	public void setpNum(String pNum) {
		this.pNum = pNum;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", id=" + id + ", pNum=" + pNum + "]";
	}

}
