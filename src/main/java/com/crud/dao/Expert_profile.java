package com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crud.dbmanager.DBManager;
import com.crud.dto.Career;
import com.crud.dto.Certificate;
import com.crud.dto.Education;
import com.crud.dto.Expert;
import com.crud.dto.Expert_profileDto;
import com.crud.dto.Portfolio;
import com.crud.dto.User;

public class Expert_profile {

	
	public int ex_create(Expert_profileDto dto) {
		// 경력
		Connection conn = null; PreparedStatement pstmt = null;
		
		String sql = "insert into dto (expert_id) values (?)";
		int result = -1;
		try {
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,dto.getExpert_id());
			
			result = pstmt.executeUpdate();
			pstmt.close();
			for(Portfolio p : dto.getPortfolio()) {
				createPortfolio(p,conn,dto.getExpert_id());
			}
			for(Certificate c : dto.getCerti()) {
				createCertificate(c,conn,dto.getExpert_id());
			}
			for(Career r : dto.getCareer()) {
				createCareer(r,conn,dto.getExpert_id());
			}
			for(Education f : dto.getEdu()) {
				createEducation(f,conn,dto.getExpert_id());
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
	
	public int createPortfolio(Portfolio pt , Connection conn, int expert_id) {
		int result = -1;
		String sql = "insert into portfolio(portfolio_entry) values (?)";
		PreparedStatement pstmt = null;
		try {
		DBManager db = new DBManager();
		conn = db.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,pt.getPortfolio_entry());
		pstmt.executeUpdate();
		}catch(SQLException e) {e.printStackTrace();
		}finally {
			if (pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	public int createEducation(Education ed , Connection conn , int expert_id) {
		int result = -1;
		PreparedStatement pstmt = null;
		
		String sql ="insert into education (education_entry) values (?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,ed.getEducation_entry());
			pstmt.executeUpdate();
			pstmt.close();
		}catch(SQLException e) {e.printStackTrace();
		}finally {
		 	if(pstmt != null) {try{pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
		 	}

		return result;
	}
	
	public int createCertificate(Certificate ct,Connection conn , int expert_id) {
		int result = -1;
		PreparedStatement pstmt = null;
		String sql = "insert into certificate (certificate_entry) values (?)";
		try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,ct.getCertificate_entry());
		pstmt.close();
		}catch(SQLException e) {e.printStackTrace();
		}finally {
		 	if(pstmt != null) {try{pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
		 	}
		return result;
	}
	
	public int createCareer(Career cr , Connection conn , int expert_id) {
		int result = -1;
		PreparedStatement pstmt = null;
		String sql = "insert into career (career_entry) values (?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,cr.getCareer_entry());
			result = pstmt.executeUpdate();
			pstmt.close();
		}catch(SQLException e) {e.printStackTrace();
		}finally {
		 	if(pstmt != null) {try{pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
		 	}
		return result;
	}
	
	//List
	
	public Expert_profileDto ex_list(){
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		String sql = "SELECT * "
				+ "FROM expert a "
				+ "LEFT JOIN user b ON a.user_id = b.user_id "
				+ "LEFT JOIN portfolio c ON a.expert_id = c.expert_id "
				+ "LEFT JOIN certificate d ON a.expert_id = d.expert_id "
				+ "LEFT JOIN education e ON a.expert_id = e.expert_id "
				+ "LEFT JOIN career f ON a.expert_id = f.expert_id "
				+ "LEFT JOIN user g ON a.user_id = g.user_id "
				+ "WHERE a.expert_id = ?";

		DBManager db = new DBManager();
		Expert_profileDto dto = new Expert_profileDto();

		List<Portfolio> portfolio = new ArrayList<>();
		List<Education> education = new ArrayList<>();
		List<Certificate> certificate = new ArrayList<>();
		List<Career> career = new ArrayList<>();
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,dto.getExpert_id());
			rset = pstmt.executeQuery();
			while(rset.next()){
				dto.setUser_intro("user_intro");
				dto.setUser_name("user_name");
				portfolio.add(new Portfolio(rset.getInt("expert_id"),rset.getInt("portfolio"),rset.getString("portfolio_entry")));
				education.add(new Education(rset.getInt("expert_id"),rset.getInt("education"),rset.getString("education_entry")));
				certificate.add(new Certificate(rset.getInt("expert_id"),rset.getInt("certificate"),rset.getString("certificate_entry")));
				career.add(new Career(rset.getInt("expert_id"),rset.getInt("career"),rset.getString("career_entry")));
			}
			dto.setPortfolio(portfolio);
			dto.setEdu(education);
			dto.setCerti(certificate);
			dto.setCareer(career);
		}catch(SQLException e) {e.printStackTrace();
		}finally {
		 	if(rset != null) {try{rset.close();}catch(SQLException e) {e.printStackTrace();}}
		 	if(pstmt != null) {try{pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
		 	if(conn != null) {try{conn.close();}catch(SQLException e) {e.printStackTrace();}}
		 	}
		return dto;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////		UPDATE	UPDATE	UPDATE	UPDATE	UPDATE	UPDATE	UPDATE	UPDATE	////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// 포트폴리오
	public int profileE_portfolio(Portfolio dto) {
		int result = -1;
		Connection conn = null; PreparedStatement pstmt = null;

		String sql = "update portfolio set portfolio_no=?";
		// 등록 >> 카테고리 학력 포트폴리오 자격증 및 기타 서류 이동가능거리 활동지역(area)

		try {
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,dto.getExpert_id());
			//pstmt.setInt(6,ex.getCity_id()); // 활동 가능거리 Expert
			result = pstmt.executeUpdate();

		}catch(SQLException e) {e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			}catch(SQLException e) {e.printStackTrace();}
		} return result;
	}
	
	//자격증 및 기타서류
	public int profileE_certi(Certificate dto) {
		int result = -1;
		Connection conn = null; PreparedStatement pstmt = null;

		String sql = "update certificate set certificate_no=?";
		// 등록 >> 카테고리 학력 포트폴리오 자격증 및 기타 서류 이동가능거리 활동지역(area)

		try {
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,dto.getCertificate_no());
			//pstmt.setInt(6,ex.getCity_id()); // 활동 가능거리 Expert
			result = pstmt.executeUpdate();

		}catch(SQLException e) {e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			}catch(SQLException e) {e.printStackTrace();}
		} return result;
	}
	
	// 경력
	public int profileE_career(Career dto) {
		int result = -1;
		Connection conn = null; PreparedStatement pstmt = null;

		String sql = "update career set career_no=?";
		// 등록 >> 카테고리 학력 포트폴리오 자격증 및 기타 서류 이동가능거리 활동지역(area)

		try {
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,dto.getCareer());
			result = pstmt.executeUpdate();

		}catch(SQLException e) {e.printStackTrace();
		}finally {
		 	if(pstmt != null) {try{pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
		 	if(conn != null) {try{conn.close();}catch(SQLException e) {e.printStackTrace();}}
		 	}return result;
	}
	
	// 학력
		public int profileE_edu(Education dto) {
			int result = -1;
			Connection conn = null; PreparedStatement pstmt = null;

			String sql = "update education set education_no=?";
			// 등록 >> 카테고리 학력 포트폴리오 자격증 및 기타 서류 이동가능거리 활동지역(area)

			try {
				DBManager db = new DBManager();
				conn = db.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,dto.getEducation());
				result = pstmt.executeUpdate();

			}catch(SQLException e) {e.printStackTrace();
			}finally {
			 	if(pstmt != null) {try{pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
			 	if(conn != null) {try{conn.close();}catch(SQLException e) {e.printStackTrace();}}
			 	} return result;
		}
	
	// 프로필 이름 수정
	public int profileE_name(User us) {
		int result = -1;
		
		Connection conn=null; PreparedStatement pstmt = null;
		String sql = "update user set user_name=?";
		try {
			
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,us.getUser_name());
			result = pstmt.executeUpdate();
		}catch(Exception e) {e.printStackTrace();
		}finally {
		 	if(pstmt != null) {try{pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
		 	if(conn != null) {try{conn.close();}catch(SQLException e) {e.printStackTrace();}}
		 	}
		return result;
	}
	
	// 프로필 대표서비스 수정
	public int profileE_service(Expert dto) {
		int result = -1;
		
		Connection conn=null; PreparedStatement pstmt = null;
		String sql = "update expert set category2_id=?";
		try {
			
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,dto.getCategory2_id());
			result = pstmt.executeUpdate();
		}catch(Exception e) {e.printStackTrace();
		}finally {
		 	if(pstmt != null) {try{pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
		 	if(conn != null) {try{conn.close();}catch(SQLException e) {e.printStackTrace();}}
		 	} return result;
	}
	
	// 프로필 한줄소개
	
	public int profileE_intro(Expert dto) {
		int result = -1;
		
		Connection conn=null; PreparedStatement pstmt = null;
		String sql = "update expert set expert_intro=?";
		try {
			
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dto.getExpert_intro());
			result = pstmt.executeUpdate();
		}catch(Exception e) {e.printStackTrace();
		}finally {
		 	if(pstmt != null) {try{pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
		 	if(conn != null) {try{conn.close();}catch(SQLException e) {e.printStackTrace();}}
		 	}
		return result;
	}
	
	public int profileE_city(Expert dto) {
		int result = -1;
		Connection conn = null; PreparedStatement pstmt = null;
		String sql ="update city set city_id=?";
		try {
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,dto.getCity_id());
			result = pstmt.executeUpdate();
		}catch(Exception e) {e.printStackTrace();
		}finally {
		 	if(pstmt != null) {try{pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
		 	if(conn != null) {try{conn.close();}catch(SQLException e) {e.printStackTrace();}}
		 	}
		return result;
	}
	
	public int profileE_range(Expert dto) {
		int result = -1;
		Connection conn = null; PreparedStatement pstmt = null;
		String sql ="update expert set expert_range=?";
		try {
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dto.getExpert_range());
			result = pstmt.executeUpdate();
		}catch(Exception e) {e.printStackTrace();
		}finally {
		 	if(pstmt != null) {try{pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
		 	if(conn != null) {try{conn.close();}catch(SQLException e) {e.printStackTrace();}}
		 	}
		return result;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////DELETE	DELETE	DELETE	DELETE	DELETE	DELETE	DELETE	DELETE	DELETE////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	

	public int profileD_portfolio(Portfolio dto) {
		int result = -1;
		
		Connection conn = null; PreparedStatement pstmt = null;
		String sql = "delete from portfolio where portfolio_no=?";
		try {
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,dto.getPortfolio());
			result = pstmt.executeUpdate();
		}catch(Exception e) {e.printStackTrace();
		}finally {
		 	if(pstmt != null) {try{pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
		 	if(conn != null) {try{conn.close();}catch(SQLException e) {e.printStackTrace();}}
		 	}
		return result;
	}
	
	public int profileD_certi(Certificate dto) {
		int result = -1;
		Connection conn = null; PreparedStatement pstmt = null;
		String sql = "delete from certificate where certificate_no=?";
		try {
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,dto.getCertificate_no());
			result = pstmt.executeUpdate();
		}catch(Exception e) {e.printStackTrace();
		}finally {
		 	if(pstmt != null) {try{pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
		 	if(conn != null) {try{conn.close();}catch(SQLException e) {e.printStackTrace();}}
		 	}
		return result;
	}
	
	public int profileD_career(Career dto) {
		int result = -1;
		Connection conn = null; PreparedStatement pstmt = null;
		String sql = "delete from career where career_no=?";
		try {
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,dto.getCareer());
			result = pstmt.executeUpdate();
		}catch(Exception e) {e.printStackTrace();
		}finally {
		 	if(pstmt != null) {try{pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
		 	if(conn != null) {try{conn.close();}catch(SQLException e) {e.printStackTrace();}}
		 	}
		return result;
	}
	
	public int profileD_edu(Education dto) {
		int result = -1;
		Connection conn = null; PreparedStatement pstmt = null;
		String sql = "delete from education where education_no=?";
		try {
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,dto.getEducation());
			result = pstmt.executeUpdate();
		}catch(Exception e) {e.printStackTrace();
		}finally {
		 	if(pstmt != null) {try{pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
		 	if(conn != null) {try{conn.close();}catch(SQLException e) {e.printStackTrace();}}
		 	}
		return result;
	}
	
	public int profileD_name(User us) {
		int result = -1;
		
		Connection conn=null; PreparedStatement pstmt = null;
		String sql = "delete from user where user_name=?";
		try {
			
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,us.getUser_name());
			result = pstmt.executeUpdate();
		}catch(Exception e) {e.printStackTrace();
		}finally {
		 	if(pstmt != null) {try{pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
		 	if(conn != null) {try{conn.close();}catch(SQLException e) {e.printStackTrace();}}
		 	}
		return result;
	}
	
	// 프로필 대표서비스 수정
	public int profileD_service(Expert dto) {
		int result = -1;
		
		Connection conn=null; PreparedStatement pstmt = null;
		String sql = "delete from expert where category2_id=?";
		try {
			
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,dto.getCategory2_id());
			result = pstmt.executeUpdate();
		}catch(Exception e) {e.printStackTrace();
		}finally {
		 	if(pstmt != null) {try{pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
		 	if(conn != null) {try{conn.close();}catch(SQLException e) {e.printStackTrace();}}
		 	}
		return result;
	}
	
	// 프로필 한줄소개
	
	public int profileD_intro(Expert dto) {
		int result = -1;
		
		Connection conn=null; PreparedStatement pstmt = null;
		String sql = "delete from expert where expert_intro=?";
		try {
			
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dto.getExpert_intro());
			result = pstmt.executeUpdate();
		}catch(Exception e) {e.printStackTrace();
		}finally {
		 	if(pstmt != null) {try{pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
		 	if(conn != null) {try{conn.close();}catch(SQLException e) {e.printStackTrace();}}
		 	}
		return result;
	}
	
	public int profileD_city(Expert dto) {
		int result = -1;
		Connection conn = null; PreparedStatement pstmt = null;
		String sql ="delete from city where city_id=?";
		try {
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,dto.getCity_id());
			result = pstmt.executeUpdate();
		}catch(Exception e) {e.printStackTrace();
		}finally {
		 	if(pstmt != null) {try{pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
		 	if(conn != null) {try{conn.close();}catch(SQLException e) {e.printStackTrace();}}
		 	}
		return result;
	}
	
	public int profileD_range(Expert dto) {
		int result = -1;
		Connection conn = null; PreparedStatement pstmt = null;
		String sql ="delete from expert where expert_range=?";
		try {
			DBManager db = new DBManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dto.getExpert_range());
			result = pstmt.executeUpdate();
		}catch(Exception e) {e.printStackTrace();
		}finally {
		 	if(pstmt != null) {try{pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
		 	if(conn != null) {try{conn.close();}catch(SQLException e) {e.printStackTrace();}}
		 	}
		return result;
	}
}