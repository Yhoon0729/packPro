<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Travel Activity Details</title>
</head>
<body>
    <h2>Travel Activity Details</h2>
    <p><strong>제목:</strong> ${activity.activityTitle}</p>
    <p><strong>설명:</strong> ${activity.activityDescription}</p>
    <p><strong>계절:</strong> ${activity.season}</p>
    <p><strong>금액:</strong> ${activity.price}</p>
    <p><strong>좋아요:</strong> ${activity.likes}</p>
    <p><strong>리뷰:</strong> ${activity.reviews}</p>
    
    <form action="/packagePro/booking/confirm" method="post">
    	<button type="submit">최종확인</button>
    </form>
</body>
</html>
