package com.crud.requestService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.requestdao.RequestDao;

public class EstimatedList implements RequestService{
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int request_id = Integer.parseInt(request.getParameter("request_id"));
		
		request.setAttribute("estimatedList", new RequestDao().estimatedList(request_id));
		System.out.println(request.getAttribute("estimatedList"));
		request.setAttribute("request_id", request_id);
		System.out.println(request.getAttribute("request_id"));
		request.getRequestDispatcher("/request/requestEstimateList.jsp").forward(request, response);
	}
}
