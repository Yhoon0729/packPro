package model;

public class Country {

	private	String code1;
	private	String code2;
	private	String code3;
	
	private	String continentEn;
	private	String continent;
	private	String continent2;
	
	private	String nameEn;
	private	String name;
	
	public Country() {}
	
	public Country(String code1, String code2, String code3, String continentEn, String continent, String continent2,
			String nameEn, String name) {
		super();
		this.code1 = code1;
		this.code2 = code2;
		this.code3 = code3;
		this.continentEn = continentEn;
		this.continent = continent;
		this.continent2 = continent2;
		this.nameEn = nameEn;
		this.name = name;
	}

	public String getCode1() {
		return code1;
	}

	public void setCode1(String code1) {
		this.code1 = code1;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public String getCode3() {
		return code3;
	}

	public void setCode3(String code3) {
		this.code3 = code3;
	}

	public String getContinentEn() {
		return continentEn;
	}

	public void setContinentEn(String continentEn) {
		this.continentEn = continentEn;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getContinent2() {
		return continent2;
	}

	public void setContinent2(String continent2) {
		this.continent2 = continent2;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [code1=" + code1 + ", code2=" + code2 + ", code3=" + code3 + ", continentEn=" + continentEn
				+ ", continent=" + continent + ", continent2=" + continent2 + ", nameEn=" + nameEn + ", name=" + name
				+ "]";
	}
	
	
	
	
}
