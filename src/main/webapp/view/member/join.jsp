<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<script>
	function chkform(f) {
		let chk = f.userPass.value == f.userPassChk.value
		if (!chk) {
			alert("비밀번호 확인이 틀렸습니다.")
			f.userPassChk.focus()
			return chk;
		} else {
			alert("가입이 완료되었습니다.")
			return chk;
		}
	}
</script>


<body>
	<div class="container">
		<h4 class="">회원가입</h4>
		<form class="" novalidate action="joinPro" onsubmit="return chkform(this)" method="post">
		
			<div class="">
				<label for="countryCode">국가</label>
				<input type="text" class="" id="countryCode" name="countryCode" placeholder="국가코드를 입력해주세요." value="" required>
			</div>

			<div class="">
				<label for="userId">아이디</label>
				<input type="text" class="" id="userId" name="userId" placeholder="아이디을 입력해주세요." value="" required>
			</div>

			<div class="">
				<label for="userPass">비밀번호</label>
				<input type="password" id="userPass" name="userPass" placeholder="비밀번호을 입력해주세요." value="" required>
			</div>

			<div class=>
				<label for="userPassChk">비밀번호확인</label>
				<input type="password" id="userPassChk" name="userPassChk" placeholder="비밀번호확인을 입력해주세요." value="" required>
			</div>
			
			<div class="">
				<label for="userName">이름</label>
				<input type="text" class="" id="userName" name="userName" placeholder="이름을 입력해주세요." value="" required>
			</div>
			
			<div class="">
				<label for="userTel">전화번호</label>
				<input type="tel" id="userTel" name="userTel" placeholder="ex)01012345678" required>
			</div>

			<div class="">
				<label for="userAge">나이</label>
				<input type="text" id="userAge" name="userAge" placeholder="나이를 입력해주세요." value="" required>
			</div>

			<div class="">
				<div class="">
					<label for="userGen">남자</label>
					<input type="radio" id="userGen" name="userGen" value="1" required>
				</div>
				<div class="">
					<label for="userGen">여자</label>
					<input type="radio" id="userGen" name="userGen" value="2" required>
				</div>
			</div>

			<button class="" type="submit">가입 완료</button>
		</form>
	</div>
</body>
</html>