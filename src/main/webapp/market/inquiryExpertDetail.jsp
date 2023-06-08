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
	<div class="refund">
	
	</div>
	<form action="${pageContext.request.contextPath}/answerCreate.crud?inquiry_id=${mInquiry.inquiry_id}" method="POST" id="inquiry">
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
		<c:if test="${mInquiry.category == '환불'}">
		<!-- Trigger the modal with a button -->
		<button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">환불</button>		
		</c:if>
		
		<a href="javascript:history.go(-1)" title="뒤로가기" class="btn btn-default">뒤로가기</a>
	</div>
	</form>
			<!-- Modal -->
		<div id="myModal" class="modal fade" role="dialog">
		  <div class="modal-dialog">
		
		    <!-- Modal content-->
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		        <h4 class="modal-title">환불/취소 요청</h4>
		      </div>
		      <div class="modal-body">
		        <p>환불/취소 요청을 받겠습니까?</p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" id="ajaxrefund">환불</button>
		        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
		      </div>
		    </div>
		
		  </div>
		</div>
	
	<script>
	  $(function(){
		    $("#ajaxrefund").on("click", function(){
		      $.ajax({
		        url: "${pageContext.request.contextPath}/ajaxRefund.crud?market_id=" + ${mInquiry.market_id} + "&user_id=" + ${mInquiry.user_id},
		        type: "post",
		        dataType: "text",
		        success: function(text){
		        	$(".refund").append($("<p>").append(text));
		            $("#myModal").css("display", "none");
		            $(".modal-backdrop").remove();
		            $("body").removeClass("modal-open");
		        },
		        error: function(xhr, textStatus, errorThrown){
		          // AJAX 요청 실패 처리
		        }
		      });
		    });
		    $("#inquiry").on("click",function(){
			    if ($("#answer").val() == "") {
				      alert("답변을 입력해야합니다.");
				      $("#answer").focus();
				      return false;
				    }
		    });
		  });
	</script>

	
</div>
<%@ include file="../inc/header.jsp"%>