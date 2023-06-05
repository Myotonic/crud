<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<div class="container">
  <h3>${marketDetailDto.title}</h3>  
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
	<!-- Indicators -->
	<ol class="carousel-indicators">
		<c:forEach var="i" begin="0" end="${marketDetailDto.images.size() - 1}"
			varStatus="status">
			<li data-target="#myCarousel" data-slide-to="${i}"
				<c:if test="${status.first}">class="active"</c:if>></li>
		</c:forEach>
	</ol>

	<!-- Wrapper for slides -->
	<div class="carousel-inner" role="listbox">
		<c:forEach var="dto" items="${marketDetailDto.images}" varStatus="status">
			<div class="item <c:if test="${status.first}">active</c:if>">
				<img src="/images/${dto}" alt="이미지">
			</div>
		</c:forEach>
	</div>


    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
<%@ include file="../inc/footer.jsp" %>