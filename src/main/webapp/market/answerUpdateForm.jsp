<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>
<div class="container">
	<h3>문의</h3>
	<div class="form-group">
		<label for="iCate">문의 유형</label> 
		<input type="text"class="form-control" id="iCate" name="iCate" value="${mInquiry.category}" readonly>
	</div>
	<div class="form-group">
		<label for="iTitle">문의 제목</label> 
		<input type="text"class="form-control" id="iTitle" name="iTitle" value="${mInquiry.title}" readonly>
	</div>
	<div class="form-group">
		<label for="iContent">문의 내용</label>
		<textarea class="form-control" rows="5" id="iContent" name="iContent" readonly>${mInquiry.content}</textarea>
	</div>
	<form action="${pageContext.request.contextPath}/answerUpdate.crud?inquiry_id=${mInquiry.inquiry_id}" method="POST">
	<div class="form-group">
	<label for="answer">답변</label>
	<textarea class="form-control" rows="5" id="answer" name="answer" >${mInquiry.answer.answer}</textarea>
	</div>
	<div class="form-group text-right">
		<input type="submit" class="btn btn-info" value="수정"/>
		<a href="javascript:history.go(-1)" title="뒤로가기" class="btn btn-default" style="color:white;">뒤로가기</a>
	</div>
	</form>

	
</div>
<%@ include file="../inc/header.jsp"%>