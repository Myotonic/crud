<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<div class="container panel panel-info">
	<h3 class="text-center">주소 설정</h3>
	<form action="expert_joinArea.crud" method="post" class="form">
		<div class="row">
			<div class="col-sm-2"><label for="postcode">우편번호</label></div>
			<div class="col-sm-2"><input type="text" id="sido" name="sido" class="form-control"></div>
			<div class="col-sm-2"><input type="text" id="sigungu" name="sigungu" class="form-control"></div>
			<div class="col-sm-2"><input type="text" id="roadAddress" name="roadAddress" class="form-control"></div>
			<div class="col-sm-4"><input type="button" id="post" value="우편번호" class="btn btn-danger"></div>
		</div>
		<input type="submit" value="범위 설정" />
	</form>
</div>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	$(function(){
		$("#post").on("click", function(){
			new daum.Postcode({
		        oncomplete: function(data) {
		        	$("#sido").val(data.sido);
		        	$("#sigungu").val(data.sigungu);
		        	$("#roadAddress").val(data.roadAddress);
		        }
		    }).open();
		});
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