package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.HotelMybatis;
import kic.mskim.MskimRequestMapping;
import kic.mskim.RequestMapping;
import model.Hotel;
import model.HotelBooking;

@WebServlet("/hotel/*")
public class HotelController extends MskimRequestMapping {
    HttpSession session;
    HotelMybatis mybatisdao = new HotelMybatis();

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        super.service(request, response);
    }

    @RequestMapping("hotelList")
    public String hotelList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Hotel> li = mybatisdao.hotelList();
        List<Hotel> locli = mybatisdao.hotellocList();
        request.setAttribute("li", li);
        request.setAttribute("locli", locli);
        System.out.println(li);
        return "/view/hotel/hotelList.jsp";
    }

    @RequestMapping("hotelbooking")
    public String hotelbooking(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int hotelId = Integer.parseInt(request.getParameter("hotelId"));
        String checkinDate = request.getParameter("checkinDate");
        String checkoutDate = request.getParameter("checkoutDate");
        int adult = Integer.parseInt(request.getParameter("adult"));
        int child = Integer.parseInt(request.getParameter("child"));
        int rooms = Integer.parseInt(request.getParameter("rooms"));

        HotelBooking booking = new HotelBooking();
        booking.setHtlBookingid(100);
        booking.setHtlId(hotelId);
        booking.setHtlCheckin(checkinDate);
        booking.setHtlCheckout(checkoutDate);
        booking.setHtlAdult(adult);
        booking.setHtlChild(child);
        booking.setHtlRooms(rooms);
        booking.setHtlTotalprice(rooms * mybatisdao.getHotelPrice(hotelId));

        session.setAttribute("booking", booking);

        System.out.println("세션 호텔 예약 " + booking);
        return "/view/hotel/hotelBooking.jsp";
    }
}
