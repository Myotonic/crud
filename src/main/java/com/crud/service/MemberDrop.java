package com.crud.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.MemberDao;

public class MemberDrop implements MemberService {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int user_id = (int) request.getSession().getAttribute("member"); // 탈퇴할 회원의 email 가져오기

        MemberDao dao = new MemberDao();
        
        if (dao.deleteMember(user_id)) {
			request.getSession().invalidate(); // 세션 무효화
        	out.println("<script>alert('탈퇴 성공');</script>");
		}else {
			out.println("<script>alert('탈퇴 실패');</script>");
		}
		
	}

}
