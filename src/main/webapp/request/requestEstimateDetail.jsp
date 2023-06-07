<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file='../inc/header.jsp' %>

	<div class="container">
		<h3 class="">견적서 상세</h3>
		<div class="form-group jumbotron"  >
		<h4>${estimateDetailDto.user_name}</h4>
		<p>${estimateDetailDto.review}	${estimateDetailDto.city_name}	${estimateDetailDto.career_entry}</p>
		<br>
		<h4>견적 내용</h4>
		<p>${estimateDetailDto.content}</p>
		<h4>예상금액</h4>
		<p>${estimateDetailDto.price}</p>
		<a href=""><button class="btn btn-info">프로필보기</button></a>
		<a href=""><button class="btn btn-info">채팅하기</button></a>
		</div>
		
	</div>
<%@ include file='../inc/footer.jsp' %>