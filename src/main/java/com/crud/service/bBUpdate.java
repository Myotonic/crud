package com.company.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.CommDao;
import com.company.dto.bWriterDto;

public class bBUpdate implements GosuService{

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; chatset=UTF-8");
		PrintWriter out = response.getWriter();
		CommDao dao = new CommDao();
		bWriterDto br = new bWriterDto();
		int result = dao.board_update(br);
		
		if(result > 0) {
			System.out.println("<script>alert('수정성공');</script>");
		}else {
			System.out.println("<script>alert('수정실패');</script>");
		}
	}

}
