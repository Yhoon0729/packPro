package controller;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AirDAO;
import kic.mskim.MskimRequestMapping;
import kic.mskim.RequestMapping;
import model.AirInfo;
import model.FestivalInfo;

@WebServlet("/air/*")
public class AirController extends MskimRequestMapping {

	private static final long serialVersionUID = 1L;
	
	AirDAO airDAO = new AirDAO();

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

	
	
	// 축제에서 선택된 국가의 공항 선택
	@RequestMapping("airindex")
	public String airindex(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	// post 방식의 한글 깨짐 방지
	request.setCharacterEncoding("UTF-8");
	
	// 파라메터값 가져오기
	String festivalCode = request.getParameter("code");

	// 국내 출발 공항리스트
	List<String> list = airDAO.getDepartureAirportListAll();
	
	request.setAttribute("airList", list);
	
		
	// 연결 설정
	return "/view/air/AirSelect.jsp";
	}
	
	
	// 출발 공항 선택 완료 도착 공항 리스트 보여주기
	@RequestMapping("depAir")
	public String depAir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	// post 방식의 한글 깨짐 방지
	request.setCharacterEncoding("UTF-8");
	
	// 파라메터값 가져오기
	String depAir = request.getParameter("depAir");
	
	session.setAttribute("depAir", depAir);
		
	// 도착 공항리스트
	FestivalInfo festivalInfo = (FestivalInfo) session.getAttribute("list"); 
	
	String country = festivalInfo.getCountry();
	
	List<String> list = airDAO.getArrivalAirportListAll( country, depAir );
	
	request.setAttribute("airList", list);
	
		
	// 연결 설정
	return "/util/AirArrAirportList.jsp";
	}
	

	// 도착 공항 선택 완료 일종 선택 보여주기
	@RequestMapping("arrAir")
	public String arrAir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	// post 방식의 한글 깨짐 방지
	request.setCharacterEncoding("UTF-8");
	
	// 파라메터값 가져오기
	String arrAir = request.getParameter("arrAir");
	
	session.setAttribute("arrAir", arrAir);
	
		
	// 연결 설정
	return "/util/AirSelectDate.jsp";
	}

	// text 활용 : 변경 또는 삭제 금지
	@RequestMapping("airText")
	public String airText(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	// post 방식의 한글 깨짐 방지
	request.setCharacterEncoding("UTF-8");
	
	// 파라메터값 가져오기
	String text = request.getParameter("text");
	
	request.setAttribute("text", text);

		
	// 연결 설정
	return "/util/AirText.jsp";
	}
	
	
	
	// 가는 날짜 선택
	@RequestMapping("airDepDate")
	public String airDepDate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	// post 방식의 한글 깨짐 방지
	request.setCharacterEncoding("UTF-8");
	
	// 파라메터값 가져오기
	String date = request.getParameter("date");
	
	// 날짜 문자열을 LocalDate로 변환
    LocalDate localDate = LocalDate.parse(date);
    
    // 날짜의 요일을 가져옴
    DayOfWeek dayOfWeek = localDate.getDayOfWeek();
    
    // 요일을 출력 (한글로 변환)
    switch (dayOfWeek) {
    case MONDAY: date="월"; break;
    case TUESDAY: date="화"; break;
    case WEDNESDAY: date="수"; break;
    case THURSDAY: date="목"; break;
    case FRIDAY: date="금"; break;
    case SATURDAY: date="토"; break;
    case SUNDAY: date="일"; break;
}
    
    session.setAttribute("depDate", date);
    	
	// 연결 설정
	return "/util/AirText.jsp";
	}

	
	
	// 오는 날짜 선택
	@RequestMapping("airRtnDate")
	public String airRtnDate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	// post 방식의 한글 깨짐 방지
	request.setCharacterEncoding("UTF-8");
	
	// 파라메터값 가져오기
	String date = request.getParameter("date");
	
	// 날짜 문자열을 LocalDate로 변환
    LocalDate localDate = LocalDate.parse(date);
    
    // 날짜의 요일을 가져옴
    DayOfWeek dayOfWeek = localDate.getDayOfWeek();
    
    // 요일을 출력 (한글로 변환)
    switch (dayOfWeek) {
    case MONDAY: date="월"; break;
    case TUESDAY: date="화"; break;
    case WEDNESDAY: date="수"; break;
    case THURSDAY: date="목"; break;
    case FRIDAY: date="금"; break;
    case SATURDAY: date="토"; break;
    case SUNDAY: date="일"; break;
    }
    
    // 돌아오는 날짜 저장
    session.setAttribute("rtnDate", date);
    
    String depAir = (String) session.getAttribute("depAir");
    String arrAir = (String) session.getAttribute("arrAir");
    String depDate = (String) session.getAttribute("depDate");
    String rtnDate = (String) session.getAttribute("rtnDate");
    
    System.out.println(depAir + "-" + arrAir + "-" + depDate + "-" + rtnDate );
    
    
    List<AirInfo> list1 = airDAO.getAirInfoList( depAir, arrAir, depDate );
    
    request.setAttribute("airListDep", list1);
    
    List<AirInfo> list2 = airDAO.getAirInfoList( arrAir, depAir, rtnDate );
   
    request.setAttribute("airListRtn", list2);
    		
	// 연결 설정
	return "/util/AirInfoList.jsp";
	}
	
	
	
	
	
}// class
