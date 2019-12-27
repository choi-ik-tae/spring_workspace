<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<style>
		table{border: 1px solid black;}
		td{border: 1px solid black;}
		th{border: 1px solid black;}
	</style>
</head>
<body>
	<table>
		<tr>
			<th>번호
			<th>이름
			<th>메세지
			<th>날짜
			<th>
		</tr>
		<c:choose>
		<c:when test="${list.size() == 0}">
			보관된 메세지가 없습니다.
			<button id="toHome" type="button">to Home</button>
		</c:when>
		<c:when test="${list.size() > 0}">
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.seq}
				<td>${dto.name}
				<td>${dto.msg}
				<td>${dto.write_date}
				<td><button id="delete${dto.seq}" type="button">삭제</button>
				<form action="deleteProc.do" method="post" id="Delete${dto.seq}">
					<input type="hidden" name="seq" value="${dto.seq}">
				</form>
				<script>
					$("#delete${dto.seq}").on("click",function(){
						$("#Delete${dto.seq}").submit();
					});
				</script>
			</tr>
		</c:forEach>
		</c:when>
		</c:choose>
	</table>
	<button id="toHome" type="button">to Home</button>
	<script>
		$("#toHome").on("click",function(){
			location.href="home";
		});
	</script>
</body>
</html>