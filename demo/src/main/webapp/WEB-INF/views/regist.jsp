<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� ����</title>
</head>
<body>
	<form method="post">
		<input type="text" name="email" placeholder="email"><br>
		<input type="password" name="pwd" placeholder="��й�ȣ"><br>
		<input type="password" name="confirmPwd" placeholder="��й�ȣ Ȯ��"><br>
		<input type="submit" value="ȸ������ �ϱ�">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</body>
</html>