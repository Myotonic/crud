<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<div class="container member-page">
	<h3>회원가입</h3>
<hr />
	<form action="expert_join.crud" method="post" class="form">
		<div class="member_form">
			<!-- 이름 입력 -->
			<div class="row form-group ">
				<div class="col-sm-3 text-left">
					<label for="name">이름</label>
				</div>
				<div class="col-sm-9">
					<input type="text" name="name" id="name" placeholder="이름을 입력해주세요" class="form-control"/>
				</div>
			</div>
			<div class="form-group member_extra">
				<p class="result r1"></p>	<!-- 중복확인 결과 뜨는 곳 -->
			</div>
			
			<!-- 이메일 입력 -->
			<div class="row form-group ">
				<div class="col-sm-3 text-left">
					<label for="email">이메일</label>
				</div>
				<div class="col-sm-6">
					<input type="email" name="email" id="email" placeholder="crud@emali.com" class="form-control"/>
				</div>
				<div class="col-sm-3">
					<input type="button" value="중복" class="btn idCheck" />
				</div>
			</div>
			<div class="form-group member_extra">
				<p class="result r2"></p>	<!-- 중복확인 결과 뜨는 곳 -->
			</div>
		
			<!-- 이메일 전송 -->
			<div class="row emailSend1 form-group ">
				<div class="col-sm-3 text-left">
					<label for="emailV">이메일인증</label>
				</div>
				<div class="col-sm-6">
					<input type="email" name="emailV" id="emailV"  class="form-control" readonly />
				</div>
				<div class="col-sm-3">
					<input type="button" value="전송" class="btn emailSend2" />
				</div>
			</div>
			<div class="form-group member_extra">
				<p class="result r3"></p>
			</div>
			
			<!-- 인증번호 확인 -->
			<div class="row emailCheck1 form-group ">
				<div class="col-sm-3 text-left">
					<label for="email">인증 번호</label>
				</div>
				<div class="col-sm-6">
					<input type="text" id="emailCheck2" name="emailCheck2" class="form-control" />
				</div>
				<div class="col-sm-3">
					<input type="button" value="인증" class="btn emailCheck3" />
				</div>
			</div>
			<div class="form-group member_extra">
				<p class="result r4"></p>	
			</div>
			
			<!-- 비밀번호 입력 -->
			<div class="row form-group ">
				<div class="col-sm-3 text-left">
					<label for="pass">비밀번호</label> 
				</div>
				<div class="col-sm-6">
					<input type="password" name="pass" id="pass" placeholder="비밀번호를 입력해주세요" class="form-control"/>
				</div>
				<div class="col-sm-3">
					<input type="button" id="show" class="btn" value="표시">
				</div>	
			</div>
			<div class="form-group member_extra">
				<p class="result r5"></p>
			</div>
		</div>
		<div class="form-group member_extra">
			<input type="submit" value="회원가입" class="member_submit form-control" />
		</div>
	</form>
</div>
<script>
	$(function(){
		//1.  user input code -  hide
		$(".emailCheck1").hide();
		$(".emailSend2").attr("disabled", true);
		
		//중복 확인
		$(".idCheck").on("click", function(){
		  if( $("#name").val() != "" && $("#email").val() != ""){ 
			$.ajax({
				url : "${pageContext.request.contextPath}/EmailCheck",
				type:"get",
				dataType:"text",
				data :{"email" : $("#email").val()},
				success : function(data){
					$(".r2").html(data); 	//사용 가능한지 띄우기
					if($(".r2 span").attr("data-check")!= "false"){	//사용이 가능하다면 
						$("#emailV").val($("#email").val());		//이메일 인증에 값 넣기
						$(".emailSend2").attr("disabled", false);
					}
				},
				error : function(xhr, textStatus, errorThrown){
					$(".r2").html(textStatus + "(http-"+xhr.status + "/" +errorThrown);
				}
			});
		  }
		});
		

		//2.     
		let code = "";	//인증번호 확인 저장
	    let check = "";  //인증번호 확인 
        //이메일 전송
        $(".emailSend2").on("click", function(){
	        	if(   $("#emailV").val().trim()  == $("#email").val().trim()   ){		//이메일 인증에 값이 있다면 (이메일이 사용 가능하다면)						
        		$.ajax({
					url : "${pageContext.request.contextPath}/EmailSend",
					type:"get",
					dataType:"text",
					data :{"emailV" : $("#emailV").val(), "name":$("#name").val()},
					success : function(data){
						code = data;	//이메일 전송 확인 값 저장
						 $(".emailCheck1").show();	//인증번호 확인 폼 띄우기
						 
						 //인증번호 매치 확인
						 $(document).on("click", ".emailCheck3" , function(){  
							 
							 //빈칸검사	
							 if($("#emailCheck2").val() == ""){ 
									$(".r4").html("번호를 입력해주세요");
									$("#emailCheck2").focus();
									return false;
								}
							 
							//인증번호 확인	
							if(code.trim() == $("#emailCheck2").val().trim()){
				        		check = "true";
				        		$(".r4").html("인증 완료");
				        	}else{
				        		$(".r4").html("인증 실패");
				        	}
						});
						        
						 
					},
					error : function(xhr, textStatus, errorThrown){
						$(".r3").html(textStatus + "(http-"+xhr.status + "/" +errorThrown);
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
	        	
        //제출하기 전
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
			}else if($(".r2 span").attr("data-check")=="false"){ //이메일 중복이라면   data-check
				$(".r2").html("이메일을 확인해주세요");
				$("#email").focus();
				return false;
			}else if (check != "true"){ //이메일 인증코드가 맞다면 submit하기 / 아니라면 submit 하지 말기
	            $(".r4").html("메일 인증을 완료해주세요");
	            $("#emailCheck2").focus();
	            return false;
	        }else if($("#pass").val() == ""){ 
				$(".r5").html("비밀번호를 입력해주세요");
				$("#pass").focus();
				return false;
			}
			
		});
	});
</script>
<%@ include file="../inc/footer.jsp" %>