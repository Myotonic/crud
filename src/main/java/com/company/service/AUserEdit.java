package com.company.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dto.AreaCityDto;
import com.company.dto.Category2Dto;
import com.company.dto.CategoryDto;
import com.company.dto.CityDto;
import com.company.dto.ExpertDto;
import com.company.dto.UserDto;
import com.company.dto.UserExpertCategoryCityDto;
import com.crud.dao.AdminDao;

public class AUserEdit implements AAction {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminDao dao = new AdminDao();
		
		
		UserDto user = new UserDto();
		ExpertDto expert = new ExpertDto();
		Category2Dto category2 = new Category2Dto();
		AreaCityDto Areacity = new AreaCityDto();
		CategoryDto category = new CategoryDto();
		CityDto city = new CityDto();
		
		
		
		
		UserExpertCategoryCityDto dto = new UserExpertCategoryCityDto();
		
		user.setUser_name(request.getParameter("user_name"));
		user.setUser_id(Integer.parseInt(request.getParameter("user_id")));
		
		
		expert.setExpert_intro(request.getParameter("expert_intro"));
		expert.setExpert_range(request.getParameter("expert_range"));
		
		
		category2.setCategory2_name(request.getParameter("category2_name"));
		
		category.setCategory2(category2);

		
		city.setCity_name(request.getParameter("city_name"));
		
		Areacity.setCity(city);
	
		
		
		
		dto.setExpert(expert);
		dto.setUser(user);
		dto.setCategory(category);
		dto.setCity(Areacity);
		
		
		dao.expertEdit(dto);
		
		
	}

}
