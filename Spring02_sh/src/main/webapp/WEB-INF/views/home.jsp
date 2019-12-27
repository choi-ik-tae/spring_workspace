<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>
	<button id="in_btn">To Input</button>
	<button id="out_btn">To Output</button>
	
	<script>
		$("#in_btn").on("click", function(){
			location.href="input.do";
		});
		
		$("#out_btn").on("click", function(){
			location.href="output.do";
		});
	</script>
</body>
</html>