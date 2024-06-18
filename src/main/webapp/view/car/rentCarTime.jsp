<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<div class="container">
		<h2>Rent Car Time</h2>
		<form id="rentCarTimeForm" action="rentCarInfo" method="post">
			<input type="hidden" name="car_id" value="${car_id}" />
			<p>선택된 차량 ID: ${car_id}</p>
			<tr>
				<td><label for="sRentDate">대여 날짜:</label>
				<input type="date" id="sRentDate" name="sRentDate" required></td><br><br>
				<label for="sRsentTime">대여 시각:</label> 
				<td><input type="time"id="sRentTime" name="sRentTime" required></td><br><br>
				
				<td><label for="eRentDate">반납 날짜:</label>
				<input type="date" id="eRentDate" name="eRentDate" required></td><br><br>
				<label for="eRentTime">반납 시각:</label> 
				<td><input type="time"id="eRentTime" name="eRentTime" required></td><br><br>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</form>
	</div>
</body>
</html>