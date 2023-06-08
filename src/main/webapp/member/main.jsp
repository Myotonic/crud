<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<div class="container member-page">
	<h1 class="logo">CRUD</h1>
	<br>
	<div class="">
		<h3 class="text-center">서비스 요청하기</h3>
		
		<div class="well" style="height:88px;">
		
		<div class="col ">
			<div class="col-sm-3 ca1 "><img alt="레슨" src="${pageContext.request.contextPath}/imgs/lesson.png"><strong>레슨</strong></div>
			<div class="col-sm-3 ca2 "><img alt="홈/리빙" src="${pageContext.request.contextPath}/imgs/living.png"><strong>홈/리빙</strong></div>
			<div class="col-sm-3 ca3 "><img alt="디자인/개발" src="${pageContext.request.contextPath}/imgs/design.png"><strong>디자인/개발</strong></div>
			<div class="col-sm-3 ca4 "><img alt="기타" src="${pageContext.request.contextPath}/imgs/guitar.png"><strong>기타</strong></div>
		</div>
		
		<div class="col">
		<div class="col-sm-3 r1 "></div>
		<div class="col-sm-3 r2 "></div>
		<div class="col-sm-3 r3 "></div>
		<div class="col-sm-3 r4 "></div>
		</div>
		
		</div>
		
	</div>
	
	<br/>
	<hr/>
	<br/>

	<div class="">
		<div class="row">
			<div class="col-sm-6">
			<table class="table table-bordered">
			<caption><strong>마켓</strong></caption>
			<thead>
			<tr style="background-color: rgb(26, 188, 156); color: white;">						
				<th scope="col">CATEGORY</th>
				<th scope="col">MTITLE</th>
				<th scope="col">PRICE</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="market" items="${mDtoList}" varStatus="status">
			<tr>
				<td>${market.category2_name}</td>
				<td><a href="${pageContext.request.contextPath}/marketDetail.crud?market_id=${market.market_id}">${market.title}</a></td>
				<td>${market.price}</td>
			</tr>
			</c:forEach> 
			</tbody>
			</table>
			</div>
			<div class="col-sm-6">
			<table class="table table-bordered">
			<caption><strong>커뮤니티</strong></caption>
			<thead>
			<tr style="background-color: rgb(26, 188, 156); color: white;">				
				<th scope="col">BNO</th>
				<th scope="col">BTITLE</th>
				<th scope="col">BDATE</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="board" items="${bDtoList}" varStatus="status">
			<tr>
				<td>${board.board_no}</td>
				<td><a href="${pageContext.request.contextPath}/?board_no=${board.board_no}">${board.board_title}</a></td>
				<td>${board.board_upload_day}</td>
			</tr>
			</c:forEach> 
			</tbody>
			</table>
			</div>
		</div>
	</div>
</div>	
	<script>
		$(window).ready( function(){
			$(".ca1").on("click", function() {
				$.ajax({
					url : "${pageContext.request.contextPath}/ajax/e.txt" ,
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
					url : "${pageContext.request.contextPath}/ajax/ee.txt" ,
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
					url : "${pageContext.request.contextPath}/ajax/eee.txt" ,
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
					url : "${pageContext.request.contextPath}/ajax/eeee.txt" ,
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
<%@ include file="../inc/footer.jsp" %>