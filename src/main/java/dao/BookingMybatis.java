package dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mapper.BookingAnno;
import util.MybatisConnection;

public class BookingMybatis {
	SqlSession session = MybatisConnection.getConnection();
	
	public int booking(int act_id, String fst_code, int htl_bookingid, int car_history_id, int car_id, int htl_id) {
		Map map = new HashMap();
		map.put("act_id", act_id);
		map.put("fst_code", fst_code);
		map.put("htl_bookingid", htl_bookingid);
		map.put("car_history_id", car_history_id);
		map.put("car_id", car_id);
		map.put("htl_id", htl_id);
		int booking = session.getMapper(BookingAnno.class).booking(map);
		session.commit();
		return booking;
	}
}

