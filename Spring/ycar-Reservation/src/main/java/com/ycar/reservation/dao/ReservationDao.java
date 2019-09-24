package com.ycar.reservation.dao;

import java.io.Serializable;
import java.util.List;

public interface ReservationDao<T> extends Serializable{

	public List<T> getlist(long r_idx);
}
