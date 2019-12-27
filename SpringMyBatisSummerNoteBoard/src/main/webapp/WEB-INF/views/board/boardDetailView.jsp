<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
* {box-sizing: border-box;}
td {border: 1px solid black;}
table {
   width: 500px;
   margin: auto;
}
</style>
</head>
<body>
   <table>
      <tr>
         <td colspan="4" style="text-align: center;">${dto.seq}</td>
      </tr>
      <tr>
         <td colspan="1">제목</td>
         <td colspan="3">${dto.title}</td>

      </tr>
      <tr>
         <td>작성자</td>
         <td>${dto.id}</td>
         <td>작성날짜</td>
         <td>${dto.write_date}</td>
      </tr>
      <tr>
         <td colspan="4"><textarea cols="80" rows="30"
               style="resize: none;" name="contents" id="contents" disabled>${dto.contents}</textarea>
         </td>
      </tr>
      <c:choose>
      	<c:when test="${flist.size() == 0}">
      		<tr>
      			<td colspan="4">등록한 파일이 없어!
      		</tr>
      	</c:when>
      	<c:otherwise>
      		<tr>
      		<td colspan="4">
	      		<c:forEach items="${flist}" var="fdto">
	      			<a href="${pageConetxt.request.contextPath}/board/boardFileDownload.bo?target=${fdto.sys_name}">${fdto.ori_name}</a>
	      		</c:forEach>
	      	</td>
      		</tr>
      	</c:otherwise>
      </c:choose>
      <tr>
         <td colspan="4">
            <div
               style="float: left; width: 80%; height: 50px; display: inline-block;">
               <textarea style="width: 100%; height: 100%; resize: none;"></textarea>
            </div>
            <div style="float: left; width: 20%; height: 50px;">
               <button style="width: 100%; height: 100%;">작성</button>
            </div>
         </td>
      </tr>
      <tr>
         <td colspan="4" style="text-align: right">
         	<button id="back">돌아가기</button>
         	<c:if test="${id == dto.id}">
         		<button id="modify" type="button">수정</button>
         		<button id="delete" type="button">삭제</button>
         	</c:if>
         </td>
      </tr>
   </table>
   <script>
		$("#back").on("click",function(){
         location.href="${pageContext.request.contextPath}/board/board.bo"
      	});
      	$("#delete").on("click",function(){
			location.href="${pageContext.request.contextPath}/board/boardDelete.bo?seq=${dto.seq}"
		});
		$("#modify").on("click",function(){
			location.href="${pageContext.request.contextPath}/board/boardModify.bo?seq=${dto.seq}"
		});
   </script>
</body>
</html>