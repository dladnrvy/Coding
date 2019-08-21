package com.reservation.rsv.dao;

import java.util.List;

import com.reservation.rsv.domain.FirstReserve;
import com.reservation.rsv.domain.ReserveList;
import com.reservation.rsv.domain.SecondReserve;
import com.reservation.rsv.domain.ThirdReserve;

public interface ReservationDao {

	//첫번째 시간 예약 넣기
	public int firstInsert(FirstReserve rvi);
	//두번째 시간 예약 넣기
	public int secondInsert(SecondReserve rvi);
	//세번째 시간 예약 넣기
	public int thirdInsert(ThirdReserve rvi);
	
	//첫번째 시간  좌석 검색
	public List<ReserveList> selectList();
	//두번째 시간  좌석 검색
	public SecondReserve secondSelect();
	//세번째 시간  좌석 검색
	public int thirdSelect(ThirdReserve rvs);
}
