package com.crud.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.CommDao;
import com.crud.dto.BoardResult;

public class bBoardList implements GosuService{

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		CommDao dao = new CommDao();
		BoardResult dto = new BoardResult();
		dto = dao.list();
		
		request.setAttribute("bList", dto);
		
	}
}