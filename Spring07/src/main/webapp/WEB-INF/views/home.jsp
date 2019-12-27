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
	<form action="upload.do" enctype="multipart/form-data" method="post">
		<!-- multiple 을 주면 여러개 선택가능 -->
		<input type="file" name="file" multiple="multiple"><br>
		<input type="text" name="title"><br>
		<input type="text" name="contents"><br>
		<button id="upload">파일업로드</button>
	</form>
</body>
</html>