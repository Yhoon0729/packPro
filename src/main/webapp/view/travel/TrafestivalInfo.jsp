<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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



</head>
<body>

	<form action="/packagePro/air/airindex?code=${list.code }" method="post">
	
		<h1>축제 상세 정보$()</h1>
	
		<table>
		
			<tbody>
				
				<tr>
					<td>국가명</td>
					<td>${list.country }</td>					
				</tr>
								
				<tr>
				
					<td>축제명</td>
					<td>${list.festivalName }</td>					
				</tr>
				
				<tr>
					<td>축제 기간</td>
					<td style="width:450px;">${list.startDay } ~ ${list.endDay }</td>					
				</tr>

				<tr>
					<td>축제정보</td>
					<td>${list.info1 }</td>					
				</tr>

				<tr>
					<td>축제정보</td>
					<td>${list.info2 }</td>					
				</tr>

				<tr>
					<td>축제정보</td>
					<td>${list.info3 }</td>					
				</tr>
				
				<tr>
					<td>관련 정보</td>
					<td>${list.url1 }</td>					
				</tr>

				<tr>
					<td>관련 정보</td>
					<td>${list.url2 }</td>					
				</tr>

				<tr>
					<td>관련 정보</td>
					<td>${list.url3 }</td>					
				</tr>
				
			</tbody>
		
		</table>
		
		<!-- 확인 -->

	<a href="traindex">이전 페이지</a>
	
	<button type="submit">선택완료</button>
	
	</form>

</body>
</html>