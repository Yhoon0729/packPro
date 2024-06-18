package dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mapper.RentAnno;
import model.Car;
import model.CarHis;
import util.MybatisConnection;

public class CarMybatis {
	SqlSession session = MybatisConnection.getConnection();
	
	public List<Car> carList() {
		List<Car> carList = session.getMapper(RentAnno.class).getCars1();
		System.out.println("+++++"+carList);
		return carList;
	}
	
	public int fee(int car_id) {
		int hourFee = session.getMapper(RentAnno.class).fee(car_id);
		return hourFee;
	}
	
	public int carHis(int car_id, int totFee, Date sDay, Date eDay) {
		Map map = new HashMap();
		map.put("car_id", car_id);
		map.put("totFee", totFee);
		map.put("sDay", sDay);
		map.put("eDay", eDay);
		
		int num = session.getMapper(RentAnno.class).carHis(map);
		session.commit();
		return num;
	}
	
	public List<CarHis> rent(int car_id) {
		List<CarHis> rent = session.getMapper(RentAnno.class).rent(car_id);
		return rent;
	}
	
	public List<CarHis> rentCarList() {
		List<CarHis> rentCarList = session.getMapper(RentAnno.class).rentCarList();
		
		return rentCarList;
	}
	
	
} // end of class carMybatis
