<%@page import="com.company.dto.MarketDto"%>
<%@page import="com.company.dto.UserMarketCategoryDto"%>
<%@page import="com.company.dto.AdminDto"%>
<%@page import="com.company.service.ACategory"%>
<%@page import="com.company.dto.Category1Dto"%>
<%@page import="com.company.dto.CategoryDto"%>
<%@page import="com.company.dto.UserExpertCategoryCityDto"%>
<%@page import="com.company.dao.AdminDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container panel panel-info">
   <h3 class="panel-danger"></h3>
 
 
 <%
 
AdminDao dao =  new AdminDao();
UserMarketCategoryDto dto = new UserMarketCategoryDto();
MarketDto market = new MarketDto();

market.setMarket_id(1);


dto.setMarket(market);
 out.println(dao.marketDetail(dto));
  
 
  

/* 	
	 AdminDao dao = new AdminDao();
	 UserExpertCategoryCityDto dto = new UserExpertCategoryCityDto();
	 CategoryDto category = new CategoryDto();
	 Category1Dto category1 = new Category1Dto();
	 
	 category1.setCategory1_name("레슨");
	 //category1.setCategory1_name(request.getParameter("category1_name"));
	 category.setCategory1(category1);
	 dto.setCategory(category);
  
	
	 out.println(dao.category1(dto)); */
  
 %>
 
</div>
</body>
</html>