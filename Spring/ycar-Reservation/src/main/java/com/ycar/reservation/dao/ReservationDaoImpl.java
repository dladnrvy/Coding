package com.ycar.reservation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ycar.reservation.entity.ReservationEntity;

public class ReservationDaoImpl implements ReservationDao<ReservationEntity>{

	private EntityManager entityManager;
	
	public ReservationDaoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	@Override
	public List<ReservationEntity> getlist(long r_idx) {
		
		Query query = entityManager.createQuery("from ");
		
		return null;
	}

}
