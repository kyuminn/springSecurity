<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원 가입</title>
</head>
<body>
	<form method="post">
		<input type="text" name="email" placeholder="email"><br>
		<input type="password" name="pwd" placeholder="비밀번호"><br>
		<input type="password" name="confirmPwd" placeholder="비밀번호 확인"><br>
		<input type="submit" value="회원가입 하기">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</body>
</html>