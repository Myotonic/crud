<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>CRUD</title>
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
		      <a class="navbar-brand" href="main.crud">CRUD</a>
		    </div>
		    <ul class="nav navbar-nav">
		      <li><a href="#">서비스요청</a></li>
		      <li><a href="#">고수찾기</a></li>
		      <li><a href="#">클래스 마켓</a></li>
		      <li><a href="#">커뮤니티</a></li>
		    </ul>
		    <ul class="nav navbar-nav navbar-right mynav_r">
		      <c:choose >
					<c:when test="${memberValue eq 'expert'}">
						  <li><a href=""><span>받은 요청</span></a></li>
					      <li><a href=""><span>채팅</span></a></li>
					      <li><a href=""><span>프로필</span></a></li>
					</c:when>
					<c:when test="${memberValue eq 'user'}">
						  <li><a href=""><span>받은 견적</span></a></li>
					      <li><a href=""><span>채팅</span></a></li>
					</c:when>
					<c:otherwise>
					      <li><a href="login.crud"><span>로그인</span></a></li>
					      <li><a href="user_joinV.crud"><span>회원가입</span></a></li>
					      <li><a href="expert_joinC1.crud"><span>고수가입</span></a></li>
					</c:otherwise>
			</c:choose>
		    </ul>
		  </div>
		</nav>
	</div>