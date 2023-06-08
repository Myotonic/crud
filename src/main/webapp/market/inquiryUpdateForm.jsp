<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>
<div class="container">
	<h3>문의</h3>
	<form
		action="${pageContext.request.contextPath}/inquiryUpdate.crud?inquiry_id=${mInquiry.inquiry_id}"
		method="post" id="inquiryForm">
		<div class="form-group">
		<label for="iCategory">문의 유형</label> 
		<input type="text"class="form-control" id="iCategory" name="iCategory" value="${mInquiry.category}" readonly>
		</div>
		<div class="form-group">
			<label for="iTitle">문의 제목</label> <input type="text"
				class="form-control" id="iTitle" name="iTitle" value="${mInquiry.title}">
		</div>
		<div class="form-group">
			<label for="iContent">문의 내용</label>
			<textarea class="form-control" rows="5" id="iContent" name="iContent">${mInquiry.content}</textarea>
		</div>
		<div class="form-group text-right">
			<a href="javascript:history.go(-1)" title="뒤로가기" class="btn btn-default" style="color:white;">뒤로</a>
			<button type="submit" class="btn btn-primary" style="color:white;">수정</button>
		</div>
	</form>
</div>
<%@ include file="../inc/header.jsp"%>