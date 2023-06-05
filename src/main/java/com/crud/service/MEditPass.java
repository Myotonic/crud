package com.crud.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.MemberDao;
import com.crud.dto.UserDto;

public class MEditPass implements MemberService {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		MemberDao dao = new MemberDao();
		int user_id = (int) request.getSession().getAttribute("member");
		UserDto dto = dao.getUser(user_id);
		String email = dto.getUser_email();
		String newPass = request.getParameter("newPass");
		
		if(dao.updatePassword(email, newPass)) {
			out.println("<script>alert('변경 성공');</script>");
		}else {
			out.println("<script>alert('변경 실패');</script>");
		}
	}

}
