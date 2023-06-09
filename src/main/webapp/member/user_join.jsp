<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>\
<div class="container member-page">
	<h2>회원가입</h2>
	<hr />
	<form action="user_join.crud" method="post" class="member_form">
		<div class="form-group">
			<fieldset>
				<legend>이름</legend>
				<input type="text" name="name" id="name" placeholder="이름을 입력해주세요" class="form-control"/>
				<p class="result r1"></p>
			</fieldset>
		</div>
		<div class="form-group">
		<fieldset>
				<legend>이메일</legend>
				<div class="row">
					<div class="col-sm-9">
						<input type="email" name="email" id="email" placeholder="crud@emali.com" class="form-control" />
					</div>
					<div class="col-sm-3">
						<input type="button" value="중복" class="btn idCheck" />
					</div>
				</div>
				<p class="result r2"></p>
			</fieldset>
		</div>

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
				<input type="submit" value="회원가입" class="member_submit form-control" />
			</div>
		</fieldset>
		<div class="member_extra">
			<a href="expert_joinC1.crud">고수로 회원가입하러 가기</a>
		</div>
	</form>
	<script>
		$(function(){
			//중복체크 안 눌렀을 때
			var buttonClicked = false;
			//중복체크
			$(".idCheck").on("click", function(){
				if($("#email").val() == ""){ 
					$(".r2").html("이메일을 입력해주세요");
					$("#email").focus();
					return false;
				}else{
					$.ajax({
						url : "${pageContext.request.contextPath}/EmailCheck",
						type:"get",
						dataType:"text",
						data :{"email" : $("#email").val()},
						success : function(data){
							buttonClicked = true;
							$(".r2").html(data);
						},
						error : function(xhr, textStatus, errorThrown){
							$(".r2").html(textStatus + "(http-"+xhr.status + "/" +errorThrown);
						}
					});
				}
			});
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
				if($("#name").val() == ""){ 
					$(".r1").html("이름을 입력해주세요");
					$("#name").focus();
					return false;
				}else if($("#email").val() == ""){ 
					$(".r2").html("이메일을 입력해주세요");
					$("#email").focus();
					return false;
				}else if($(".r2 span").attr("data-check")=="false" || !buttonClicked){ 
					//아이디가 중복 안될 때 || 중복 검사 안 했을 때
					$(".r2").html("이메일을 확인해주세요");
					$("#email").focus();
					return false;
				}else if($("#pass").val() == ""){ 
					$(".r3").html("비밀번호를 입력해주세요");
					$("#pass").focus();
					return false;
				}
		        
			});
		});
	</script>
</div>
<%@ include file="../inc/footer.jsp" %>