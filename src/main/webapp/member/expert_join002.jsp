<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../inc/header.jsp" %>
<div class="container member-page">
	<h3>서비스 선택</h3>
	<hr />
	<form action="expert_joinC.crud" method="post" class="form">
		<fieldset>
			<div class="row form-group">
			<c:forEach var="dto" items="${c2 }" varStatus="status">
<%-- 				 <div class="col-sm-${12/status.count}"> --%>
					<input type="radio" name="category2" id=${dto.category2_id } value="${dto.category2_id }">
					<label for="category2">${dto.category2_name }</label>
<!-- 				</div> -->
			</c:forEach>
			</div>
			<div class="form-group member_extra">
				<input type="submit" value="다음" class="member_submit form-control" />
			</div>
		</fieldset>
	</form>
</div>
 <script>
	$(function(){
		$(".form").on("submit", function(){
			if($(":radio[name='category2']:checked").length == 0){
				alert("선택해주세요");
				return false;
			}
		});
	});
</script> 

<%@ include file="../inc/footer.jsp" %>