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
    function updateAction(car_id) {
        var form = document.getElementById('rentCarForm');
        form.action = "/packagePro/car/rentCarTime?car_id=" + car_id;
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
						<td><input type="radio" name="chk"  onchange="updateAction(${c.car_id})"></td>
						<td>${c.car_id}</td>
						<td>${c.car_nation}</td>
						<td>${c.car_type}</td>
						<td>${c.car_name}</td>
						<td>${c.car_daily_fee}</td>
						<td>${c.car_com}</td>
					</tr>
				</c:forEach>
			</table>
			<input type="submit" value="Submit">
		</form>
	</div>
</body>
</html>