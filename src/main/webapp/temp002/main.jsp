<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<div class="container panel panel-info">
	<h3 class="text-center">main</h3>
	<% 
		
	String value1="null";
		if(String.valueOf(session.getAttribute("memberValue"))!=null){
		value1 = String.valueOf(session.getAttribute("memberValue"));}
	int value2 = 0;
		if(session.getAttribute("member")!=null){value2=(int)session.getAttribute("member");}
	int value3 = 0;
		if(session.getAttribute("expert")!=null){value3=(int)session.getAttribute("expert");}
	%>
	<p><%=value1 %> : memberValue</p>
	<p><%=value2 %> : member</p>
	<p><%=value3 %> : expert</p>
</div>

<%@ include file="../inc/footer.jsp" %>