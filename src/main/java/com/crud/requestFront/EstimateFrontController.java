package com.crud.requestFront;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.estimateService.EstimateCreate;
import com.crud.estimateService.EstimateList;
import com.crud.estimateService.RequestDetail;

/**
 * Servlet implementation class EstimateFrontController
 */
@WebServlet("*.estimate")
public class EstimateFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EstimateFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doEstimate(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doEstimate(request, response);
	}
	
	protected void doEstimate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String path = request.getServletPath();
		
		if(path.equals("/create.estimate")) {
			new EstimateCreate().exec(request, response);
			
		} else if(path.equals("/list.estimate")) {
			new EstimateList().exec(request, response);
			
		} else if(path.equals("/detail.estimate")) {
			new RequestDetail().exec(request, response);
		}
		
	}

}
