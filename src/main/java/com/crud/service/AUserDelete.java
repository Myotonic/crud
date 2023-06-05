package com.crud.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.AdminDao;
import com.crud.dto.UserDto;
import com.crud.dto.UserExpertCategoryCityDto;

public class AUserDelete implements AAction {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminDao dao = new AdminDao();
		UserExpertCategoryCityDto dto = new UserExpertCategoryCityDto();
		UserDto user = new UserDto();
		user.setUser_id(Integer.parseInt(request.getParameter("user_id")));
		
		
		dto.setUser(user);
		
		
		
		
		dao.expertDelete(dto);
		
		
		
	}

}
