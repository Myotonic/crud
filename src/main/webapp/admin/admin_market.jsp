<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="inc/header.jsp" %>

<div class="container panel panel-info">
   <h3 class="panel-heading">마켓 리스트</h3>
   <table class="table table-info">
 <caption>마켓 리스트</caption>
 <thead>
 <tr>
 <th scope="row">마켓번호</th><th scope="row">마켓 타이틀</th><th scope="row">회원이메일</th><th scope="row">생성일</th>
 </thead>
 <tbody>
 
 <c:forEach var="i"  items="${marketlist}"   varStatus="s">
 <tr>
 <td>${i.market.market_id}</td><td><a href="${pageContext.request.contextPath}/marketdetail.admin?market_id=${i.market.market_id}">${i.market.title}</a></td><td>${i.user.user_email}</td><td>${i.market.date}</td>
 </tr>
 </c:forEach>
 </tbody>
 </table>
 
 
</div>

<%@include file="inc/footer.jsp" %>
