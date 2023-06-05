package com.crud.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.MemberDao;

public class MCategory1 implements MemberService {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		MemberDao dao = new MemberDao();
		request.setAttribute("dto", dao.category1());
		//id값 저장 category2가 받음
	}

}
