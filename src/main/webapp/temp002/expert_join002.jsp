<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../inc/header.jsp" %>
<div class="container panel panel-info">
	<h3 class="text-center">활동 분야 선택</h3>
	<form action="expert_joinC.crud" method="post" class="form">
		<c:forEach var="dto" items="${c2 }" varStatus="status">
			<input type="radio" name="category2" id=${dto.category2_id } value="${dto.category2_id }">
			<label for="category2">${dto.category2_name }</label>
		</c:forEach>
		<input type="submit" value="지역 선택"/>
	</form>
</div>
 <script>
	$(function(){
		$(".form").on("submit", function(){
			if($(":radio[name='category2']:checked").length == 0){
				alert("수신여부 선택해주세요");
				return false;
			}
		});
	});
</script> 

<%@ include file="../inc/footer.jsp" %>