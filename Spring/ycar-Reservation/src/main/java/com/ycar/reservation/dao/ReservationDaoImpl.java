package com.ycar.reservation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.ycar.reservation.domain.Reservation;
import com.ycar.reservation.entity.ReservationEntity;

public class ReservationDaoImpl implements ReservationDao<ReservationEntity>{

	private EntityManager entityManager;
	
	public ReservationDaoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	String sqlString = "select new com.ycar.reservation.domain.Reservation(p.nickname, d.d_date, d.d_starttime, d.d_endtime, d.d_startpoint, d.d_endpoint, d.d_commute, d.d_fee, d.d_startlon, d.d_startlat, d.d_endlon, d.d_endlat, r.r_confirm)"
			+ "from ReservationEntity as r"
			+ "inner join D_carpoolEntity as d"
			+ "on d.dr_idx = r.dr_idx"
			+ "inner join PassengerEntity as p"
			+ "on p.p_idx = r.p_idx"
			+ "where  d.d_idx = :d_idx"
			+ "order by d.d_date desc"; 
	
	
	@Override
	public List<Reservation> getlist(int driver_idx) {
		
		System.out.println("호잇 : " + driver_idx);
		
		TypedQuery<Reservation> query = (TypedQuery<Reservation>)entityManager.createQuery(sqlString, Reservation.class);
				query.setParameter("d_idx", driver_idx);
				
				System.out.println("호잇d : " + query);
		
		/* List<Reservation> list = query.getResultList(); */
		
		/* System.out.println("출력 : " + list); */
		
		/* entityManager.close(); */
		
		return query.getResultList();
	}

}
