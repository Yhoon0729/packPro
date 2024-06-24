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
        String carId = request.getParameter("carId");
        System.out.println(carId);
        request.setAttribute("carId", carId);
        return "/view/car/rentCarTime.jsp";
	}
	
	@RequestMapping("rentCarInfo")
	public String rentCarInfo(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
        int carId = Integer.parseInt(request.getParameter("carId"));
        String sRentDate = request.getParameter("sRentDate");
        String sRentTime = request.getParameter("sRentTime");
        String eRentDate = request.getParameter("eRentDate");
        String eRentTime = request.getParameter("eRentTime");
        System.out.println("sRentDate = " + sRentDate);
        System.out.println("sRentTime = " + sRentTime);
        SimpleDateFormat obj = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
        
        Date carStartDate = null;
        Date carEndDate = null;
        long totTime=0;
        try {
        	carStartDate = obj.parse(sRentDate+" "+sRentTime);
			System.out.println("carStartDate = " + carStartDate);
			carEndDate = obj.parse(eRentDate+" "+eRentTime);
			System.out.println("carEndDate = " + carEndDate);
			totTime = (carEndDate.getTime() - carStartDate.getTime()) / (1000*60*60);
			System.out.println("totTime = " + totTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  
        System.out.println(carId);
        
        int hourFee = dao.fee(carId);
        int totFee = (int)(totTime * hourFee);
        int num = dao.carHis(carId, totFee, carStartDate, carEndDate);
        
        CarHis carHis = dao.rent(carId);
        session.setAttribute("carHis", carHis);
        System.out.println(session.getAttribute("carHis"));

        request.setAttribute("carId", carId);
        request.setAttribute("sRentDate", sRentDate);
        request.setAttribute("sRentTime", sRentTime);
        
        request.setAttribute("eRentDate", eRentDate);
        request.setAttribute("eRentTime", eRentTime);  
        request.setAttribute("totTime", totTime);
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
