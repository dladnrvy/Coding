package com.ycar.reservation.entity;

public class ReservationDTO {

	//idx
	private long r_idx;
	private long dr_idx;
	private long p_idx;
	private long d_idx;
	
	//carpool table
	private String d_date;
	private String d_starttime;
	private String d_endtime;
	private String d_startpoint;
	private String d_endpoint;
	private String d_commute;
	private int d_fee;
	private String d_startlon;
	private String d_startlat;
	private String d_endlon;
	private String d_endlat;
	
	//passenger table
	private String nickname;
	
	//reservation table
	private String r_confirm;
	
	
	

	public ReservationDTO() {}

	public ReservationDTO(long r_idx, long dr_idx, long p_idx, long d_idx, String d_date, String d_starttime,
			String d_endtime, String d_startpoint, String d_endpoint, String d_commute, int d_fee, String d_startlon,
			String d_startlat, String d_endlon, String d_endlat, String nickname, String r_confirm) {
		this.r_idx = r_idx;
		this.dr_idx = dr_idx;
		this.p_idx = p_idx;
		this.d_idx = d_idx;
		this.d_date = d_date;
		this.d_starttime = d_starttime;
		this.d_endtime = d_endtime;
		this.d_startpoint = d_startpoint;
		this.d_endpoint = d_endpoint;
		this.d_commute = d_commute;
		this.d_fee = d_fee;
		this.d_startlon = d_startlon;
		this.d_startlat = d_startlat;
		this.d_endlon = d_endlon;
		this.d_endlat = d_endlat;
		this.nickname = nickname;
		this.r_confirm = r_confirm;
	}

	public long getR_idx() {
		return r_idx;
	}

	public void setR_idx(long r_idx) {
		this.r_idx = r_idx;
	}

	public long getDr_idx() {
		return dr_idx;
	}

	public void setDr_idx(long dr_idx) {
		this.dr_idx = dr_idx;
	}

	public long getP_idx() {
		return p_idx;
	}

	public void setP_idx(long p_idx) {
		this.p_idx = p_idx;
	}

	public long getD_idx() {
		return d_idx;
	}

	public void setD_idx(long d_idx) {
		this.d_idx = d_idx;
	}

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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getR_confirm() {
		return r_confirm;
	}

	public void setR_confirm(String r_confirm) {
		this.r_confirm = r_confirm;
	}
	
	
	
}
