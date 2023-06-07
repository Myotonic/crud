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
	<form action="${pageContext.request.contextPath}/answerCreate.crud?inquiry_id=${mInquiry.inquiry_id}" method="POST">
	<div class="form-group">
	<label for="answer">답변</label>
	<textarea class="form-control" rows="5" id="answer" name="answer" <c:if test="${mInquiry.checkAnswer}">readonly</c:if>> <c:if test="${mInquiry.checkAnswer}">${mInquiry.answer.answer}</c:if></textarea>
	</div>
	<div class="form-group text-right">
		<c:choose>
		  <c:when test="${mInquiry.checkAnswer}">
		  		<a href="${pageContext.request.contextPath}/answerDelete.crud?inquiry_id=${mInquiry.inquiry_id}" title="삭제" class="btn btn-danger">삭제</a>
				<a href="${pageContext.request.contextPath}/answerUpdateForm.crud?inquiry_id=${mInquiry.inquiry_id}" title="수정" class="btn btn-info">수정</a>
		  </c:when>
		  <c:otherwise>
		  <input type="submit" class="btn btn-info" value="답변등록"/>
		  </c:otherwise>
		</c:choose>
		
		<a href="javascript:history.go(-1)" title="뒤로가기" class="btn btn-default">뒤로가기</a>
	</div>
	</form>

	
</div>
<%@ include file="../inc/header.jsp"%>