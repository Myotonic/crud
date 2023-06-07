<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../inc/header.jsp" %>
<div class="container member-page">
	<h3>활동 분야 선택</h3>
	<hr />
	<form action="expert_joinC2.crud" method="post" class="form">
		<fieldset>
		<div class="row form-group">
				<div class="col-sm-3 glyphicon glyphicon-pencil"></div>
				<div class="col-sm-3 glyphicon glyphicon-home"></div>
				<div class="col-sm-3 glyphicon glyphicon-blackboard"></div>
				<div class="col-sm-3 glyphicon glyphicon-option-horizontal"></div>
		</div>
		<div class="row form-group">
			<c:forEach var="dto" items="${dto }" varStatus="status">
				<div class="col-sm-3">
					<input type="radio" name="category1" id=${dto.category1_id } value="${dto.category1_id }" >
					<label for="${dto.category1_id }">${dto.category1_name }</label>
				</div>
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
			if($(":radio[name='category1']:checked").length == 0){
					alert("선택해주세요");
					return false;
				}
		});
	});
</script> 
<%@ include file="../inc/footer.jsp" %>