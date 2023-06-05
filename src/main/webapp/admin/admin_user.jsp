<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../inc/header.jsp" %>


<div class="container panel panel-info">
   <h3 class="panel-heading">유저 리스트</h3>
 
 
 <table class="table table-info">
 <caption>유저 리스트</caption>
 <thead>
 <tr>
 <th scope="row">회원번호</th><th scope="row">회원이메일</th><th scope="row">회원명</th><th scope="row">가입일</th><th scope="row">전문가</th>
 </tr>
 </thead>
 <tbody>
 <c:forEach var="i" items="${userlist}" varStatus="s">
 <tr>
 <td>${i.user.user_id}</td><td> <a href="${pageContext.request.contextPath}/userdetail.admin?user_id=${i.user.user_id}">${i.user.user_email}</a></td><td>${i.user.user_name}</td><td>${i.user.user_date}</td><td><c:if test="${i.expert.expert_id == 0}">X</c:if><c:if test="${i.expert.expert_id != 0}">O</c:if></td>
 </tr>
 </c:forEach>
 </tbody>
 </table>

 
</div>
<%@include file="../inc/footer.jsp" %>