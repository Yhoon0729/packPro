package model;

public class CarHis {
	private int car_history_id;
	private int car_id;
	private int totFee;
	private String sDay;
	private String eDay;
	
	public int getCar_history_id() {
		return car_history_id;
	}
	public void setCar_history_id(int car_history_id) {
		this.car_history_id = car_history_id;
	}
	public int getCar_id() {
		return car_id;
	}
	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}
	public int getTotFee() {
		return totFee;
	}
	public void setTotFee(int totFee) {
		this.totFee = totFee;
	}
	public String getsDay() {
		return sDay;
	}
	public void setsDay(String sDay) {
		this.sDay = sDay;
	}
	public String geteDay() {
		return eDay;
	}
	public void seteDay(String eDay) {
		this.eDay = eDay;
	}
	
	@Override
	public String toString() {
		return "CarHis [car_history_id=" + car_history_id + ", car_id=" + car_id + ", totFee=" + totFee + ", sDay="
				+ sDay + ", eDay=" + eDay + "]";
	}

}
