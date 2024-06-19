<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>호텔 리스트</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        .modal-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .modal-body {
            display: flex;
        }
        .modal-body .hotel-info {
            flex: 1;
        }
        .modal-body .booking-info {
            flex: 1;
            padding-left: 20px;
        }
        .number-input {
            display: flex;
            align-items: center;
            margin-bottom: 10px;
        }
        .number-input button {
            width: 30px;
            height: 30px;
            border: 1px solid #ccc;
            background: #f0f0f0;
            font-size: 18px;
            line-height: 1;
        }
        .number-input input {
            text-align: center;
            border: 1px solid #ccc;
            height: 30px;
            width: 50px;
            margin: 0 5px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="text-center my-4">호텔 리스트</h1>
        <div class="button-container text-center mb-4">
            <c:forEach var="h" items="${locli}">
                <button class="filter-button btn btn-light" onclick="filterTable('${h.fstLoc}')">${h.fstLoc}</button>
            </c:forEach>
            <button class="filter-button btn btn-light" onclick="filterTable('')">전체</button>
        </div>
        <table id="hoteltable" class="table table-striped">
            <thead class="thead-dark">
                <tr>
                    <th>호텔아이디</th>
                    <th>축제지역코드</th>
                    <th>호텔이름</th>
                    <th>호텔평점</th>
                    <th>호텔가격</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="h" items="${li}">
                    <tr data-toggle="modal" data-target="#hotelModal" onclick="showModal(this, '${h.htlImg}', ${h.htlId})">
                        <td>${h.htlId}</td>
                        <td>${h.fstLoc}</td>
                        <td>${h.htlName}</td>
                        <td>${h.htlGrade}</td>
                        <td><fmt:formatNumber value="${h.htlPrice}" pattern="#,###" />원</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="hotelModal" tabindex="-1" aria-labelledby="hotelModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="hotelModalLabel">호텔 정보</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="hotel-info">
                        <div class="text-center mb-3">
                            <img id="modalHotelImage" src="" alt="호텔 이미지" class="img-fluid" style="max-height: 300px;">
                        </div>
                        <p><strong>호텔이름:</strong> <span id="modalHtlName"></span></p>
                        <p><strong>호텔평점:</strong> <span id="modalHtlGrade"></span></p>
                        <p><strong>호텔가격:</strong> <span id="modalHtlPrice"></span></p>
                        <p><strong>총 가격:</strong> <span id="modalHtlTotalPrice"></span></p> <!-- 총 가격 표시 -->
                    </div>
                    <div class="booking-info">
                        <form id="bookingForm" method="post" action="hotelbooking">
                            <div class="form-group">
                                <label for="checkinDate">체크인 날짜</label>
                                <input type="date" class="form-control" id="checkinDate" name="checkinDate" required>
                            </div>
                            <div class="form-group">
                                <label for="checkoutDate">체크아웃 날짜</label>
                                <input type="date" class="form-control" id="checkoutDate" name="checkoutDate" required>
                            </div>
                            <div class="form-group">
                                <label for="occupancy">객실 인원</label>
                                <div class="number-input">
                                    <button type="button" onclick="changeValue('adult', -1)">-</button>
                                    <input type="number" id="adult" name="adult" value="1" min="1" readonly>
                                    <button type="button" onclick="changeValue('adult', 1)">+</button>
                                    <label for="adult" class="ml-2">성인</label>
                                </div>
                                <div class="number-input">
                                    <button type="button" onclick="changeValue('child', -1)">-</button>
                                    <input type="number" id="child" name="child" value="0" min="0" readonly>
                                    <button type="button" onclick="changeValue('child', 1)">+</button>
                                    <label for="child" class="ml-2">어린이</label>
                                </div>
                                <div class="number-input">
                                    <button type="button" onclick="changeValue('rooms', -1)">-</button>
                                    <input type="number" id="rooms" name="rooms" value="1" min="1" readonly>
                                    <button type="button" onclick="changeValue('rooms', 1)">+</button>
                                    <label for="rooms" class="ml-2">객실</label>
                                </div>
                                <input type="hidden" id="occupancyText" name="occupancyText">
                                <input type="hidden" id="hotelId" name="hotelId"> <!-- Hidden input for hotelId -->
                            </div>
                        </form>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
                    <button type="button" class="btn btn-primary" onclick="submitBooking()">예약하기</button>
                </div>
            </div>
        </div>
    </div>

    <script>
        let htlPrice = 0;

        function filterTable(code) {
            const table = document.getElementById('hoteltable').getElementsByTagName('tbody')[0];
            const rows = table.getElementsByTagName('tr');

            for (let i = 0; i < rows.length; i++) {
                const cell = rows[i].getElementsByTagName('td')[1];
                if (code === '' || cell.textContent === code) {
                    rows[i].style.display = '';
                } else {
                    rows[i].style.display = 'none';
                }
            }
        }

        function showModal(row, imageUrl, hotelId) {
            const cells = row.getElementsByTagName('td');
            document.getElementById('modalHtlName').textContent = cells[2].textContent;
            document.getElementById('modalHtlGrade').textContent = cells[3].textContent;
            document.getElementById('modalHtlPrice').textContent = cells[4].textContent;
            document.getElementById('modalHotelImage').src = imageUrl;
            document.getElementById('hotelId').value = hotelId; // Set the hotelId

            htlPrice = parseInt(cells[4].textContent.replace(/,/g, ''));
            updateTotalPrice();
        }

        function changeValue(id, delta) {
            const element = document.getElementById(id);
            let value = parseInt(element.value) + delta;
            value = Math.max(value, parseInt(element.min));
            element.value = value;
            updateTotalPrice();
        }

        function updateTotalPrice() {
            const rooms = parseInt(document.getElementById('rooms').value);
            const totalPrice = rooms * htlPrice;
            document.getElementById('modalHtlTotalPrice').textContent = totalPrice.toLocaleString() + '원';
        }

        function updateOccupancyText() {
            const adult = document.getElementById('adult').value;
            const child = document.getElementById('child').value;
            const rooms = document.getElementById('rooms').value;
            const occupancyText = `성인: ${adult}, 어린이: ${child}, 객실: ${rooms}`;
            document.getElementById('occupancyText').value = occupancyText;
        }

        function submitBooking() {
            const form = document.getElementById('bookingForm');
            updateOccupancyText();
            form.submit();
        }
    </script>
</body>
</html>
