package com.crud.requestdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.crud.dbmanager.DBManager;
import com.crud.requestdto.EstimateDto;
import com.crud.requestdto.RequestDetailDto;
import com.crud.requestdto.RequestedListDto;

public class EstimateDao {
	DBManager db;
	Connection conn;
	PreparedStatement pstm;
	ResultSet rset;
	
	public EstimateDao() {
		db = new DBManager();
		conn = db.getConnection();
	}
	
//////////////////////////////////////견적서 - 받은 요청///////////////////////////////////////////
	public List<RequestedListDto> estimateList(int expert_id) {
		List<RequestedListDto> list = new ArrayList<>();
		
		RequestedListDto dto = null;
		
		String sql = "select re.request_id, ca.category2_name , u.user_name , re.create_date , re.content "
				+ "from request re "
				+ "join category2 ca on ca.category2_id = re.category2_id "
				+ "join user u on u.user_id = re.user_id "
				+ "join city ci on ci.city_id = re.city_id "
				+ "join expert ex on ex.category2_id = ca.category2_id "
				+ "join city ciex on ciex.city_id = ex.city_id "
				+ "where "
				+ "    (6371000 * ACOS(  "
				+ "        COS(RADIANS(ci.mapy)) * COS(RADIANS(ciex.mapy)) * COS(RADIANS(ci.mapx) - RADIANS(ciex.mapx)) +  "
				+ "        SIN(RADIANS(ci.mapy)) * SIN(RADIANS(ciex.mapy)) "
				+ "    )) <= ex.expert_range  "
				+ "and re.status = 1  "
				+ "and ex.expert_id = ?  ";
		
		String sql2 = "select estimate_id "
				+ "from estimate es "
				+ "join request re on es.request_id = re.request_id "
				+ "where es.expert_id = ?";
		
		PreparedStatement pstm2 = null;
		ResultSet rset2 = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, expert_id);
			
			rset = pstm.executeQuery();
			
			pstm2 = conn.prepareStatement(sql2);
			pstm2.setInt(1, expert_id);
			
			rset2 = pstm2.executeQuery();
			
			while(rset.next()) {
				dto = new RequestedListDto();
				dto.setCategory2_name(rset.getString("category2_name"));
				dto.setUser_name(rset.getString("user_name"));
				dto.setCreate_date(rset.getString("create_date"));
				dto.setContent(rset.getString("content"));
				dto.setRequest_id(rset.getInt("request_id"));
				
				if(rset2.next()) {
					dto.setMystatus(1); //가지고 있으면 1(요청수락상태)
				} else {
					dto.setMystatus(-1);//없으면 -1
				}
				list.add(dto);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rset2 != null) { try {rset2.close();}catch(Exception e) {} }
			if(pstm2 != null) { try {pstm2.close();}catch(Exception e) {} }
			if(rset != null) { try {rset.close();}catch(Exception e) {} }
			if(pstm != null) { try {pstm.close();}catch(Exception e) {} }
			if(conn != null) { try {conn.close();}catch(Exception e) {} }
		}
		return list;
	}
	
//////////////////////////////////////견적서 - 받은 요청 상세///////////////////////////////////////////
	public RequestDetailDto requestDetail(int request_id) {
		RequestDetailDto dto = new RequestDetailDto();
		
		String sql = "select re.request_id, u.user_name , ci.city_name , re.work_date , re.content "
				+ "from request re "
				+ "join city ci on ci.city_id = re.city_id "
				+ "join user u on u.user_id = re.user_id  "
				+ "where re.request_id = ? ";
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, request_id);
			
			rset = pstm.executeQuery();
			
			if(rset.next()) {
				dto.setUser_name(rset.getString("user_name"));
				dto.setCity_name(rset.getString("city_name"));
				dto.setWork_date(rset.getString("work_date"));
				dto.setContent(rset.getString("content"));
				dto.setRequest_id(rset.getInt("request_id"));
			}
			
		} catch (Exception e) {
			
		} finally {
			if(rset != null) { try {rset.close();}catch(Exception e) {} }
			if(pstm != null) { try {pstm.close();}catch(Exception e) {} }
			if(conn != null) { try {conn.close();}catch(Exception e) {} }
		}
		
		return dto;
	}
	
	
//////////////////////////////////////견적서 작성	///////////////////////////////////////////
	public int estimateCreate(EstimateDto dto) {
		
		String sql = "insert into estimate ( request_id, expert_id, price, content ) values ( ?, ?, ?, ? )";
		int result = -1;
		
		try {
			conn = db.getConnection();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, dto.getRequestID());
			pstm.setInt(2, dto.getExpertID());
			pstm.setInt(3, dto.getPrice());
			pstm.setString(4, dto.getContent());
			
			result = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstm != null) { try {pstm.close();}catch(Exception e) {} }
			if(conn != null) { try {conn.close();}catch(Exception e) {} }
		}
		
		return result;
	}
}
