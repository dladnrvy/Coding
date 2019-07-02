package mm;

import java.util.Date;

public class MemberSave {
	
	private String uID;
	private String uPW;
	private String uName;
	private Date tDate;
	
	
	public MemberSave(String uID, String uPW, String uName) {
		super();
		this.uID = uID;
		this.uPW = uPW;
		this.uName = uName;
	}
	
	public String getuID() {
		return uID;
	}


	public String getuPW() {
		return uPW;
	}


	public String getuName() {
		return uName;
	}


	public Date gettDate() {
		return tDate;
	}


	public void settDate(Date tDate) {
		this.tDate = tDate;
	}


	public void setuID(String uID) {
		this.uID = uID;
	}


	public void setuPW(String uPW) {
		this.uPW = uPW;
	}


	public void setuName(String uName) {
		this.uName = uName;
	}


	
	
	
	
	
	

}
