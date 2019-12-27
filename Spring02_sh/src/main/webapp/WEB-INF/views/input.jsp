<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Input</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>
	<button id="to_home">To Home</button>
	
	<form action="inputProc.do" method="post">
		<input type="text" id="username" name="username" placeholder="이름">
		<input type="text" id="msg" name="msg" placeholder="메시지">
		<input type="submit" value="제출">
		<input type="reset" value="초기화">
	</form>
	
	<script>
		$("#to_home").on("click", function(){
			location.href="home";
		});
	</script>
</body>
</html>