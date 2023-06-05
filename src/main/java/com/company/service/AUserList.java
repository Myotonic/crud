package com.company.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.AdminDao;
import com.crud.dto.ExpertDto;
import com.company.dto.UserExpertDto;


public class AUserList implements AAction {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("email") != null) {
		
		
		 AdminDao dao = new AdminDao();

		
		
		 
		 request.setAttribute("userlist", dao.exportList());
		
		 
		}else {
			
			request.getRequestDispatcher("/home.admin").forward(request, response);
			
			
		}
		 
		
		
	}

}
