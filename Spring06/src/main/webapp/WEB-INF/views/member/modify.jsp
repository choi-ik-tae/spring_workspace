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
	<h1>정보수정</h1>
	<form action="modifyProc.do" method="post">
		<label class="space">아이디 : </label>
		<input type="text" name="id" id="id" value="${dto.id}" readonly><br>
		<label class="space">패스워드 : </label>
		<input type="password" name="pw"><br>
		<label class="space">이름 : </label>
		<input type="text" name="name" value="${dto.name}"><br>
		<label class="space">연락처 : </label>
		<input type="text" name="phone" value="${dto.phone}"><br><br>
		<button id="btnModify">정보수정</button>
	</form>
</body>
</html>