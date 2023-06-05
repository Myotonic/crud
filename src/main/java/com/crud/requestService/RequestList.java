package com.crud.requestService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crud.requestdao.RequestDao;

public class RequestList implements RequestService{
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int user_id = (int)session.getAttribute("member");
		
		request.setAttribute("requestList", new RequestDao().requestList(user_id));
		request.getRequestDispatcher("/request/requestList.jsp").forward(request, response);
	}
}
