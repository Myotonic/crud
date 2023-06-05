package com.company.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dto.MarketDto;
import com.company.dto.UserMarketCategoryDto;
import com.crud.dao.AdminDao;

public class AMarketDetail implements AAction {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("email") != null) {
			
		
		AdminDao dao = new AdminDao();
		UserMarketCategoryDto dto = new UserMarketCategoryDto();
		MarketDto market = new MarketDto();
		
		market.setMarket_id(Integer.parseInt(request.getParameter("market_id")));
		
		
		
		dto.setMarket(market);
		
		
		request.setAttribute("list", dao.marketDetail(dto));
		
		}else {
			
			request.getRequestDispatcher("/home.admin").forward(request, response);
			
			
		}
		
	}

}
