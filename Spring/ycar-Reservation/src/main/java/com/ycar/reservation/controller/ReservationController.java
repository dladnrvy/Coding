package com.ycar.reservation.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ycar.reservation.Repository.ReservationRepository;
import com.ycar.reservation.dao.ReservationDao;
import com.ycar.reservation.domain.Reservation;
import com.ycar.reservation.entity.ReservationDTO;
import com.ycar.reservation.entity.RESERVATION;

@Controller
public class ReservationController {

	/*
	 * @Autowired private SqlSessionTemplate template;
	 */
	
	
	@PersistenceContext
	EntityManager entityManager;

	
	private ReservationDao rvDao;
	
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
	
	public ReservationController() {
		this.rvDao = new ReservationDao(entityManager);
	}
	
	@RequestMapping("/getlist/{d_idx}")
	@ResponseBody
	public List<ReservationDTO> getList(
			@PathVariable("d_idx") int d_idx
			){
		System.out.println("첫번쨰" + d_idx);
		this.rvDao = new ReservationDao(entityManager);
		
		List<ReservationDTO> list = rvDao.reservationList(d_idx);
		
		System.out.println("두번쨰" + d_idx);
	
		return list;
	}
}
