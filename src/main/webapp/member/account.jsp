<%@page import="com.crud.dto.UserDto"%>
<%@page import="com.crud.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<%
   int user_id = (int) session.getAttribute("member");
   MemberDao dao = new MemberDao();
   UserDto dto = dao.getUser(user_id);
%>
<div class="container member-page">
	<h3>계정 설정</h3>
	<div class="account">
		<div class="row">
			<a href="${pageContext.request.contextPath}/editNameV.crud" class="btn form-control" title="수정하기"> 
			<span class="col-sm-2 ">이름</span><span class="col-sm-10"><%=dto.getUser_name() %></span></a>
		</div>
		<hr>
		<div class="row myemail">
				<span class="col-sm-2">이메일</span><span class="col-sm-10 "><%=dto.getUser_email() %></span>
		</div>
		<div class="row last">
			<a href="${pageContext.request.contextPath}/editPassV.crud" class="btn form-control" title="수정하기"> <span
				class="col-sm-2">비밀번호</span><span class="col-sm-10">•••••••</span></a>
		</div>
		<div> 
			<a href="AccountDropV.crud" title="계정탈퇴" class="btn form-control">계정 탈퇴</a>
		</div>
	</div>
</div>

<%@ include file="../inc/footer.jsp" %>