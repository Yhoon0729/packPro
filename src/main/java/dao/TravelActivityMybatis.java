package dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import model.TravelActivity;
import util.MybatisConnection;

public class TravelActivityMybatis {
    private SqlSession session;
    private String namespace = "xml.travelActivity.";

    public TravelActivityMybatis() {
        session = MybatisConnection.getConnection();
    }

    // 모든 액티비티 목록 조회
    public List<TravelActivity> getTravelActivityList() {
        List<TravelActivity> list = session.selectList(namespace + "selectTravelActivityList");
        return list;
    }

 // 특정 ID의 액티비티 조회
    public TravelActivity getTravelActivityById(Long activityId) {
        return session.selectOne(namespace + "selectTravelActivityById", activityId);
    }
    
}
