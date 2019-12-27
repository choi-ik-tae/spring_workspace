<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="/js/script.js"></script>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div>
		<button id="work">work</button>
		<img src="/images/1.jpg" style="width:200px;">
		<img src="/images/images.jpg" style="width:200px;">
	</div>
	<script>
		$("#work").on("click",function(){
			location.href="work.do";
		});
	</script>
</body>
</html>