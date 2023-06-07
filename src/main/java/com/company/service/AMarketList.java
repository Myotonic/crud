package com.company.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.AdminDao;

public class AMarketList implements AAction {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getSession().getAttribute("email") != null) {

		
		
		AdminDao dao = new AdminDao();
		
		request.setAttribute("marketlist", dao.marketList());
		
		}else {
			
			request.getRequestDispatcher("/home.admin").forward(request, response);
			
			
		}
		
		
	}

}
