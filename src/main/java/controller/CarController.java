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
import kic.mskim.MskimRequestMapping;
import kic.mskim.RequestMapping;
import model.Car;
import model.CarHis;

@WebServlet("/car/*")
public class CarController extends MskimRequestMapping{

	HttpSession session;
	CarMybatis dao = new CarMybatis();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();
		super.service(request, response);
	}
	
	@RequestMapping("rentCar")
	public String rentCar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		List<Car> li = dao.carList();
		request.setAttribute("li", li);
		System.out.println(li);
		return "/view/car/rentCar.jsp";
	}
	
	@RequestMapping("rentCarTime")
	public String rentCarTime(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
        String car_id = request.getParameter("car_id");
        System.out.println(car_id);
        request.setAttribute("car_id", car_id);
        return "/view/car/rentCarTime.jsp";
	}
	
	@RequestMapping("rentCarInfo")
	public String rentCarInfo(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
        int car_id = Integer.parseInt(request.getParameter("car_id"));
        String sRentDate = request.getParameter("sRentDate");
        String sRentTime = request.getParameter("sRentTime");
        String eRentDate = request.getParameter("eRentDate");
        String eRentTime = request.getParameter("eRentTime");
        System.out.println("sRentDate = " + sRentDate);
        System.out.println("sRentTime = " + sRentTime);
        SimpleDateFormat obj = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
        
        Date sDay = null;
        Date eDay = null;
        long tot_time=0;
        try {
			sDay = obj.parse(sRentDate+" "+sRentTime);
			System.out.println("sDay = " + sDay);
			eDay = obj.parse(eRentDate+" "+eRentTime);
			System.out.println("eDay = " + eDay);
			tot_time = (eDay.getTime() - sDay.getTime()) / (1000*60*60);
			System.out.println("tot_time = " + tot_time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  
        System.out.println(car_id);
        
        int hourFee = dao.fee(car_id);
        int totFee = (int)(tot_time * hourFee);
        
        int num = dao.carHis(car_id, totFee, sDay, eDay);
        
        List<CarHis> rent = dao.rent(car_id);
        session.setAttribute("rent", rent);
        System.out.println(session.getAttribute("rent"));

        request.setAttribute("car_id", car_id);
        request.setAttribute("sRentDate", sRentDate);
        request.setAttribute("sRentTime", sRentTime);
        
        request.setAttribute("eRentDate", eRentDate);
        request.setAttribute("eRentTime", eRentTime);  
        request.setAttribute("tot_time", tot_time);
        request.setAttribute("hourFee", hourFee);
        request.setAttribute("totFee", totFee);
        
		return "/view/car/rentCarInfo.jsp";
	}
	
	@RequestMapping("rentCarList")
	public String rentCarList(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		List<CarHis> li = dao.rentCarList();
		request.setAttribute("li", li);
		System.out.println(li);
		
		return "/view/car/rentCarList.jsp";
	}
}
