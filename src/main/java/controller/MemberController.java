package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CarMybatis;
import dao.MemberMybatis;
import kic.mskim.MskimRequestMapping;
import kic.mskim.RequestMapping;
import model.Car;
import model.CarHis;
import model.Member;

@WebServlet("/member/*")
public class MemberController extends MskimRequestMapping{

	HttpSession session;
	MemberMybatis dao = new MemberMybatis();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();
		super.service(request, response);
	}
	
	@RequestMapping("join")
	public String join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		return "/view/member/join.jsp";
	} // end of join()
	
	@RequestMapping("joinPro")
	public String joinPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String countryCode = request.getParameter("countryCode");
		String userId = request.getParameter("userId");
		String userPass = request.getParameter("userPass");
		String userName = request.getParameter("userName");
		String userTel = request.getParameter("userTel");
		int userAge = Integer.parseInt(request.getParameter("userAge"));
		int userGen = Integer.parseInt(request.getParameter("userGen"));

		
		int num = dao.insertMember(countryCode, userId, userPass, userName, userTel, userAge, userGen);
		System.out.println("가입정보" + num);
		
		String msg = "";
		String url = "join";

		if (num > 0) {
			msg = userName + "님의 회원가입이 완료되었습니다.";
			url = "login";
		} else {
			msg = "회원가입이 실패 하였습니다.";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);

		return "/view/alert.jsp";
	} // end of joinPro()
	
	@RequestMapping("login")
	public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		return "/view/member/login.jsp";
	} // end of login()
}
