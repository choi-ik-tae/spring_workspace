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
<form name="memberRegisterFrm" action="${pageContext.request.contextPath}/beginSpring/memberRegister.action" method="POST">

<input type="text" name="userid" value="" required />

<input type="password" name="passwd" value="" required />

<input type="text" name="name" value="" required />

<input type="email" name="email" value="" required />

<input type="tel" name="tel" value="" required placeholder="-없이입력하세요"/>

<input type="submit" value="가입하기" />

<input type="reset" value="취소하기" />

</form>
</body>
</html>