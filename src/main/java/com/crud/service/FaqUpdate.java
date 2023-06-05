package com.crud.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.MDao;
import com.crud.dto.Faq;

public class FaqUpdate implements MarketService{

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		Faq faq = new Faq();
		MDao dao = new MDao();
		PrintWriter out = response.getWriter();
		String result = "관리자에게 문의하세요.";
		faq.setTitle(request.getParameter("fTitle"));
		faq.setContent(request.getParameter("fContent"));
		faq.setMarket_id(Integer.parseInt(request.getParameter("market_id")));
		if(dao.updateFaq(faq)>0) {
			result = "faq수정에 성공했습니다.";
		}
		out.println("<script>alert('"+result+"');</script>");
		
	}

}
