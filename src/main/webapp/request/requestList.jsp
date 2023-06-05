<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file='../inc/header.jsp' %>
	<div class="container panel panel-success">
		<h3 class="panel-heading">보낸 요청 목록</h3>
		<div class="col">
		
		<!-- 이걸 append 하면 됨. -->
		
		<c:forEach var="i" items="${requestList}" varStatus="status">
			<div class="col-sm-4 panel-body form-group">
			<h4>${i.category2_name}</h4>
				<p>${i.create_date}</p>
				<p class="text-center"><c:if test="${i.status == 1}">견적요청 중</c:if></p>
				<p class="text-center"><c:if test="${i.status != 1}">견적마감</c:if></p>
				<p>${i.count}개의 견적을 받았습니다</p>
				<a href='${pageContext.request.contextPath}/eslist.request?request_id=${i.request_id}'><button id="detailbtn" class="btn btn-info form-control" >상세보기</button></a>
				</div>
		</c:forEach>

<hr/>
<%-- ${requestList} --%>
<hr/>
<%-- ${requestList.RequestListDto} --%>
<hr/>
<%-- ${requestList.RequestListDto.catogory2_name} --%>
<hr/>
		
<!-- 			<div class="col-sm-4"> -->
<!-- 				<h4>카테고리 이름</h4> -->
<!-- 				<p>견적작성일</p> -->
<!-- 				<p>견적상태</p> -->
<!-- 				<p>~개의 견적</p> -->
<!-- 			</div> -->
		<!-- 이걸 append 하면 됨. -->
		
		
		</div>
	</div>
	
<%@ include file='../inc/footer.jsp' %>