package com.crud.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.MDao;
import com.crud.dto.MDto;

public class MarketDetail implements MarketService{

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		MDto dto = new MDto();
		MDao dao = new MDao();
		dto = dao.detailMarket(Integer.parseInt(request.getParameter("market_id")));
		request.setAttribute("marketDetailDto", dto);
	}

}
