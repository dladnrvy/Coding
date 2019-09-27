package com.ycar.reservation.entityty;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;

import com.ycar.reservation.domain.Reservation;

@Entity
@Table(name = "RESERVATION")
 
@SecondaryTables({
	@SecondaryTable(name = "D_CARPOOL", pkJoinColumns = @PrimaryKeyJoinColumn(name = "dr_idx")),
	@SecondaryTable(name = "PASSENGER", pkJoinColumns = @PrimaryKeyJoinColumn(name = "p_idx")),
	@SecondaryTable(name = "DRIVER", pkJoinColumns = @PrimaryKeyJoinColumn(name = "d_idx"))
})

public class RESERVATION{

	@Id
	@Column(length = 10)
	private long r_idx;
	
	//탑승자 테이블
	/*
	 * @Column(table = "PASSENGER", insertable = false, updatable= false) private
	 * long p_idx;
	 */
	
	@Column(length = 1, nullable = false, table = "PASSENGER")
	private String r_confirm;
	
	//카풀 테이블
	/*
	 * @Column(table = "D_CARPOOL", name = "dr_idx" ,insertable = false, updatable=
	 * false) private long dr_idx;
	 */
	
	//드라이버
	/*
	 * @Column(table = "DRIVER", insertable = false, updatable= false)
	 * 
	 * @GeneratedValue private long d_idx;
	 */
	
	@Column(nullable = false, table = "D_CARPOOL")
	private String d_date;
	
	@Column(length = 255, nullable = false, table = "D_CARPOOL")
	private String d_starttime;
	
	@Column(length = 255, nullable = false, table = "D_CARPOOL")
	private String d_endtime;
	
	@Column(length = 255, nullable = false, table = "D_CARPOOL")
	private String d_startpoint;
	
	@Column(length = 255, nullable = false, table = "D_CARPOOL")
	private String d_endpoint;
	
	@Column(length = 4, nullable = false, table = "D_CARPOOL")
	private String d_commute;
	
	@Column(length = 10, nullable = false, table = "D_CARPOOL")
	private int d_fee;
	
	@Column(length = 500, nullable = true, table = "D_CARPOOL")
	private String d_startlon;
	
	@Column(length = 500, nullable = true, table = "D_CARPOOL")
	private String d_startlat;
	
	@Column(length = 500, nullable = true, table = "D_CARPOOL")
	private String d_endlon;
	
	@Column(length = 500, nullable = true, table = "D_CARPOOL")
	private String d_endlat;

	public long getR_idx() {
		return r_idx;
	}

	public void setR_idx(long r_idx) {
		this.r_idx = r_idx;
	}

	/*
	 * public long getP_idx() { return p_idx; }
	 * 
	 * public void setP_idx(long p_idx) { this.p_idx = p_idx; }
	 */

	public String getR_confirm() {
		return r_confirm;
	}

	public void setR_confirm(String r_confirm) {
		this.r_confirm = r_confirm;
	}

	/*
	 * public long getDr_idx() { return dr_idx; }
	 * 
	 * public void setDr_idx(long dr_idx) { this.dr_idx = dr_idx; }
	 */

	/*
	 * public long getD_idx() { return d_idx; }
	 * 
	 * public void setD_idx(long d_idx) { this.d_idx = d_idx; }
	 */

	public String getD_date() {
		return d_date;
	}

	public void setD_date(String d_date) {
		this.d_date = d_date;
	}

	public String getD_starttime() {
		return d_starttime;
	}

	public void setD_starttime(String d_starttime) {
		this.d_starttime = d_starttime;
	}

	public String getD_endtime() {
		return d_endtime;
	}

	public void setD_endtime(String d_endtime) {
		this.d_endtime = d_endtime;
	}

	public String getD_startpoint() {
		return d_startpoint;
	}

	public void setD_startpoint(String d_startpoint) {
		this.d_startpoint = d_startpoint;
	}

	public String getD_endpoint() {
		return d_endpoint;
	}

	public void setD_endpoint(String d_endpoint) {
		this.d_endpoint = d_endpoint;
	}

	public String getD_commute() {
		return d_commute;
	}

	public void setD_commute(String d_commute) {
		this.d_commute = d_commute;
	}

	public int getD_fee() {
		return d_fee;
	}

	public void setD_fee(int d_fee) {
		this.d_fee = d_fee;
	}

	public String getD_startlon() {
		return d_startlon;
	}

	public void setD_startlon(String d_startlon) {
		this.d_startlon = d_startlon;
	}

	public String getD_startlat() {
		return d_startlat;
	}

	public void setD_startlat(String d_startlat) {
		this.d_startlat = d_startlat;
	}

	public String getD_endlon() {
		return d_endlon;
	}

	public void setD_endlon(String d_endlon) {
		this.d_endlon = d_endlon;
	}

	public String getD_endlat() {
		return d_endlat;
	}

	public void setD_endlat(String d_endlat) {
		this.d_endlat = d_endlat;
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
	 * @JoinTable(name="PASSENGER_p_idx") private PassengerEntity PASSENGER;
	 * 
	 * public PassengerEntity getPassengerEntity() { return PASSENGER; }
	 * 
	 * public void setPassengerEntity(PassengerEntity PASSENGER) { this.PASSENGER =
	 * PASSENGER; }
	 * 
	 * 
	 * @ManyToOne
	 * 
	 * @JoinTable(name="D_CARPOOL_dr_idx") private D_carpoolEntity D_CARPOOL;
	 * 
	 * public D_carpoolEntity getD_carpoolEntity() { return D_CARPOOL; }
	 * 
	 * public void setD_carpoolEntity(D_carpoolEntity D_CARPOOL){ this.D_CARPOOL =
	 * D_CARPOOL; }
	 */
	 
	 
	 //, insertable = false, updatable = false
	 
	  
	
	 
	 
	 

}


