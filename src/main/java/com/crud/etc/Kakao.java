package com.crud.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Servlet implementation class Kakao
 * 
 * http://localhost:8080/project_paing_img/kakao?code=gcoY5ZDa_LqgXl3niz9bTxVBwHoXmaCezYQK_8vmil-B2PcxK2I9gfavCPP1PV7wSMhtVgoqJY8AAAGIk7crWA
 * 
 * 
 */
@WebServlet("/kakao.admin")
public class Kakao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Kakao() {
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
		
		String client_id = "bca8f5dab0a2ba8e29925a29d8eb6aae";
		String redirect_uri = "http://localhost:8080/project_test_port001/kakao.admin";
		String code = request.getParameter("code");
		
		String requestUrl = "https://kauth.kakao.com/oauth/token?grant_type=authorization_code";
		requestUrl += "&client_id=" +  client_id;
		requestUrl += "&redirect_uri=" +  redirect_uri;
		requestUrl += "&code=" +  code;
		
		
		URL url = null;
		HttpURLConnection conn = null;
		BufferedReader br = null;
		BufferedReader br2 = null;
		
		String line = "";
		String line2 = "";
		StringBuffer sb = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		String result = "";
		String result2 = "";
		
		
	
		try {
			
			url = new URL(requestUrl);
			conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			
			
			if(conn.getResponseCode() == 200) {
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			
			while((line = br.readLine()) !=null)
			{
				sb.append(line);
			}
			result = sb.toString();
			System.out.println(result);
			
//			JsonObject jo = new JsonObject();
//			jo.get("access_token");
			
			
			br.close();
			conn.disconnect();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		
		
		
		JsonObject jo = (JsonObject)parser.parse(result);
		
		String access_token = jo.get("access_token").getAsString();
		
		System.out.println(access_token);
		
		requestUrl = "https://kapi.kakao.com/v2/user/me";
		
//		Authorization: Bearer ${ACCESS_TOKEN}
//
//		Content-type: application/x-www-form-urlencoded;charset=utf-8
//		
		
		
		
		try {
			url = new URL(requestUrl);
			conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("Authorization", "Bearer "+access_token);
			
			conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			
			
			
			if(conn.getResponseCode() == 200) {
				br2 = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				br2 = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			
			
			while((line2 = br2.readLine()) !=null)
			{
				sb2.append(line2);
			}
			
			result2 = sb2.toString();
			System.out.println(result2);
			
			
			
//			String nickname = jo2.get("nickname").getAsString();
//			String profile_image = jo.get("profile_image").getAsString();
			
			
//			System.out.println(nickname);
//			System.out.println(profile_image);
			

			br2.close();
			conn.disconnect();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		

		Gson gson2 = new Gson();
		JsonParser parser2 = new JsonParser();
		
		
		JsonObject jo2 = (JsonObject)parser2.parse(result2);
		
		JsonObject properties = (JsonObject)jo2.get("properties");
		
		JsonObject kakao_account = (JsonObject)jo2.get("kakao_account");
		
		JsonObject profile = (JsonObject)kakao_account.get("profile");
		
		request.setAttribute("nickname", properties.get("nickname").getAsString());
//		request.setAttribute("profile_image", properties.get("profile_image").getAsString());
//		request.setAttribute("thumbnail_image", properties.get("thumbnail_image").getAsString());
		request.setAttribute("email", kakao_account.get("email").getAsString());
		
		
		request.getRequestDispatcher("/admin/admin_kakao.jsp").forward(request, response);
		
		System.out.println(properties);
		System.out.println(profile);
		System.out.println(kakao_account);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
		
	}

}
