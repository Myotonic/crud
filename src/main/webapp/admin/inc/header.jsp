<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Admin</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


<!-- 달력 뿌리는 용 -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js"></script>


<link rel="shortcuticon" type="image/x-icon" href="${pageContext.request.contextPath}/admin/imgs/myicon.ico"/>
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/admin/imgs/myicon.ico"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/header.css"/>



</head>
<body>


<h1 class="myhidden">My Company</h1>
<nav class="navbar navbar-inverse">
<h2 class="myhidden" >main menu</h2>
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" >관리자 페이지</a>
    </div>
    <ul class="nav navbar-nav">
     <!--  <li class="active"><a href="result.admin">Home</a></li> -->
      
      <c:if test="${sessionScope.email != null }">
      <li><a href="${pageContext.request.contextPath}/userlist.admin">유저 관리</a></li>
      <li><a href="${pageContext.request.contextPath}/marketlist.admin">클래스 관리</a></li>
      </c:if>
      <!-- <li><a href="#">커뮤니티 관리</a></li> -->
      
      <!-- <li><a href="#">공지사항(?)</a></li> -->
    
    </ul>
    
    
    
    <ul class="nav navbar-nav navbar-right">
     <!--  <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li> -->
     
     <c:if test="${sessionScope.email == null }">
      <li><a href="${pageContext.request.contextPath}/home.admin"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
     </c:if>
     <c:if test="${sessionScope.email != null }">
      <li><a href="${pageContext.request.contextPath}/logout.admin"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
     </c:if>
     
    </ul>
    <!-- <form class="navbar-form navbar-right" action="#">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search">
      </div>
      <button type="submit" class="btn btn-default">Submit</button>
    </form> -->
    
  </div>
</nav>