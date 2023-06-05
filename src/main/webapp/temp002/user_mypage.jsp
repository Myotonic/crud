<%@page import="com.crud.dto.UserDto"%>
<%@page import="com.crud.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<%
   int user_id = (int) session.getAttribute("member");
   MemberDao dao = new MemberDao();
   UserDto dto = dao.getUser(user_id);
%>
<div class="member-page text-center">
	<h2>마이페이지</h2>
	<div class="mypage">
		<div class="my_account row">
			<div class="user_icon glyphicon glyphicon-user col-sm-2"></div>
			<div class="user_info col-sm-4">
					<div class="user_name row"><%=dto.getUser_name() %></div>
					<div class="user_email row"><%=dto.getUser_email() %></div>
			</div>
			<div class="col-sm-3">
				<a href="logout.crud" title="로그아웃" class="btn">로그아웃</a>
			</div>
			<div class="account_setting col-sm-3">
				<a href="AccountSetting.crud" title="계정설정" class="btn">계정 설정</a>
			</div>
		</div>
		<hr/>
		<div class="my_class">
			<div class="my_title"><strong>클래스</strong></div>
			<div class="my_content"><a href="">구매 내역</a></div>
			<div class="my_content"><a href="">문의 내역</a></div>
		</div>
		<hr/>
		<div class="my_comm">
			<div class="my_title"><strong>커뮤니티</strong></div>
			<div class="my_content"><a href="">작성글</a></div>
			<div class="my_content"><a href="">댓글</a></div>
		</div>
		<hr />
		<div>
			<p> <a href="MemberValue.crud" title="전환" class="btn form-control">고수 전환</a> </p>
		</div>
	</div>
</div>
<%@ include file="../inc/footer.jsp" %>