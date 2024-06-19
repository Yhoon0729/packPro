package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TravelActivityMybatis;
import kic.mskim.MskimRequestMapping;
import kic.mskim.RequestMapping;
import model.TravelActivity;

@WebServlet("/TravelActivity/*")
public class TravelActivityController extends MskimRequestMapping {
    HttpSession session;
    TravelActivityMybatis activityDAO = new TravelActivityMybatis();

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        super.service(request, response);
    }

    @RequestMapping("TravelActivityList")
    public String travelActivityList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<TravelActivity> activityList = activityDAO.getTravelActivityList();
        session.setAttribute("activityList", activityList); // 세션에 activityList 저장
        request.setAttribute("activityList", activityList); // request에도 저장
        System.out.println("리스트:"+activityList);
        System.out.println("디버깅이 제대로 완료되었습니다욧!.");
        return "/view/TravelActivity/TravelActivityList.jsp"; // JSP 페이지로 이동
    }

    
    @RequestMapping("TravelActivityDetails")
    public String showActivityDetails(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    	    // 클라이언트에서 전달한 활동 ID를 받아옵니다.
            long activityId = Long.parseLong(request.getParameter("id"));
        
            // 활동 ID를 사용하여 데이터베이스에서 해당 활동의 정보를 조회합니다.
            TravelActivity activity = activityDAO.getTravelActivityById(activityId);
            
            // 조회된 활동 정보를 request에 담아 JSP 페이지로 전달합니다.
            request.setAttribute("activity", activity);
            session.setAttribute("activity", activity);
            
            return "/view/TravelActivity/TravelActivityDetails.jsp"; // JSP 페이지로 이동
        
        
}}
