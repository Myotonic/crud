<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container panel panel-info">
   <h3 class="panel-heading">공지사항</h3>
   
   <div class="panel-body">
   이 포트폴리오는 상업적 목적이 아닌 개인 포트폴리오 용도로 제작되었으며,
   홈페이지의 일부 내용과 기타 이미지 등의 그 출처가 따로 있음을 밝힙니다.
   
   </div>
   <div class="panel-body">
   <h4>포트폴리오 풀 동영상 보러가기</h4>
   <img src="${pageContext.request.contextPath}/imgs/QRCodeImg.jpg" alt="포트폴리오 풀 동영상 qr코드" />
   
   </div>
   <div class="panel-footer">
   		<input type="checkbox" id="subpop" name="subpop"/>
   		<label for="subpop">오늘 하루동안 이 창을 열지 않음.</label>
   		<input type="button" value="닫기." title="닫기." id="close"/>  
   </div>
   
 
 
</div>
</body>
</html>