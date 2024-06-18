<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<tr>
	<th colspan="5">출국편</th>
</tr>

<c:forEach var="li" items="${airListDep }">
<tr>
	<td rowspan="2">
	<input type="radio" name="depAir" id="${li.flightCode }" onChange="selectDepAir(event)" />
	</td>
	<td>${li.companyName }</td>
	<td>${li.flightCode }</td>
	<td>${li.seatClass }</td>
	<td>${li.price } 원</td>
</tr>

<tr>
	<td>${li.depAirportName }</td>
	
	<c:set var="time" value="${li.depTime}" />
		<td><c:out value="${fn:substring(time, 11, 16)}" /></td>
	
	<td>${li.arrAirportName }</td>
		<c:set var="time" value="${li.arrTime}" />
		<td><c:out value="${fn:substring(time, 11, 16)}" /></td>

</tr>
</c:forEach>


<tr>
	<th colspan="5">입국편</th>
</tr>

<c:forEach var="li" items="${airListRtn }">
<tr>
	<td rowspan="2" style="width: 20px;">
	<input type="radio" name="rtnAir" id="${li.flightCode }" onChange="selectRtnAir(event)" />
	</td>
	<td style="width: 130px;">${li.companyName }</td>
	<td style="width: 140px;">${li.flightCode }</td>
	<td style="width: 130px;">${li.seatClass }</td>
	<td style="width: 140px;">${li.price } 원</td>
</tr>

<tr>
	<td>${li.depAirportName }</td>
	<c:set var="time" value="${li.depTime}" />
		<td><c:out value="${fn:substring(time, 11, 16)}" /></td>
	
	<td>${li.arrAirportName }</td>
		<c:set var="time" value="${li.arrTime}" />
		<td><c:out value="${fn:substring(time, 11, 16)}" /></td>
</tr>
</c:forEach>