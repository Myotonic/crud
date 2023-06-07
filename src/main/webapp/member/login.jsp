<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<div class="container member-page">
	<h3>로그인</h3>
	<hr />
	<form action="login.crud" method="post" class="member_form">
		<div class="form-group">
			<fieldset>
				<legend>이메일</legend>
				<input type="email" name="email" id="email" placeholder="crud@emali.com" class="form-control"/>
			</fieldset>
		</div>
		<div class="form-group">
			<fieldset>
				<legend>비밀번호</legend> 
				<input type="password" name="pass" id="pass" placeholder="비밀번호를 입력해주세요" class="form-control"/>
			</fieldset>
		</div>
		<fieldset>
			<div class="form-group">
				<input type="submit" value="로그인" class="member_submit form-control" />
			</div>
		</fieldset>
		<div class="member_extra">
			<a href="password_find.jsp">비밀번호 찾기</a>
			<a href="user_join.jsp">회원가입</a>
		</div>
	</form>
</div>
<%@ include file="../inc/footer.jsp" %>