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
	<h3>마이페이지</h3>
	<hr />
	<div class="">
		<div class="row">
			<div class="user_icon glyphicon glyphicon-user col-sm-2"></div>
			<div class=" col-sm-8">
				<div class="row double"><%=dto.getUser_name() %></div>
				<div class="row double"><%=dto.getUser_email() %></div>
			</div>
			<div class="col-sm-2">
				<a href="${pageContext.request.contextPath}/logout.crud" title="로그아웃" class="btn">로그아웃</a>
				<a href="${pageContext.request.contextPath}/AccountSetting.crud" title="계정설정" class="btn">계정 설정</a>
			</div>
		</div>
		<hr/>
		<div class="">
			<div class=""><strong>클래스</strong></div>
			<div class=""><a href="${pageContext.request.contextPath}/myPageMarket.crud">나의 상품 내역</a></div>
			<div class=""><a href="${pageContext.request.contextPath}/inquiryView.crud">문의 내역 관리</a></div>
		</div>
		<hr/>
		<div class="last">
			<div class=""><strong>커뮤니티</strong></div>
			<div class=""><a href="">작성글</a></div>
			<div class=""><a href="">댓글</a></div>
		</div>
		<div class="member_extra">
			<a href="MemberValue.crud" title="전환" class="btn form-control">유저 전환</a>
		</div>
	</div>
</div>
<%@ include file="../inc/footer.jsp" %>