<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../inc/header.jsp" %>


<div class="container panel panel-info">
   <h3 class="panel-heading">마켓 디테일</h3>
   
  <form method="post" action="${pageContext.request.contextPath}/marketdelete.admin?market_id=${list.market.market_id}" id="form">
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
   <input type="text" name="title" id="title" value="${list.market.title}" class="form-control" readonly/>
   </div>
   
   <div>
   <p>내용</p>
  	<textarea name="content" id="content" class="form-control" readonly>${list.market.content}</textarea>
   </div>
   
   
   
    
   <div>
   <p>생성일</p>
   <input type="text" name="date" id="date" value="${list.market.date}" class="form-control" readonly/>
   </div>
   
    <div>
   <p>가격</p>
   <input type="text" name="price" id="price" value="${list.market.price}" class="form-control" readonly/>
   </div>
   
    <div>
   <p>환불</p>
   <input type="text" name="refund" id="refund" value="${list.market.refund}" class="form-control" readonly/>
   </div>
   
   
    <div>
   <p>구분</p>
   <input type="text" name="division" id="division" value="${list.market.division}" class="form-control" readonly/>
   </div>
   
   
   
   <div>
   <p>대분류 / 소분류</p>
   <input type="text" name="category1_name" id="category1_name" value="${list.category.category1.category1_name}" class="form-control" readonly/>
   <input type="text" name="category2_name" id="category2_name" value="${list.category.category2.category2_name}" class="form-control" readonly/>
   </div>
   
   
   
   <div>
   <a href="${pageContext.request.contextPath}/marketedit_form.admin?market_id=${list.market.market_id}" class="btn btn-info">edit</a>
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


<%@include file="../inc/footer.jsp" %>