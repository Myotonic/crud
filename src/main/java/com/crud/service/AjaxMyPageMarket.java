package com.crud.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.MDao;
import com.crud.dto.MDto;
import com.google.gson.Gson;

public class AjaxMyPageMarket implements MarketService{

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		List<MDto> list = new ArrayList<>();
		MDao dao = new MDao();
		if(request.getSession().getAttribute("memberValue").equals("user")) {
			list = dao.userMarket(request.getParameter("mDivision")==null? "상품" : request.getParameter("mDivision") , (int)(request.getSession().getAttribute("member"))
					,request.getParameter("market_count") ==null? 0:Integer.parseInt(request.getParameter("market_count")));
		}else {
			list = dao.expertMarket(request.getParameter("mDivision")==null? "상품" : request.getParameter("mDivision") , (int)(request.getSession().getAttribute("expert_id"))
					,request.getParameter("market_count") ==null? 0:Integer.parseInt(request.getParameter("market_count")));
		}
		Gson gson = new Gson();
		String json = gson.toJson(list);
		response.getWriter().write(json);
	}

}
