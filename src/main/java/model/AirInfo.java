package model;

public class AirInfo {

	private String company;
	private String companyName;
	private String flightCode;
	
	private String depCountry;
	private String depCity;
	private String depAirport;
	private String depAirportName;
	
	private String arrCountry;
	private String arrCity;
	private String arrAirport;
	private String arrAirportName;
	
	private String depTime;
	private String arrTime;
	
	private String day;
	private String division;
	private int price;
	private String seatClass;
	
	AirInfo(){}

	public AirInfo(String company, String companyName, String flightCode, String depCountry, String depCity,
			String depAirport, String depAirportName, String arrCountry, String arrCity, String arrAirport,
			String arrAirportName, String depTime, String arrTime, String day, String division, int price,
			String seatClass) {
		super();
		this.company = company;
		this.companyName = companyName;
		this.flightCode = flightCode;
		this.depCountry = depCountry;
		this.depCity = depCity;
		this.depAirport = depAirport;
		this.depAirportName = depAirportName;
		this.arrCountry = arrCountry;
		this.arrCity = arrCity;
		this.arrAirport = arrAirport;
		this.arrAirportName = arrAirportName;
		this.depTime = depTime;
		this.arrTime = arrTime;
		this.day = day;
		this.division = division;
		this.price = price;
		this.seatClass = seatClass;
	}

	@Override
	public String toString() {
		return "AirInfo [company=" + company + ", companyName=" + companyName + ", flightCode=" + flightCode
				+ ", depCountry=" + depCountry + ", depCity=" + depCity + ", depAirport=" + depAirport
				+ ", depAirportName=" + depAirportName + ", arrCountry=" + arrCountry + ", arrCity=" + arrCity
				+ ", arrAirport=" + arrAirport + ", arrAirportName=" + arrAirportName + ", depTime=" + depTime
				+ ", arrTime=" + arrTime + ", day=" + day + ", division=" + division + ", price=" + price
				+ ", seatClass=" + seatClass + "]";
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public String getDepCountry() {
		return depCountry;
	}

	public void setDepCountry(String depCountry) {
		this.depCountry = depCountry;
	}

	public String getDepCity() {
		return depCity;
	}

	public void setDepCity(String depCity) {
		this.depCity = depCity;
	}

	public String getDepAirport() {
		return depAirport;
	}

	public void setDepAirport(String depAirport) {
		this.depAirport = depAirport;
	}

	public String getDepAirportName() {
		return depAirportName;
	}

	public void setDepAirportName(String depAirportName) {
		this.depAirportName = depAirportName;
	}

	public String getArrCountry() {
		return arrCountry;
	}

	public void setArrCountry(String arrCountry) {
		this.arrCountry = arrCountry;
	}

	public String getArrCity() {
		return arrCity;
	}

	public void setArrCity(String arrCity) {
		this.arrCity = arrCity;
	}

	public String getArrAirport() {
		return arrAirport;
	}

	public void setArrAirport(String arrAirport) {
		this.arrAirport = arrAirport;
	}

	public String getArrAirportName() {
		return arrAirportName;
	}

	public void setArrAirportName(String arrAirportName) {
		this.arrAirportName = arrAirportName;
	}

	public String getDepTime() {
		return depTime;
	}

	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}

	public String getArrTime() {
		return arrTime;
	}

	public void setArrTime(String arrTime) {
		this.arrTime = arrTime;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}
	
	
	
	
	
	
}// class
