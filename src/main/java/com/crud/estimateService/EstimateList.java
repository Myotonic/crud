package com.crud.estimateService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crud.requestdao.EstimateDao;

public class EstimateList implements EstimateService{
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int expert_id = (int)session.getAttribute("expert_id");
		
		request.setAttribute("estimateList", new EstimateDao().estimateList(expert_id));
		request.getRequestDispatcher("/estimate/estimateList.jsp").forward(request, response);
	}
}
