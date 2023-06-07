<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<div class="container member-page">
	<h3>활동지역 설정</h3>
	<hr />
<<<<<<< HEAD
	<form action="expert_joinArea.crud" method="post" class="member_form">
	
		<input type="hidden" id="mapx" name="mapx" />
		<input type="hidden" id="mapy" name="mapy" />
		
		<div class="post_none">
			<input type="text" id="sido" name="sido">
			<input type="text" id="sigungu" name="sigungu">
=======
	<form action="expert_joinArea.crud" method="post" class="form">
		<div class="member_form">
			<input type="hidden" id="sido" name="sido">
			<input type="hidden" id="sigungu" name="sigungu">
			
			<div id="wrap" style="border:1px solid;width:500px;height:300px;margin:5px 0;position:relative"> </div>
>>>>>>> branch 'master' of https://github.com/Myotonic/crud.git
		</div>
		<div class="form-group member_extra">
			<input type="text" id="roadAddress" name="roadAddress" class="form-control" readonly>
		</div>
		<div class="form-group member_extra">
			<input type="submit" value="다음" class="member_submit form-control" />
		</div>
	</form>
</div>

<!--   이한동 06-07 수정분   -->
<script type="text/javascript"
			src="//dapi.kakao.com/v2/maps/sdk.js?appkey=206619e722961e9bb72b6eab05eaaa4d&libraries=services">
	</script>
<!--   이한동 06-07 수정분   -->

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
        	 
        	 ///// 이한동 06-07 수정분 /////
        	 var geocoder = new kakao.maps.services.Geocoder();

        	 geocoder.addressSearch(data.roadAddress, function(result, status) {

        	      if (status === kakao.maps.services.Status.OK) {

        	         var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
        	         
        	         $("#mapx").val(result[0].x);
        	         $("#mapy").val(result[0].y);
        	     } 
        	 });	
        	 ///// 이한동 06-07 수정분 /////
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