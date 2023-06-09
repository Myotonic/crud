package com.crud.requestService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.requestdao.RequestDao;

public class RequestCancle implements RequestService{
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		int request_id = Integer.parseInt(request.getParameter("request_id"));
		int result = new RequestDao().requestCancle(request_id);
		
		if(result > 0) {
			out.println("<script> alert('성공'); location.href='"+request.getContextPath()+"/list.request';</script>");
		} else {
			out.println("<script> alert('실패'); location.href='"+request.getContextPath()+"/list.request';</script>");
		}
	}
}
