<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="inc/header.jsp" %>


<div class="container panel panel-info">
   <h3 class="panel-heading">유저 디테일</h3>
   
  <form method="post" action="${pageContext.request.contextPath}/useredelete.admin?user_id=${list.user.user_id}" id="form">
   <fieldset>
   <legend>유저 디테일</legend>
   
   <div>
   <p>유저 이메일</p>
   <input type="text" name="user_email" id="user_email" value="${list.user.user_email}" class="form-control" readonly/>
   </div>
   <div>
   <p>유저 이름</p>
   <input type="text" name="user_name" id="user_name" value="${list.user.user_name}" class="form-control" readonly/>
   </div>
   <div>
   <c:if test="${list.expert.expert_id != 0}">
   
   <div>
   <p>전문가 소개</p>
   <input type="text" name="expert_intro" id="expert_intro" value="${list.expert.expert_intro}" class="form-control" readonly/>
   </div>
   
   <div>
   <p>전문가 활동 범위</p>
   <input type="text" name="expert_range" id="expert_range" value="${list.expert.expert_range}" class="form-control" readonly/>
   </div>
   <div>
   <p>대분류 / 소분류</p>
   <input type="text" name="category1_name" id="category1_name" value="${list.category.category1.category1_name}" class="form-control" readonly/>
   <input type="text" name="category2_name" id="category2_name" value="${list.category.category2.category2_name}" class="form-control" readonly/>
   </div>
   
   <div>
   <p>도시 / 구</p>
   <input type="text" name="area_name" id="area_name" value="${list.city.area.area_name}" class="form-control" readonly/>
   <input type="text" name="city_name" id="city_name" value="${list.city.city.city_name}" class="form-control" readonly/>
   </div>
   
   </div>
   
   </c:if>
   <div>
   <a href="${pageContext.request.contextPath}/useredit_form.admin?user_id=${list.user.user_id}" class="btn btn-info">edit</a>
   </div>
   <div>
   <input type="submit" value="delete" title="go delete" class="btn btn-danger">
   </div>
   </fieldset>
 </form>
 
</div>
<script>
$(function() {
	$("#form").on("submit", function() {
	
		var result = confirm("정말로 삭제하시겠습니까?");
		if (result) {
		  alert('삭제되었습니다.');
		} else {
		  alert("삭제가 취소되었습니다.");
		  return false;
		}
		
	});
	
});



</script>


<%@include file="inc/footer.jsp" %>