<%@page import="com.crud.dto.UserDto"%>
<%@page import="com.crud.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
	<div class="member-page text-center">
	<h2>고수 가입</h2>
	<div class="member_form">
		<form action="user_join.crud" method="post" class="form">
			
			<hr />
			<%
			/*    int user_id = (int) session.getAttribute("user_id"); */
			   MemberDao dao = new MemberDao();
			   UserDto dto = dao.getUser(2);
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
				<div class="col-sm-6">
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
			</div>
			<p class="r3 label label-danger"></p>
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
			<p class="r4 label label-danger"></p>
			<hr />
			
			<!-- 비밀번호 입력 -->
			<div class="row">
				<div class="col-sm-4">
					<label for="pass">비밀번호</label> 
				</div>
				<div class="col-sm-8">
					<input type="password" name="pass" id="pass" placeholder="비밀번호를 입력해주세요" class="form-control"/>
				</div>
			</div>
			<p class="r5 label label-danger"></p>
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
				
				$("#emailV").val($("#email").val());
 
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
								console.log("1>>" + code);
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
			     
		        //제출하기 전
				$("form").on("submit", function(){
					//빈칸검사
					if($("#pass").val() == ""){ 
						$(".r3").html("비밀번호를 입력해주세요");
						$("#pass").focus();
						return false;
					}
					
					//중복체크 안 눌렀을 때
					var buttonClicked = false;
			        $(".idCheck").on("click", function(){ buttonClicked = true; });
			        
					//이메일 중복이라면 또는 중복확인 버튼을 안 눌렀다면     data-check
					if($(".r2 span").attr("data-check")=="false" || !buttonClicked){
						$(".r2").html("이메일을 확인해주세요");
						$("#email").focus();
						return false;
					}
					
					//이메일 인증코드가 맞다면 submit하기 / 아니라면 submit 하지 말기
					if (check != "true"){
			            $(".r4").html("인증번호를 확인해주세요");
			            $("#emailCheck2").focus();
			            return false;
			        }
					//비밀번호 확인
					if($("#pass").val() != <%=dto.getUser_pass()%>){
						 $(".r5").html("비밀번호가 일치하지 않습니다");
				         $("#pass").focus();
				         return false;
					}
					
				});
			});
		</script>
	</div>
</div>
<%@ include file="../inc/footer.jsp" %>