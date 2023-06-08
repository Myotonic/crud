package com.company.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.company.dto.AdminDto;
import com.crud.dao.AdminDao;

public class ALogin implements AAction{

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		AdminDao dao = new AdminDao();
		AdminDto dto = new AdminDto();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		
		dto.setAdmin_email(request.getParameter("email"));
		dto.setAdmin_pass(request.getParameter("pass"));
		
		
		AdminDto result = dao.login(dto);
		
		if(request.getParameter("email").equals(result.getAdmin_email()) && request.getParameter("pass").equals(result.getAdmin_pass()) ) {
			
			System.out.println("로그인");
			request.getSession().setAttribute("email", request.getParameter("email"));
			
			request.getRequestDispatcher("/result.admin").forward(request, response);

			
		}else {
			
			System.out.println("로그인 안됨.");
			out.println("<script>alert('아이디 또는 비밀번호가 틀렸습니다.');</script>");
			out.println("<script>location.href='home.admin';</script>");
			
			
		}
		
		
		
	}

	
}
