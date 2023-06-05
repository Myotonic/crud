<%@page import="com.google.gson.*"%>
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
   <h3 class="panel-heading"></h3>
   
   <%
   
   Gson gson = new Gson();
   
   JsonObject jobj1 = new JsonObject();
   jobj1.addProperty("name", "sally");
   jobj1.addProperty("age", 3);
   
   //out.println(gson.toJson(jobj1));
   
   
   
   JsonObject jobj2 = new JsonObject();
   jobj2.addProperty("mno", 1);
   jobj2.addProperty("mname", "choco");
   
   out.println(gson.toJson(jobj2));
   
   
   
  JsonArray list = new JsonArray();
  JsonObject j3 = new JsonObject();
  j3.addProperty("name", "sally");
  j3.addProperty("age", 3);
  list.add(j3);
  
  j3 = new JsonObject();
  j3.addProperty("name", "alpha");
  j3.addProperty("age", 7);
  list.add(j3);
  
  out.println(list);
  
  JsonArray list2 = new JsonArray();
  JsonObject j4 = new JsonObject();
  
  j4.addProperty("1", "one");
  j4.addProperty("2", "two");
  
  list2.add(j4);
  
  j4 = new JsonObject();
  
  
  j4.addProperty("3", "three");
  j4.addProperty("4", "four");
  
  list2.add(j4);
  
  out.println(list2);
   
   %>
 
 
</div>
</body>
</html>