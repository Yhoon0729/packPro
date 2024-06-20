package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.Festival;
import model.FestivalInfo;
import util.MybatisConnection;

public class FestivalDAO {

	SqlSession session = MybatisConnection.getConnection();
	String nameSpace = "festival";

	// 2. 축제 전체 리스트
	// XML 방식
	public List<Festival> getFestivalListAll() {
		List<Festival> result = session.selectList(nameSpace + ".getFestivalListAll");
		return result;
	}// get

	// 3. 축제 정보
	// XML 방식
	public FestivalInfo getFestivalInfo(String code) {

		FestivalInfo result = session.selectOne(nameSpace + ".getFestivalInfo", code);
		return result;
	}// get

}// class
