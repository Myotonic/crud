package com.crud.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.MemberDao;
import com.crud.dto.AreaDto;

public class MArea implements MemberService {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String sido = request.getParameter("sido");
		String sigungu = request.getParameter("sigungu");
		String area = sido + " " + sigungu;
		
		AreaDto dto = new AreaDto();
		dto.setArea_name(area);

		MemberDao dao = new MemberDao();

		/*
		 * if (!dao.isArea(dto.getArea_name())) { //존재하지 않는 경우 int result =
		 * dao.insertArea(dto);
		 * 
		 * if (result > 0) { // 데이터 삽입 성공 request.setAttribute("area_id",
		 * dao.getAreaId(area)); } else { // 데이터 삽입 실패 } } else {
		 * request.setAttribute("area_id", dao.getAreaId(area)); }
		 */
		int area_id = dao.getAreaId(area);
		if (area_id==-1) {	//존재하지 않는 경우
			int result = dao.insertArea(dto);

			if (result > 0) {
				// 데이터 삽입 성공
				request.getSession().setAttribute("area_id", dao.getAreaId(area));
			} else {
				// 데이터 삽입 실패
			}
		} else {
			request.getSession().setAttribute("area_id", area_id);
		}

	}

}
