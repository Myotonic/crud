package com.crud.requestService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.requestdao.RequestDao;

public class EstimateDetail implements RequestService{
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int estimate_id = Integer.parseInt(request.getParameter("estimate_id"));
		int request_id = Integer.parseInt(request.getParameter("request_id"));
		
		request.setAttribute("estimateDetailDto", new RequestDao().estimateDetail(estimate_id));
		request.setAttribute("estimate_id", estimate_id);
		request.setAttribute("request_id", request_id);
		request.getRequestDispatcher("/request/requestEstimateDetail.jsp").forward(request, response);
	}
}
