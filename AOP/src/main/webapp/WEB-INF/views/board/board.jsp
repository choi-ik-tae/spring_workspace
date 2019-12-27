<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<link href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">
<style>
	#btnBox{}
</style>
</head>
<body>
<table id="example" class="display" style="width:100%;">
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>조회수</th>
                <th>작성날짜</th>
            </tr>
        </thead>
        <tbody>
        <c:choose>
			<c:when test="${list.size() == 0}">
				<tr>
					<td colspan="5">작성된 글이 없습니다.
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.seq}
						<td><a href="${pageContext.request.contextPath}/board/boardDetail.bo?seq=${dto.seq}">${dto.title}</a>
						<td>${dto.id}
						<td>${dto.hit}
						<td>${dto.write_date}
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
        </tbody>
    </table>
    <div id="btnBox">
    	<button id="toWrite" type="button">글쓰기</button>
    	<button id="toHome" type="button">돌아가기</button>
    </div>
    <script>
	    $(document).ready(function() {
	        $('#example').DataTable();
	    } );
	    $("#toWrite").on("click",function(){
			location.href = "${pageContext.request.contextPath}/board/boardWrite.bo";
		});
		$("#toHome").on("click",function(){
			location.href = "${pageContext.request.contextPath}/home";
		});
    </script>
</body>
</html>