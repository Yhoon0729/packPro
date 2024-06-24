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
	
	public int carHis(int carId, int totFee, Date carStartDate, Date carEndDate) {
		Map map = new HashMap();
		map.put("carId", carId);
		map.put("totFee", totFee);
		map.put("carStartDate", carStartDate);
		map.put("carEndDate", carEndDate);
		
		int num = session.getMapper(RentAnno.class).carHis(map);
		session.commit();
		return num;
	}
	
	public CarHis rent(int car_id) {
		CarHis rent = session.getMapper(RentAnno.class).rent(car_id);
		return rent;
	}
	
	public List<CarHis> rentCarList() {
		List<CarHis> rentCarList = session.getMapper(RentAnno.class).rentCarList();
		
		return rentCarList;
	}
	
	
} // end of class carMybatis
