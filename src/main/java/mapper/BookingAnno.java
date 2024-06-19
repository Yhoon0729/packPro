package mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;

public interface BookingAnno {
	@Insert("insert into booking values(bookingseq.nextval, #{act_id}, #{fst_code}, "
			+ "	#{htl_bookingid}, #{car_history_id}, #{car_id}, #{htl_id})")
	public int booking(Map map);
}
