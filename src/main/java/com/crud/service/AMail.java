package com.crud.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.AdminDao;
import com.crud.dto.AdminDto;

public class AMail implements AAction {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminDao dao = new AdminDao();
		AdminDto dto = new AdminDto();
		
		PrintWriter out = response.getWriter();
		
		
		dto.setAdmin_email(request.getParameter("admin_email"));
		dto.setAdmin_pass(request.getParameter("admin_pass"));
		
		
		
		if(dao.newPass(dto) > 0) {
			
			out.println("<script>alert('암호가 변경되었습니다.');</script>");
			
			out.println("<script>location.href='home.admin';</script>");
			
			
		}else {
			
			System.out.println("암호변경 안됨.");
			
		}
		
		
		
		
	}

}
