package com.crud.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.MDao;
import com.crud.dto.Category1Dto;
import com.crud.dto.MDto;

public class MarketRead implements MarketService{

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		List<Category1Dto> category = new ArrayList<>();
		List<MDto> dto = null;
		MDao dao = new MDao();
		String division = request.getParameter("mDivision");
		String category1_id = request.getParameter("category1_id");
		dto = dao.readMarket(division==null? "상품":division, category1_id==null? 0: Integer.parseInt(category1_id),
				request.getParameter("market_count") ==null? 0:Integer.parseInt(request.getParameter("market_count")));
		category = dao.category1();
		request.setAttribute("mDtoList", dto);
		request.setAttribute("mCategory", category);
	}

}
