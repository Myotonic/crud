package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.service.bBUpdate;
import com.company.service.bBoardCreate;
import com.company.service.bBoardList;

/**
 * Servlet implementation class gosuCommController
 */

@WebServlet("*.crud")
public class gosuCommController extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gosuCommController() {
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
        // TODO Auto-generated method stub
    	action(request, response);
    	
    }

    protected void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        String path = request.getServletPath();
        if(path.equals("/bBoardList.crud")) {
            bBoardList service = new bBoardList();
            service.exec(request, response);
            request.getRequestDispatcher("/Community/bBoardList.jsp").forward(request, response);
        }else if(path.equals("/bWriter.crud")) {
            System.out.println("1");
            bBoardList service = new bBoardList();
            service.exec(request, response);
            String bWriteNum = request.getParameter("bBreak_point");
            if(bWriteNum.equals("1")) {
            	request.getRequestDispatcher("/Community/bWriter.jsp").forward(request, response);
            }else if(bWriteNum.equals("2")) {
            	request.getRequestDispatcher("expert/eWriter.jsp").forward(request, response);
            }
        }else if(path.equals("/bBoardCreate.crud")) {
        	bBoardCreate service = new bBoardCreate();
        	service.exec(request, response);
        	out.print("<script>location.href='/bBoardList.crud'</script>");
        }
        else if(path.equals("/bBoardUpdate.crud")) {
            bBUpdate service = new bBUpdate();
            service.exec(request, response);
            request.getRequestDispatcher("/bBoardList.crud").forward(request, response);
        }
    }
}