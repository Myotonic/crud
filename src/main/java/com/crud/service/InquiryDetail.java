package com.crud.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.MDao;
import com.crud.dto.Inquiry;

public class InquiryDetail implements MarketService{

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		Inquiry inquiry = new Inquiry();
		MDao dao = new MDao();
		int inquiry_id = Integer.parseInt(request.getParameter("inquiry_id"));
		inquiry= dao.detailInquiry(inquiry_id);
		System.out.println(inquiry);
		request.setAttribute("mInquiry", inquiry);
	}

}
