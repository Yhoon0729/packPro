<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<c:forEach var="li" items="${airList }">
	<input type="radio" name="arrAirport" 
	 id="${li }" onChange="selectDate(event)" />
	<label for="${li }">${li }</label>
</c:forEach>
