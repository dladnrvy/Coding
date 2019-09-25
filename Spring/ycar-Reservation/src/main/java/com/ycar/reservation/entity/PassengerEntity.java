package com.ycar.reservation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PASSENGER")
public class PassengerEntity {

	@Id
	@Column
	private long p_idx;
	
	@Column(length = 50, nullable = true)
	private String nickname;

	public long getP_idx() {
		return p_idx;
	}

	public void setP_idx(long p_idx) {
		this.p_idx = p_idx;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	/*
	 * @OneToMany(mappedBy = "PassengerEntity") private ReservationEntity
	 * reservationEntity;
	 */
	
	
	
	
}
