package com.crud.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crud.dao.MemberDao;
import com.crud.dto.ExpertDto;
import com.crud.dto.UserDto;

public class MExpertJoin implements MemberService {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		UserDto userDto = new UserDto();
		userDto.setUser_name(request.getParameter("name"));
		userDto.setUser_email(request.getParameter("email"));
		userDto.setUser_pass(request.getParameter("pass"));

		MemberDao dao = new MemberDao();
		int result = dao.insertUser(userDto);

		if (result > 0) {
		    // 회원가입 성공

		    // 삽입된 사용자의 user_id 
		    int userId = dao.getUserId(userDto.getUser_email());
		    int category2_id = Integer.parseInt((String)request.getSession().getAttribute("category2"));
		    String category = dao.getCategory2Name(category2_id);	//서비스
		    int city_id = (int) request.getSession().getAttribute("city_id");
		    String range = (String)request.getSession().getAttribute("range");

		    // expert 테이블에 추가 데이터를 입력
		    ExpertDto expertDto = new ExpertDto();
		    expertDto.setUser_id(userId);
		    expertDto.setCategory2_id(category2_id);
		    expertDto.setCity_id(city_id);
		    expertDto.setExpert_intro(userDto.getUser_name() + "고수님의 "+category+"서비스");
		    expertDto.setExpert_range(range);

		    int expertResult = dao.insertExpert(expertDto);
		    HttpSession session = request.getSession(false);
		    if (expertResult > 0) {
		        // expert 데이터 삽입 성공
		    	out.println("<script>alert('가입 성공! 로그인 후 사용하세요'); </script>");
	            session.invalidate(); // 세션 무효화
		    } else {
		        // expert 데이터 삽입 실패
		    	out.println("<script>alert('가입 실패'); location.href='history.go(-1)'; </script>");
		    }
		} else {
		    // 회원가입 실패
	    	out.println("<script>alert('가입 실패'); location.href='history.go(-1)'; </script>");
		}
		
	}

}
