package com.ycar.reservation.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;

import com.ycar.reservation.domain.Reservation;

@Entity
@Table(name = "RESERVATION")
/*
 * @DiscriminatorValue("A")
 * 
 * @PrimaryKeyJoinColumn(name = "r_idx")
 */
public class RESERVATION{

	@Id
	@Column(length = 10)
	private long r_idx;
	
	/*
	 * @Column private int p_idx;
	 * 
	 * @Column private int dr_idx;
	 */
	 
	
	
	/* @JoinColumn(name = "p_idx") */
	/* @JoinTable(name = "PASSENGER") */
	//, fetch = FetchType.LAZY
		@ManyToOne(targetEntity = PASSENGER.class)
		@JoinColumn(name="p_idx",insertable = false, updatable=false)
	  private PASSENGER passengerIdx;
	  
	
	/*
	 * @JoinColumn(name="dr_idx" ,insertable = false, updatable=false, table =
	 * "D_CARPOOL")
	 */
	/* @JoinTable(name = "D_CARPOOL") */
		@ManyToOne(targetEntity = D_CARPOOL.class)
	  @JoinColumn(name = "dr_idx" ,insertable = false, updatable=false)
	  private D_CARPOOL dcarpoolIdx;
		
		
	 
	 
	@Column(length = 1, nullable = false)
	private String r_confirm;
	
	public RESERVATION() {};



	public RESERVATION(long r_idx, PASSENGER passengerIdx, D_CARPOOL dcarpoolIdx, String r_confirm) {
		this.r_idx = r_idx;
		this.passengerIdx = passengerIdx;
		this.dcarpoolIdx = dcarpoolIdx;
		this.r_confirm = r_confirm;
	}



	public long getR_idx() {
		return r_idx;
	}



	public void setR_idx(long r_idx) {
		this.r_idx = r_idx;
	}

	

	



	/*
	 * public PASSENGER getPASSENGER() { return PASSENGER; }
	 * 
	 * 
	 * 
	 * public void setPASSENGER(PASSENGER pASSENGER) { PASSENGER = pASSENGER; }
	 * 
	 * 
	 * 
	 * public D_CARPOOL getD_CARPOOL() { return D_CARPOOL; }
	 * 
	 * 
	 * 
	 * public void setD_CARPOOL(D_CARPOOL d_CARPOOL) { D_CARPOOL = d_CARPOOL; }
	 */



	public String getR_confirm() {
		return r_confirm;
	}



	public PASSENGER getPassengerIdx() {
		return passengerIdx;
	}



	public void setPassengerIdx(PASSENGER passengerIdx) {
		this.passengerIdx = passengerIdx;
	}



	public D_CARPOOL getDcarpoolIdx() {
		return dcarpoolIdx;
	}



	public void setDcarpoolIdx(D_CARPOOL dcarpoolIdx) {
		this.dcarpoolIdx = dcarpoolIdx;
	}



	public void setR_confirm(String r_confirm) {
		this.r_confirm = r_confirm;
	}
	
	
	
	  
	
	/*
	 * @JoinTable(name= "jointable" , joinColumns = @JoinColumn(name
	 * ="RESERVATION",referencedColumnName = "p_idx", insertable = false, updatable
	 * = false), inverseJoinColumns = @JoinColumn(name = "PASSENGER",
	 * referencedColumnName = "p_idx", updatable = false) ) private PASSENGER
	 * PASSENGER;
	 * 
	 * 
	 * @JoinTable(name= "jointable" , joinColumns = @JoinColumn(name =
	 * "RESERVATION", referencedColumnName = "dr_idx",insertable = false, updatable
	 * = false), inverseJoinColumns = @JoinColumn(name = "D_CARPOOL" ,
	 * referencedColumnName = "dr_idx", updatable = false) ) private D_CARPOOL
	 * D_CARPOOL;
	 */
	 
	 
	 
	 //(name = "D_CARPOOL_dr_idx")
	  //(name ="PASSENGER_p_idx")

	

	/*
	 * public long getR_idx() { return r_idx; }
	 * 
	 * public void setR_idx(long r_idx) { this.r_idx = r_idx; }
	 */
	
	

	

	 

	

	
	
	/*
	 * public PASSENGER getPassenger() { return PASSENGER; }
	 * 
	 * public void setPassenger(PASSENGER passenger) { this.PASSENGER = passenger; }
	 * 
	 * public D_CARPOOL getDcarpool() { return D_CARPOOL; }
	 * 
	 * public void setDcarpool(D_CARPOOL dcarpool) { this.D_CARPOOL = dcarpool; }
	 */
	 

	
	
	/*
	 * public long getP_idx() { return p_idx; }
	 * 
	 * public void setP_idx(long p_idx) { this.p_idx = p_idx; }
	 * 
	 * 
	 * public long getDr_idx() { return dr_idx; }
	 * 
	 * public void setDr_idx(long dr_idx) { this.dr_idx = dr_idx; }
	 */
	 
	 
	 

	
	/*
	 * public Set<PassengerEntity> getP_idx() { return p_idx; }
	 * 
	 * public void setP_idx(Set<PassengerEntity> p_idx) { this.p_idx = p_idx; }
	 * 
	 * public Set<D_carpoolEntity> getDr_idx() { return dr_idx; }
	 * 
	 * public void setDr_idx(Set<D_carpoolEntity> dr_idx) { this.dr_idx = dr_idx; }
	 */
	 

	
	
	
	
	/*
	 * public PASSENGER getP_idx() { return p_idx; }
	 * 
	 * public void setP_idx(PASSENGER p_idx) { this.p_idx = p_idx; }
	 * 
	 * public D_CARPOOL getDr_idx() { return dr_idx; }
	 * 
	 * public void setDr_idx(D_CARPOOL dr_idx) { this.dr_idx = dr_idx; }
	 */
	 
	 
	 

	/*
	 * public String getR_confirm() { return r_confirm; }
	 * 
	 * public void setR_confirm(String r_confirm) { this.r_confirm = r_confirm; }
	 */

	
	
	
	
	
	
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="p_idx" ,insertable = false, updatable=false, table =
	 * "PASSENGER") private PASSENGER PASSENGER;
	 * 
	 * public PASSENGER getPassengerEntity() { return PASSENGER; }
	 * 
	 * public void setPassengerEntity(PASSENGER PASSENGER) { this.PASSENGER =
	 * PASSENGER; }
	 * 
	 * 
	 * @ManyToOne
	 * 
	 * @JoinTable(name="D_CARPOOL") private D_CARPOOL D_CARPOOL;
	 * 
	 * public D_CARPOOL getD_carpoolEntity() { return D_CARPOOL; }
	 * 
	 * public void setD_carpoolEntity(D_CARPOOL D_CARPOOL){ this.D_CARPOOL =
	 * D_CARPOOL; }
	 */
	  
	
	 
	 
	 
	 //, insertable = false, updatable = false
	 
	  
	
	 
	 
	 

}


