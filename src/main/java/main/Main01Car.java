package main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kic.mskim.RequestMapping;
import mapper.RentAnno;
import model.Car;
import util.MybatisConnection;

public class Main01Car {
	public static void main(String[] args) {
		SqlSession session = MybatisConnection.getConnection();

		RentAnno rentAnno = session.getMapper(RentAnno.class);
		
		List<Car> li1 = rentAnno.getCars1();
		
		
		System.out.println(li1);
	}
}
