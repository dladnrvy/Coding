package com.ycar.reservation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="RESERVATION")
public class ReservationEntity {

	@Id
	@Column
	private long r_idx;

	@Column(nullable = false)
	private int p_idx;
	
	@Column(nullable = false)
	private int dr_idx;
	
	@Column(length = 1, nullable = false)
	private String r_confirm;

	public long getR_idx() {
		return r_idx;
	}

	public void setR_idx(long r_idx) {
		this.r_idx = r_idx;
	}

	public int getP_idx() {
		return p_idx;
	}

	public void setP_idx(int p_idx) {
		this.p_idx = p_idx;
	}

	public int getDr_idx() {
		return dr_idx;
	}

	public void setDr_idx(int dr_idx) {
		this.dr_idx = dr_idx;
	}

	public String getR_confirm() {
		return r_confirm;
	}

	public void setR_confirm(String r_confirm) {
		this.r_confirm = r_confirm;
	}

	@Override
	public String toString() {
		return "ReservationEntity [r_idx=" + r_idx + ", p_idx=" + p_idx + ", dr_idx=" + dr_idx + ", r_confirm="
				+ r_confirm + "]";
	}
	
	
	
	
	
}
