package com.crud.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.CommDao;
import com.crud.dto.Area;
import com.crud.dto.bWriterDto;
import com.crud.dto.category1;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class bBoardCreate implements GosuService{

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		int result = -1;
		PrintWriter out = response.getWriter();
		bWriterDto br = new bWriterDto();
		String path = "/upload";
	    MultipartRequest multi = new MultipartRequest(request, path, 1024 * 1024 * 10, "UTF-8", new DefaultFileRenamePolicy());
		String bTitle = multi.getParameter("board_title");
		String bContent = multi.getParameter("board_content");
		String break_point = multi.getParameter("board_break_point");
		
		List<category1> bCate1 = new ArrayList<>();
		List<Area> bArea = new ArrayList<>();
		
		br.setBoard_title(bTitle);
		br.setBoard_content(bContent);
		br.setCate1(bCate1);
		br.setbArea(bArea);
		br.setBoard_break_point(break_point);
		
		CommDao dao = new CommDao();
		result = dao.write(br);
		
		if(result > 0) {
		    out.print("<script>alert('글쓰기 성공');</script>");
		    out.println("<script>location.href='/bBoardList.crud'</script>");
		} else {
		    out.print("<script>alert('글쓰기 실패');</script>");
		    out.println("<script>javascript:history.go(-1);</script>");
		}
	}
}
