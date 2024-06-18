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
	
	@Select("select car_daily_fee fee from car_rental_car1 where car_id = #{car_id}")
	public int fee(int car_id);
	
	@Insert("insert into car_rental_history values(car_his.nextval, #{car_id}, #{totFee}, #{sDay}, #{eDay})")
	public int carHis(Map map);
	
	@Select("select * from car_rental_history where car_id = #{car_id}")
	List<CarHis> rent(int car_id);
	
	@Select("select car_history_id, car_id,"
			+ "	to_char(car_start_date, 'yyyy-mm-dd hh24:mi') sDay,"
			+ "	to_char(car_end_date, 'yyyy-mm-dd hh24:mi') eDay "
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
