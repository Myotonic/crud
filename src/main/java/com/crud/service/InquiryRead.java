package com.crud.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.MDao;
import com.crud.dto.Inquiry;

public class InquiryRead implements MarketService{

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		List<Inquiry> list = new ArrayList<>();
		MDao dao = new MDao();
		int id = 0;
		String where = "";
		if(request.getSession().getAttribute("memberValue").equals("user")) {
			id = (int)request.getSession().getAttribute("member");
			where = "user_id";
		}else {
			id = (int)request.getSession().getAttribute("expert_id");
			where="m.expert_id";
		}
		list = dao.readInquiry(id, where,request.getParameter("inquiry_count") ==null? 0:Integer.parseInt(request.getParameter("inquiry_count")));
		request.setAttribute("iList", list);
	}

}
