package com.crud.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.AdminDao;
import com.crud.dto.ExpertDto;
import com.crud.dto.UserDto;
import com.crud.dto.UserExpertDto;

public class AUserDetail implements AAction {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getSession().getAttribute("email") != null) {
		
		
		
		 AdminDao dao = new AdminDao();
		 UserDto dto = new UserDto();
		
		 dto.setUser_id(Integer.parseInt(request.getParameter("user_id")));
		 
		 
		
		 
		 request.setAttribute("list", dao.exportDetail(dto));
		
		 
		 
	}else {
		
		request.getRequestDispatcher("/home.admin").forward(request, response);
		
		
	}
		
		
	}

}
