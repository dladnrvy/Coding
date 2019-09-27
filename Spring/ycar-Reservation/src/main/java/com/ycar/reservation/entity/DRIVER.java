package com.ycar.reservation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DRIVER")
public class DRIVER {

	@Id
	@Column
	private long d_idx;

	public long getD_idx() {
		return d_idx;
	}

	public void setD_idx(long d_idx) {
		this.d_idx = d_idx;
	}

	public DRIVER(long d_idx) {
		this.d_idx = d_idx;
	}
	
	
	
	
}
