package com.ycar.reservation.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ycar.reservation.entity.ReservationEntity;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

	@Query("SELECT p.nickname, d.d_date, d.d_starttime, d.d_endtime, d.d_startpoint, d.d_endpoint, d.d_commute, d.d_fee, d.d_startlon, d.d_startlat, d.d_endlon, d.d_endlat, r.r_confirm FROM ReservationEntity AS r JOIN D_carpoolEntity AS d JOIN PassengerEntity AS p on p.p_idx = r.p_idx and d.dr_idx = r.dr_idx where d.d_idx = d_idx order by d.d_date desc")
	public List<ReservationEntity> getlist(int d_idx);
	
	
}
