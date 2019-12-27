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
	<c:forEach items="${list}" var="dto">
		작성자 : ${dto.name}<br>
		메세지 : ${dto.msg }<br><br>
		<form action="delete.do" method="post" id="frm${dto.seq}">
			<input type="hidden" name="seq" value="${dto.seq}">
		</form>
		<button id="delete${dto.seq}" type="button">삭제</button>
		<script>
			$("#delete${dto.seq}").on("click",function(){
				$("#frm${dto.seq}").submit();
			});
		</script>
	</c:forEach>
</body>
</html>