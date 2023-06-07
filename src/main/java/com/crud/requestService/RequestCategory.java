package com.crud.requestService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.requestdao.RequestDao;

public class RequestCategory implements RequestService{
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int category2_id = Integer.parseInt(request.getParameter("category2_id"));
		
		request.setAttribute("dto", new RequestDao().requestMainCategory(category2_id));
		request.getRequestDispatcher("/request/requestCreate.jsp").forward(request, response);
	}
}
