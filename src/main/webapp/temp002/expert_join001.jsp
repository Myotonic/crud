<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../inc/header.jsp" %>
<div class="container panel panel-info">
	<h3 class="text-center">활동 분야 선택</h3>
	<form action="expert_joinC2.crud" method="post" class="form">
		<c:forEach var="dto" items="${dto }" varStatus="status">
			<input type="radio" name="category1" id=${dto.category1_id } value="${dto.category1_id }">
			<label for="category1">${dto.category1_name }</label>
		</c:forEach>
		<input type="submit" value="다음 카테고리"/>
	</form>
</div>
 <script>
	$(function(){
		$(".form").on("submit", function(){
			if($(":radio[name='category1']:checked").length == 0){
					alert("수신여부 선택해주세요");
					return false;
				}
		});
	});
</script> 
<%@ include file="../inc/footer.jsp" %>