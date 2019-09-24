package com.ycar.reservation.domain;

public class Reservation {

	private int r_idx; //예약번호
	private int p_idx; //탑승자 idx
	private int dr_idx; //운전자 idx
	private String r_confirm; //수락여부
	
	public Reservation() {}
	
	public Reservation(int r_idx, int p_idx, int dr_idx, String r_confirm) {
		this.r_idx = r_idx;
		this.p_idx = p_idx;
		this.dr_idx = dr_idx;
		this.r_confirm = r_confirm;
	}

	public int getR_idx() {
		return r_idx;
	}

	public void setR_idx(int r_idx) {
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
	
	
	
	
	
}
