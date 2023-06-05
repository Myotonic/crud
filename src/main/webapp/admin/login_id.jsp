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
   <h3 class="panel-heading">아이디 찾기</h3>
   <form action="${pageContext.request.contextPath}/login_id.admin" method="post" id="form_login" class="form-horizontal" >
   <fieldset>
   <legend>FIND - ID</legend>
   
   
   
   <div class="form-group">
   <div class="col-sm-3"></div>
   <div class="col-sm-6">
   <label for="name">관리자 이름</label>
   <input type="text" name="name" id="name" class="form-control" placeholder="관리자 이름"/>
   </div>
   <div class="col-sm-3"></div>
   </div>
   
   <div class="form-group">
   <div class="col-sm-3"></div>
   <div class="col-sm-6">
   <label for="admin_num">사원번호</label>
   <input type="text" name="admin_num" id="admin_num" class="form-control" placeholder="사원번호"/>
   </div>
   <div class="col-sm-3"></div>
   </div>
   
   
   
   <div class="form-group">
   <div class="col-sm-3"></div>
   <div class="col-sm-6">
   <input type="submit" value="아이디찾기" title="아이디찾기 하기" class="btn btn-danger form-control"/>
   </div>
   <div class="col-sm-3"></div>
   </div>
  
  
   <div class="form-group">
   <div class="col-sm-3"></div>  
   <div class="col-sm-6">
   <p><a href="#" class="btn btn-info form-control">취소</a></p>
   </div>
   <div class="col-sm-3"></div>
   </div>
   
   
   
   </fieldset>
   </form>
 
 
 
<script>
 
 
			 $(function() {
				 $("#form_login").on("submit", function() {
			
					 if($("#name").val()==""){
						 $("#name").focus();
						 
						 alert('이름이 빈칸입니다.');
						 
						 return false;
						 
					 }
					 if($("#admin_num").val()==""){
						 $("#admin_num").focus();
						 
						 alert('사원번호가 빈칸입니다.');
						 
						 return false;
						 
					 }
					 
					
					 
				});
				
			});
 
 
 
 
 
 </script>
 
 
</div>
<!-- </body>
</html> -->


<%@include file="inc/footer.jsp" %>