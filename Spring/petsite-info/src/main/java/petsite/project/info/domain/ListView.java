package petsite.project.info.domain;

import java.util.List;

public class ListView {

	private List<InfoSave> infoList;
	private int count;
	private int pageNum;
	private int pageTotal;
	private int pageTotalCount;
	
	
	
	public int getPageTotalCount() {
		return pageTotalCount;
	}
	public void setPageTotalCount(int pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}
	public List<InfoSave> getInfoList() {
		return infoList;
	}
	public void setInfoList(List<InfoSave> infoList) {
		this.infoList = infoList;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	
	
}
