package com.driver.reservation.dao;

import java.util.List;

import com.driver.reservation.domain.DriverReservation;

public interface DriverReservationDao {

	// 운전자 저장
	public int InsertReservation(DriverReservation reservation);

	//리스트
	public List<DriverReservation> carpoolList(int idx);

	//삭제
	public int deleteCarpool(int dr_idx);
}
