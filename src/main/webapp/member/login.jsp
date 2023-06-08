<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<div class="container member-page">
	<h3>로그인</h3>
	<hr />
	<form action="login.crud" method="post" class="member_form">
		<fieldset>
			<legend>이메일</legend>
			<div class="form-group">
				<input type="email" name="email" id="email" placeholder="crud@emali.com" class="form-control" />
			</div>
		</fieldset>
		<fieldset>
			<legend>비밀번호</legend>
			<div class="row form-group ">
				<div class="col-sm-9">
					<input type="password" name="pass" id="pass" placeholder="비밀번호를 입력해주세요" class="form-control" />
				</div>
				<div class="col-sm-3">
					<input type="button" id="show" class="btn" value="표시">
				</div>
			</div>
			<div class="form-group member_extra">
				<p class="result r3"></p>
			</div>
		</fieldset>
		<fieldset>
			<div class="form-group">
				<input type="submit" value="로그인" class="member_submit form-control" />
			</div>
		</fieldset>
		<div class="member_extra">
			<a href="user_joinV.crud">회원가입</a>
		</div>
	</form>
</div>
<script>
$(function(){
	//현재비밀번호 표시
	  $("#show").on("click", function() {
	    var passwordInput = $("#pass");

	    if (passwordInput.attr("type") === "password") {
	      passwordInput.attr("type", "text");
	      $(this).val("숨김");
	    } else {
	      passwordInput.attr("type", "password");
	      $(this).val("표시");
	    }
	  });
	$("form").on("submit", function(){
		//빈칸검사
		if($("#email").val() == ""){ 
			alert("이메일을 입력해주세요");
			$("#email").focus();
			return false;
		}else if($("#pass").val() == ""){ 
			alert("비밀번호를 입력해주세요");
			$("#pass").focus();
			return false;
		}
	});
}); 
</script>
<%@ include file="../inc/footer.jsp" %>