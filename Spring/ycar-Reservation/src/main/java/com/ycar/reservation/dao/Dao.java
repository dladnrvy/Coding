package com.ycar.reservation.dao;

import java.io.Serializable;
import java.util.List;


public interface Dao<T> extends Serializable {

	public List<T> reservationList(int d_idx);
}
