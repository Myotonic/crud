package com.crud.requestService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.requestdao.RequestDao;
import com.crud.requestdto.RequestDto;
import com.crud.service.MArea;
import com.crud.service.MCity;

public class RequestCreate implements RequestService{
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		RequestDto dto = new RequestDto();
		
		new MArea().exec(request, response);
		new MCity().exec(request, response);
		
//		out.println(request.getAttribute("area_id"));
//		out.println(request.getAttribute("city_id"));
//		out.println(request.getParameter("category2_id"));
//		out.println(request.getParameter("work_date"));
		
		
		dto.setUser_id((int)request.getSession().getAttribute("member")); //user_id
		dto.setCategory2_id(Integer.parseInt(request.getParameter("category2_id")));
		dto.setCity_id((int)request.getAttribute("city_id"));
		dto.setWork_date(request.getParameter("work_date"));
		dto.setContent(request.getParameter("content"));
		System.out.println(request.getParameter("content"));
		
		int result = new RequestDao().requestCreate(dto);
		
		if(result > 0) {
			out.println("<script>alert('성공'); location.href='"+request.getContextPath()+"/request/requestSuccess.jsp';  </script>");
		} else {
			out.println("<script>alert('실패'); location.href='"+request.getContextPath()+"/qwer.jsp';  </script>");
		}
	}
}
