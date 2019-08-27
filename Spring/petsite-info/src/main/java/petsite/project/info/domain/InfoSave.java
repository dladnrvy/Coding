package petsite.project.info.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class InfoSave {
	
	private int idx;
	private String uId;
	private String title;
	private String text;
	private String photo;
	private String date;
	
	public InfoSave() {}

	public InfoSave(int idx, String uId, String title, String text, String photo, String date) {
		this.idx = idx;
		this.uId = uId;
		this.title = title;
		this.text = text;
		this.photo = photo;
		this.date = date;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
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
		return "InfoSave [idx=" + idx + ", uId=" + uId + ", title=" + title + ", text=" + text + ", photo=" + photo
				+ ", date=" + date + "]";
	}
	
	
	
	

}
