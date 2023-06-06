<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>CRUD</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  
  <link rel="shortcuticon" href="${pageContext.request.contextPath }/inc/favicon.ico" type="image/x-icon">
  <link rel="icon" 		   href="${pageContext.request.contextPath }/inc/favicon.ico" type="image/x-icon">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/mycss.css" >

</head>
<body>
	<div id="header">
		<h1 class="myhidden">로고</h1>
		<nav class="navbar mybg_h">
			<h2 class="myhidden">주메뉴</h2>
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="${pageContext.request.contextPath}/main.crud">CRUD</a>
		    </div>
		    <ul class="nav navbar-nav">
		      <li><a href="${pageContext.request.contextPath}/request/home.jsp">서비스요청</a></li>
		      <li><a href="${pageContext.request.contextPath}/marketView.crud">클래스 마켓</a></li>
		      <li><a href="#">커뮤니티</a></li>
		    </ul>
		    <ul class="nav navbar-nav navbar-right mynav_r">
		      <c:choose >
					<c:when test="${memberValue eq 'expert'}">
						  <li><a href="${pageContext.request.contextPath}/list.estimate"><span>받은 요청</span></a></li>
					      <li><a href=""><span>채팅</span></a></li>
					      <li><a href=""><span>프로필</span></a></li>
					      <li><a href="${pageContext.request.contextPath}/MyPage.crud"><span class="glyphicon glyphicon-user"></span></a></li>
					</c:when>
					<c:when test="${memberValue eq 'user'}">
						  <li><a href="${pageContext.request.contextPath}/list.request"><span>보낸 요청</span></a></li>
					      <li><a href=""><span>채팅</span></a></li>
					      <li><a href="${pageContext.request.contextPath}/MyPage.crud"><span class="glyphicon glyphicon-user"></span></a></li>
					</c:when>
					<c:otherwise>
					      <li><a href="${pageContext.request.contextPath}/loginV.crud"><span>로그인</span></a></li>
					      <li><a href="${pageContext.request.contextPath}/user_joinV.crud"><span>회원가입</span></a></li>
					      <li><a href="${pageContext.request.contextPath}/expert_joinC1.crud"><span>고수가입</span></a></li>
					</c:otherwise>
			</c:choose>
		    </ul>
		  </div>
		</nav>
	</div>