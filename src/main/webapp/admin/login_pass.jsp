<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
Latest compiled and minified CSS
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

jQuery library
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

Latest compiled JavaScript
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body> -->

<%@include file="inc/header.jsp" %>
<div class="container panel panel-info">
   <h3 class="panel-heading">비밀번호 찾기</h3>
   <form action="#" method="post" id="form_login" class="form-horizontal" >
   <fieldset>
   <legend>FIND - PASSWORD</legend>
   
   <div class= "col-sm-offset-4">
   
   
   
   <div class="form-group">
   <div class="col-sm-6">
   <label for="email">이메일</label>
   <input type="email" name="email" id="email" class="form-control" placeholder="이메일"/>
   </div>
   </div>
   
   
   
   <div class="form-group">
   <div class="col-sm-6">
   <input type="submit" value="이메일 전송" title="이메일 전송 하기" class="btn btn-danger form-control"/>
   </div>
   </div>
  
  
   <div class="form-group">  
   <div class="col-sm-6">
   <p><a href="#" class="btn btn-info form-control">취소</a></p>
   </div>
   </div>
   
   </div>
   </fieldset>
   </form>
 
 
 
<script>
 
 
			 $(function() {
				 $("#form_login").on("submit", function() {
			
					 
					 
					 if($("#email").val()==""){
						 $("#email").focus();
						 
						 alert('이메일이 빈칸입니다.');
						 
						 return false;
						 
					 }
					 
					
					 
				});
				
			});
 
 
 
 
 
 </script>
 
 
</div>
<%@include file="inc/footer.jsp" %>
<!-- </body>
</html> -->