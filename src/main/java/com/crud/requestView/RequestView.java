package com.crud.requestView;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dbmanager.DBManager;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class RequestView
 */
@WebServlet("/request")
public class RequestView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestView() {
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
		
		String sql = "select ca2.category2_id, ca2.category2_name, ca1.category1_name from category2 ca2 join category1 ca1 using(category1_id) where category2_id = ?";
		
		int category2_id = Integer.parseInt(request.getParameter("category2_id"));
		DBManager db = new DBManager();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = db.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1,category2_id);
			rset = pstm.executeQuery();
			if(rset.next()) {
				
			}
		} catch (Exception e) {
			
		} finally {
			if(rset != null) { try {rset.close();}catch(Exception e) {} }
			if(pstm != null) { try {pstm.close();}catch(Exception e) {} }
			if(conn != null) { try {conn.close();}catch(Exception e) {} }
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
