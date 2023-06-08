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
	<h3>이름수정</h3>
	<hr />
	<form action="editName.crud" method="post">
		<fieldset>
			<div class="row member_form ">
				<div class="col-sm-3 text-left">
					<label for="newName">이름</label>
				</div>
				<div class="col-sm-9">
					<input type="text" id="newName" name="newName" value="<%=dto.getUser_name() %>" class="form-control"/>
				</div>
			</div>
			<div class="form-group check-btn">	
				<a href="${pageContext.request.contextPath}/AccountSetting.crud" class="btn " title="취소">취소</a>
				<input type="submit" value="수정" class="btn" title="수정" />
			</div>
		</fieldset>
	</form>
</div>

<%@ include file="../inc/footer.jsp" %>