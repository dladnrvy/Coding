package com.reservation.rsv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservation.rsv.dao.InsertDao;
import com.reservation.rsv.domain.FirstReserve;
import com.reservation.rsv.domain.SecondReserve;
import com.reservation.rsv.domain.ThirdReserve;

@Service("rvService")
public class ReserveService {

	@Autowired
	private InsertDao dao;
	
	public int firstInsert(FirstReserve firstRv) {
		
		
		int rCnt = 0;
		
		rCnt = dao.firstInsert(firstRv);
		
		return rCnt;
	}
	
	public int secondInsert(SecondReserve secondRv) {
		
		
		int rCnt = 0;
		
		rCnt = dao.secondInsert(secondRv);
		
		return rCnt;
	}
	
	public int thirdInsert(ThirdReserve thirdRv) {
		
		
		int rCnt = 0;
		
		rCnt = dao.thirdInsert(thirdRv);
		
		return rCnt;
	}
	
}
