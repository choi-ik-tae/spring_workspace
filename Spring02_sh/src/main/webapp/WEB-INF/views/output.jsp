<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Output</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<style>
		div{margin:auto;}
	</style>
</head>
<body>
	<table border=1 align=center>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>메시지</th>
			<th>날짜</th>
			<th></th>
		</tr>
			<c:forEach items="${list}" var="dto" varStatus="status">
				<tr>
					<td>${dto.seq}</td>
					<td>${dto.name}</td>
					<td>${dto.msg}</td>
					<td>${dto.getFormedDate()}</td>
					<td><button id="delete${dto.seq}" onclick="location.href='delete.do?seq=${dto.seq}'">삭제</button></td>
				</tr>
			</c:forEach>
	</table>
	<div id="box">
		<button id="to_home">To Home</button>
	</div>
	<script>
		$("#to_home").on("click", function(){
			location.href="home";
		});
	</script>
</body>
</html>