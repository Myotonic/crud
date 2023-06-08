package com.crud.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.MDao;

public class MarketBuy implements MarketService{

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		MDao dao = new MDao();
		String result = "관리자에게 문의하세요.";
		PrintWriter out = response.getWriter();
		int user_id = (int) request.getSession().getAttribute("member");
		int market_id = Integer.parseInt(request.getParameter("market_id"));
		if(dao.marketBuy(user_id, market_id)>0) {
			result = "구입에 성공했습니다.";
		}
		out.println("<script>alert('"+result+"');</script>");
	}

}
