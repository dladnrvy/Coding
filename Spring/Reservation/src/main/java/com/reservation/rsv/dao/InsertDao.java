package com.reservation.rsv.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.reservation.rsv.domain.FirstReserve;
import com.reservation.rsv.domain.SecondReserve;
import com.reservation.rsv.domain.ThirdReserve;

@Repository("rvDao")
public class InsertDao {
	
	@Autowired
	JdbcTemplate template;
	
	public int firstInsert(FirstReserve rv) {
		
		String sql = "insert into firstTime (uname,seat_num)values (?,?)";
		
		return template.update(sql,rv.getUname(),rv.getSeat_num()); 
	};
	
	public int secondInsert(SecondReserve rv) {
		
		String sql = "insert into secondtime (uname,seat_num)values (?,?)";
		
		return template.update(sql,rv.getUname(),rv.getSeat_num()); 
	};
	
	public int thirdInsert(ThirdReserve rv) {
		
		String sql = "insert into thirdtime (uname,seat_num)values (?,?)";
		
		return template.update(sql,rv.getUname(),rv.getSeat_num()); 
	};
	
	
	
}
