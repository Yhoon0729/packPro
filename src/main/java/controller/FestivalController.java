package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FestivalDAO;
import kic.mskim.MskimRequestMapping;
import kic.mskim.RequestMapping;
import model.Festival;
import model.FestivalInfo;

@WebServlet("/tra/*")
public class FestivalController extends MskimRequestMapping {
	
	private static final long serialVersionUID = 1L;
	FestivalDAO festivalDAO = new FestivalDAO();
	
	/* web 과의 연동을 위한 기본 설정 */
	HttpSession session;
	
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, 
	IOException {
		session=request.getSession();
		System.out.println("service");
		super.service(request, response);
	}
	
	/* 축제 선택 리스트 메인 화면*/
	@RequestMapping("traindex")
	public String index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// post 방식의 한글 깨짐 방지
		request.setCharacterEncoding("UTF-8");
		
		// 계절별 상품 리스트 가져오기
	
		
		List<Festival> result = new ArrayList<>(); 
		result = festivalDAO.getFestivalListAll();
		
		session.setAttribute("list", result);
		System.out.println(session.getAttribute("list").getClass());
				
	// 연결 설정
	return "/view/travel/TraMain.jsp";
	}
	
	/* 축제 정보 화면*/
	@RequestMapping("festivalInfo")
	public String festivalInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// post 방식의 한글 깨짐 방지
		request.setCharacterEncoding("UTF-8");
		
		// parameter 처리
		String festivalCode = request.getParameter("code");
		request.setAttribute("festivalCode", festivalCode);
		System.out.println("festivalCode" + festivalCode);
		
		// 페스티벌 정보 가져오기
	
		
		FestivalInfo result = festivalDAO.getFestivalInfo( festivalCode );
		
		System.out.println( festivalCode + "  " + result );
		
		session.setAttribute("list", result);
				
	// 연결 설정
	return "/view/travel/TrafestivalInfo.jsp";
	}

	
	
}//class
