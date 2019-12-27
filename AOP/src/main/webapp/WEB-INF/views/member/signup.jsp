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
	<h1>회원가입</h1>
	<form action="signupProc.do" method="post">
		<label class="space">아이디 : </label>
		<input type="text" name="id" id="id">
		<button id="overlap" type="button">중복체크</button><br>
		<label class="space">패스워드 : </label>
		<input type="password" name="pw"><br>
		<label class="space">이름 : </label>
		<input type="text" name="name"><br>
		<label class="space">연락처 : </label>
		<input type="text" name="phone"><br><br>
		<button id="btnSignUp">회원가입</button>
	</form>
	<script>
		$("#overlap").on("click",function(){
			$.ajax({
				url:"overlap.do",
				type:"post",
				data:{
					id:$("#id").val()
				}
			}).done(function(e){
				if(e == "1") {
					alert("중복된 아이디 입니다.");
				} else {
					alert("사용가능한 아이디 입니다.");
				}
			})
		});
	</script>
</body>
</html>