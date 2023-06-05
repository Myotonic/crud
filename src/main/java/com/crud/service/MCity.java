package com.crud.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.MemberDao;
import com.crud.dto.CityDto;

public class MCity implements MemberService {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String name = request.getParameter("roadAddress");
		
		CityDto dto = new CityDto();
		dto.setCity_name(name);
		dto.setArea_id((int)request.getSession().getAttribute("area_id")); 

		MemberDao dao = new MemberDao();
		/*
		 * if (!dao.isCity(dto.getCity_name())) { int result = dao.insertCity(dto);
		 * 
		 * if (result > 0) { // 데이터 삽입 성공 } else { // 데이터 삽입 실패 } } else { // 삽입 안 할 시 }
		 */
		int city_id = dao.getCityId(name);
		if (city_id==-1) {	//존재하지 않는 경우
			int result = dao.insertCity(dto);
			request.getSession().removeAttribute("area_id");
			if (result > 0) {
				// 데이터 삽입 성공
				request.getSession().setAttribute("city_id", dao.getCityId(name));
			} else {
				// 데이터 삽입 실패
			}
		} else {
			request.getSession().setAttribute("city_id", city_id);
		}
	}

}
