package com.company.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.AdminDao;
import com.company.dto.UserDto;

public class AUserEditView implements AAction {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 AdminDao dao = new AdminDao();
		 UserDto dto = new UserDto();
		
		 dto.setUser_id(Integer.parseInt(request.getParameter("user_id")));
		 
		 
		
		 
		 request.setAttribute("list", dao.exportDetail(dto));
		
	}

}
