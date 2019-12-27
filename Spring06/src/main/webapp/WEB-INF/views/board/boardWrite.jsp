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
        <form action="boardWriteProc.bo" enctype="multipart/form-data" method="post">
        <table>
        	<tr>
        		<td colspan="4">글쓰기</td>
        	</tr>
            <tr>
                <td colspan="1">제목</td>
                <td colspan="3"><input type="text" name="title"></td>
            </tr>
            <tr>
                <td colspan="4">
                <textarea cols="80" rows="30" style="resize: none;" name="contents" id="contents"></textarea>
                </td>
            </tr>
            <tr>
            	<td colspan="4"><input type="file" name="file" multiple="multiple"></td>
            </tr>
            <tr>
                <td colspan="4" style="text-align: right">
                    <button id="toWrite">글쓰기</button>
                    <button id="toHome" type="button">돌아가기</button>
                </td>
            </tr>
        </table>
        </form>
        <script>
            $("#toHome").on("click",function(){
                location.href = "${pageContext.request.contextPath}/home";
            });
        </script>
    </body>
</html>