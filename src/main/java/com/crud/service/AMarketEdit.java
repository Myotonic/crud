package com.crud.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.AdminDao;
import com.crud.dto.Category1Dto;
import com.crud.dto.Category2Dto;
import com.crud.dto.CategoryDto;
import com.crud.dto.MarketDto;
import com.crud.dto.UserMarketCategoryDto;

public class AMarketEdit implements AAction {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		AdminDao dao = new AdminDao();
		UserMarketCategoryDto dto = new UserMarketCategoryDto();
		MarketDto market = new MarketDto();
		CategoryDto category = new CategoryDto();
		Category1Dto category1 = new Category1Dto();
		Category2Dto category2 = new Category2Dto();
		
		
		market.setTitle(request.getParameter("title"));
		market.setContent(request.getParameter("content"));
		market.setDate(request.getParameter("date"));
		market.setPrice(Integer.parseInt(request.getParameter("price")));
		market.setRefund(request.getParameter("refund"));
		market.setDivision(request.getParameter("division"));
//		market.setCategory1_id(Integer.parseInt(request.getParameter("category1")));
//		market.setCategory2_id(Integer.parseInt(request.getParameter("category2")));
		market.setMarket_id(Integer.parseInt(request.getParameter("market_id")));
		
		category1.setCategory1_name(request.getParameter("category1_name"));
		category2.setCategory2_name(request.getParameter("category2_name"));
		
		category.setCategory1(category1);
		category.setCategory2(category2);
		
		  
		dto.setMarket(market);
		dto.setCategory(category);
		  
		
		dao.MarketEdit(dto);
		
		
		
	}

	
	
}
