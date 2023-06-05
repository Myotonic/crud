package com.crud.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.MemberDao;

public class MPass implements MemberService {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String email = request.getParameter("email");	//값..... 가져오기
		String newPassword = request.getParameter("newPass");

		MemberDao dao = new MemberDao();
		boolean success = dao.updatePassword(email, newPassword);

		if (success) {
		    // 비밀번호 수정 성공
		} else {
		    // 비밀번호 수정 실패
		}
		
	}

}
