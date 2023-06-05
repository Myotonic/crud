<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file='../inc/header.jsp' %>

	<div class="container">
		<h3>CRUD</h3>
		
		<a href="${pageContext.request.contextPath}/list.estimate">가즈아</a>
		
		<div class="col">
			<div class="col-sm-3"><img alt="ddd" src="${pageContext.request.contextPath}/icon.png" class="ca1"></div>
			<div class="col-sm-3"><img alt="ddd" src="${pageContext.request.contextPath}/icon.png" class="ca2"></div>
			<div class="col-sm-3"><img alt="ddd" src="${pageContext.request.contextPath}/icon.png" class="ca3"></div>
			<div class="col-sm-3"><img alt="ddd" src="${pageContext.request.contextPath}/icon.png" class="ca4"></div>
		</div>
		
		<div class="col">
		<div class="col-sm-3 r1"></div>
		<div class="col-sm-3 r2"></div>
		<div class="col-sm-3 r3"></div>
		<div class="col-sm-3 r4"></div>
		</div>
	</div>
	
	<script>
		$(window).ready( function(){
			$(".ca1").on("click", function() {
				$.ajax({
					url : "ajax/e.txt" ,
					type : "get" ,
					dataType : "text" ,
					success : function(text) {
						console.log(text);
						$(".r1").append(text);
					} ,
					error : function(xhr, textStatus, errorThrown) {
						$(".r1").html(textStatus + "(http-" + xhr.status + "/" + errorThrown);
					}
				});
			});
			$(".ca2").on("click", function() {
				$.ajax({
					url : "ajax/ee.txt" ,
					type : "get" ,
					dataType : "text" ,
					success : function(text) {
						console.log(text);
						$(".r2").append(text);
					} ,
					error : function(xhr, textStatus, errorThrown) {
						$(".r2").html(textStatus + "(http-" + xhr.status + "/" + errorThrown);
					}
				});
			});
			$(".ca3").on("click", function() {
				$.ajax({
					url : "ajax/eee.txt" ,
					type : "get" ,
					dataType : "text" ,
					success : function(text) {
						console.log(text);
						$(".r3").html(text);
					} ,
					error : function(xhr, textStatus, errorThrown) {
						$(".r3").html(textStatus + "(http-" + xhr.status + "/" + errorThrown);
					}
				});
			});
			$(".ca4").on("click", function() {
				$.ajax({
					url : "ajax/eeee.txt" ,
					type : "get" ,
					dataType : "text" ,
					success : function(text) {
						console.log(text);
						$(".r4").html(text);
					} ,
					error : function(xhr, textStatus, errorThrown) {
						$(".r4").html(textStatus + "(http-" + xhr.status + "/" + errorThrown);
					}
				});
			});
		});
	</script>
<%@ include file='../inc/footer.jsp' %>

	



