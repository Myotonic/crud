package com.crud.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.MDao;
import com.crud.dto.Answer;

public class AnswerCreate implements MarketService{

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		MDao dao = new MDao();
		String result = "관리자에게 문의하세요.";
		PrintWriter out = response.getWriter();
		Answer answer = new Answer();
		answer.setAnswer(request.getParameter("answer"));
		answer.setExpert_id(Integer.parseInt(request.getParameter("expert_id")));
		int inquiry_id = Integer.parseInt(request.getParameter("inquiry_id"));
		if(dao.createAnswer(inquiry_id, answer)>0) {
			result = "답변에 성공했습니다.";
		}
		out.println("<script>alert('"+result+"');</script>");
	}

}
