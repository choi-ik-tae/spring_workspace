<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.css" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.js"></script>
    <script>
	    $(function(){
			$("#writeForm").on("submit",function(){
				var contents = $(".note-editable").html();
				$("#contents").val(contents);
			});
		});
    </script>
</head>
<body>
	<form action="writeProc2.do" method="post" enctype="multipart/form-data" id="writeForm">
		제목 : <input type="text" name="title">
		파일 : <input type="file" name="files" multiple="multiple">
		<button type="submit">제출</button>
		<textarea style="display:none;" name="contents" id="contents"></textarea>
	</form>
	<div id="summernote"></div>
	<script>
		$("#summernote").summernote()
	</script>
</body>
</html>