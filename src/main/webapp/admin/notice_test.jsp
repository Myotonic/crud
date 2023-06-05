<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../inc/header.jsp" %>

<style>
#notice{
    position: fixed;
    top: 10%;
    right: 5%;
    z-index: 100000;
    width: 30%;
}


</style>




<div class="container panel panel-info" id="notice">
   <h3 class="panel-heading">공지사항</h3>
 
 
 
 <div class="panel-body">
   이 포트폴리오는 상업적 목적이 아닌 개인 포트폴리오 용도로 제작되었으며,
   홈페이지의 일부 내용과 기타 이미지 등의 그 출처가 따로 있음을 밝힙니다.
   
   </div>
   <div class="panel-body text-center">
   <h4>포트폴리오 풀 동영상 보러가기</h4>
   <img src="${pageContext.request.contextPath}/imgs/QRCode.jpg" alt="포트폴리오 풀 동영상 qr코드" />
   
   </div>
   <div class="panel-footer">
   		<input type="checkbox" id="subpop" name="subpop"/>
   		<label for="subpop">오늘 하루동안 이 창을 열지 않음.</label>
   		<input type="button" value="닫기." title="닫기." id="close"/>  
   </div>
 
 
 
</div>

<script>

 $(function() {
	 $("#subpop", "#close").on("click", function() {
		
		 $("#notice").fadeOut();
		
	});
	
});


</script>

<%@include file="../inc/footer.jsp" %>