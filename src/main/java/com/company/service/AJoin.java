package com.company.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
=======
import com.crud.dao.AdminDao;
>>>>>>> branch 'master' of https://github.com/Myotonic/crud.git
import com.company.dto.AdminDto;
import com.crud.dao.AdminDao;

public class AJoin implements AAction {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		AdminDao dao = new AdminDao();
		AdminDto dto = new AdminDto();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		
		dto.setAdmin_email(request.getParameter("email"));
		dto.setAdmin_name(request.getParameter("name"));
		dto.setAdmin_pass(request.getParameter("pass"));
		
		
		
		
		dao.join(dto);
		
		
		
		
//		dto.setAdmin_email(request.getParameter("id"));
//		
//		AdminDto result = dao.IdCheck(dto);
//		
//		if(request.getParameter("id").equals(result.getAdmin_email())) {
//			
//			System.out.println("id 중복.");
//			out.println("이미 사용중인 아이디 입니다.");
//			
//		}
//		else {
//			
//			out.println("사용 가능한 아이디 입니다.");
//			
//			
//		}
		
		
		
		
		
	}

}
