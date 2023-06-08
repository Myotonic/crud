<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file='../inc/header.jsp' %>
	<div class="container">
		<h3 class="">보낸 요청 목록</h3>
		<hr/>
		<div class="col">
		
		<c:forEach var="i" items="${requestList}" varStatus="status">
			<div class="col-sm-4 panel-body form-group" style="width:31%; padding:10px 10px; margin: 10px; color: inherit; background-color:#eee;">
			<h4>${i.category2_name}</h4>
				<p>${i.create_date}</p>
				<p class="text-center"><c:if test="${i.status == 1}">견적요청 중</c:if></p>
				<p class="text-center"><c:if test="${i.status != 1}">견적마감</c:if></p>
				<p>${i.count}개의 견적을 받았습니다</p>
				<a href='${pageContext.request.contextPath}/eslist.request?request_id=${i.request_id}'><button id="detailbtn" class="btn btn-info form-control" style="color:white;" >상세보기</button></a>
				</div>
		</c:forEach>
		
		</div>
	</div>
	
<%@ include file='../inc/footer.jsp' %>