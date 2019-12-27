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
</head>
<body>
	<table id="example" class="display" style="width:100%">
		<thead>
			<th>번호
			<th>제목
			<th>아이디
			<th>조회수
			<th>작성날짜
		</thead>
		<tbody>
		<c:choose>
			<c:when test="${list.size() == 0}">
				<tr>
					<td>작성된 글이 없습니다.
					<td><button id="toWrite" type="button">글쓰러가기</button>
					<td><button id="toHome" type="button">돌아가기</button>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.seq}
						<td>${dto.title}
						<td>${dto.id}
						<td>${dto.hit}
						<td>${dto.write_date}
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
			<tr>
				<td><button id="toWrite" type="button">글쓰기</button>
				<td><button id="toHome" type="button">돌아가기</button>
			</tr>
		</tbody>
	</table>
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