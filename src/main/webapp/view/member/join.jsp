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
			alert("��й�ȣ Ȯ���� Ʋ�Ƚ��ϴ�.")
			f.userPassChk.focus()
			return chk;
		} else {
			alert("������ �Ϸ�Ǿ����ϴ�.")
			return chk;
		}
	}
</script>


<body>
	<div class="container">
		<h4 class="">ȸ������</h4>
		<form class="" novalidate action="joinPro" onsubmit="return chkform(this)" method="post">
		
			<div class="">
				<label for="countryCode">����</label>
				<input type="text" class="" id="countryCode" name="countryCode" placeholder="�����ڵ带 �Է����ּ���." value="" required>
			</div>

			<div class="">
				<label for="userId">���̵�</label>
				<input type="text" class="" id="userId" name="userId" placeholder="���̵��� �Է����ּ���." value="" required>
			</div>

			<div class="">
				<label for="userPass">��й�ȣ</label>
				<input type="password" id="userPass" name="userPass" placeholder="��й�ȣ�� �Է����ּ���." value="" required>
			</div>

			<div class=>
				<label for="userPassChk">��й�ȣȮ��</label>
				<input type="password" id="userPassChk" name="userPassChk" placeholder="��й�ȣȮ���� �Է����ּ���." value="" required>
			</div>
			
			<div class="">
				<label for="userName">�̸�</label>
				<input type="text" class="" id="userName" name="userName" placeholder="�̸��� �Է����ּ���." value="" required>
			</div>
			
			<div class="">
				<label for="userTel">��ȭ��ȣ</label>
				<input type="tel" id="userTel" name="userTel" placeholder="ex)01012345678" required>
			</div>

			<div class="">
				<label for="userAge">����</label>
				<input type="text" id="userAge" name="userAge" placeholder="���̸� �Է����ּ���." value="" required>
			</div>

			<div class="">
				<div class="">
					<label for="userGen">����</label>
					<input type="radio" id="userGen" name="userGen" value="1" required>
				</div>
				<div class="">
					<label for="userGen">����</label>
					<input type="radio" id="userGen" name="userGen" value="2" required>
				</div>
			</div>

			<button class="" type="submit">���� �Ϸ�</button>
		</form>
	</div>
</body>
</html>