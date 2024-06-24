package mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import model.Member;



public interface MemberAnno {
	
	@Select("select * from users where userId = #{userId}")
	Member getMember(String userId);
	
	@Select("select * from users")
	List<Member> memberList();
	
	// 회원가입 sql
	@Insert("insert into users values (userSeq.nextval,#{countryCode},#{userId},#{userPass},#{userName},#{userTel},#{userAge},#{userGen})")
	public int insertMember(Map map);
 
}