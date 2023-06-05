package com.crud.requestFront;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.requestService.EstimateDetail;
import com.crud.requestService.EstimatedList;
import com.crud.requestService.RequestCancle;
import com.crud.requestService.RequestCreate;
import com.crud.requestService.RequestList;

/**
 * Servlet implementation class RequestFrontController
 */
@WebServlet("*.request")
public class RequestFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dodo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dodo(request, response);
	}

	protected void dodo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String path = request.getServletPath();
		
		System.out.println(path);
		
		if(path.equals("/create.request")) {
			System.out.println("크리에이트");
			new RequestCreate().exec(request, response);
			
		} else if(path.equals("/list.request")) {
			new RequestList().exec(request, response);
			
		} else if(path.equals("/eslist.request")) {
			new EstimatedList().exec(request, response);
			
		} else if(path.equals("/esdetail.request")) {
			new EstimateDetail().exec(request, response);
			
		} else if(path.equals("/cancle.request")) {
			new RequestCancle().exec(request, response);
		} 
		
	}
	
}
