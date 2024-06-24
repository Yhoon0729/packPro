<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
    function updateAction(carId) {
        var form = document.getElementById('rentCarForm');
        form.action = "/packagePro/car/rentCarTime?carId=" + carId;
    }
</script>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<div class="container">
		<h2>Available Cars</h2>
		<form id="rentCarForm" action="/rentCar/car/rentCarTime" method="post">
			<table border="1">
				<tr>
					<th>선택</th>
					<th>차량 시리얼 번호</th>
					<th>국가</th>
					<th>차종</th>
					<th>모델</th>
					<th>일일 요금</th>
					<th>렌탈 회사</th>
				</tr>

				<c:forEach var="c" items="${li}">
					<tr>
						<td><input type="radio" name="chk"  onchange="updateAction(${c.carId})"></td>
						<td>${c.carId}</td>
						<td>${c.carNation}</td>
						<td>${c.carType}</td>
						<td>${c.carName}</td>
						<td>${c.carDailyFee}</td>
						<td>${c.carCom}</td>
					</tr>
				</c:forEach>
			</table>
			<input type="submit" value="Submit">
		</form>
	</div>
</body>
</html>