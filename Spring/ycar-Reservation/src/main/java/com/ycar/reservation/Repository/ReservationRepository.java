package com.ycar.reservation.Repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ycar.reservation.domain.Reservation;
import com.ycar.reservation.entityty.RESERVATION;

public interface ReservationRepository extends JpaRepository<RESERVATION, Long> {

	
	
	  @Query("select r.r_idx, sp.nickname, d.d_date, d.d_starttime, d.d_endtime, d.d_startpoint, d.d_endpoint, d.d_commute, d.d_fee, d.d_startlon, d.d_startlat, d.d_endlon, d.d_endlat,r.r_confirm"
	  + " from RESERVATION r " 
	  + " join D_CARPOOL d " 
	  + " on d.dr_idx = r.dr_idx "
	  + " join PASSENGER sp " 
	  + " on sp.p_idx = r.p_idx "
	  + " where d.d_idx = : d_idx and r.r_confirm = 'B' ") 
	  public List<RESERVATION> getlist(int d_idx);
	 	
	//@Param("d_idx") int d_idx
	/*
	 * @Query("select cp.d_date, rs.r_idx from D_carpoolEntity cp join ReservationEntity rs where cp.d_idx = ?1"
	 * ) public List<ReservationEntity> getlist(int d_idx);
	 */
	
	  
	  	   
	  
	/*
	 * @Query(" select * from RESERVATION r \r\n " +
	 * " join D_CARPOOL d on r.dr_idx = d.dr_idx\r\n " +
	 * " join PASSENGER p on p.p_idx = r.p_idx \r\n " +
	 * " where d.d_idx = :d_idx and r.r_confirm = \"B\"  ")
	 */
}
