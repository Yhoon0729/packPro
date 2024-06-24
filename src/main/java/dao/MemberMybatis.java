package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mapper.MemberAnno;
import model.Member;
import util.MybatisConnection;

public class MemberMybatis {
	
	SqlSession session = MybatisConnection.getConnection();
	
	public Member getMember(String userId) {
		Member mem = session.getMapper(MemberAnno.class).getMember(userId);
		return mem;
	} // end of getMemeber()
	
	public List<Member> memberList() {
		List<Member> li = session.getMapper(MemberAnno.class).memberList();
		return li;
	} // end of memberList()

	public int insertMember(String countryCode, String userId, String userPass, String userName, 
			String userTel, int userAge, int userGen) {
		Map map = new HashMap();
		map.put("countryCode", countryCode);
		map.put("userId", userId);
		map.put("userPass", userPass);
		map.put("userName", userName);
		map.put("userTel", userTel);
		map.put("userAge", userAge);
		map.put("userGen", userGen);
		
		int num = session.getMapper(MemberAnno.class).insertMember(map);
		session.commit();
		return num;
	} // end of insertMember()


}