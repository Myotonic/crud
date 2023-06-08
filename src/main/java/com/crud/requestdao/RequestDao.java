package com.crud.requestdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.crud.dbmanager.DBManager;
import com.crud.requestdto.EstimateDetailDto;
import com.crud.requestdto.EstimatedListDto;
import com.crud.requestdto.RequestCategoryDto;
import com.crud.requestdto.RequestDto;
import com.crud.requestdto.RequestListDto;

public class RequestDao {
	DBManager db;
	Connection conn;
	PreparedStatement pstm;
	ResultSet rset;
	
public RequestDao() {
	db = new DBManager();
	conn = db.getConnection();
}

	//////////////////////////////////////	요청서 작성	///////////////////////////////////////////
	public int requestCreate(RequestDto dto) {
		int result = -1;
		
		String sql = "insert into request ( user_id, category2_id, city_id, work_date, content ) values ( ?, ?, ?, ?, ? )";
		
		try {
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, dto.getUser_id());
			pstm.setInt(2, dto.getCategory2_id());
			pstm.setInt(3, dto.getCity_id());
			pstm.setString(4, dto.getWork_date());
			pstm.setString(5, dto.getContent());
			
			result = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstm != null) { try {pstm.close();}catch(Exception e) {} }
			if(conn != null) { try {conn.close();}catch(Exception e) {} }
		}
		
		return result;
	}
	
	
////////////////////////////////////// 요청내역	///////////////////////////////////////////
	public List<RequestListDto> requestList(int user_id) {
		List<RequestListDto> list = new ArrayList<>();
		RequestListDto dto = null;
		
		String sql = "select re.request_id, ca.category2_name, re.create_date, re.status, count(es.request_id) count "
				+ "from request re "
				+ "join category2 ca on ca.category2_id = re.category2_id "
				+ "left join estimate es on es.request_id = re.request_id "
				+ "where re.user_id=? "
				+ "group by re.request_id";
		
//		String sql = "select ca.category2_name , re.create_date, re.status, count(es.request_id) count \r\n"
//				+ "from request re\r\n"
//				+ "join category2 ca on ca.category2_id = re.category2_id\r\n"
//				+ "left join estimate es on es.request_id = re.request_id\r\n"
//				+ "where re.user_id=?\r\n"
//				+ "group by re.request_id";
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, user_id);
			
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				System.out.println("qq");
				dto = new RequestListDto();
				
				dto.setRequest_id(rset.getInt("re.request_id"));
				dto.setCategory2_name(rset.getString("ca.category2_name"));
				dto.setCreate_date(rset.getString("re.create_date"));
				dto.setStatus(rset.getInt("re.status"));
				dto.setCount(rset.getInt("count"));
				
				list.add(dto);
				
			}
			
		} catch(Exception e) {
			
		} finally {
			if(rset != null) { try {rset.close();}catch(Exception e) {} }
			if(pstm != null) { try {pstm.close();}catch(Exception e) {} }
			if(conn != null) { try {conn.close();}catch(Exception e) {} }
		}
		
		return list;
	}
	
//////////////////////////////////////요청서 - 받은견적 목록///////////////////////////////////////////
	public List<EstimatedListDto> estimatedList(int request_id) {
		
		List<EstimatedListDto> list = new ArrayList<>();
		EstimatedListDto dto = null;
		
//		String sql = "select u.user_name, exex.review_no, es.price "
//				+ "from estimate es "
//				+ "join expert ex on es.expert_id = ex.expert_id "
//				+ "join expert_prifile exex on exex.expert_id = ex.expert_id "
//				+ "join user u on u.user_id = ex.user_id "
//				+ "where es.request_id = ?";  // 요청서아이디의 견적서 전부
		
		String sql = "select es.request_id, es.estimate_id, u.user_name , exex.expert_review_no , es.price\r\n"
				+ "from estimate es\r\n"
				+ "join expert ex on es.expert_id = ex.expert_id\r\n"
				+ "join expert_profile exex on exex.expert_id = ex.expert_id\r\n"
				+ "join user u on u.user_id = ex.user_id\r\n"
				+ "where es.request_id =?";
		
		try {
			
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, request_id);
			
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				dto = new EstimatedListDto();
				dto.setUser_name(rset.getString("u.user_name"));
				dto.setReview(rset.getInt("exex.expert_review_no"));
				dto.setPrice(rset.getInt("es.price"));
				dto.setEstimate_id(rset.getInt("es.estimate_id"));
				dto.setRequest_id(rset.getInt("es.request_id"));
				
				list.add(dto);
			}
			
		} catch(Exception e) {
			
		} finally {
			if(rset != null) { try {rset.close();}catch(Exception e) {} }
			if(pstm != null) { try {pstm.close();}catch(Exception e) {} }
			if(conn != null) { try {conn.close();}catch(Exception e) {} }
		}
		
		return list;
	}
	
