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
			<form action="member/login.do" method="post" id="frm">
				<label class="space">아이디 : </label>
				<input type="text" name="id" id="id"><br>
				<label class="space">비밀번호 : </label>
				<input type="password" name="pw" id="pw"><br>
				<button id="btnLogin">로그인</button>
				<button id="btnJoin">회원가입</button>
			</form>
			<script>
				$("#btnJoin").on("click",function(){
					$("#frm").attr("action","member/signup.do");
				});
			</script>
		</c:when>
		<c:otherwise>
			${loginInfo} 님 환영합니다!<br>
			<button id="memberList" type="button">회원목록</button>
			<button id="myPage" type="button">마이페이지</button>
			<button id="board" type="button">게시판</button>
			<button id="modify" type="button">정보수정</button>
			<button id="logout" type="button">로그아웃</button>
			<button id="memberOut" type="button">회원탈퇴</button>
			<button id="test" type="button">테스트</button>
			<script>
				$("#memberList").on("click",function(){
					location.href = "${pageContext.request.contextPath}/member/memberList.do";
				});
				$("#myPage").on("click",function(){
					location.href = "${pageContext.request.contextPath}/member/myPage.do";
				});
				$("#logout").on("click",function(){
					location.href = "${pageContext.request.contextPath}/member/logout.do";
				});
				$("#memberOut").on("click",function(){
					location.href = "${pageContext.request.contextPath}/member/memberOut.do";
				});
				$("#modify").on("click",function(){
					location.href = "${pageContext.request.contextPath}/member/modify.do";
				});
				$("#board").on("click",function(){
					location.href = "${pageContext.request.contextPath}/board/board.bo";
				});
				$("#test").on("click",function(){
					location.href = "${pageContext.request.contextPath}/index.jsp";
				});
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>