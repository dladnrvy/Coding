package com.ycar.reservation.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ycar.reservation.entity.ReservationDTO;

public class ReservationDao implements Dao<ReservationDTO>{
	
	private EntityManager emf;
	
	public ReservationDao() {};
	
	public ReservationDao(EntityManager enManager) {
		this.emf = enManager; 
	}
	
	public List<ReservationDTO> reservationList(int d_idx) {
		
		
		String sql = "select r.r_idx, sp.nickname, d.d_date, d.d_starttime, d.d_endtime, d.d_startpoint, d.d_endpoint, d.d_commute, d.d_fee, d.d_startlon, d.d_startlat, d.d_endlon, d.d_endlat,r.r_confirm "
				+ " from RESERVATION r " 
				+ " join D_CARPOOL d " 
				+ " join PASSENGER sp " 	
				+ " where d.d_idx = "+ d_idx
				+ " and r.r_confirm = 'B' ";
		//	+ " on sp.p_idx = r.p_idx " , 	+ " on d.dr_idx = r.dr_idx " 
		
		Query nativeQuery = emf.createNativeQuery(sql, "ReservationMapping")
				.setParameter("d_idx", d_idx);
		
		List<ReservationDTO> resultList = nativeQuery.getResultList();
		
		emf.close();
		
		return resultList;
	}
}
