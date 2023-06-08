package com.crud.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.CommDao;
import com.crud.dto.bWriterDto;

public class bBoardMainView implements GosuService{

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		CommDao dao = new CommDao();
		List<bWriterDto> list = new ArrayList<>();
		list = dao.mainBoard();
		request.setAttribute("bDtoList", list);
		
	}

}
