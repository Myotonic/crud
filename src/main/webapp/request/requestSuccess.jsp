<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file='../inc/header.jsp' %>
	<div class="container">
		<h3 class="text-center">요청서 작성완료</h3>
		<div class="form-group text-center">
			<span><p>당장보러가야대</p></span>
			<a href="${pageContext.request.contextPath}/list.request"><button id="btnbtnbtn" title="btn" class="btn btn-info text-center" style="color:white;">OK</button></a>
		</div>
	</div>
<%@ include file='../inc/footer.jsp' %>