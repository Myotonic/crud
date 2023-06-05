<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file='../inc/header.jsp' %>
	<div class="container panel panel-success">
		<h3 class="panel-heading">요청서 상세</h3>
		<div class="form-group">
			<h4>${requestDetailDto.user_name}</h4>
			<h4>${requestDetailDto.city_name}</h4>
			<h4>${requestDetailDto.work_date}</h4>
			<h4>요청서 상세사항</h4>
			<p>${requestDetailDto.content}</p>
			<a href="estimate/estimateCreate.jsp?request_id=${requestDetailDto.request_id}"><button class="btn btn-info">요청승인</button></a>
		</div>
	</div>
<%@ include file='../inc/footer.jsp' %>