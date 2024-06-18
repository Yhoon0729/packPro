package model;

public class Car {
	private int car_id;
	private String car_nation;
	private String car_type;
	private String car_name;
	private int car_daily_fee;
	private String car_com;
	
	public int getCar_id() {
		return car_id;
	}
	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}
	public String getCar_nation() {
		return car_nation;
	}
	public void setCar_nation(String car_nation) {
		this.car_nation = car_nation;
	}
	public String getCar_type() {
		return car_type;
	}
	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}
	public String getCar_name() {
		return car_name;
	}
	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}
	public int getCar_daily_fee() {
		return car_daily_fee;
	}
	public void setCar_daily_fee(int car_daily_fee) {
		this.car_daily_fee = car_daily_fee;
	}
	public String getCar_com() {
		return car_com;
	}
	public void setCar_com(String car_com) {
		this.car_com = car_com;
	}
	@Override
	public String toString() {
		return "Car [car_id=" + car_id + ", car_nation=" + car_nation + ", car_type=" + car_type + ", car_name="
				+ car_name + ", car_daily_fee=" + car_daily_fee + ", car_com=" + car_com + "]";
	}

	
	
}
