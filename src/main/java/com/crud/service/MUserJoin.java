package com.crud.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.MemberDao;
import com.crud.dto.UserDto;

public class MUserJoin implements MemberService {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		UserDto dto = new UserDto();
		dto.setUser_name(request.getParameter("name"));
		dto.setUser_email(request.getParameter("email"));
		dto.setUser_pass(request.getParameter("pass"));
		
		MemberDao dao = new MemberDao();
		 if (dao.insertUser(dto) > 0) { 
		    out.println("<script>alert('가입 성공! 로그인 후 사용하세요'); </script>");
		 }else {
			out.println("<script>alert('가입 실패'); location.href='history.go(-1)'; </script>");
		 }
	}

}
