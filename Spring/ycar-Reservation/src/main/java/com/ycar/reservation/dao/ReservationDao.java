package com.ycar.reservation.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ycar.reservation.domain.Reservation;
import com.ycar.reservation.entity.ReservationEntity;

public interface ReservationDao<T> extends Serializable{

	
	public List<Reservation> getlist(int d_idx);

}
