package com.company.dao;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.dbmanager.DBManager;
import com.company.dto.Area;
import com.company.dto.BoardResult;
import com.company.dto.City;
import com.company.dto.Comment;
import com.company.dto.Expert;
import com.company.dto.User;
import com.company.dto.bWriterDto;
import com.company.dto.category1;
import com.company.dto.category2;

public class CommDao {
    public int write(bWriterDto br) throws UnknownHostException {
    	Connection conn = null; PreparedStatement pstmt = null;
         String sql = "insert into board_write (board_title,board_content,board_ip,board_break_point,expert_id,user_id,board_category_no) values (?,?,?,?,?,?,?)";
           int result = -1;
           try {
              DBManager db = new DBManager();
              conn = db.getConnection();
              pstmt = conn.prepareStatement(sql);
              pstmt.setString(1,br.getBoard_title());
              pstmt.setString(2,br.getBoard_content());
              pstmt.setString(3, InetAddress.getLocalHost().getHostAddress());
              pstmt.setString(4,br.getBoard_break_point());
              pstmt.setInt(5,br.getExpert_id());
              pstmt.setInt(6,br.getUser_id());
              pstmt.setInt(7,br.getBoard_category_no());
              result = pstmt.executeUpdate();

           }catch(SQLException e) {
              e.printStackTrace();
           }finally {
   		 	if(pstmt != null) {try{pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
   		 	if(conn != null) {try{conn.close();}catch(SQLException e) {e.printStackTrace();}}
   		 	}
         return result;
    }

      public BoardResult list() {
          Connection conn = null;
          PreparedStatement pstmt = null;
          ResultSet rset = null;

  		String sql = " SELECT * "
  				+ "				FROM board_write a "
  				+ "				LEFT JOIN comment b ON a.board_no = b.board_no "
  				+ "				LEFT JOIN area c ON a.board_no = c.area_id "
  				+ "				LEFT JOIN city d ON a.board_no = d.city_id "
  				+ "				cross join category1 e "
  				+ "				LEFT JOIN category2 f ON a.board_no = f.category2_id "
  				+ "				LEFT JOIN user g ON a.board_no = g.user_id "
  				+ "				LEFT JOIN expert h ON a.board_no = h.expert_id";
  			
          List<bWriterDto> boardList = new ArrayList<>();
          List<Comment> commentList = new ArrayList<>();
          List<City>bCity = new ArrayList<>();
          List<Area>bArea = new ArrayList<>();
          List<category1>cate1 = new ArrayList<>();
          List<category2>cate2 = new ArrayList<>();
          List<User>user = new ArrayList<>();
          List<Expert>expert = new ArrayList<>();

          try {
              DBManager db = new DBManager();
              conn = db.getConnection();
              pstmt = conn.prepareStatement(sql);
              rset = pstmt.executeQuery();

              while (rset.next()) {
                  boardList.add(new bWriterDto(rset.getInt("board_no"), rset.getString("board_title"), rset.getString("board_content"), rset.getString("board_upload_day"), rset.getString("board_break_point"),rset.getInt("expert_id"),rset.getInt("user_id"),rset.getInt("board_category_no")));
                  commentList.add(new Comment(rset.getInt("comment_no"), rset.getInt("like_no"), rset.getString("comment_con")));
                  bCity.add(new City(rset.getInt("area_id"),rset.getInt("city_id"),rset.getString("city_name")));
                  bArea.add(new Area(rset.getInt("area_id"),rset.getString("area_name")));
                  cate1.add(new category1(rset.getInt("category1_id"),rset.getString("category1_name")));
                  cate2.add(new category2(rset.getInt("category2_id"),rset.getString("category2_name")));
                  user.add(new User(rset.getInt("user_id"),rset.getString("user_name"),rset.getString("user_email"),rset.getString("user_pass")
                		  ,rset.getString("user_date"),rset.getString("user_ip")));
                  expert.add(new Expert(rset.getInt("expert_id"),rset.getInt("user_id"),rset.getInt("city_id"),rset.getInt("category2_id"),rset.getString("expert_date")
                		  ,rset.getString("expert_intro"),rset.getString("expert_range")));
              }
          } catch (SQLException e) {
              e.printStackTrace();
          } finally {
        	  	if(rset != null) {try{rset.close();}catch(SQLException e) {e.printStackTrace();}}
     		 	if(pstmt != null) {try{pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
       		 	if(conn != null) {try{conn.close();}catch(SQLException e) {e.printStackTrace();}}
       		 	}
          return new BoardResult(boardList,commentList,bCity,bArea,cate1,cate2,user,expert);
      }

    public int delete(bWriterDto br) {
       int result = -1;
       Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
       DBManager db = new DBManager();
       String sql = "delete from board_write where board_no=?";
       
       try {
          conn = db.getConnection();
          pstmt = conn.prepareStatement(sql);
          pstmt.setInt(1,br.getBoard_no());
          result = pstmt.executeUpdate();
       }catch(SQLException e) {e.printStackTrace();
       }finally {
		 	if(pstmt != null) {try{pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
  		 	if(conn != null) {try{conn.close();}catch(SQLException e) {e.printStackTrace();}}
  		 	}
       return result;
    }
    
    public int board_update(bWriterDto br) {
       int result = -1;
       Connection conn = null; PreparedStatement pstmt = null;
       DBManager db = new DBManager();
       String sql = "update board_write set board_title=? , board_content=? where board_no=?";
       try {
          conn = db.getConnection();
          pstmt = conn.prepareStatement(sql);
          pstmt.setString(1,br.getBoard_title());
          pstmt.setString(2,br.getBoard_content());
          pstmt.setInt(3,br.getBoard_no());
          result = pstmt.executeUpdate();
          if(result > 0) {
             System.out.println("수정성공");
          }else {
             System.out.println("수정실패");
          }
       }catch(SQLException e) {e.printStackTrace();
       }finally {
		 	if(pstmt != null) {try{pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
  		 	if(conn != null) {try{conn.close();}catch(SQLException e) {e.printStackTrace();}}
  		 	}
       return result;
    }
}