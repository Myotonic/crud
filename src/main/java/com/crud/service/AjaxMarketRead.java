package com.crud.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.MDao;
import com.crud.dto.MDto;
import com.google.gson.Gson;

public class AjaxMarketRead implements MarketService{

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		List<MDto> dto = null;
		MDao dao = new MDao();
		String division = request.getParameter("mDivision");
		String category1_id = request.getParameter("category1_id");
		dto = dao.readMarket(division==null? "상품":division, category1_id==null? 0: Integer.parseInt(category1_id),
				request.getParameter("market_count") ==null? 0:Integer.parseInt(request.getParameter("market_count")));
		Gson gson = new Gson();
		String json = gson.toJson(dto);
		response.getWriter().write(json);
	}

}
