<%@page import="com.crud.service.MLogin"%>
<%@page import="com.crud.service.MemberValue"%>
<%@page import="com.crud.dto.AreaDto"%>
<%@page import="com.crud.dto.CityDto"%>
<%@page import="com.crud.dao.MemberDao"%>
<%@page import="com.crud.service.MemberService"%>
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
<div class="container">
	<h3></h3>
	
	<%
// 		session.setAttribute("memberValue", "user");
// 		MemberService service = new MemberValue();
		
		MemberService service = new MLogin();
		service.exec(request, response);

// 		String a = (String)request.getSession().getAttribute("memberValue");
	%>
<%-- 	<p><%=a %></p> --%>
</div>
</body>
</html>