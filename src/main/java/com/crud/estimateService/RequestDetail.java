package com.crud.estimateService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.requestdao.EstimateDao;

public class RequestDetail implements EstimateService{
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int request_id = Integer.parseInt(request.getParameter("request_id"));
		int status = Integer.parseInt(request.getParameter("status"));
		
		request.setAttribute("requestDetailDto", new EstimateDao().requestDetail(request_id));
		request.setAttribute("status", status);
		request.getRequestDispatcher("/estimate/estimateDetail.jsp").forward(request, response);
	}
}
