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
	<c:choose>
		<c:when test="${loginInfo == null}">
			<form action = "${pageContext.request.contextPath}/member/login.do" id="frm" method="post">
				<div id="loginBox">
					<label class="space">아이디 : </label>
					<input type="text" name="id"><br>
					<label class="space">비밀번호 : </label>
					<input type="password" name="pw"><br>
				</div>
				<div id="btnBox">
					<button id="loginBtn">로그인</button>
					<button id="signupBtn">회원가입</button>
				</div>
			</form>
			<script>
				$("#signupBtn").on("click",function(){
					$("#frm").attr("action","${pageContext.request.contextPath}/member/signup.do");
				});
			</script>
		</c:when>
		<c:otherwise>
			<div id="infoBox">
				${loginInfo}님 안녕하세요.
			</div>
			<div id="btns">
				<button id="memberlist" type="button">회원목록</button>
				<button id="mypage" type="button">마이페이지</button>
				<button id="board" type="button">게시판</button>
				<button id="logout" tpye="button">로그아웃</button>
				<button id="modify" type="button">정보수정</button>
				<button id="memberout" tpye="button">회원탈퇴</button>
			</div>
			<script>
				$("#memberlist").on("click",function(){
					location.href="${pageContext.request.contextPath}/member/memberlist.do"
				});
				$("#mypage").on("click",function(){
					location.href="${pageContext.request.contextPath}/member/mypage.do"
				});
				$("#board").on("click",function(){
					location.href="${pageContext.request.contextPath}/board/board.bo"
				});
				$("#logout").on("click",function(){
					location.href="${pageContext.request.contextPath}/member/logout.do"
				});
				$("#modify").on("click",function(){
					location.href="${pageContext.request.contextPath}/member/modify.do"
				});
				$("#memberout").on("click",function(){
					location.href="${pageContext.request.contextPath}/member/memberout.do"
				});
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>