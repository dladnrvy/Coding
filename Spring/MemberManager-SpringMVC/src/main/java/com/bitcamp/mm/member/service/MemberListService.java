package com.bitcamp.mm.member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.mm.jdbc.ConnectionProvider;
import com.bitcamp.mm.member.dao.MemberDao;
import com.bitcamp.mm.member.dao.MemberSessionDao;
import com.bitcamp.mm.member.dao.MemberTemplateDao;
import com.bitcamp.mm.member.domain.ListViewData;
import com.bitcamp.mm.member.domain.MemberInfo;
import com.bitcamp.mm.member.domain.SearchParam;

@Service("listService")
public class MemberListService implements MemberService {

	/*
	 * @Autowired private MemberDao dao;
	 */
	@Autowired
	/* private MemberTemplateDao dao; */
	private SqlSessionTemplate template;
	
	private MemberSessionDao dao;

	final int MEMBER_CNT_List = 3;

	public ListViewData getListData(int currentPageNumber, SearchParam searchParam) {
		
		dao = template.getMapper(MemberSessionDao.class);
		
		ListViewData listData = new ListViewData();
		   
	//	Connection conn = null;
		
	
		//try {
		//	conn = ConnectionProvider.getConnection();
			//현재 페이지 번호
			listData.setCurrentPageNumber(currentPageNumber);
			//전체 게시물의 개수
		//	int totalCnt = dao.selectTotalCount(conn, searchParam);
			int totalCnt = dao.selectTotalCount(searchParam);
			
			int totalPageCnt = 0;
			//전체 페이지 개수
			if(totalCnt > 0) {
				totalPageCnt = totalCnt/MEMBER_CNT_List;
				if(totalCnt % MEMBER_CNT_List>0) {
					totalPageCnt++;
				}
			}
			listData.setPageTotalCount(totalPageCnt);
			
			//구간 검색을 위한 index
			// 1 -> 0, 2 -> 3, 3 -> 6, 4 -> 9
			int index = (currentPageNumber-1) * MEMBER_CNT_List;
			
			//회원 정보 리스트
			List<MemberInfo> memberList = null;
			//1. 검색 조건이 없는 경우 selectList -> 전체 회원의 리스트
			//2. id로 검색 : where like uid '%?%'
			//3. name으로 검색 : where like uname '%?%'
			//4. id또는 name 으로 검색 : where like uname '%?%  and like uid '%?%''
			
			Map<String, Object> search = new HashMap<String, Object>();
			search.put("search", searchParam);
			search.put("index", index);
			search.put("MEMBER_CNT_List", MEMBER_CNT_List);
			
			
		/*
		 * listData.setMemberList(dao.selectList(search));
		 * 
		 * System.out.println(searchParam.getKeyword()); memberList =
		 * dao.selectList(search);
		 */
			memberList = dao.selectList(search);
		
		/*
		 * if(searchParam.getStype().equals("both")) { memberList =
		 * dao.selectListByBoth(sear); } else if(searchParam.getStype().equals("id")) {
		 * memberList = dao.selectListById(sear); } else
		 * if(searchParam.getStype().equals("name")) { memberList =
		 * dao.selectListByName(sear); }
		 */
		 
			
			
		 listData.setMemberList(memberList); 
			
			// 1 -> 9-0 =9, 2 -> 9-3=6
			int no = totalCnt - index;
			listData.setNo(no);
			
			listData.setTotalCount(totalCnt);
			
		//}
		
		return listData;
		
		
	}                  

	public List<MemberInfo> getAllList(){
		
		dao = template.getMapper(MemberSessionDao.class);
		
		List<MemberInfo> list = dao.selectAllList();
		
		return list;
	}
	
	
	
}
