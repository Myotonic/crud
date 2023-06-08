package com.crud.service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.MDao;
import com.crud.dto.Faq;
import com.crud.dto.MDto;
import com.crud.dto.Time;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MarketCreate implements MarketService{

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		MDto dto = new MDto();
		MDao dao = new MDao();
		String result = "관리자에게 문의하세요.";
		PrintWriter out = response.getWriter();
		String path="/images";
		List<String> images = new ArrayList<>();
		MultipartRequest multi = new MultipartRequest(request, path, 1024 * 1024 * 10, "UTF-8", new DefaultFileRenamePolicy());
		@SuppressWarnings("unchecked")
		Enumeration<String> fileNames = multi.getFileNames();
		while (fileNames.hasMoreElements()) {
		    String fieldName = fileNames.nextElement();
		    File file = multi.getFile(fieldName);
		    System.out.println(file.getName());
		    if (file != null) {
		        images.add(file.getName());
		    }
		}
		dto.setImages(images);
		dto.setTitle(multi.getParameter("mTitle"));
		dto.setContent(multi.getParameter("mContent"));
		dto.setPrice(Integer.parseInt(multi.getParameter("mPrice")));
		dto.setRefund(multi.getParameter("mRefund"));
		dto.setDivision(multi.getParameter("mDivision"));
		dto.setExpert_id((int) request.getSession().getAttribute("expert_id"));
		dto.setCategory1_id(Integer.parseInt(multi.getParameter("category1_id")));
		dto.setCategory2_id(Integer.parseInt(multi.getParameter("category2_id")));
		if(dto.getDivision().equals("수업")) {
			dto.setAppointment(multi.getParameter("mAppointment") == "1"? "시간결정" : "시간협의");
			dto.setProceed(multi.getParameter("mProceed") == "1"? "비대면" : "대면");
			dto.setLocation(multi.getParameter("mLocation"));
			dto.setStartSchedule(multi.getParameter("mStartSchedule"));
			dto.setEndSchedule(multi.getParameter("mEndSchedule"));
			String day[] = multi.getParameterValues("mDay[]");
			String starttime[] = multi.getParameterValues("mStartTime[]");
			String endtime[] = multi.getParameterValues("mEndTime[]");
			List<Time> times = new ArrayList<>();
			for(int i = 0 ; i < day.length;i++) {
				times.add(new Time(day[i],starttime[i],endtime[i]));			
			}
			dto.setTime(times);
		}
		String fTitle[] = multi.getParameterValues("fTitle[]");
		String fContent[] =multi.getParameterValues("fContent[]");
		List<Faq> faq = new ArrayList<>();
		for(int i = 0; i < fTitle.length;i++) {
			faq.add(new Faq(fTitle[i],fContent[i],dto.getMarket_id()));
		}
		dto.setFaq(faq);
		if(dao.createMarket(dto)>0) {
			result = "마켓등록을 성공했습니다.";
		}
		out.println("<script>alert('"+result+"');</script>");
		
	}
	
}
