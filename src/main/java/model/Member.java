package model;

public class Member {
	private int userNum;
	private String countryCode;
	private String userId;
	private String userPass;
	private String userName;
	private String userTel;
	private int userAge;
	private int userGen;
	
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public int getUserGen() {
		return userGen;
	}
	public void setUserGen(int userGen) {
		this.userGen = userGen;
	}
	@Override
	public String toString() {
		return "Member [userNum=" + userNum + ", countryCode=" + countryCode + ", userId=" + userId + ", userPass="
				+ userPass + ", userName=" + userName + ", userTel=" + userTel + ", userAge=" + userAge + ", userGen="
				+ userGen + "]";
	}
	
	
}