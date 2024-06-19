<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>액티비티</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }
        header {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 1rem 0;
            margin-bottom: 20px;
        }
        .activity-list {
            max-width: 800px;
            margin: 0 auto;
            padding: 0 20px;
        }
        .activity-item {
            cursor: pointer; /* 마우스 커서를 포인터로 변경하여 클릭 가능하게 함 */
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            border-radius: 4px;
            padding: 15px;
            margin-bottom: 20px;
            transition: transform 0.2s ease-in-out; /* 부드러운 변형 효과 */
        }
        .activity-item:hover {
            transform: scale(1.02); /* 호버 시 약간 확대됨 */
        }
        .activity-item h2 {
            font-size: 1.2rem;
            margin-bottom: 10px;
            color: #333;
        }
        .activity-item p {
            margin-bottom: 5px;
            color: #666;
        }
        .activity-item a {
            display: inline-block;
            background-color: #007bff;
            color: #fff;
            text-decoration: none;
            padding: 8px 15px;
            border-radius: 4px;
            transition: background-color 0.3s ease;
        }
        .activity-item a:hover {
            background-color: #0056b3;
        }
    </style>
    <script>
    document.addEventListener('DOMContentLoaded', function() {
        var activityItems = document.querySelectorAll('.activity-item');
        activityItems.forEach(function(item) {
            item.addEventListener('click', function() {
                var activityId = item.dataset.activityId;
                var url = '<%= request.getContextPath() %>/TravelActivity/TravelActivityDetails?id=' + activityId;
                console.log("Redirecting to URL: " + url); // 디버깅 로그

                // 현재 창에서 URL로 이동
                window.location.href = url;

               
            });
        });
    });

  </script>


    
</head>
<body>
    <header>
        <h1>액티비티</h1>
    </header>
    <main>
       <section class="activity-list">
            <c:forEach var="activity" items="${activityList}">
                <article class="activity-item" data-activity-id="${activity.id}">
                    <p><strong>제목:</strong> ${activity.activityTitle}</p>
        			<p><strong>설명:</strong> ${activity.activityDescription}</p>
                    <p><strong>계절 :</strong> ${activity.season}</p>
                    <p><strong>금액 :</strong> ${activity.price}</p>
                    <p><strong>좋아요 :</strong> ${activity.likes}</p>
                    <p><strong>리뷰:</strong> ${activity.reviews}</p>
                </article>
            </c:forEach>
        </section>
    </main>
</body>
</html>
