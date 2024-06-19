package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookingMybatis;
import kic.mskim.MskimRequestMapping;
import kic.mskim.RequestMapping;
import model.CarHis;
import model.FestivalInfo;
import model.HotelBooking;
import model.TravelActivity;

@WebServlet("/booking/*")
public class BookingController extends MskimRequestMapping {
	
	HttpSession session;
	BookingMybatis dao = new BookingMybatis();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();
		super.service(request, response);
	}
	
	@RequestMapping("confirm")
	public String confirm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		FestivalInfo finfo = (FestivalInfo) session.getAttribute("list");
		String fst_code = finfo.getCode();
		System.out.println("finfo.getCode()"+finfo.getCode());
		
		HotelBooking htlBooking = (HotelBooking) session.getAttribute("booking");
		System.out.println("세션 예약 호텔" + htlBooking);
		int htl_id = htlBooking.getHtlId();
		int htl_bookingid = htlBooking.getHtlBookingid();
		
		CarHis carHis = (CarHis) session.getAttribute("carHis");
		int car_id = carHis.getCar_id();
		int car_history_id = carHis.getCar_history_id();
		
		TravelActivity activity = (TravelActivity) session.getAttribute("activity");
		int act_id = activity.getId();
		
		int booking = dao.booking(act_id, fst_code, htl_bookingid, car_history_id, car_id, htl_id);
        return "/view/booking/confirm.jsp";
	}
	
}
