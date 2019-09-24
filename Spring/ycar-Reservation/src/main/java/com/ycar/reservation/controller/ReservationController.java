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
import com.ycar.reservation.dao.ReservationDaoImpl;
import com.ycar.reservation.domain.Reservation;
import com.ycar.reservation.entity.ReservationEntity;

@Controller
public class ReservationController {

	/*
	 * @Autowired private SqlSessionTemplate template;
	 */
	
	
	@PersistenceContext
	EntityManager entityManager;
	
	private ReservationDaoImpl dao;
	
	@Autowired
	private ReservationRepository respository;
	
	@RequestMapping("/getlist/{driver_idx}")
	@ResponseBody
	public List<Reservation> getList(
			@PathVariable("driver_idx") int driver_idx
			){
		
		this.dao = new ReservationDaoImpl(entityManager);
		
		List<Reservation> list = dao.getlist(driver_idx);
		
		for(Reservation reservationEntity : list) {
			System.out.println(reservationEntity);
		}
		
		System.out.println(list.toString());
		
		return list;
	}
	
	@RequestMapping("/getlists/{d_idx}")
	@ResponseBody
	public List<ReservationEntity> getLists(
			@PathVariable("d_idx") int d_idx
			){
		
		System.out.println("들어온 idx : " + d_idx);
		
		List<ReservationEntity> list = respository.getlist(d_idx);
		
		
		
		for(ReservationEntity reservationEntity : list) {
			System.out.println(reservationEntity);
		}
	
		
		return list;
	}
}
