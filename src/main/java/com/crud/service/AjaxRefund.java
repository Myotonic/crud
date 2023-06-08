package com.crud.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.MDao;

public class AjaxRefund implements MarketService{

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MDao dao = new MDao();
		int result = dao.deleteUser_Market(Integer.parseInt(request.getParameter("market_id")), Integer.parseInt(request.getParameter("user_id")));
		String result2="환불 요청 실패";
		PrintWriter out = response.getWriter();
		if(result >0) {
			out.println("환불요청 성공");
		}
		out.println(result2);
	}

}
