package com.company.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dto.AdminDto;
import com.crud.dao.AdminDao;

public class ADupl implements AAction {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		AdminDao dao = new AdminDao();
		AdminDto dto = new AdminDto();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		dto.setAdmin_email(request.getParameter("id"));
		
		AdminDto result = dao.IdCheck(dto);
		int idDouble =-1;
		
		if(request.getParameter("id").equals(result.getAdmin_email())) {
			
			System.out.println("id 중복.");
			
			
			out.println(idDouble);
			
		}
		else {
			
			idDouble = 1;
			
			out.println(idDouble);
			
		}
		
		
	}

}
