package com.crud.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.MDao;
import com.crud.dto.MDto;

public class InquiryRead implements MarketService{

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		MDto dto = new MDto();
		MDao dao = new MDao();
		int id = 0;
		String where = "";
		if(request.getSession().getAttribute("memberValue").equals("user")) {
			id = Integer.parseInt(request.getParameter("user_id"));
			where = "user_id";
		}else {
			id = Integer.parseInt(request.getParameter("user_id"));
			where="expert_id";
		}
		dto = dao.readInquiry(id, where);
		request.setAttribute("iList", dto);
	}

}
