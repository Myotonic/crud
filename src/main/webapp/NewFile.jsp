<%@page import="org.apache.tomcat.util.http.fileupload.RequestContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="inc/header.jsp" %>
	
	<div class="container text-center" id="qqqeee">
		<div class="dropdown text-center">
			<button class="btn btn-default dropdown-toggle" data-toggle="dropdown"><img alt="icon" src="icon.png">
			 <span class="caret"></span></button>
			<ul class="dropdown-menu">
    			<li><a href="#">카테고리1</a></li>
    			<li><a href="#">카테고리2</a></li>
    			<li><a href="#">카테고리3</a></li>
 			 </ul>
		</div>
		
		<div class="dropdown text-center">
			<button class="btn btn-default dropdown-toggle" data-toggle="dropdown"><img alt="icon" src="icon.png">
			 <span class="caret"></span></button>
			<ul class="dropdown-menu">
    			<li><a href="#">카테고리1</a></li>
    			<li><a href="#">카테고리2</a></li>
    			<li><a href="#">카테고리3</a></li>
 			 </ul>
		</div>
		
		<div class="dropdown text-center">
			<button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
			<img alt="icon" src="icon.png">
			 <span class="caret"></span></button>
			<ul class="dropdown-menu">
    			<li><a href="#">카테고리1</a></li>
    			<li><a href="#">카테고리2</a></li>
    			<li><a href="#">카테고리3</a></li>
 			 </ul>
		</div>
		
		<div class="dropdown text-center">
			<button class="btn btn-default dropdown-toggle" data-toggle="dropdown"><img alt="icon" src="icon.png">
			 <span class="caret"></span></button>
			<ul class="dropdown-menu">
    			<li><a href="#">카테고리1</a></li>
    			<li><a href="#">카테고리2</a></li>
    			<li><a href="#">카테고리3</a></li>
 			 </ul>
		</div>
		
		<div class="dropdown text-center">
			<button class="btn btn-default dropdown-toggle" data-toggle="dropdown"><img alt="icon" src="icon.png">
			 <span class="caret"></span></button>
			<ul class="dropdown-menu">
    			<li><a href="#">카테고리1</a></li>
    			<li><a href="#">카테고리2</a></li>
    			<li><a href="#">카테고리3</a></li>
 			 </ul>
		</div>
	</div>
	
	<div class="panel">
		<div class="panel-body">
			<span class="glyphicon glyphicon-plus">제목</span><p></p>
		</div>
	</div>

	<script>
	
		$(document).ready(function(){
			var dropdownContents = $('.dropdown-content');
			
			$('.dropdown-icon').click(function(){
				var dropdownId = $(this).data('dropdown-id');
				var dropdownContent = $('#dropdown-content-' + dropdownId);
				
				dropdownContents.not(dropdownContent).hide();
				
				dropdownContent.toggle();
			});
			
			$(document).click(function(e){
				var target = e.target;
				
				if(!$(target).hasClass('dropdown-icon')) {
					dropdownContents.hide();
				}
				
			})
			
			
		})
		
	
	</script>

	
	<%@ include file="inc/footer.jsp" %>
<!-- 
	
 -->