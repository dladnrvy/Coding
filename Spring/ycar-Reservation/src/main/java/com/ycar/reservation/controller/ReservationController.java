package com.ycar.reservation.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ycar.reservation.Repository.ReservationRepository;
import com.ycar.reservation.domain.Reservation;
import com.ycar.reservation.entityty.RESERVATION;

@Controller
public class ReservationController {

	/*
	 * @Autowired private SqlSessionTemplate template;
	 */
	
	
	@PersistenceContext
	EntityManager entityManager;

	
	@Autowired
	private ReservationRepository respository;
	
	
	@RequestMapping("/getlists/{d_idx}")
	@ResponseBody
	public List<RESERVATION> getLists(
	@PathVariable("d_idx") int d_idx 
			){
		
		 System.out.println("01 들어온 idx : " + d_idx); 
		
		List<RESERVATION> list = respository.getlist(d_idx);
		System.out.println("02 들어온 list: " + list);
		
		
		
		/*
		 * for(ReservationEntity reservationEntity : list) {
		 * System.out.println(reservationEntity.getPassengerEntity().getNickname()
		 * +" 요잇  "+ reservationEntity.getD_carpoolEntity() ); }
		 */
	
		
		return list;
	}
}
