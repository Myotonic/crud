<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="inc/header.jsp" %>

 

<div class="container panel panel-info">
   <h3 class="panel-heading">마켓 디테일</h3>
   
  <form method="post" action="${pageContext.request.contextPath}/marketedit.admin?market_id=${list.market.market_id}" id="form">
   <fieldset>
   <legend>마켓 디테일</legend>
   
   <div>
   <p>유저 이메일</p>
   <input type="text" name="user_email" id="user_email" value="${list.user.user_email}" class="form-control" readonly/>
   </div>
   <div>
   <p>유저 이름</p>
   <input type="text" name="user_name" id="user_name" value="${list.user.user_name}" class="form-control" readonly/>
   </div>
  
  
   <div>
   <p>제목</p>
   <input type="text" name="title" id="title" value="${list.market.title}" class="form-control"/>
   </div>
   
   <div>
   <p>내용</p>
  	<textarea name="content" id="content" class="form-control" >${list.market.content}</textarea>
   </div>
   
   
   
    
   <div>
   <p>생성일</p>
  	<input type="text" id="picker" name="date">
   </div>
   
    <div>
   <p>가격</p>
   <input type="text" name="price" id="price" value="${list.market.price}" class="form-control">
   </div>
   
    <div>
   <p>환불</p>
   <input type="text" name="refund" id="refund" value="${list.market.refund}" class="form-control"/>
   </div>
   
   
    <div>
   <p>구분</p>
   <input type="text" name="division" id="division" value="${list.market.division}" class="form-control"/>
   </div>
   
   
   
   <div>
   <p>대분류 / 소분류</p>
  	<select id="category1_name" name="category1_name" class="form-control">
  		<option value=0>---</option>
  		<option value="레슨" >레슨</option>
  		  		<option value="홈/리빙" >홈/리빙</option>
  		  		  		<option value="디자인/개발" }>디자인/개발</option>
  		  		  		  		<option value="기타" >기타</option>
  	</select>
  	
  	<select id="category2_name" name="category2_name" class="form-control result r1">
  		<option value=0>---</option>
  		<%-- <option value="댄스" ${i}>댄스</option>
  		<option value="피아노" ${i}>피아노</option> --%>
  	
  	</select>
  	
   </div>
   
   
   
  <%--  <div>
   <a href="${pageContext.request.contextPath}/marketedit_form.admin?market_id=${list.market.market_id}" class="btn btn-info">edit</a>
   </div> --%>
   <div>
   <input type="submit" value="edit" title="go edit" class="btn btn-info">
   </div>
   </fieldset>
 </form>
 
</div>

<script>

$(function() {
	
	$("#picker").datetimepicker({
        format: 'Y-m-d H:i:s'
    });
		
	
	
	
	$("#category1_name").on("change" , function() {
		
		$.ajax({
				
				url:"${pageContext.request.contextPath}/category.admin",
				type:"get",
				data:{"category1_name" : $("#category1_name").val()},
				dataType:"json",
				
				
				success: function(json) {
					
					/* console.log(json); */
					
					$(".r1").empty();
					
					for(i in json){
						
						
						var name = json[i].category2_name;
						
						
						console.log(name);
						
						var option = $("<option>").html(name);
						
						$(".r1").append(option);
						
						
					}
					
					
					
				},
			
				error :function(xhr ,textStatus, errorThrown) {
					console.log(textStatus + "(http-"+xhr.status+"/"+ errorThrown);
				}
			
		});
		
	});
	
	
});


 



</script>


<%@include file="inc/footer.jsp" %>