package com.ycar.reservation.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

@Entity
@Table(name = "DRIVER")
@SqlResultSetMapping(
		name = "ReservationMapping",
		classes = @ConstructorResult(
				targetClass = ReservationDTO.class,
				columns = {
						@ColumnResult(name="d_idx", type = BigInteger.class)
				})
		)
public class DRIVER {

	@Id
	@Column
	@GeneratedValue
	private long d_idx;
	
	public DRIVER() {}
	
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
