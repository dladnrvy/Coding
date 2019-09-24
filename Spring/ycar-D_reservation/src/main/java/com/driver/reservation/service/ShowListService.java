package com.driver.reservation.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.reservation.dao.DriverReservationDao;
import com.driver.reservation.domain.DriverReservation;

@Service
public class ShowListService {

	@Autowired
	private SqlSessionTemplate template;

	private DriverReservationDao dao;

	public List<DriverReservation> showListForDate(int d_idx) {
		
		
		System.out.println("(서비스)검색하고자 하는 사람의 idx는" + d_idx);
	
		dao = template.getMapper(DriverReservationDao.class);
		
			
		List<DriverReservation> test = dao.carpoolList(d_idx);
		
		
		
		System.out.println("서비스) 출력해봅니다 : "+test);
		
		return test;
	}

	
	 
	 

}
