<%@page import="com.crud.requestdto.EstimateDto"%>
<%@page import="com.crud.requestdao.EstimateDao"%>
<%@page import="com.crud.requestdto.EstimatedListDto"%>
<%@page import="com.crud.requestdto.RequestListDto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.crud.dbmanager.DBManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.crud.requestdao.RequestDao"%>
<%@page import="com.crud.requestdto.RequestDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>BASIC</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container panel panel-success">
		<h3 class="panel-heading">FORM BASIC-\PLUS</h3>
		<%
		
// 		RequestDto dto = new RequestDto();
// 		dto.setUser_id(1);
// 		dto.setCategory2_id(1);
// 		dto.setCity_id(1);
// 		dto.setWork_date("2023-05-29");
// 		dto.setContent("setContent");	request_id, expert_id, price, content
		EstimateDto dto = new EstimateDto();
		dto.setRequestID(1);
		dto.setExpertID(1);
		dto.setPrice(100);
		dto.setContent("concon");

		out.print(new EstimateDao().estimateCreate(dto));
		
		%>
	</div>
</body>
</html>