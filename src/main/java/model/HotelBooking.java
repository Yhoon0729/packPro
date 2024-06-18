package model;

public class HotelBooking {
	private int htlBookingid;
	private int htlId;
	private String htlCheckin;
	private String htlCheckout;
	private int htlAdult;
	private int htlChild;
	private int htlRooms;
	private int htlTotalprice;
	
	public int getHtlBookingid() {
		return htlBookingid;
	}
	public void setHtlBookingid(int htlBookingid) {
		this.htlBookingid = htlBookingid;
	}
	public int getHtlId() {
		return htlId;
	}
	public void setHtlId(int htlId) {
		this.htlId = htlId;
	}
	public String getHtlCheckin() {
		return htlCheckin;
	}
	public void setHtlCheckin(String htlCheckin) {
		this.htlCheckin = htlCheckin;
	}
	public String getHtlCheckout() {
		return htlCheckout;
	}
	public void setHtlCheckout(String htlCheckout) {
		this.htlCheckout = htlCheckout;
	}
	public int getHtlAdult() {
		return htlAdult;
	}
	public void setHtlAdult(int htlAdult) {
		this.htlAdult = htlAdult;
	}
	public int getHtlChild() {
		return htlChild;
	}
	public void setHtlChild(int htlChild) {
		this.htlChild = htlChild;
	}
	public int getHtlRooms() {
		return htlRooms;
	}
	public void setHtlRooms(int htlRooms) {
		this.htlRooms = htlRooms;
	}
	public int getHtlTotalprice() {
		return htlTotalprice;
	}
	public void setHtlTotalprice(int htlTotalprice) {
		this.htlTotalprice = htlTotalprice;
	}
	@Override
	public String toString() {
		return "HotelBooking [htlBookingid=" + htlBookingid + ", htlId=" + htlId + ", htlCheckin=" + htlCheckin
				+ ", htlCheckout=" + htlCheckout + ", htlAdult=" + htlAdult + ", htlChild=" + htlChild + ", htlRooms="
				+ htlRooms + ", htlTotalprice=" + htlTotalprice + "]";
	}
	
	
}
