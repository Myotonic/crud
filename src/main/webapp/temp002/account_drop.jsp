<%@page import="com.crud.dto.UserDto"%>
<%@page import="com.crud.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<div class="container panel panel-info text-center" >
	<h3 class="text-center">계정 탈퇴</h3>
	<div class="drop_check ">
		<ol class="text-left">
			<li>탈퇴 시 모든 정보 및 게시글, 댓글 등이 즉시 삭제 됩니다</li>
			<li>동의하시는 경우, 탈퇴를 진행하시려면 "탈퇴하기" 버튼을 클릭하세요.</li>
		</ol>
	</div>
	<div class="check-btn">
		<a href="${pageContext.request.contextPath}/AccountSetting.crud" class="btn" title="취소">취소</a>
		<a href="${pageContext.request.contextPath}/AccountDrop.crud" class="btn" title="탈퇴">탈퇴</a>
	</div>
</div>

<%@ include file="../inc/footer.jsp" %>