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
<link rel="stylesheet" href="css/header.css">
</head>
<body>

<div  id="header">
<h1 class="myhidden">My Company</h1>
<nav class="navbar myheader">
	<h2 class="myhidden" >main menu</h2>
  	<div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Company</a>
    </div>
    <ul class="nav navbar-nav mydrop">
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1
        <span class="caret"></span></a>
        <ul class="dropdown-menu mymenu">
          <li><a href="#" >Page 1-1</a></li>
          <li><a href="#" >Page 1-2</a></li>
          <li><a href="#" >Page 1-3</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 2
        <span class="caret"></span></a>
        <ul class="dropdown-menu mymenu">
          <li><a href="#">Page 2-1</a></li>
          <li><a href="#">Page 2-2</a></li>
          <li><a href="#">Page 2-3</a></li>
        </ul>
      </li>
    </ul>
    <ul class="nav navbar-nav navbar-right mynav_r">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span><span class="myhidden"> Sign Up</span></a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span><span class="myhidden">Login</span></a></li>
    </ul>
  </div>
</nav>

</div>

<div class="container panel panel-info">
   <h3 class="panel-heading">header</h3>
   
   <pre>
   
   1. https://www.w3schools.com/bootstrap/bootstrap_navbar.asp
   2. 검색 : navbar
   
   </pre>
 
 
 <footer id="footer">
 	<div class="container-fluid">
 		<ul class="nav navbar-nav mynav_f">
 				<li><a href="#" class="btn btn-info">portfolio1</a></li>
 		 		<li><a href="#" class="btn btn-info">portfolio1</a></li>
 		 		<li><a href="#" class="btn btn-info">portfolio1</a></li>
 		</ul>
 		<ul class="nav navbar-nav navbar-right">
 				<li><a href="#" >contact</a></li>
 		 		<li><a href="#" 	>about</a></li>
 		</ul>
 	</div>
 	<div class="my text-center">
 	    Copyright 2023 by Company All Rights Reserved.
 	</div>
 </footer>
 
</div>
</body>
</html>