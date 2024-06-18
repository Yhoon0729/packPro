package model;

import java.util.Date;

public class sCar {
	private int car_id;
	private Date sTime;
	private Date eTime;
	private int totFee;
	
	public int getCar_id() {
		return car_id;
	}
	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}
	public Date getsTime() {
		return sTime;
	}
	public void setsTime(Date sTime) {
		this.sTime = sTime;
	}
	public Date geteTime() {
		return eTime;
	}
	public void seteTime(Date eTime) {
		this.eTime = eTime;
	}
	public int getTotFee() {
		return totFee;
	}
	public void setTotFee(int totFee) {
		this.totFee = totFee;
	}
	
}
