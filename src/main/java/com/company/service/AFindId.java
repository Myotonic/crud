package com.company.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dto.AdminDto;
import com.crud.dao.AdminDao;

public class AFindId implements AAction {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		AdminDao dao = new AdminDao();
		AdminDto dto = new AdminDto();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		
		dto.setAdmin_name(request.getParameter("name"));
		dto.setAdmin_num(Integer.parseInt(request.getParameter("admin_num")));
		
		
		AdminDto result = dao.findId(dto);
		
		
		

		if(request.getParameter("name").equals(result.getAdmin_name()) && request.getParameter("admin_num").equals(String.valueOf(result.getAdmin_num()))) {
			
			System.out.println("id찾기 성공");
			
			
			
			
			request.setAttribute("admin_num", result.getAdmin_num());
			request.setAttribute("name", result.getAdmin_name());
			request.setAttribute("date", result.getAdmin_date());
			request.setAttribute("email", result.getAdmin_email());
			
			
			
			
			
			request.getRequestDispatcher("/admin/admin_find_id.jsp").forward(request, response);

			
		}else {
			
			System.out.println("id찾기 안됨.");
			out.println("<script>alert('사원번호 또는 이름이 틀렸습니다.');</script>");
			out.println("<script>location.href='login_id_form.admin';</script>");
			
			
		}
		
		
		
		
	}

}
