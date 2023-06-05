<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file='../inc/header.jsp' %>
	<div class="container panel panel-success">
	<%
	out.print(session.getAttribute("member"));
	%>
		<h3 class="panel-heading text-center">${dto.category1_name} - ${dto.category2_name}</h3>
		<div class="form-group ajaxx">
			<div class="form-group ajax1">
			</div>
			<div class="text-right">
			<c:set var="cnt" value="1" />
			<input type="button" value="취소" id="prebtn" class="btn btn-default">
			<input type="button" value="다음" id="nextbtn" class="btn btn-info">
			</div>
		</div>
		
		<form action="${pageContext.request.contextPath}/create.request" method="get" id="formrequest" >
			<input type="hidden" id="sido" name="sido" />
			<input type="hidden" id="sigungu" name="sigungu" />
			<input type="hidden" id="roadAddress" name="roadAddress" />
			<input type="hidden" id="date" name="work_date" />
			<input type="hidden" id="content2" name="content" />
			<input type="hidden" id="hidden" name="category1_id" value="${dto.category1_id}" />
			<input type="hidden" id="hidden" name="category1_name" value="${dto.category1_name}" />
			<input type="hidden" id="hidden" name="category2_id" value="${dto.category2_id}" />
			<input type="hidden" id="hidden" name="category2_name" value="${dto.category2_name}" />
		</form>
		
		<script>
			$(function() {
				
				var sido = "";
				var sigungu = "";
				var roadAddress = "";
				
				var date = "";
				var content = "";
				var cnt = '1';
				
				var requestdate = function() {$.ajax({
					url : "ajax/requestdate.txt" ,
					type : "get" ,
					dataType : "text" ,
					success : function(text) {
						console.log(text);
						$(".ajax1").html(text);
						$("#work_date").val(date);
						$("#work_datetxt").val(date);
						$("#work_date").on("change" ,function() {
							date = $("#work_date").val();
							$("#work_datetxt").val(date);
							console.log(date);
						});
					} ,
					error : function(xhr , textStatus, errorThrown) {
						console.log(textStatus + " / " + xhr.status + " / " + errorThrown);
					}
				});
				}
				
				var requestmap = function() {
					$.ajax({
						url : "ajax/requestmap.txt" ,
						type : "get" ,
						dataType : "text" ,
						success : function(text) {
							console.log(text);
							$(".ajax1").html(text);
							$("#sido").val(sido);
							$("#sigungu").val(sigungu);
							$("#roadAddress").val(roadAddress);
							$(function(){
								$("#post").on("click", function(){
									new daum.Postcode({
								        oncomplete: function(data) {
								        	$("#sido").val(data.sido);
								        	$("#sigungu").val(data.sigungu);
								        	$("#roadAddress").val(data.roadAddress);
								        	sido = data.sido;
								        	sigungu = data.sigungu;
								        	roadAddress = data.roadAddress;
								        }
								    }).open();
								});
							});
						} ,
						error : function(xhr , textStatus, errorThrown) {
							console.log(textStatus + " / " + xhr.status + " / " + errorThrown);
						}
					});
				}
				
				var requestcontent = function() {
					$.ajax({
						url : "ajax/requestcontent.txt" ,
						type : "get" ,
						dataType : "text" ,
						success : function(text) {
							console.log(text);
							$(".ajax1").html(text);
							$("#content").val(content);
							$("#content").on("change", function() {
								content = $("#content").val();
								console.log(content);
							});
						} ,
						error : function(xhr , textStatus, errorThrown) {
							console.log(textStatus + " / " + xhr.status + " / " + errorThrown);
						}
					});
				}
				
				var requestconfirm = function() {
					$.ajax({
						url : "ajax/requestconfirm.txt" ,
						type : "get" ,
						dataType : "text" ,
						success : function(text) {
							console.log(text);
							$(".ajax1").html(text);
							$("#city_name").val(roadAddress);
							$("#work_date").val(date);
							$("#content").val(content);
						}
					});
				}
				
				requestmap();
				
				$("#nextbtn").on("click",function() {
					
					if(cnt == '1') {
						if(roadAddress == "") {
							alert('입력해줭');
							return false;
						}
						cnt++;
						requestdate();
						$("#prebtn").val('이전');
					} else if (cnt == '2') {
						if(date == "") {
							alert('입력해줭');
							return false;
						}
						cnt++;
						requestcontent();
					} else if (cnt == '3') {
						if(content == "") {
							alert('입력해줭');
							return false;
						}
						cnt++;
						requestconfirm();
						$("#nextbtn").val('확인');
					} else if (cnt == '4') {
						$("#sido").val(sido);
						$("#sigungu").val(sigungu);
						$("#roadAddress").val(roadAddress);
						$("#date").val(date);
						$("#content2").val(content);
						$("#formrequest").submit();
					}
				});
				
				$("#prebtn").on("click",function() {
					if(cnt == '2') {
						cnt--;
						requestmap();
						$("#prebtn").val('취소');
					} else if (cnt == '3') {
						cnt--;
						requestdate();
					} else if (cnt == '4') {
						cnt--;
						requestcontent();
					}
				});
			});
		</script>
		<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	</div>
	<% %>
<%@ include file='../inc/footer.jsp' %>