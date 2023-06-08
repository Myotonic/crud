package com.company.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dto.Category1Dto;
import com.company.dto.Category2Dto;
import com.company.dto.CategoryDto;
import com.company.dto.UserExpertCategoryCityDto;
import com.crud.dao.AdminDao;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ACategory implements AAction {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		 AdminDao dao = new AdminDao();
		 UserExpertCategoryCityDto dto = new UserExpertCategoryCityDto();
		 CategoryDto category = new CategoryDto();
		 Category1Dto category1 = new Category1Dto();
		 
		 //category1.setCategory1_name("레슨");
		 category1.setCategory1_id(Integer.parseInt(request.getParameter("category1_name")));
		 category.setCategory1(category1);
		 dto.setCategory(category);
		 
		 PrintWriter out = response.getWriter();
		 
		 
		 
		 request.setAttribute("category1", dao.category1(dto));
		
		 JsonArray list = new JsonArray();
		 
		 
		 
		 List<Category2Dto> clist = dao.category1(dto);
		
		 
		 
		 for(Category2Dto  c : clist) {
			 
			 JsonObject j1 = new JsonObject();
			 
			 
			 
			 j1.addProperty("category2_name", c.getCategory2_name());
			 
			 list.add(j1);
			 
			 
		 }
		 
		
		 
		 
		 
		 out.println(list);
		 
		 
	}

}
