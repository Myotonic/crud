<%@page import="com.crud.dto.UserDto"%>
<%@page import="com.crud.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<%
   int user_id = (int) session.getAttribute("member");
   MemberDao dao = new MemberDao();
   UserDto dto = dao.getUser(user_id);
%>
<div class="container panel panel-info">
	<h3 class="text-center">계정 설정</h3>
	<div class="account">
		<div class="row">
			<span class="">이름</span>
			<a href="editNameV.crud" class="btn form-control" title="수정하기"><%=dto.getUser_name() %></a>
		</div>
		<div class="row">
			<span class="">이메일</span>
			<p><%=dto.getUser_email() %></p>
		</div>
		<div class="row">
			<span class="">비밀번호</span>
			<a href="editPassV.crud" class="btn form-control" title="수정하기">•••••••</a>
		</div>
	</div>
	<div> 
		<p> <a href="AccountDropV.crud" title="계정탈퇴" class="btn form-control">계정 탈퇴</a> </p> 
	</div>
</div>

<%@ include file="../inc/footer.jsp" %>