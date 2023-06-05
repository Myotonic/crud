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


<%@include file="../inc/header.jsp" %>
<div class="container panel panel-info">
   <h3 class="panel-heading">새 비밀번호 입력</h3>
   <form action="#" method="post" id="form_login" class="form-horizontal" >
   <fieldset>
   <legend>NEW - PASSWORD</legend>
   
   <div class= "col-sm-offset-4">
   
   <div class="form-group">
   <div class="col-sm-6">
   <label for="name">새 비밀번호</label>
   <input type="password" name="pass" id="pass" class="form-control" placeholder="새 비밀번호"/>
   </div>
   </div>
   
   <div class="form-group">
   <div class="col-sm-6">
   <label for="admin_num">새 비밀번호 확인</label>
   <input type="password" name="re_pass" id="re_pass" class="form-control" placeholder="새 비밀번호 확인"/>
   </div>
   </div>
   
   
   
   <div class="form-group">
   <div class="col-sm-6">
   <input type="submit" value="비밀번호 바꾸기" title="비밀번호 바꾸기 하기" class="btn btn-danger form-control"/>
   </div>
   </div>
  
  
  <!--  <div class="form-group">  
   <div class="col-sm-6">
   <p><a href="#" class="btn btn-info form-control">취소</a></p>
   </div>
   </div> -->
   
   </div>
   </fieldset>
   </form>
 
 
 
<script>
 
 
			 $(function() {
				 $("#form_login").on("submit", function() {
			
					 if($("#pass").val()==""){
						 $("#pass").focus();
						 
						 alert('비밀번호가 빈칸입니다.');
						 
						 return false;
						 
					 }
					 
					 if($("#re_pass").val()!=$("#pass").val()){
						 $("#re_pass").focus();
						 
						 alert('비밀번호가 다릅니다.');
						 return false;
						 
					 }
					 
					
					 
				});
				
			});
 
 
 
 
 
 </script>
 
 
</div>
<!-- </body>
</html> -->


<%@include file="../inc/footer.jsp" %>