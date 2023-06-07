<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file='../inc/header.jsp' %>

	<div class="container">
		<h3>서비스 요청하기</h3>
		
		<div class="container well">
		
		<div class="col">
			<div class="col-sm-3 ca1 text-center"><img alt="ddd" src="img/lesson.png"><strong>레슨</strong></div>
			<div class="col-sm-3 ca2 text-center"><img alt="ddd" src="img/living.png"><strong>홈/리빙</strong></div>
			<div class="col-sm-3 ca3 text-center"><img alt="ddd" src="img/design.png"><strong>디자인/개발</strong></div>
			<div class="col-sm-3 ca4 text-center"><img alt="ddd" src="img/guitar.png"><strong>기타</strong></div>
		</div>
		
		</div>
		
		<div class="col">
		<div class="col-sm-3 r1 text-center"></div>
		<div class="col-sm-3 r2 text-center"></div>
		<div class="col-sm-3 r3 text-center"></div>
		<div class="col-sm-3 r4 text-center"></div>
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
						$(".r1").html(text);
						$(".r2").html("");
						$(".r3").html("");
						$(".r4").html("");
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
						$(".r2").html(text);
						$(".r1").html("");
						$(".r3").html("");
						$(".r4").html("");
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
						$(".r3").html(text);
						$(".r2").html("");
						$(".r1").html("");
						$(".r4").html("");
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
						$(".r4").html(text);
						$(".r2").html("");
						$(".r3").html("");
						$(".r1").html("");
					} ,
					error : function(xhr, textStatus, errorThrown) {
						$(".r4").html(textStatus + "(http-" + xhr.status + "/" + errorThrown);
					}
				});
			});
		});
	</script>
<%@ include file='../inc/footer.jsp' %>

	



