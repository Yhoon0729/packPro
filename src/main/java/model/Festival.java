package model;

import java.sql.Date;

public class Festival {

	private String code;
	private String season;
	private String countryCode;
	private String country;
	
	private String festivalName;
	private Date startDay;
	private Date endDay;
	
	Festival(){}

	public Festival(String code, String season, String countryCode, String country, String festivalName, Date startDay,
			Date endDay) {
		super();
		this.code = code;
		this.season = season;
		this.countryCode = countryCode;
		this.country = country;
		this.festivalName = festivalName;
		this.startDay = startDay;
		this.endDay = endDay;
	}

	@Override
	public String toString() {
		return "Festival [code=" + code + ", season=" + season + ", countryCode=" + countryCode + ", country=" + country
				+ ", festivalName=" + festivalName + ", startDay=" + startDay + ", endDay=" + endDay + "]";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFestivalName() {
		return festivalName;
	}

	public void setFestivalName(String festivalName) {
		this.festivalName = festivalName;
	}

	public Date getStartDay() {
		return startDay;
	}

	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}

	public Date getEndDay() {
		return endDay;
	}

	public void setEndDay(Date endDay) {
		this.endDay = endDay;
	}

	
	
	

}
