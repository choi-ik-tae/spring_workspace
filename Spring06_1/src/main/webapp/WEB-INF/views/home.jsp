<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>
	<button id="btnLogin" type="button">로그인</button>
	<button id="btnSignup" type="button">회원가입</button>
	<c:choose>
		<c:when test="${session != null}">
			<button id="btnLogout">로그아웃</button>
		</c:when>
	</c:choose>
	<script>
		$("#btnLogin").on("click", function() {
			location.href="member/login";
		});
		$("#btnSignup").on("click", function() {
			location.href="member/signup";
		});
		$("#btnLogout").on("click", function() {
			location.href="member/logout.do";
		});
	</script>
</body>
</html>