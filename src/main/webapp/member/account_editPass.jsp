<%@page import="com.crud.dto.UserDto"%>
<%@page import="com.crud.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<%
	int user_id = (int) session.getAttribute("member");
	MemberDao dao = new MemberDao();
	UserDto dto = dao.getUser(user_id);
%>
<div class="container member-page">
	<h3>비밀번호 변경</h3>
	<hr />
	<form action="editPasss.crud" method="post" class="member_form">
		<fieldset>
			<label for="pass">현재 비밀번호</label>
			<div class="row form-group">
				<div class="col-sm-9">
					<input type="password" id="pass" name="pass" class="form-control" placeholder="현재 비밀번호 입력" />
				</div>
				<div class="col-sm-3">
					<input type="button" id="show1" class="btn" value="표시">
				</div>
			</div>
			<p class="result r1"></p>
		</fieldset>
		<fieldset>
			<label for="newPass">새로운 비밀번호</label>
			<div class="row form-group">
				<div class="col-sm-9">
					<input type="password" id="newPass" name="newPass" class="form-control" placeholder="새로운 비밀번호 입력" />
				</div>
				<div class="col-sm-3">
					<input type="button" id="show2" class="btn" value="표시">
				</div>
			</div>
			<p class="result r2"></p>
		</fieldset>
		<div class="form-group text-center check-btn">	
			<a href="${pageContext.request.contextPath}/AccountSetting.crud" class="btn " title="취소">취소</a>
			<input type="submit" value="변경" class="btn" title="변경" />
		</div>
	</form>
<script>
		$(function(){
			//현재비밀번호 표시
			  $("#show1").on("click", function() {
			    var passwordInput = $("#pass");

			    if (passwordInput.attr("type") === "password") {
			      passwordInput.attr("type", "text");
			      $(this).val("숨김");
			    } else {
			      passwordInput.attr("type", "password");
			      $(this).val("표시");
			    }
			  });
			//새로운 비밀번호 표시
			  $("#show2").on("click", function() {
			    var passwordInput = $("#newPass");

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
				if($("#pass").val() == ""){ 
					$(".r1").html("비밀번호를 입력해주세요");
					$("#pass").focus();
					return false;
				}else if($("#pass").val() != <%=dto.getUser_pass()%>){ //비밀번호 확인
					 $(".r1").html("비밀번호가 일치하지 않습니다");
			         $("#pass").focus();
			         return false;
				}else if($("#newPass").val() == ""){ 
					$(".r2").html("비밀번호를 입력해주세요");
					$("#pass").focus();
					return false;
				}
			});
		});
	</script>
</div>

<%@ include file="../inc/footer.jsp" %>
