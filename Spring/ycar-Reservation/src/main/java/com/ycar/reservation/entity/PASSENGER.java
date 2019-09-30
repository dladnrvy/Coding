package com.ycar.reservation.entity;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;

@Entity
@Table(name="PASSENGER")
@SqlResultSetMapping(
		name = "ReservationMapping",
		classes = @ConstructorResult(
				targetClass = ReservationDTO.class,
				columns = {
						@ColumnResult(name="p_idx", type = BigInteger.class),
						@ColumnResult(name="nickname", type = String.class)
				})
		)
/*
 * @DiscriminatorColumn(name = "p_idx")
 * 
 * @Inheritance(strategy = InheritanceType.JOINED)
 * 
 * @NaturalIdCache
 * 
 * @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
 */
public class PASSENGER{

	@Id
	@Column
	@GeneratedValue
	private long p_idx;
	
	@Column(length = 50, nullable = true)
	private String nickname;
	
	public PASSENGER() {}

	
	public PASSENGER(long p_idx, String nickname) {
		this.p_idx = p_idx;
		this.nickname = nickname;
	}




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
	 * @OneToMany(mappedBy = "passengerEntity") private ReservationEntity
	 * reservationEntity;
	 * 
	 * public ReservationEntity getReservationEntity() { return reservationEntity; }
	 * 
	 * public void setReservationEntity(ReservationEntity reservationEntity) {
	 * this.reservationEntity = reservationEntity; }
	 */
	  
	  
	/*
	 * @OneToMany(mappedBy = "p_idx") private List<ReservationEntity> reservation;
	 */
	
	
	
	
}
