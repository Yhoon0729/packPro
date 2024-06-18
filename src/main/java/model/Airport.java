package model;

public class Airport {
	
	String code;
	String name;
	String continent;
	
	String country;
	String city;
	
	Airport(){}

	public Airport(String code, String name, String continent, String country, String city) {
		super();
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.country = country;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Airport [code=" + code + ", name=" + name + ", continent=" + continent + ", country=" + country
				+ ", city=" + city + "]";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	

}
