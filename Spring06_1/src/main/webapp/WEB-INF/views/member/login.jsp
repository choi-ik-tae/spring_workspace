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
        .space{
            width: 100px;
            display: inline-block;
        }
    </style>
</head>
<body>
	<form action="loginProc.do" method="post" id="frm">
		<label class="space">아이디 : </label>
		<input type="text" name="id"><br>
		<label class="space">비밀번호 : </label>
		<input tpye="password" name="pw"><br><br>
		<button id="btnLogin">로그인</button>
		<button id="btnSignup" type="button">회원가입</button>
	</form>
	<script>
		$("#btnSignup").on("click",function(){
			location.href="signup";
		});
	</script>
</body>
</html>