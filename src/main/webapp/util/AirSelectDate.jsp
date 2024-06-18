<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

    
<label for="depTime">가는 날짜</label>
<input  type="date" id="depTime" onchange="selectDepDate(event)"/>

~

<label for="rtnTime">오는 날짜</label>
<input  type="date" id="rtnTime" onchange="selectRtnDate(event)"/>