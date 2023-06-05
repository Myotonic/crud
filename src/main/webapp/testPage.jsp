<%@page import="com.company.dto.UserExpertCategoryCityDto"%>
<%@page import="com.company.service.AUserDetail"%>
<%@page import="com.company.dto.Category1Dto"%>
<%@page import="com.company.service.AUserList"%>
<%@page import="com.company.dto.MarketDto"%>
<%@page import="com.company.dto.UserMarketDto"%>
<%@page import="com.company.dto.UserDto"%>
<%@page import="com.company.dto.ExpertDto"%>
<%@page import="com.company.dto.UserExpertDto"%>
<%@page import="com.company.dto.AdminDto"%>
<%@page import="com.company.dao.AdminDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
   <h3 class="panel-heading">test</h3>
 <%
 /* AdminDao dao = new AdminDao();

 UserExpertDto dto = new UserExpertDto();
 
 ExpertDto expert = new ExpertDto();
 
 expert.setCategory2_id(1);
 
 
 dto.setExpert(expert);
 
 
 
 out.println(dao.category(dto));
  */
 
  
 /*  AdminDao dao = new AdminDao();
 
  
  out.println(dao.exportList()); */
  
  
  
 /*  AdminDao dao = new AdminDao();
  UserDto dto = new UserDto();
  dto.setUser_id(1);
  
  
  
  out.println(dao.exportDetail(dto)); */
  
  
  /* AdminDao dao = new AdminDao();
  UserDto user = new UserDto();
  ExpertDto expert = new ExpertDto();
  UserExpertDto dto = new UserExpertDto();
  
  user.setUser_name("updatetest");
  user.setUser_id(1);
  
  
  expert.setExpert_intro("updateintro");
  expert.setExpert_range("updaterange");
  expert.setCategory2_id(1);
  expert.setCity_id(1);
  
  dto.setExpert(expert);
  dto.setUser(user);
  
  
  
  out.println(dao.expertEdit(dto)); */
  
  
  
  
  /* AdminDao dao = new AdminDao();

  out.println(dao.marketList()); */
  
  
 /*  AdminDao dao = new AdminDao();
  
  UserMarketDto dto = new UserMarketDto();
  MarketDto market = new MarketDto();
  market.setMarket_id(1);
  dto.setMarket(market);
  
  
  out.println(dao.marketDetail(dto)); */
  
 /*  
  AdminDao dao = new AdminDao();
  UserMarketDto dto = new UserMarketDto();
  MarketDto market = new MarketDto();
  market.setTitle("updatetitle");
  market.setContent("updatecontent");
  market.setDate("2023-05-29 00:00:00");
  market.setPrice(888888);
  market.setRefund("updaterefund");
  market.setDivision("updatedivision");
  market.setCategory1_id(1);
  market.setCategory2_id(1);
  market.setMarket_id(1);
  
  dto.setMarket(market);
  
  
  out.println(dao.MarketEdit(dto));
  
   */
  
   /* AdminDao dao = new AdminDao();
   
   Category1Dto dto = new Category1Dto();
   
   dto.setCategory1_id(1);
   
  
   
   out.println(dao.category1(dto));
   
  
  
  AUserList list = new AUserList();
  list.exec(request, response);
  */
 
AdminDao dao = new AdminDao();
UserExpertCategoryCityDto dto = new UserExpertCategoryCityDto();
dto.getCategory().getCategory1().setCategory1_name("레슨");


 

  out.println(dao.category1(dto));
 %>

<%-- table class="table table-info">
 <caption>유저 리스트</caption>
 <thead>
 <tr>
 <th scope="row">회원번호</th><th scope="row">회원이메일</th><th scope="row">회원명</th><th scope="row">가입일</th><th scope="row">전문가</th>
 </tr>
 </thead>
 <tbody>
 <c:forEach var="i" items="${userlist}" varStatus="s">
 <tr>
 <td>${i.user.user_id}</td><td>${i.user.user_email}</td><td>${i.user.user_name}</td><td>${i.user.user_date}</td><td><c:if test="${i.expert.expert_id == 0}">X</c:if><c:if test="${i.expert.expert_id != 0}">O</c:if></td>
 </tr>
 </c:forEach>
 </tbody>
 </table> --%>
 
 
 
 
 

</div>




</body>
</html>