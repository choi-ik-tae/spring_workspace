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
	<h1>회원정보</h1>
	<table border="1">
		<tr>
			<th>아이디
			<th>이름
			<th>전화번호
		</tr>
			<tr>
				<td>${dto.id}
				<td>${dto.name}
				<td>${dto.phone}
			</tr>
		<tr>
			<td colspan="3" style="text-align:center"><button id="toHome" type="button">돌아가기</button>
		</tr>
	</table>
	<script>
		$("#toHome").on("click",function(){
			location.href="${pageContext.request.contextPath}/home";
		});
	</script>
</body>
</html>