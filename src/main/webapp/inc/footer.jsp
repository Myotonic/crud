<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<footer id="footer" class="container-fluid text-center">
<div class="col" style="">
	<div class="col-sm-4">
		<br /><br />
		<h1 class="logo text-center">CRUD</h1>
	</div>
	<div class="col-sm-3">
	</div>
	<div class="col-sm-4">
			<ul class="list-group col-sm-3">
			 <li class="list-group-item mylist">서비스 요청</li>
		      <li class="myList"><a href="${pageContext.request.contextPath}/request/home.jsp" class="btn">요청</a></li>
		      <li class="myList"><a href="${pageContext.request.contextPath}/request/home.jsp" class="btn">레슨</a></li>
		      <li class="myList"><a href="${pageContext.request.contextPath}/request/home.jsp" class="btn">홈/리빙</a></li>
		      <li class="myList"><a href="${pageContext.request.contextPath}/request/home.jsp" class="btn">디자인/개발</a></li>
		      <li class="myList"><a href="${pageContext.request.contextPath}/request/home.jsp" class="btn">기타</a></li>
		    </ul>
		    <ul class="list-group col-sm-3">
			 <li class="list-group-item mylist">클래스 마켓</li>
		      <li class="myList"><a href="${pageContext.request.contextPath}/marketView.crud" class="btn">MARKET</a></li>
		    </ul>
		    <ul class="list-group col-sm-3">
			 <li class="list-group-item mylist">커뮤니티</li>
		      <li class="myList"><a href="" class="btn">커뮤니티</a></li>
		    </ul>
		    <ul class="list-group col-sm-3">
			 <li class="myList mylist list-group-item">관리자 페이지</li>
		      <li class="myList"><a href="home.admin" class="btn">관리자<br/>로그인</a></li>
		    </ul>
		</div>
	</div>
		
		<div class="col-sm-12 myclarboth text-center">
			Copyright 2023 by Company. All Rights Reserved;
		</div>
</footer>

</body>
</html>
