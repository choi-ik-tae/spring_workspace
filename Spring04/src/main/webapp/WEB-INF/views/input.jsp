<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>
	<form action="inputProc.do" method="post">
		<label>이름 : </label><input name="name" type="text"><br>
		<label>메세지 : </label><input name="msg" type="text"><br>
		<button type="submit">제출</button>
	</form>
</body>
</html>