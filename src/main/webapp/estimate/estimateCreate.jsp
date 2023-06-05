<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file='../inc/header.jsp' %>
	<div class="container panel panel-success">
		<h3 class="panel-heading">요청서 상세</h3>
		<div class="form-group r1">
		</div>
			<button class="btn btn-info text-center" id="nextbtn">다음</button>
	</div>
	
	<script>
		$(function() {
			var content = "";
			var price = "";
			
			$.ajax({
				url : "ajax/estimate.txt" ,
				type : "get" ,
				dataType : "text" ,
				success : function(text) {
					$(".r1").html(text);
					$("#content").on("change", function() {
						content = $("#content").val();
					});
				} ,
				error : function(xhr, textStatus, errorThrown) {
					console.log(textStatus + "(http-" + xhr.status + " / " + errorThrown);
				}
			});
					
			$("#nextbtn").on("click", function() {
				if(price == "") {
					$.ajax({
						url : "ajax/estimate2.txt" ,
						type : "get" ,
						dataType : "text" ,
						success : function(text) {
							$(".r1").html(text);
							$("#price").on("change", function(){
								price = $("#price").val();
								console.log(price);
							});
						} ,
						error : function(xhr, textStatus, errorThrown) {
							console.log(textStatus + "(http-" + xhr.status + " / " + errorThrown);
						}
					});
				} else {
					$.ajax({
						url : "${pageContext.request.contextPath}/create.estimate" ,
						type : "get" ,
						data : { "content" : content , "price" : price , "request_id" : ${param.request_id}} ,
						success : function(msg) {
							alert(msg);
							location.href='${pageContext.request.contextPath}/list.estimate';
						} ,
						error : function(xhr, textStatus, errorThrown) {
							console.log(textStatus + "(http-" + xhr.status + " / " + errorThrown);
						}
					});
				}
			});
		})
	</script>
	
<%@ include file='../inc/footer.jsp' %>