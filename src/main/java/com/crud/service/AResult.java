package com.crud.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.AdminDao;
import com.crud.dto.AdminDto;
import com.mysql.cj.Session;

public class AResult implements AAction {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession() != null) {


		AdminDao dao = new AdminDao();
		
		AdminDto dto = new AdminDto();
		
		//AdminDto dto2 = new AdminDto();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		

		//dto2.setAdmin_email(request.getParameter("email"));
		//dto2.setAdmin_pass(request.getParameter("pass"));
		
		//request.setAttribute("login", dao.login(dto2));
		
		
//		request.setAttribute("dto", dao.result(dto));
		
		
		dto.setAdmin_email(request.getParameter("email"));
		
		AdminDto result = dao.result(dto);
		
		if(result==null) {
			
			
			dto.setAdmin_email((String)request.getSession().getAttribute("email"));
			
			result = dao.result(dto);
			
		}
		
		
		
		request.getSession().setAttribute("dto", result);
		
		
		}else {
			
			request.getRequestDispatcher("/home.admin").forward(request, response);
			
			
		}
		
		
		
		
	}

}
