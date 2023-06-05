package com.crud.estimateService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.requestdao.EstimateDao;
import com.crud.requestdto.EstimateDto;

public class EstimateCreate implements EstimateService{
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		EstimateDto dto = new EstimateDto();
		
		
		dto.setRequestID(Integer.parseInt(request.getParameter("request_id")));
		dto.setExpertID((int)request.getSession().getAttribute("expert_id"));
		dto.setContent(request.getParameter("content"));
		dto.setPrice(Integer.parseInt(request.getParameter("price")));
		
		int result = new EstimateDao().estimateCreate(dto);
		
		if(result > 0) {
			out.println("성공");
//			out.println("<script> alert('견적서 작성성공'); location.href='성공시 경로'; </script>");
		} else {
			out.println("실패");
		}
		
	}
}
/*

private int requestID;
	private int expertID;
	private String content;
	private int price;

*/