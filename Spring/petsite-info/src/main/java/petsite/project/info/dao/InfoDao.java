package petsite.project.info.dao;

import java.util.List;

import petsite.project.info.domain.InfoList;
import petsite.project.info.domain.InfoSave;
import petsite.project.info.domain.SearchParam;

public interface InfoDao {

	//글 작성
	public int insertWrite(InfoSave infoSave);
	
	//글 수정
	public int update(InfoSave infoSave);
	
	//글 삭제
	public int delete(int idx);
	
	//게시물 개수
	public int selectCount(InfoSave infosave);
	
	//게시물 검색
	public 
	
	//게시물 LIST
	public List<InfoList> AllList();
	
	//게시물 내용 idx받아서
	public InfoSave selectList(int idx);
}
