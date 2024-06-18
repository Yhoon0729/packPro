<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>예약 확인</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        .container {
            margin-top: 50px;
        }
        .card {
            margin-bottom: 20px;
        }
        .card-header {
            background-color: #007bff;
            color: white;
        }
        .card-body {
            font-size: 1.1em;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="text-center my-4">예약 확인</h1>
        <div class="card">
            <div class="card-header">
                예약 정보
            </div>
            <div class="card-body">
                <p><strong>호텔 이름:</strong> <span id="hotelName">${param.hotelName}</span></p>
                <p><strong>체크인 날짜:</strong> <span id="checkinDate">${param.checkinDate}</span></p>
                <p><strong>체크아웃 날짜:</strong> <span id="checkoutDate">${param.checkoutDate}</span></p>
                <p><strong>성인:</strong> <span id="adultCount">${param.adultCount}</span></p>
                <p><strong>어린이:</strong> <span id="childCount">${param.childCount}</span></p>
                <p><strong>객실 수:</strong> <span id="roomCount">${param.roomCount}</span></p>
                <p><strong>가격:</strong> <span id="totalPrice">${param.totalPrice}</span>원</p>
            </div>
        </div>
        <div class="text-center">
            <button class="btn btn-primary" onclick="goBack()">뒤로 가기</button>
        </div>
    </div>

    <script>
        function goBack() {
            window.history.back();
        }
    </script>
</body>
</html>