//////////////////////////////////////요청서 - 받은견적 목록의 상세///////////////////////////////////////////
	public EstimateDetailDto estimateDetail(int estimate_id) {
		
		EstimateDetailDto dto = new EstimateDetailDto();
		
//		String sql = "select u.user_name , expro.review , ex.city_id , ca.career_entry , es.content , es.price "
//				+ "from estimate es "
//				+ "join expert ex on es.expert_id = ex.expert_id "
//				+ "join career ca on ex.expert_id = ca.expert_id "
//				+ "join expert_profile expro on expro.expert_id = ca.expert_id "
//				+ "join city ci on ex.city_id = ci.city_id "
//				+ "join user u on u.user_id = ex.user_id "
//				+ "where es.estimate_id = ?";
		
		String sql = "select u.user_name , expro.expert_review_no , ci.city_name , ca.career_entry , es.content , es.price\r\n"
				+ "from estimate es\r\n"
				+ "join expert ex on es.expert_id = ex.expert_id\r\n"
				+ "join career ca on ex.expert_id = ca.expert_id\r\n"
				+ "join expert_profile expro on expro.expert_id = ca.expert_id\r\n"
				+ "join city ci on ex.city_id = ci.city_id\r\n"
				+ "join user u on u.user_id = ex.user_id\r\n"
				+ "where es.estimate_id = ?";
		
		try {
			conn = db.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, estimate_id);
			
			rset = pstm.executeQuery();
			
			if(rset.next()) {
				dto.setUser_name(rset.getString("u.user_name"));
				dto.setReview(rset.getInt("expro.expert_review_no"));
				dto.setCity_name(rset.getString("ci.city_name"));
				dto.setCareer_entry(rset.getString("ca.career_entry"));
				dto.setContent(rset.getString("es.content"));
				dto.setPrice(rset.getInt("es.price"));
			}
			
		} catch(Exception e) {
			
		} finally {
			if(rset != null) { try {rset.close();}catch(Exception e) {} }
			if(pstm != null) { try {pstm.close();}catch(Exception e) {} }
			if(conn != null) { try {conn.close();}catch(Exception e) {} }
		}
		
		return dto;
		
	}
	
	public int requestCancle(int request_id) {
		int result = -1;
		
		String sql = "update request set status=0 where request_id=?";
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, request_id);
			
			result = pstm.executeUpdate();
			
		} catch (Exception e) {
			
		} finally {
			if(pstm != null) { try {pstm.close();}catch(Exception e) {} }
			if(conn != null) { try {conn.close();}catch(Exception e) {} }
		}
		return result;
	}
	
	public RequestCategoryDto requestMainCategory(int category2_id) {
		
		String sql = "select ca2.category2_name, ca1.category1_name from category2 ca2 join category1 ca1 using(category1_id) where category2_id = ?";
		
		RequestCategoryDto dto = new RequestCategoryDto();

		try {
			conn = db.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1,category2_id);
			rset = pstm.executeQuery();
			if(rset.next()) {
				dto.setCategory2_id(category2_id);
				dto.setCategory2_name(rset.getString("category2_name"));
				dto.setCategory1_name(rset.getString("category1_name"));
				dto.setCategory1_id(rset.getInt("category1_id"));
			}
		} catch (Exception e) {
			
		} finally {
			if(rset != null) { try {rset.close();}catch(Exception e) {} }
			if(pstm != null) { try {pstm.close();}catch(Exception e) {} }
			if(conn != null) { try {conn.close();}catch(Exception e) {} }
		}
		
		return dto;
		
	}
	
}
