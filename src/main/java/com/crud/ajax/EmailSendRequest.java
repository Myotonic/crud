package com.crud.ajax;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dto.UserDto;
import com.crud.requestdao.EstimateDao;
import com.crud.requestdao.RequestDao;
import com.crud.requestdto.RequestDetailDto;

/**
 * Servlet implementation class EmailSend
 */
@WebServlet("/EmailSendRequest")
public class EmailSendRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailSendRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action(request, response);
	}
	
	protected void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int request_id = Integer.parseInt(request.getParameter("request_id"));
		RequestDetailDto dto = new EstimateDao().requestDetail(request_id);
		
		int estimate_id = Integer.parseInt(request.getParameter("estimate_id"));
		
		String subject = "CRUD에서 [" + dto.getUser_name() + "] 님이 당신에게 [" + dto.getCategory2_name() + "] 서비스를 요청했습니다.";
		String content = "요청인 : " + dto.getUser_name() + "\r\n"
				+ "카테고리 : " + dto.getCategory2_name() + "\r\n"
				+ "주소 : " + dto.getCity_name() + "\r\n"
				+ "희망일 : " + dto.getWork_date() + "\r\n"
				+ "요청내용 : " + dto.getContent() + "\r\n"
				+ "요청인 연락처 : " + request.getParameter("yun");
		
		//1. 보내는 쪽 메일 설정 - 네이버가 빌려준 이메일 서버 / id, pass
		String host = "smtp.naver.com";
		String user = "crud0420@naver.com";
		String password = "dbdbdig0420_crud";
		
		//2. 받는 사람 - 관리자 이메일
		String to = new RequestDao().requestMail(estimate_id);
		
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");
		
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.naver.com");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		Session session = Session.getDefaultInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			message.setSubject(subject);
			message.setContent(content, "text/html; charset=euc-kr");

			Transport.send(message);
			
		} catch (AddressException e) { e.printStackTrace();
		} catch (MessagingException e) { e.printStackTrace();
		}
		
		request.getRequestDispatcher("/cancle.request").forward(request, response);
		
	}
}
