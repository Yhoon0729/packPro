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
                    <tr data-toggle="modal" data-target="#hotelModal" onclick="showModal(this)">
                        <td>${h.htlId}</td>
                        <td>${h.fstLoc}</td>
                        <td>${h.htlName}</td>
                        <td>${h.htlGrade}</td>
                        <td><fmt:formatNumber value="${h.htlPrice}" pattern="#,###" /></td>
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
                    <p><strong>호텔아이디:</strong> <span id="modalHtlId"></span></p>
                    <p><strong>축제지역코드:</strong> <span id="modalFstLoc"></span></p>
                    <p><strong>호텔이름:</strong> <span id="modalHtlName"></span></p>
                    <p><strong>호텔평점:</strong> <span id="modalHtlGrade"></span></p>
                    <p><strong>호텔가격:</strong> <span id="modalHtlPrice"></span></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
                </div>
            </div>
        </div>
    </div>

    <script>
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

        function showModal(row) {
            const cells = row.getElementsByTagName('td');
            document.getElementById('modalHtlId').textContent = cells[0].textContent;
            document.getElementById('modalFstLoc').textContent = cells[1].textContent;
            document.getElementById('modalHtlName').textContent = cells[2].textContent;
            document.getElementById('modalHtlGrade').textContent = cells[3].textContent;
            document.getElementById('modalHtlPrice').textContent = cells[4].textContent;
        }
    </script>
</body>
</html>
