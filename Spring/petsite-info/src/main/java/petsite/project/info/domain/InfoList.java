package petsite.project.info.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;


public class InfoList {

	private String uId;
	private String title;
	private String text;
	private MultipartFile photo;
	private String date;
	
	public InfoList() {}
	
	public InfoList(String uId, String title, String text, MultipartFile photo, String date) {
		this.uId = uId;
		this.title = title;
		this.text = text;
		this.photo = photo;
		this.date = date;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "InfoList [uId=" + uId + ",| title=" + title + ",| text=" + text + ",| photo=" + photo + ",| date=" + date
				+ "]";
	}
	
	public InfoSave toInfoSave() {
		
		InfoSave info = new InfoSave();
		info.setuId(uId);
		info.setTitle(title);
		info.setText(text);
		
		return info;
	}
	
	
		
	

}
