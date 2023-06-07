package com.crud.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.MDao;
import com.crud.dto.Inquiry;

public class MarketInquiry implements MarketService{

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		MDao dao = new MDao();
		Inquiry inquiry = new Inquiry();
		PrintWriter out = response.getWriter();
		String result = "관리자에게 문의하세요";
		inquiry.setCategory(request.getParameter("iCategory"));
		inquiry.setTitle(request.getParameter("iTitle"));
		inquiry.setContent(request.getParameter("iContent"));
		inquiry.setMarket_id(Integer.parseInt(request.getParameter("market_id")));
		inquiry.setUser_id((int) request.getSession().getAttribute("member"));
		if(dao.createInquiry(inquiry)>0) {
			result = "문의작성을 완료했습니다.";
		}
		out.println("<script>alert('"+result+"');</script>");
	}

}
