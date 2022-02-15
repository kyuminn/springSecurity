<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Login page</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/auth/loginProc" commandName="login">
		<input type="text" name="email"><br>
		<input type="password" name="pwd">
		<input type="submit" value="로그인">
		<input type="button" value="회원가입" onclick="window.location.href='${pageContext.request.contextPath}/auth/regist'">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /><br><br>
		${requestScope.loginFailMsg}
	</form>
</body>
</html>