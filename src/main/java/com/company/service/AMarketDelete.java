package com.company.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
=======
import com.crud.dao.AdminDao;
>>>>>>> branch 'master' of https://github.com/Myotonic/crud.git
import com.company.dto.MarketDto;
import com.company.dto.UserMarketCategoryDto;
import com.crud.dao.AdminDao;

public class AMarketDelete implements AAction {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminDao dao = new AdminDao();
		UserMarketCategoryDto dto = new UserMarketCategoryDto();
		MarketDto market = new MarketDto();
		market.setMarket_id(Integer.parseInt(request.getParameter("market_id")));
		
		dto.setMarket(market);
		dao.MarketDelete(dto);
		
	}

}
