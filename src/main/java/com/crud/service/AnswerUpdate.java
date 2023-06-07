package com.crud.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.MDao;
import com.crud.dto.Answer;
import com.crud.dto.Inquiry;

public class AnswerUpdate implements MarketService{

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		Answer answer = new Answer();
		answer.setInquiry_id(Integer.parseInt(request.getParameter("inquiry_id")));
		answer.setAnswer(request.getParameter("answer"));
		MDao dao = new MDao();
		PrintWriter out = response.getWriter();
		String result = "관리자에게 문의하세요.";
		
		if(dao.updateAnswer(answer)>0) {
			result = "수정에 성공했습니다.";
		}
		out.println("<script>alert('"+result+"');</script>");		
		
	}

}
