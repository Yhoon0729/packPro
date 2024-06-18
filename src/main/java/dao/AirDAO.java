package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import model.AirInfo;
import model.Airport;
import util.MybatisConnection;

public class AirDAO {
	
	SqlSession session = MybatisConnection.getConnection();
	String nameSpace = "air";

	// 출발 공항 리스트
	public List<String> getDepartureAirportListAll(){
		
		List<String> result = session.selectList(nameSpace + ".getDepartureAirportListAll");
		
		return result;
	}
	
		
	
	
	// 도착 공항 리스트
	public List<String> getArrivalAirportListAll( String country, String depAir ){
		
		Map<String, String> map = new HashMap<>();
		
		map.put("country", country);
		map.put("depAir", depAir);
		
		List<String> result = session.selectList
				(nameSpace + ".getArrivalAirportListAll", map);
		
		return result;
	}
	

	
	// 도착 공항 리스트
	public List<AirInfo> getAirInfoList( String depAir, String arrAir, String date ){
		
		Map<String, String> map = new HashMap<>();
		
		map.put("depAir", depAir);
		map.put("arrAir", arrAir);
		map.put("day", date);
		
		List<AirInfo> result = session.selectList
				(nameSpace + ".getAirInfoList", map);
		
		return result;
	}

}
