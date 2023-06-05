package com.crud.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.MDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ImgUpdate implements MarketService{

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		List<String> images = new ArrayList<>();
		int market_id = Integer.parseInt(request.getParameter("market_id"));
		MDao dao = new MDao();
		PrintWriter out = response.getWriter();
		String path="/images";
		String result = "관리자에게 문의하세요.";
		MultipartRequest multi =    //요청위임  경로    용량            인코딩  동일명파일처리 
				new MultipartRequest(request, path, 1024*1024*5, "UTF-8", new DefaultFileRenamePolicy());
		
		@SuppressWarnings("unchecked")
		Enumeration<String> imgs = multi.getFileNames();
		while(imgs.hasMoreElements()) {
		    String fieldName = imgs.nextElement();
			images.add(fieldName);
		}
		if(dao.updateImg(images,market_id)>0) {
			result = "이미지수정에 성공했습니다.";
		}
		out.println("<script>alert('"+result+"');</script>");		
	}

}
