<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file='../inc/header.jsp' %>
	<div class="container">
		<h3 class="">받은 요청</h3>
		<hr/>
		<div class="col">
		
		<c:forEach var="i" items="${estimateList}" varStatus="status">
			<div class="col-sm-4 panel-body form-group" style="width:31%; padding:10px 10px; margin: 10px; color: inherit; background-color:#eee;">
			<h4>${i.category2_name}</h4>
				<p class="text-right"><c:if test="${i.mystatus == 1}">요청 수락됨</c:if></p>
				<p class="text-right"><c:if test="${i.mystatus != 1}">대기 중</c:if></p>
				<p>${i.create_date}</p>
				<p>${i.user_name}</p>
				<p>${i.content}</p>
				<a href='${pageContext.request.contextPath}/detail.estimate?request_id=${i.request_id}'><button id="detailbtn" class="btn btn-info form-control" >상세보기</button></a>
				</div>
		</c:forEach>
		
		</div>
	</div>
	
<%@ include file='../inc/footer.jsp' %>