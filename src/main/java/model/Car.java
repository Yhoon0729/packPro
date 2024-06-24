package model;

public class Car {
	private int carId;
	private String carNation;
	private String carType;
	private String carName;
	private int carDailyFee;
	private String carCom;
	
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getCarNation() {
		return carNation;
	}
	public void setCarNation(String carNation) {
		this.carNation = carNation;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public int getCarDailyFee() {
		return carDailyFee;
	}
	public void setCarDailyFee(int carDailyFee) {
		this.carDailyFee = carDailyFee;
	}
	public String getCarCom() {
		return carCom;
	}
	public void setCarCom(String carCom) {
		this.carCom = carCom;
	}
	
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carNation=" + carNation + ", carType=" + carType + ", carName=" + carName
				+ ", carDailyFee=" + carDailyFee + ", carCom=" + carCom + "]";
	}
}
