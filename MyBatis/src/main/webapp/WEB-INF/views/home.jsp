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
	<form action="write.do" method="post">
		<div id="box">
			작성자 : <input type="text" name="name"><br>
			내용 : <input type="text" name="msg"><br>
			<button type="submit">제출</button>
			<button type="button" id="btnSelect">출력</button>
			<a href="${pageContext.request.contextPath}/selectDyn1">SelectDyn1</a>
		</div>
	</form>
	<script>
		$("#btnSelect").on("click",function(){
			location.href = "${pageContext.request.contextPath}/output.do";
		});
	</script>
</body>
</html>