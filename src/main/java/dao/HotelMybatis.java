package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.Hotel;
import model.HotelBooking;
import util.MybatisConnection;

public class HotelMybatis {
	SqlSession session = MybatisConnection.getConnection();
	String namespace = "xml.hotel.";
	
	public List<Hotel> hotelList() {
		List<Hotel> li = session.selectList(namespace + "hotelList");
		return li;
	}
	
	public List<Hotel> hotellocList() {
		List<Hotel> li = session.selectList(namespace + "hotellocList");
		return li;
	}
	
	public int hotelBookingInsert(HotelBooking hotelbooking) {
		int num = session.insert(namespace + "hotelBookingInsert");
		return num;
	}
	
	public HotelBooking getHotelBooking(int id) {
		HotelBooking hb = session.selectOne(namespace + "getHotelBooking", id);
		return hb;
	}

	public int getHotelPrice(int hotelId) {
        int num = session.selectOne(namespace + "getHotelPrice", hotelId);
        return num;
    }
}
