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
        <form action="boardModifyProc.bo" method="post">
        <input type="hidden" name="seq" value="${dto.seq}">
        <table>
        	<tr>
        		<td colspan="4">수정하기</td>
        	</tr>
            <tr>
                <td colspan="1">제목</td>
                <td colspan="3"><input type="text" name="title" value="${dto.title}"></td>
            </tr>
            <tr>
            </tr>
            <tr>
                <td colspan="4">
                <textarea cols="80" rows="30" style="resize: none;" name="contents" id="contents">${dto.contents}</textarea>
                </td>
            </tr>
            <tr>
                <td colspan="4" style="text-align: right">
                    <button id="modify">수정하기</button>
                </td>
            </tr>
        </table>
        </form>
    </body>
</html>