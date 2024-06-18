<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- prefix 사용 설정  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>
 table{ border-collapse : collapse; }  /*이중선 제거*/
 th,td{
      width: 100px;
      height: 50px;
      text-align: center;
      border: 1px solid #000;
      
      vertical-align: top;	/* 위 */
      vertical-align: bottom;   /* 아래 */
      vertical-align: middle;   /* 가운데 */
    }
</style>


<body>

<form action="" method="post">

	<h1>여행 상품 선택</h1>
	
	<table>
	
		<thead>
			<tr>
				<th>계절</th>
				<th style="width:150px">축제명</th>
				<th>시작</th>
				<th>끝</th>
			</tr>
		</thead>
		
		<tbody>
							
			<c:forEach var="li" items="${list }">
				<tr>
		 			<c:if test="${li.season == 'spr'}">
						<td>봄</td>
						<td>
							<a href="/packagePro/tra/festivalInfo?code=${li.code }">
								${li.festivalName}
							</a>
						</td>
						<td> ${li.startDay}</td>
						<td> ${li.endDay}</td>
					</c:if>
				<tr>
			</c:forEach>
			
			<c:forEach var="li" items="${list }">
				<tr>
		 			<c:if test="${li.season == 'sum'}">
						<td>여름</td>
						<td>
							<a href="/packagePro/tra/festivalInfo?code=${li.code }">
								${li.festivalName}
							</a>
						</td>
						<td> ${li.startDay}</td>
						<td> ${li.endDay}</td>
					</c:if>
				<tr>
			</c:forEach>
			
			<c:forEach var="li" items="${list }">
				<tr>
		 			<c:if test="${li.season == 'fal'}">
						<td>가을</td>
						<td>
							<a href="/packagePro/tra/festivalInfo?code=${li.code }">
								${li.festivalName}
							</a>
						</td>
						<td> ${li.startDay}</td>
						<td> ${li.endDay}</td>
					</c:if>
				<tr>
			</c:forEach>
			
			<c:forEach var="li" items="${list }">
				<tr>
		 			<c:if test="${li.season == 'win'}">
						<td>겨울</td>
						<td>
							<a href="/packagePro/tra/festivalInfo?code=${li.code }">
								${li.festivalName}
							</a>
						</td>
						<td> ${li.startDay}</td>
						<td> ${li.endDay}</td>
					</c:if>
				<tr>
			</c:forEach>
					
			
			
		</tbody>
		
	</table>
	

</form>


</body>
</html>