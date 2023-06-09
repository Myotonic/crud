package com.crud.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.MemberDao;

public class MemberValue implements MemberService {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String value = (String)request.getSession().getAttribute("memberValue");
		int user_id = (int)request.getSession().getAttribute("member");
		
		MemberDao dao = new MemberDao();
		
		if(value.equals("user")) {	//유저라면
			if( dao.getExpertId(user_id) != -1 ){	//전문가 아이디가 있다면
				request.getSession().setAttribute("memberValue", "expert");
			}else { 	//전문가 아이디가 없다면 
				request.getRequestDispatcher("/expert_joinC1.crud").forward(request, response);
			}
		}else {	//전문가라면
			request.getSession().setAttribute("memberValue", "user");
		}
		
	}

}
