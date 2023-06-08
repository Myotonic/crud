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
<div class="container">
   <h3 class="panel-heading">JOIN</h3>
   <form action="${pageContext.request.contextPath}/join.admin" method="post" id="form_login" class="form-horizontal" >
   <fieldset>
   <legend class="text-center">관리자 회원가입</legend>
   
   
   
   
   <div class="row form-group">
   <div class="col-sm-4"></div>
   <div class="col-sm-4">
   <label for="name">관리자 이름</label>
   <input type="text" name="name" id="name" class="form-control" placeholder="관리자 이름"/>
   </div>
   <div class="col-sm-4"></div>
   </div>
   
  <!--  <div class="form-group">
   <div class="col-sm-6">
   <label for="admin_num">사원번호</label>
   <input type="text" name="admin_num" id="admin_num" class="form-control" placeholder="사원번호"/>
   </div>
   </div> -->
   
   
    
   
   <div class="row form-group">
   <div class="col-sm-4"></div>
   <div class="col-sm-4"> 
   <div>
   <label for="email">이메일</label>
   <input type="email" name="email" id="email" class="form-control" placeholder="이메일"/>
   </div>
   </div>
   <div class="col-sm-4">  
   </div>
   </div>
  
   
   
   
   <div class="row form-group">
   <div class="col-sm-4"></div>
   <div class="col-sm-4">
   <label for="pass">비밀번호</label>
   <input type="password" name="pass" id="pass" class="form-control" placeholder="비밀번호"/>
   </div>
   <div class="col-sm-4"></div>
   </div>
   
   
   <div class="row form-group">
   <div class="col-sm-4"></div>
   <div class="col-sm-4">
   <label for="re_pass">비밀번호 확인</label>
   <input type="password" name="re_pass" id="re_pass" class="form-control" placeholder="비밀번호 확인"/>
   </div>
   <div class="col-sm-4"></div>
   </div>
   
   <div class="row form-group">
   <div class="col-sm-4"></div>
   <div class="col-sm-4">
   <input type="button" id="submit" value="화원가입" title="화원가입 하기" class="btn form-control"/>
   </div>
   <div class="col-sm-4"></div>
   </div>
  
  
   <div class="row"> 
   <div class="col-sm-4"></div> 
   <div class="col-sm-4">
   <p><a href="home.admin" class="btn btn-info form-control">취소</a></p>
   </div>
   <div class="col-sm-4"></div>
   </div>
   
  
   </fieldset>
   </form>
 
 
 
<script>
 
 
			 $(function() {
				 
				 
				$("#email").on("blur", function() {
					$.ajax({
						
						url:"${pageContext.request.contextPath}/id.admin",
						type:"post",
						
						data: { "id": $("#email").val() },
						success: function(data) {
							 
					          if(data==1){

					        	 alert('사용가능한 이메일 입니다.');
					        	 
					        	  
					        	 /*  $(".check").attr("value" , "사용가능한 이메일 입니다."); */
					        	
					        	 
					        	 $("#submit").attr("type", "submit");
					        	 $("#submit").attr("class", "btn btn-danger form-control");
					        	 
					        	  
					        	  
					        	  
					          }
					          else{

					        	 
					        	  
					        	  /* $(".check").attr("value" , "이미 사용중인 이메일 입니다."); */
					        	  
					        	  $("#email").focus(); 
					        	  
					        	 
					        	  
					        	  $("#submit").attr("type", "button");
						          $("#submit").attr("class", "btn form-control");
						          
						          alert('이미 사용중인 이메일 입니다.');
					        	  
					          }
					        	   
					        	   
					          
					              
					            
						    },
						    error :function(xhr ,textStatus, errorThrown) {
								alert('textStatus + "(http-"+xhr.status+"/"+ errorThrown');
							}
						    
						    
					});
					 
				});
				 
				 
				 
				 $("#form_login").on("submit", function() {
					 
					 
					 
			
					 if($("#name").val()==""){
						 $("#name").focus();
						 
						 alert('이름이 빈칸입니다.');
						 
						 return false;
						 
					 }
					
					 
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

<%@include file="inc/footer.jsp" %>