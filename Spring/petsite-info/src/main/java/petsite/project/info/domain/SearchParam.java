package petsite.project.info.domain;

public class SearchParam {
	
	private String text;
	

	public String gettext() {
		return text;
	}
	public void settext(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return "SearchParam [text=" + text + "]";
	}
	
	

}
