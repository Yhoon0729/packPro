<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2>Rent Car Confirmation</h2>

		<p>차량 시리얼 번호:${car_id}</p>

		<p>대여 날짜:${sRentDate}</p>

		<p>대여 시각:${sRentTime}</p>

		<p>반납 날짜:${eRentDate}</p>

		<p>반납 시각:${eRentTime}</p>

		<p>대여 시간:${tot_time}</p>

		<p>시간당 가격:${hourFee}</p>

		<p>총 가격:${totFee}</p>
	</div>

	<div>
		<li>세션에 저장된 값 : ${sessionScope.carHis.totFee}</li>

	</div>
	<form action="/packagePro/TravelActivity/TravelActivityList"
		method="post">
		<button type="submit">액티비티 고르러 가기</button>
	</form>
</body>
</html>