<%@page import="com.crud.dto.UserDto"%>
<%@page import="com.crud.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
	<div class="member-page text-center">
	<h2>고수 가입</h2>
	<div class="member_form text-left">
		<form action="expert_join.crud" method="post" class="form">
			
			<hr />
			<%
			   int user_id = (int) session.getAttribute("member");
			   MemberDao dao = new MemberDao();
			   UserDto dto = dao.getUser(user_id);
			%>
			<!-- 이름 가져오기 -->
			<div class="row">
				<div class="col-sm-4">
					<label for="name">이름</label>
				</div>
				<div class="col-sm-8">
					<input type="text" name="name" id="name" value="<%=dto.getUser_name() %>" class="form-control" readonly/>
				</div>
			</div>
			<hr />
			
			
			<!-- 이메일 가져오기 -->
			<div class="row">
				<div class="col-sm-4">
					<label for="email">이메일</label>
				</div>
				<div class="col-sm-8">
					<input type="email" name="email" id="email" value="<%=dto.getUser_email() %>" class="form-control" readonly />
				</div>
			</div>
			<hr />
			
			<!-- 이메일 전송 -->
			<div class="row emailSend1">
				<div class="col-sm-4">
					<label for="emailV">이메일 인증</label>
				</div>
				<div class="col-sm-6">
					<input type="email" name="emailV" id="emailV"  class="form-control"/>
				</div>
				<div class="col-sm-2">
					<input type="button" value="전송" class="btn btn-info emailSend2" />
				</div>
				<p class="r1 label label-danger"></p>
			</div>
			<hr />
			
			<!-- 인증번호 확인 -->
			<div class="row emailCheck1">
				<div class="col-sm-4">
					<label for="email">인증 번호</label>
				</div>
				<div class="col-sm-6">
					<input type="text" id="emailCheck2" name="emailCheck2" class="form-control" />
				</div>
				<div class="col-sm-2">
					<input type="button" value="인증하기" class="btn btn-info emailCheck3" />
				</div>
			</div>
			<p class="r2 label label-danger"></p>
			<hr />
			
			<!-- 비밀번호 입력 -->
			<div class="row">
				<div class="col-sm-4">
					<label for="pass">비밀번호</label> 
				</div>
				<div class="col-sm-6">
					<input type="password" name="pass" id="pass" placeholder="비밀번호를 입력해주세요" class="form-control"/>
				</div>
				<div class="col-sm-2">
						<input type="button" id="show" class="btn" value="표시">
				</div>
			</div>
			<p class="r3 label label-danger"></p>
			<hr />
			
			<fieldset>
				<div class="form-group">
					<input type="submit" value="고수 가입" class="member_submit form-control" />
				</div>
			</fieldset>
		</form>
		<script>
			$(function(){
				$(".emailCheck1").hide();

				$("#emailV").val($("#email").val()).prop("readonly", true);		//이메일 인증에 값 넣기
				    
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
											$(".r2").html("번호를 입력해주세요");
											$("#emailCheck2").focus();
											return false;
										}
									 
									//인증번호 확인	
									if(code.trim() == $("#emailCheck2").val().trim()){
						        		check = "true";
						        		$(".r2").html("인증 완료");
						        	}else{
						        		$(".r2").html("인증 실패");
						        	}
								});
								        
								 
							},
							error : function(xhr, textStatus, errorThrown){
								$(".r1").html(textStatus + "(http-"+xhr.status + "/" +errorThrown);
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
					//이메일 인증코드가 맞다면 submit하기 / 아니라면 submit 하지 말기
					if (check != "true"){
			            $(".r2").html("메일 인증을 완료해주세요");
			            $("#emailCheck2").focus();
			            return false;
			        }else if($("#pass").val() == ""){ 
						$(".r3").html("비밀번호를 입력해주세요");
						$("#pass").focus();
						return false;
					}else if($("#pass").val() != <%=dto.getUser_pass()%>){ //비밀번호 확인
						 $(".r3").html("비밀번호가 일치하지 않습니다");
				         $("#pass").focus();
				         return false;
					}
				});
			});
		</script>
	</div>
</div>
<%@ include file="../inc/footer.jsp" %>