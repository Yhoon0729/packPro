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
		<h2>렌트중인 차량 리스트</h2>
		<table border="1">
			<tr>
				<th>렌트 시리얼 번호</th>
				<th>차량 시리얼 번호</th>
				<th>대여 날짜</th>
				<th>반납 날짜</th>
			</tr>

			<c:forEach var="r" items="${li}">
				<tr>
					<td>${r.carHistoryId}</td>
					<td>${r.carId}</td>
					<td>${r.carStartDate}</td>
					<td>${r.carEndDate}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>