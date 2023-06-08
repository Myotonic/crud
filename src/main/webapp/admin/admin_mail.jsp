<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="inc/header.jsp" %>

<div class="container panel panel-info">
   <h3 class="panel-heading">NEW_PASS</h3>

<form  action="${pageContext.request.contextPath}/mail.admin" method="post" id="form" class="form-horizontal">
 <fieldset>
 <legend>NEW_PASS</legend>
 <div class="form-group">
 <label for="email">email</label>
 <input type="text" name="admin_email" id="email" class="form-control" />
 </div>
 
 
 
 
 
 
 <div>
   <input type="button" id="submit" value="메일 발송" title="메일 발송 하기" class="btn form-control"/>
 </div>
 
 </fieldset>
 </form>
</div>


<script>

$(function() {
	
	$("#email").on("blur", function() {
		$.ajax({
			
			url:"${pageContext.request.contextPath}/mailcheck.admin",
			type:"post",
			
			data: { "id": $("#email").val() },
			success: function(data) {
				 
		          if(data==1){

		        	alert('존재하지 않는 이메일 입니다.');
		        	 
		        	  
		        	 /*  $(".check").attr("value" , "사용가능한 이메일 입니다."); */
		        	
		        	 
		        	  $("#submit").attr("type", "button");
			          $("#submit").attr("class", "btn form-control");
		        	 
			          $("#email").focus(); 
			          
		        	  
		        	  
		          }
		          else{

		        	 
		        	  
		        	  /* $(".check").attr("value" , "이미 사용중인 이메일 입니다."); */
		        	  
		        	 
		        	  
		        	 
		        	  $("#submit").attr("type", "submit");
			          $("#submit").attr("class", "btn btn-danger form-control");
		        	  
		        	  
		        	  
		        	
			          
			         /*  alert('이미 사용중인 이메일 입니다.'); */
		        	  
		          }
		        	   
		        	   
		          
		              
		            
			    },
			    error :function(xhr ,textStatus, errorThrown) {
					alert('textStatus + "(http-"+xhr.status+"/"+ errorThrown');
				}
			    
			    
		});
		 
	});
	 
	
	
});


</script>



<%@include file="inc/footer.jsp" %>

