<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>최종 예약 확인</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/popper.min.js"></script>
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
        .booking-section {
            margin-bottom: 20px;
        }
        .booking-section hr {
            border-top: 1px solid #ddd;
        }
        .btn-container {
            display: flex;
            justify-content: center;
            gap: 20px;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="text-center my-4">최종 예약 확인</h1>
        
        <!-- 예약 정보 박스 -->
        <div class="card">
            <div class="card-header">
                예약 정보
            </div>
            <div class="card-body">
                <div class="booking-section">
                    <h5>축제 정보</h5>
                    <p><strong>축제 이름:</strong> <c:out value="${sessionScope.list.festivalName}"/></p>
                    <p><strong>축제 날짜:</strong> <c:out value="${sessionScope.list.startDay}"/> ~ <c:out value="${sessionScope.list.endDay}"/></p>
                </div>
                <hr />
                
                <div class="booking-section">
                    <h5>비행기 정보</h5>
                    <p><strong>출발지:</strong> <c:out value="${sessionScope.flightDeparture}"/></p>
                    <p><strong>목적지:</strong> <c:out value="${sessionScope.flightDestination}"/></p>
                    <p><strong>출발 날짜:</strong> <c:out value="${sessionScope.flightDate}"/></p>
                    <p><strong>비행기 번호:</strong> <c:out value="${sessionScope.flightNumber}"/></p>
                </div>
                <hr />

                <div class="booking-section">
                    <h5>호텔 정보</h5>
                    <p><strong>호텔 이름:</strong> <c:out value="${hotel.htlName }"/></p>
                    <p><strong>체크인 날짜:</strong> <c:out value="${sessionScope.booking.htlCheckin}"/></p>
                    <p><strong>체크아웃 날짜:</strong> <c:out value="${sessionScope.booking.htlCheckout}"/></p>
                    <p><strong>성인:</strong> <c:out value="${sessionScope.booking.htlAdult}"/></p>
                    <p><strong>어린이:</strong> <c:out value="${sessionScope.booking.htlChild}"/></p>
                    <p><strong>객실 수:</strong> <c:out value="${sessionScope.booking.htlRooms}"/></p>
                </div>
                <hr />
                
                <div class="booking-section">
                    <h5>렌트카 정보</h5>
                    <p><strong>렌트카 회사:</strong> <c:out value="${car.car_com }"/></p>
                    <p><strong>차량 종류:</strong> <c:out value="${car.car_type }"/></p>
                    <p><strong>차량 모델:</strong> <c:out value="${car.car_name }"/></p>
                    <p><strong>렌트 시작 날짜:</strong> <c:out value="${sessionScope.carHis.sDay}"/></p>
                    <p><strong>렌트 종료 날짜:</strong> <c:out value="${sessionScope.carHis.eDay}"/></p>
                </div>
                <hr />

                <div class="booking-section">
                    <h5>액티비티 정보</h5>
                    <p><strong>액티비티 이름:</strong> <c:out value="${sessionScope.activity.activityTitle}"/></p>
                </div>
            </div>
        </div>

        <div class="btn-container">
            <form action="finalizeBooking.do" method="post">
                <button type="submit" class="btn btn-primary">예약하기</button>
            </form>
            <button class="btn btn-secondary" onclick="goBack()">취소</button>
        </div>
    </div>

    <script>
        function goBack() {
            window.history.back();
        }
    </script>
</body>
</html>
