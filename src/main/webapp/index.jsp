<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
session.invalidate(); // 세션 무효화
<<<<<<< HEAD
response.sendRedirect(request.getContextPath() + "/main.crud");%> 
=======
response.sendRedirect("main.crud");%> 	
>>>>>>> branch 'master' of https://github.com/Myotonic/crud.git
