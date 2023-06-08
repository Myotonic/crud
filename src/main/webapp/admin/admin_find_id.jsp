<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="inc/header.jsp" %>


<div class="container panel panel-info">
   <h3 class="panel-heading">FIND - ID</h3>
   
   <table class="table table-info">
   <caption>관리자</caption>
   <thead>
   <tr>
   <th scope="row">사원번호</th><td>${admin_num}</td>
   </tr>
   <tr>
   <th scope="row">이름</th><td>${name}</td>
   </tr>
   <tr>
   <th scope="row">이메일</th><td>${email}</td>
   </tr>
   <tr>
   <th scope="row">입사일</th><td>${date}</td>
   </tr>
   </thead>
   </table>
   
   
 
 
</div>



<%@include file="inc/footer.jsp" %>
