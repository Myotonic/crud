package com.crud.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.MemberDao;

public class MLogin implements MemberService {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		PrintWriter out = response.getWriter();
		
		MemberDao dao = new MemberDao();
		
		String result = dao.login(email, pass);
		if(result!=null) {
			request.getSession().setAttribute("memberValue", result);
			int user_id = dao.getUserId(email);
			if(result.equals("expert")) {
				request.getSession().setAttribute("expert", dao.getExpertId(user_id) );
			}
			request.getSession().setAttribute("member", user_id);
		}else {
			out.println("<script>alert('로그인 실패'); location.href='"+request.getContextPath()+"/loginV.crud'; </script>");
		}
	}

}
