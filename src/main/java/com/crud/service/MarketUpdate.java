package com.crud.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.MDao;
import com.crud.dto.MDto;

public class MarketUpdate implements MarketService{

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		MDto dto = new MDto();
		MDao dao = new MDao();
		PrintWriter out = response.getWriter();
		String result = "관리자에게 문의하세요.";
		dto.setMarket_id(Integer.parseInt(request.getParameter("market_id")));
		dto.setTitle(request.getParameter("mTitle"));
		dto.setContent(request.getParameter("mContent"));
		dto.setPrice(Integer.parseInt(request.getParameter("mPrice")));
		dto.setRefund(request.getParameter(request.getParameter("mRefund")));
		
		if(dao.updateMarket(dto)>0) {
			result = "수정에 성공했습니다.";
		}
		out.println("<script>alert('"+result+"');</script>");
	}

}
