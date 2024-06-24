package mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import model.Car;
import model.CarHis;

public interface RentAnno {
	@Select("select *  from car_rental_car1")
	List<Car> getCars1();
	
	@Select("select carDailyFee fee from car_rental_car1 where carId = #{carId}")
	public int fee(int carId);
	
	@Insert("insert into car_rental_history values(car_his.nextval, #{carId}, #{totFee}, #{carStartDate}, #{carEndDate})")
	public int carHis(Map map);
	
	
	@Select("select * from car_rental_history where carId = #{carId}")
	CarHis rent(int car_id);
	
	@Select("select carHistoryId, carId,"
			+ "	to_char(carStartDate, 'yyyy-mm-dd hh24:mi') carStartDate,"
			+ "	to_char(carEndDate, 'yyyy-mm-dd hh24:mi') carEndDate "
			+ "	from car_rental_history")
	List<CarHis> rentCarList();
	
	@Select("select * from car_rental_car2")
	List<Car> getCars2();
	
	@Select("select * from car_rental_car3")
	List<Car> getCars3();
	
	@Select("select * from car_rental_car4")
	List<Car> getCars4();
	
	@Select("select * from car_rental_car5")
	List<Car> getCars5();
	
	@Select("select * from car_rental_car6")
	List<Car> getCars6();
	
	@Select("select * from car_rental_car7")
	List<Car> getCars7();
	
	@Select("select * from car_rental_car8")
	List<Car> getCars8();
	
	@Select("select * from car_rental_car9")
	List<Car> getCars9();
	
	@Select("select * from car_rental_car10")
	List<Car> getCars10();
	
}
