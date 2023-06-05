package com.crud.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dbmanager.DBManager;

/**
 * Servlet implementation class EmailCheck
 */
@WebServlet("/EmailCheck")
public class EmailCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		DBManager db = new DBManager();
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null; ResultSet rset = null;
		String result = "사용 가능한 아이디 입니다.";
		String sql = "select count(*) from user where user_email = ?";
		 
		int cnt = -1;
		String check = "true";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("email"));
			rset = pstmt.executeQuery();
			if (rset.next()) {  cnt = rset.getInt(1);}
			if(cnt > 0) { result = "이미 존재하는 이메일입니다."; check="false"; }
			
			out.println("<span class=\"label label-danger\" data-check="+check+">"+result+"</span>");
			
		} catch (SQLException e) { e.printStackTrace();
		}finally {
			if(pstmt!=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if( conn!=null) { try {  conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
