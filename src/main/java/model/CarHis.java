package model;

public class CarHis {
	private int carHistoryId;
	private int carId;
	private int totFee;
	private String carStartDate;
	private String carEndDate;
	
	public int getCarHistoryId() {
		return carHistoryId;
	}
	public void setCarHistoryId(int carHistoryId) {
		this.carHistoryId = carHistoryId;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public int getTotFee() {
		return totFee;
	}
	public void setTotFee(int totFee) {
		this.totFee = totFee;
	}
	public String getCarStartDate() {
		return carStartDate;
	}
	public void setCarStartDate(String carStartDate) {
		this.carStartDate = carStartDate;
	}
	public String getCarEndDate() {
		return carEndDate;
	}
	public void setCarEndDate(String carEndDate) {
		this.carEndDate = carEndDate;
	}
	@Override
	public String toString() {
		return "CarHis [carHistoryId=" + carHistoryId + ", carId=" + carId + ", totFee=" + totFee + ", carStartDate="
				+ carStartDate + ", carEndDate=" + carEndDate + "]";
	}
	
	
}
