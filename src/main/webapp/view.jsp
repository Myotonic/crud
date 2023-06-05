<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="inc/header.jsp" %>

	<div class="container panel panel-success">
		<h3 class="panel-heading">FORM BASIC-PLUS</h3>
		 <button onclick="openPopup()">Open Popup</button>
		
		<script>
			function openPopup() {
        	    var popup = window.open("popup.jsp", "Popup Page", "width=500,height=300");
			}
    	</script>
		
	</div>
<%@ include file="inc/footer.jsp" %>