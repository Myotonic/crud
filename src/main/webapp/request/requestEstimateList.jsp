<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file='../inc/header.jsp' %>
	<div class="container panel panel-success">
		<h3 class="panel-heading">견적서 목록보기                  <a href="${pageContext.request.contextPath}/cancle.request?request_id=${request_id}" class="text-right"><button class="btn btn-default  text-right">요청 취소</button></a></h3>
		<div class="col">
		
		<c:forEach var="i" items="${estimatedList}" varStatus="status">
			<div class="col-sm-4 panel-body form-group">
			<h4>${i.user_name}</h4>
				<p>${i.review}</p>
				<p>${i.price}</p>
				<div class="col">
				<a href='${pageContext.request.contextPath}/esdetail.request?estimate_id=${i.estimate_id}'><button id="detailbtn" class="btn btn-info form-control col-sm-6" >상세보기</button></a>
				<a href='${pageContext.request.contextPath}/esdetail.request?estimate_id=${i.estimate_id}'><button id="detailbtn" class="btn btn-info form-control col-sm-6" >채팅하기</button></a>
				</div>
				</div>
		</c:forEach>
		</div>
	</div>
	
<%@ include file='../inc/footer.jsp' %>