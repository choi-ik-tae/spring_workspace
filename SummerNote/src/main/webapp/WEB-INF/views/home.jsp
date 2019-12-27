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
    	<!-- onload -->
    	$(function(){
    		$("#writeForm").on("submit",function(){
    			var contents = $(".note-editable").html();
    			$("#contents").val(contents);
    		});
    	});
    	window.onbeforeunload = function(){
    		$.ajax({
    			url:"unloadAlarm.do"
    		});
    	}
    </script>
</head>
<body>
	<form action="writeProc.do" method="post" enctype="multipart/form-data" id="writeForm">
		<input type="text" name="title">
		<input type="file" name="files" multiple="multiple">
		<button type="submit">제출</button>
		<textarea style="display:none;" name="contents" id="contents"></textarea>
	</form>
    <div id="summernote"></div>	
    <script>
      $('#summernote').summernote({
        placeholder: 'Hello bootstrap 4',
        tabsize: 2,
        height: 300,
        width: 800,
        callbacks: {
            onImageUpload: function(files) {
            	// form 태그 만들고 input file 한 다음에 img파일 선택하는 것
            	var data = new FormData();
            	data.append("img",files[0]);
            	
            	$.ajax({
            		url:"ajaxImage.do",
            		data:data,
            		type:"post",
            		enctype:"multipart/form-data",
            		contentType:false,
                    processData:false,
                    cache:false
            	}).done(function(resp){
            		var img = $("<img>")
            		img.attr("src",resp);
            		$(".note-editable").append(img);
            		
            		$("#summernote").summernote("insertNode",img[0]);
            		
            		
            	}).fail(function(a,b,c){
            		console.log(a);
            		console.log(b);
            		console.log(c);
            	});
       		}
        }
      });
    </script>
</body>
</html>