package com.company.front;

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

import com.company.dbmanager.DBManager;
import com.company.dto.UserDto;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mysql.cj.xdevapi.JsonString;

/**
 * Servlet implementation class Test
 */
@WebServlet("*.test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String sql = "select * from user";
		
		
		DBManager db = new DBManager();
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		PrintWriter out = response.getWriter();
		
		try {
			
			conn = db.getConnection();
			
			pstmt =conn.prepareStatement(sql);
			
			
			rset = pstmt.executeQuery();
			
//			String result = "[";
//			
//			Boolean first= true;
//			
//			while(rset.next()) {
//				
////				int user_id, String user_name, String user_email, String user_pass, String user_date,
////				String user_ip
//				
//				if(first) {
//					result +="";
//				}else {
//					result +=",";
//				}
//				
//				result +="{\n"
//						+ " 	\"user_id\" : \""+rset.getInt("user_id")+"\",\n"
//						+ " 	\"user_name\" : \""+rset.getString("user_name")+"\",\n"
//						+ " 	\"user_email\" : \""+rset.getString("user_email")+"\"\n"
//						+ " \n"
//						+ " \n"
//						+ " \n"
//						+ " }";
//				
//				
//				first= false;
//				
//				//result.add(new UserDto(rset.getInt("user_id"),rset.getString("user_name"),rset.getString("user_email"),rset.getString("user_pass"),rset.getString("user_date"),rset.getString("user_ip")));
//				
//				
//			}
//			
//			result +="]";
//			
//			out.println(result);
			JsonArray list = new JsonArray();
			JsonObject j1 = new JsonObject();
//			JsonString js = new JsonString();
//			js.setValue("user");
			
			while(rset.next()) {
				
				j1 = new JsonObject();
				
				j1.addProperty("user_id", rset.getInt("user_id"));
				j1.addProperty("user_name", rset.getString("user_name"));
				j1.addProperty("user_email", rset.getString("user_email"));
				list.add(j1);
				
				
				
			}
			
			out.println(list);
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			
			if(rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
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
