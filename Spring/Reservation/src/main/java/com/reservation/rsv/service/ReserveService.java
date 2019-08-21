package com.reservation.rsv.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservation.rsv.dao.ReservationDao;
import com.reservation.rsv.domain.FirstReserve;
import com.reservation.rsv.domain.SecondReserve;
import com.reservation.rsv.domain.ThirdReserve;

@Service("rvService")
public class ReserveService {

	@Autowired
	SqlSessionTemplate template;
	
	@Autowired
	private ReservationDao dao;
	
	public int firstInsert(FirstReserve firstRv) {
		
		dao = template.getMapper(ReservationDao.class);
		
		int rCnt = 0;
		
		rCnt = dao.firstInsert(firstRv);
		
		return rCnt;
	}
	
	public int secondInsert(SecondReserve secondRv) {
		
		dao = template.getMapper(ReservationDao.class);
		
		int rCnt = 0;
		
		rCnt = dao.secondInsert(secondRv);
		
		return rCnt;
	}
	
	public int thirdInsert(ThirdReserve thirdRv) {
		
		dao = template.getMapper(ReservationDao.class);
		
		int rCnt = 0;
		
		rCnt = dao.thirdInsert(thirdRv);
		
		return rCnt;
	}
	
	public int firstSelect() {
		
	}
	
}
