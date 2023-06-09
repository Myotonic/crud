<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file='../inc/header.jsp' %>
	<div class="container">
		<h3 class="text-center">요청서 상세</h3>
		<div class="form-group col-md-3" style=" padding:10px 10px; float:none; margin:0 auto; color: inherit; background-color:#eee;">
			<h4>${requestDetailDto.user_name}</h4> 
			<h4>${requestDetailDto.city_name}</h4>
			<h4>${requestDetailDto.work_date}</h4>
			<h4>요청서 상세사항</h4>
			<p>${requestDetailDto.content}</p>
			<p class="text-center"><a href="estimate/estimateCreate.jsp?request_id=${requestDetailDto.request_id}" id="gogo"><button class="btn btn-info text-center" style="color:white;">요청승인</button></a>
			<c:if test="${status == 1}">
				<script>
				 $("#gogo").on("click", function() {
					 alert('이미 수락된 요청입니다.');
					 return false;
				 })
				</script>
			</c:if>
			</p>
		</div>
	</div>
<%@ include file='../inc/footer.jsp' %>