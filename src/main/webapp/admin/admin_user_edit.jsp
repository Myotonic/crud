<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="inc/header.jsp" %>


<div class="container panel panel-info">
   <h3 class="panel-heading">유저 에디터</h3>
   
  <form method="post" action="${pageContext.request.contextPath}/useredit.admin?user_id=${list.user.user_id}" id="from">
   <fieldset>
   <legend>유저 에디터</legend>
   
   <div>
   <p>유저 이메일</p>
   <input type="text" name="user_email" id="user_email" value="${list.user.user_email}" class="form-control" readonly/>
   </div>
   <div>
   <p>유저 이름</p>
   <input type="text" name="user_name" id="user_name" value="${list.user.user_name}" class="form-control"/>
   </div>
   
   <div>
   <c:if test="${list.expert.expert_id != 0}">
   
   <div>
   <p>전문가 소개</p>
   <input type="text" name="expert_intro" id="expert_intro" value="${list.expert.expert_intro}" class="form-control"/>
   </div>
   
   <div>
   <p>전문가 활동 범위</p>
   <input type="text" name="expert_range" id="expert_range" value="${list.expert.expert_range}" class="form-control"/>
   </div>
   <div>
  <%--  <c:choose>
   <c:when test="${list.category.category1.category1_name == '레슨'}">
   <c:set var="i" value="selected"/>
   </c:when>
   <c:when test="${list.category.category1.category1_name == '홈/리빙'}">
   <c:set var="i" value="selected"/>
   </c:when>
   <c:when test="${list.category.category1.category1_name == '디자인/개발'}">
   <c:set var="i" value="selected"/>
   </c:when>
   <c:when test="${list.category.category1.category1_name == '기타'}">
   <c:set var="i" value="selected"/>
   </c:when>
   </c:choose> --%>
   <p>대분류 / 소분류</p>
  	<select id="category1_name" name="category1_name" class="form-control">
  		<option value=0>---</option>
  		<option value="레슨" ${i}>레슨</option>
  		  		<option value="홈/리빙" ${i}>홈/리빙</option>
  		  		  		<option value="디자인/개발" ${i}>디자인/개발</option>
  		  		  		  		<option value="기타" ${i}>기타</option>
  	</select>
  
  <%-- <c:choose>
  	<c:when test="${list.category.category2.category2_name == '댄스'}">
   <c:set var="i" value="selected"/>
   </c:when>
   <c:when test="${list.category.category2.category2_name == '피아노'}">
   <c:set var="i" value="selected"/>
   </c:when>
   </c:choose> --%>
  	
  	<select id="category2_name" name="category2_name" class="form-control result r1">
  		<option value=0>---</option>
  		<%-- <option value="댄스" ${i}>댄스</option>
  		<option value="피아노" ${i}>피아노</option> --%>
  	
  	</select>
   </div>
  	
   <div>
   <p>주소</p>
  	<input type="text" name="area_name" id="area_name" value="${list.city.area.area_name}" class="form-control" readonly/>
   	<input type="text" name="city_name" id="city_name" value="${list.city.city.city_name}" class="form-control" readonly/>
   </div>
   
   </c:if>
   </div>
   <%-- <div>
   <a href="${pageContext.request.contextPath}/useredit.admin" class="btn btn-info">edit</a>
   </div> --%>
   <div>
   <input type="submit" value="edit" title="go edit" class="btn btn-info">
   </div>
   </fieldset>
 </form>
 
</div>
<script>

$(function() {
	
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