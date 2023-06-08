<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file='../inc/header.jsp' %>
	<div class="container">
		<div class="col">
		<h3 class="col-sm-9">견적서 목록보기</h3>
		<a href="${pageContext.request.contextPath}/delete.request?request_id=${request_id}" class="text-right"><button class="btn text-right col-sm-3" style="width:70px; heigh:15px; font-size:8px; color:white;">요청 삭제</button></a>
		</div>
		<hr/>
		<div class="col">
		
		<c:forEach var="i" items="${estimatedList}" varStatus="status">
			<div class="col-sm-4 panel-body form-group" style="padding:10px 10px; margin: 10px; color: inherit; background-color:#eee;">
			<h4>이름 : ${i.user_name}</h4>
				<p>리뷰수 : ${i.review}</p>
				<p>예상금액 : ${i.price} 원</p>
				<div class="col">
				<a href='${pageContext.request.contextPath}/esdetail.request?estimate_id=${i.estimate_id}&request_id=${request_id}'><button id="detailbtn" class="btn btn-info form-control col-sm-6" style="color:white;">상세보기</button></a>
				<br/>
				</div>
				</div>
		</c:forEach>
		</div>
	</div>
	
<%@ include file='../inc/footer.jsp' %>