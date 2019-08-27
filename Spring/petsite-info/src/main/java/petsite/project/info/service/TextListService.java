package petsite.project.info.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petsite.project.info.dao.InfoDao;
import petsite.project.info.domain.InfoList;
import petsite.project.info.domain.InfoSave;
import petsite.project.info.domain.ListView;
import petsite.project.info.domain.SearchParam;

@Service("selectList")
public class TextListService {

	@Autowired
	private SqlSessionTemplate template;
	
	private InfoDao dao;
	
	//4x3 
	final int COUNT = 12;
	
	public InfoSave selectList(int idx) {
		
		dao = template.getMapper(InfoDao.class);
		
		InfoSave infolist = null;
		
		infolist = dao.selectList(idx);
		
	return infolist;	
	}
	
	public ListView countList(int pageNum, SearchParam searchParam) {
		
		dao = template.getMapper(InfoDao.class);
		
		ListView list = new ListView();
		
		//현재 페이지 번호
		list.setCount(pageNum);
		
		//전체게시물의 개수
		int total = dao.selectCount(searchParam);
		
		//전체 페이지 개수
		int totalPage = 0;
		
		if(total > 0) {
			totalPage = total/COUNT;
			if(total % COUNT >0) {
				totalPage++;
			}
		}
		list.setPageTotal(totalPage);
		
		int index = (pageNum-1)*COUNT;
		
		List<InfoSave> infoList = null;
		Map<String,Object> search = new HashMap<String, Object>();
		search.put("search", searchParam);
		search.put("index",index);
		search.put("count",COUNT);
		
		/* list.setInfoList(infoList); */
		int no = total = index;
		list.setPageNum(no);
		list.setPageTotalCount(total);
		
		
		return list;
	}
}
