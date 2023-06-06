<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<div class="container member-page">
	<h3>활동지역 설정</h3>
	<hr />
	<form action="expert_joinArea.crud" method="post" class="member_form">
		
		<div class="post_none">
			<input type="text" id="sido" name="sido">
			<input type="text" id="sigungu" name="sigungu">
		</div>
		
		<div id="wrap" style="border:1px solid;width:500px;height:300px;margin:5px 0;position:relative"> </div>
		
		<div class="form-group member_extra">
			<input type="text" id="roadAddress" name="roadAddress" class="form-control" readonly>
		</div>
		<div class="form-group member_extra">
			<input type="submit" value="다음" class="member_submit form-control" />
		</div>
	</form>
</div>
<script>
$(function(){
	// 우편번호 찾기 찾기 화면을 넣을 element
	var element_wrap = document.getElementById('wrap');
	var currentScroll = Math.max(document.body.scrollTop, document.documentElement.scrollTop);
	 
	new daum.Postcode({
        oncomplete: function(data) {
        	$("#sido").val(data.sido);
        	$("#sigungu").val(data.sigungu);
        	$("#roadAddress").val(data.roadAddress);
        	 element_wrap.style.display = 'none';
        },
        onresize : function(size) {
            element_wrap.style.height = size.height+'px';
        },
        width : '100%',
        height : '100%'
    }).embed(element_wrap);
	
	$("form").on("submit", function(){
		//빈칸검사
		if($("#roadAddress").val() == ""){ 
			alert("주소입력해주세요");
			$("#roadAddress").focus();
			return false;
		}
	});
});
</script>
<%@ include file="../inc/footer.jsp" %>