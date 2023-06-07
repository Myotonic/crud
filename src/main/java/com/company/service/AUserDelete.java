package com.company.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
=======
import com.crud.dao.AdminDao;
>>>>>>> branch 'master' of https://github.com/Myotonic/crud.git
import com.company.dto.UserDto;
import com.company.dto.UserExpertCategoryCityDto;
import com.crud.dao.AdminDao;

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
