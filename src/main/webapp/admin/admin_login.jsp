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
<c:if test="${sessionScope.email != null }"><script>location.href='result.admin';</script></c:if>



<div class="container">
   <h3 class="panel-heading">Login</h3>
   <form action="${pageContext.request.contextPath}/login.admin" method="post" id="form_login" class="form-horizontal">
   <fieldset>
   <legend class="text-center">관리자 로그인</legend>
   <div class="panel-body">
   
   
   <div class="row form-group">
   <label class="control-label col-sm-4" for="email">이메일 :</label>
   <div class="col-sm-4">
   <input type="email" name="email" id="email" class="form-control"/>
   </div>
   <div class="col-sm-4"></div>
   
    </div>
   <div class="row form-group">
   <label class="control-label col-sm-4" for="pass">비밀번호 :</label>
   <div class="col-sm-4">
   <input type="password" name="pass" id="pass" class="form-control"/>
   </div>
   <div class="col-sm-4"></div>
   </div>
   <div class="form-group">
   <div class="col-sm-4"></div> 
    <div class="col-sm-4">
   <input type="submit" value="로그인" title="로그인하기" class="btn btn-danger btn-block"/>
    </div>
    <div class="col-sm-4"></div> 
   </div>
   
   <div class="row form-group">
   <div class="col-sm-4"></div>  
    <div class="col-sm-4">
   <p><a href="${pageContext.request.contextPath}/join_form.admin" class="btn btn-info btn-block">회원가입</a></p>
   </div>
   <div class="col-sm-4"></div> 
   </div>
   <div class="row form-group">
   <div class="col-sm-4"></div> 
   <div class="col-sm-4">
   <p><a href="login_pass.jsp" class="btn btn-block">비밀번호 찾기</a>
   <a href="${pageContext.request.contextPath}/login_id_form.admin" class="btn btn-block">아이디 찾기</a></p>
   </div>
   <div class="col-sm-4"></div> 
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
		 if($("#pass").val()==""){
			 $("#pass").focus();
			 alert('비밀번호가 빈칸입니다.');
			 
			 return false;
			 
		 }
		 
		 
	});
	
});
 
 
 
 
 
 </script>
 
</div>
<!-- </body>
</html> -->

<%@include file="../inc/footer.jsp" %>