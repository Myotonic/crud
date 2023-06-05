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
	<h3 class="text-center">이름수정</h3>
	<form action="editName.crud" method="post">
		<fieldset>
			<label for="newName">이름</label>
			<input type="text" id="newName" name="newName" value="<%=dto.getUser_name() %>" class="form-control"/>
			<div class="form-group text-center check-btn">	
				<a href="${pageContext.request.contextPath}/AccountSetting.crud" class="btn " title="취소">취소</a>
				<input type="submit" value="수정" class="btn" title="수정" />
			</div>
		</fieldset>
	</form>
</div>

<%@ include file="../inc/footer.jsp" %>