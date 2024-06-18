<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
      
<!-- prefix 사용 설정  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    
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

<script type="text/javascript">

/* 도착 공항 선택 */
function selectArrAirport(e){

    let url = "${pageContext.request.contextPath}/air/depAir?depAir=" + e.target.id; 
        
    fetch(url)
    .then( res => res.text() )
    .then( text => {
    	document.querySelector("#arrAirport").innerHTML = text;
    })
    
    url = "${pageContext.request.contextPath}/air/airText?text=" + e.target.id;
    
    fetch(url)
    .then( res => res.text() )
    .then( text => {
    	document.querySelector("#returnArrAirport").innerHTML = text;
    })

}

/* 가는 날짜 오는 날짜 선택 */
function selectDate(e){

    console.log( e.target.id );
    let url = "${pageContext.request.contextPath}/air/arrAir?arrAir=" + e.target.id; 
        
    fetch(url)
    .then( res => res.text() )
    .then( text => {
    	document.querySelector("#date").innerHTML = text;
    })
    
    url = "${pageContext.request.contextPath}/air/airText?text=" + e.target.id;
    
    fetch(url)
    .then( res => res.text() )
    .then( text => {
    	document.querySelector("#returnDepAirport").innerHTML = text;
    })
}
    
/* 가는 날짜 선택 */
function selectDepDate(e){

	let date = e.target.value 

    let url = "${pageContext.request.contextPath}/air/airDepDate?date=" + date;
    
    fetch(url)

}

/* 오는 날짜 보여주기 */
function selectRtnDate(e){

	let date = e.target.value 

    let url = "${pageContext.request.contextPath}/air/airRtnDate?date=" + date;
    
    fetch(url)
    .then( res => res.text() )
    .then( text => {
    	const id = document.querySelector("#airList");
    	
    	id.innerHTML = text;
    })
}

</script>

</head>
<body>

	<form action="/packagePro/hotel/hotelList" method="post">
	
		<h1>선택한 축제</h1>
	
		<table>
			<thead>
				<tr>
					<th>여행지</th>
					<th>축제명</th>
					<th style="width:450px">축제기간</th>
				</tr>
			</thead>
			
			<tbody>
				<tr>
					<td>${list.country }</td>
					<td>${list.festivalName }</td>
					<td>${list.startDay } ~ ${list.endDay }</td>
				</tr>
			
			</tbody>
		</table>
		
		
		<h1>출발공항 선택</h1>
		
		<table>
		
			<tbody>
			
				<tr>
					<th colspan="2">출국 일정</th>
				</tr>
			
				<tr>
					<th>출발 공항</th>
					<td style="width:550px">
					
						<c:forEach var="li" items="${airList }">
							<input type="radio" name="depAirport" 
							 id="${li }" onChange="selectArrAirport(event)" />
							<label for="${li }">${li }</label>
						</c:forEach>
					
					</td>					
				</tr>
				
				<tr>
					<th>도착 공항</th>
					<td id="arrAirport"></td>					
				</tr>
				
				<tr>
					<th>일정 선택</th>
					<td id="date"></td>					
				</tr>
				
				<tr>
					<th colspan="2">귀국 일정</th>
				</tr>
				
				<tr>
					<th>출발 공항</th>
					<td id="returnDepAirport"></td>					
				</tr>
				
				<tr>
					<th>도착 공항</th>
					<td id="returnArrAirport"></td>					
				</tr>
			</tbody>
		
		</table>
		
		<h1>항공편 선택</h1>
		
		<table>
		
			<tbody id="airList"></tbody>
			
		</table>
		
		<button type="submit">선택완료</button>
	
	</form>


</body>
</html>