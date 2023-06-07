package com.crud.dao;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crud.dbmanager.DBManager;
import com.crud.dto.Answer;
import com.crud.dto.Category1Dto;
import com.crud.dto.Faq;
import com.crud.dto.Inquiry;
import com.crud.dto.MDto;
import com.crud.dto.Time;

public class MDao {
	/////////////////////////////////////////create
	public int createMarket(MDto dto) {
		int result = -1;
		String sql = "INSERT INTO market ( "
				+ "title, content, price, ip, refund, division, expert_id, category1_id, category2_id "
				+ ") "
				+ "values ( "
				+ "?, ?, ?, ?, ?, ?, ?, ?, ? "
				+ ")";
		DBManager db = new DBManager();
		Connection conn =null; PreparedStatement pstmt = null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getPrice());
			pstmt.setString(4, InetAddress.getLocalHost().getHostAddress());
			pstmt.setString(5, dto.getRefund());
			pstmt.setString(6, dto.getDivision());
			pstmt.setInt(7, dto.getExpert_id());
			pstmt.setInt(8, dto.getCategory1_id());
			pstmt.setInt(9, dto.getCategory2_id());
			result=pstmt.executeUpdate();
			pstmt.close();
			result = createImg(dto.getImages(),dto.getExpert_id(),conn);
			for(Faq f : dto.getFaq()) {
				result = createFaq(f,dto.getExpert_id(),conn);
			}
			if(dto.getDivision().equals("수업")) {
				result = createClass(dto,conn);
			}
		} catch (SQLException | UnknownHostException e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) {try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result;
	}
	public int createClass(MDto dto, Connection conn) {
		int result = -1;
		boolean checkConn = false;
		String sql="INSERT INTO class (market_id, appointment, proceed, location, startSchedule, endSchedule)"
				+ "SELECT market_id, ?, ?,"
				+ "CASE WHEN ? = '대면' THEN ? ELSE NULL END,"
				+ "CASE WHEN ? = '시간등록' THEN ? ELSE NULL END,"
				+ "CASE WHEN ? = '시간등록' THEN ? ELSE NULL END "
				+ "FROM market WHERE expert_id = ? ORDER BY date DESC LIMIT 1";
		// 위에 when절 뒤에 구문 확인.
		if(conn==null) {
			DBManager db = new DBManager();
			conn = db.getConnection();
			checkConn=true;
		}
		PreparedStatement pstmt=null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getAppointment());
			pstmt.setString(2, dto.getProceed());
			pstmt.setString(3, dto.getProceed());
			pstmt.setString(4, dto.getLocation());
			pstmt.setString(5, dto.getAppointment());
			pstmt.setString(6, dto.getStartSchedule());
			pstmt.setString(7, dto.getAppointment());
			pstmt.setString(8, dto.getEndSchedule());
			pstmt.setInt(9, dto.getExpert_id());
			result = pstmt.executeUpdate();
			pstmt.close();
			if(dto.getAppointment().equals("시간등록")) {
				for(Time t : dto.getTime()) {
					result=createTime(t,dto.getExpert_id(),conn);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(checkConn && conn!=null) {try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result;
	}
	public int createImg(List<String> img, int expert_id ,Connection conn) {
		int result = -1;
		boolean checkConn = false;
		String sql = "insert into images "
				+ "values( "
				+ "(select market_id from market where expert_id = ? order by date desc limit 1), "
				+ "?,?,?,?,?,?,?,?,?,?)";
		if(conn==null) {
			DBManager db = new DBManager();
			conn = db.getConnection();
			checkConn=true;
		}
		PreparedStatement pstmt = null;
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1,expert_id);
			int cnt = 2;
			System.out.println(img);
			for(String s:img) {
				pstmt.setString(cnt, s);
				cnt++;
			}
			for(int i=cnt; i <12; i++) {
				pstmt.setString(i, "no.img");
			}
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(checkConn && conn!=null) {try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result;
	}
	public int createFaq(Faq faq, int expert_id, Connection conn) {
		int result = -1;
		boolean checkConn = false;
		String sql = "insert into faq( title, content, market_id) "
				+ "values( "
				+ "?, ?, "
				+ "(select market_id from market where expert_id = ? order by date desc limit 1))";
		PreparedStatement pstmt = null;
		if(conn==null) {
			DBManager db = new DBManager();
			conn = db.getConnection();
			checkConn=true;
		}
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, faq.getTitle());
			pstmt.setString(2, faq.getContent());
			pstmt.setInt(3, expert_id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(checkConn && conn!=null) {try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result;
	}
	public int createTime(Time time,int expert_id, Connection conn) {
		int result = -1;
		boolean checkConn = false;
		String sql ="INSERT INTO time (day, starttime, endtime, market_id) "
				+ "SELECT ?, ?, ?, market_id "
				+ "FROM market "
				+ "WHERE expert_id = ? "
				+ "ORDER BY date DESC "
				+ "LIMIT 1 ";
		if(conn==null) {
			DBManager db = new DBManager();
			conn = db.getConnection();
			checkConn=true;
		}
		PreparedStatement pstmt = null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, time.getDay());
			pstmt.setString(2, time.getStarttime());
			pstmt.setString(3, time.getEndtime());
			pstmt.setInt(4, expert_id);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(checkConn && conn!=null) {try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result;
	}
	public int createInquiry(Inquiry inquiry) {
		int result = -1;
		String sql = "insert into inquiry( category, title, content, ip, market_id, user_id) values "
				+ "(?, ?, ?, ?, ?, ?)";
		DBManager db = new DBManager();
		Connection conn = null; PreparedStatement pstmt =null;
		try {
			conn=db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inquiry.getCategory());
			pstmt.setString(2, inquiry.getTitle());
			pstmt.setString(3, inquiry.getContent());
			pstmt.setString(4, InetAddress.getLocalHost().getHostAddress());
			pstmt.setInt(5, inquiry.getMarket_id());
			pstmt.setInt(6, inquiry.getUser_id());
			result=pstmt.executeUpdate();
			
		} catch (SQLException | UnknownHostException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) {try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		
		return result;
	}
	public int createAnswer(int inquiry_id, Answer answer) {
		int result = -1;
		String sql = "INSERT INTO answer (inquiry_id, answer, expert_id, market_id) "
	             + "VALUES (?, ?, ?, (SELECT market_id FROM inquiry WHERE inquiry_id = ?))";
		DBManager db = new DBManager();
		Connection conn=null; PreparedStatement pstmt=null;
		try {
			conn = db.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, inquiry_id);
			pstmt.setString(2, answer.getAnswer());
			pstmt.setInt(3, answer.getExpert_id());
			pstmt.setInt(4, inquiry_id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) {try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result;
	}
	public int marketBuy(int user_id, int market_id) {
		int result =-1;
		String sql = "insert into user_market "
				+ "values(?,?)";
		DBManager db =new DBManager();
		Connection conn = null; PreparedStatement pstmt = null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user_id);
			pstmt.setInt(2, market_id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) {try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result;
	}
	/////////////////////////////////////////create

	
	/////////////////////////////////////////read
	public List<MDto> readMarket(String division, int category1_id, int count){
		List<MDto> list = new ArrayList<>();
		String where = "\r";
		if(category1_id>0) {
			where = " and m.category1_id = ? ";
		}
		String sql = "select m.market_id, m.title, m.price, c2.category2_name, i.img1, m.hit from "
				+ "market m left join images i using(market_id) "
				+ "left join category2 c2 using(category2_id) "
				+ "where division = ? "+where+""
				+ "order by date desc "
				+ "limit ?,9";
		DBManager db = new DBManager();
		int tempCnt = 2;
		Connection conn=null; PreparedStatement pstmt=null; ResultSet rset=null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, division);
			if(category1_id>0) { pstmt.setInt(2, category1_id); tempCnt++; }
			pstmt.setInt(tempCnt, count);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new MDto(rset.getInt("m.market_id"),rset.getString("m.title"),
						rset.getInt("m.price"), rset.getString("c2.category2_name"), rset.getString("i.img1"),
						rset.getInt("m.hit")));
			}
			System.out.println(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rset!=null) {try { rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) {try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		
		return list;
	}
	public List<MDto> userMarket(String division, int user_id, int market_id){
		List<MDto> list = new ArrayList<>();
		String sql = "SELECT m.market_id, m.title, m.price, c2.category2_name, i.img1, m.hit\r\n"
				+ "FROM market m\r\n"
				+ "LEFT JOIN images i ON m.market_id = i.market_id\r\n"
				+ "LEFT JOIN category2 c2 ON m.category2_id = c2.category2_id\r\n"
				+ "LEFT JOIN user_market um ON m.market_id = um.market_id\r\n"
				+ "LEFT JOIN user u ON um.user_id = u.user_id\r\n"
				+ "WHERE m.division = ? AND u.user_id = ?\r\n"
				+ "ORDER BY m.date DESC "
				+ "limit ?,5";
		DBManager db = new DBManager();
		Connection conn=null; PreparedStatement pstmt=null; ResultSet rset=null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, division);
			pstmt.setInt(2, user_id);
			pstmt.setInt(3, market_id);			
			rset=pstmt.executeQuery();
			while(rset.next()) {
				list.add(new MDto(rset.getInt("m.market_id"),rset.getString("m.title"),
						rset.getInt("m.price"), rset.getString("c2.category2_name"), rset.getString("i.img1"),
						rset.getInt("m.hit")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rset!=null) {try { rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) {try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return list;
	}
	public List<MDto> expertMarket(String division, int expert_id, int market_id){
		List<MDto> list = new ArrayList<>();
		String sql = "select m.market_id, m.title, m.price, c2.category2_name, i.img1, m.hit from "
			    + "market m left join images i using(market_id) "
			    + "left join category2 c2 using(category2_id) "
			    + "where division = ? AND expert_id = ? "
			    + "order by date desc "
			    + "limit ?, 5";
		DBManager db = new DBManager();
		Connection conn=null; PreparedStatement pstmt=null; ResultSet rset=null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, division);
			pstmt.setInt(2, expert_id);
			pstmt.setInt(3, market_id);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new MDto(rset.getInt("m.market_id"),rset.getString("m.title"),
						rset.getInt("m.price"), rset.getString("c2.category2_name"), rset.getString("i.img1"),
						rset.getInt("m.hit")));
			}
			System.out.println(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rset!=null) {try { rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) {try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		
		return list;
	}
	public String expertName(int expert_id, Connection conn) {
		String result = "";
		String sql="select * from user "
				+ "LEFT JOIN expert using(user_id) "
				+ "where expert.expert_id = ?";
		PreparedStatement pstmt = null; ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, expert_id);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getString("user.user_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rset!=null) {try { rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result;
	}
	public MDto detailMarket(int market_id) {
		MDto dto = new MDto();
		List<Faq> faq = new ArrayList<>();
		List<Time> time = new ArrayList<>();
		List<String> images = new ArrayList<>();
		String sql = "SELECT * "
				+ "FROM market "
				+ "LEFT JOIN images USING (market_id) "
				+ "LEFT JOIN faq USING (market_id) "
				+ "LEFT JOIN category1 USING (category1_id) "
				+ "LEFT JOIN category2 USING (category2_id) "
				+ "LEFT JOIN class ON market.market_id = class.market_id "
				+ "LEFT JOIN time ON market.market_id = time.market_id "
				+ "WHERE market.market_id = ? ";
		DBManager db = new DBManager();
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, market_id);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				dto.setMarket_id(rset.getInt("market_id"));
				dto.setTitle(rset.getString("market.title"));
				dto.setContent(rset.getString("market.content"));
				dto.setHit(rset.getInt("market.hit"));
				dto.setPrice(rset.getInt("market.price"));
				dto.setRefund(rset.getString("market.refund"));
				dto.setDivision(rset.getString("market.division"));
				dto.setExpert_id(rset.getInt("market.expert_id"));
				dto.setCategory1_name(rset.getString("category1.category1_name"));
				dto.setCategory2_name(rset.getString("category2.category2_name"));
				dto.setAppointment(rset.getString("class.appointment"));
				dto.setProceed(rset.getString("class.proceed"));
				dto.setStartSchedule(rset.getString("class.startSchedule"));
				dto.setEndSchedule(rset.getString("class.endSchedule"));
				dto.setLocation(rset.getString("class.location"));
				time.add(new Time(rset.getInt("time.time_id"),rset.getString("time.day"),
						rset.getString("time.starttime"),rset.getString("time.endtime"),dto.getMarket_id()));
				faq.add(new Faq(rset.getInt("faq.faq_id"),rset.getString("faq.title"),rset.getString("faq.content"),dto.getMarket_id()));
				for(int i = 1 ; i < 11; i++) {
					images.add(rset.getString("images.img"+i));
				}
//				images.add(rset.getString("images.img1"));
//				images.add(rset.getString("images.img2"));
//				images.add(rset.getString("images.img3"));
//				images.add(rset.getString("images.img4"));
//				images.add(rset.getString("images.img5"));
//				images.add(rset.getString("images.img6"));
//				images.add(rset.getString("images.img7"));
//				images.add(rset.getString("images.img8"));
//				images.add(rset.getString("images.img9"));
//				images.add(rset.getString("images.img10"));
			}
			dto.setTime(time);
			dto.setImages(images);
			dto.setFaq(faq);
			marketHit(market_id,conn);
			dto.setExpert_name(expertName(dto.getExpert_id(),conn));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rset!=null) {try { rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) {try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		
		return dto;
	}
	public List<Inquiry> readInquiry(int id,String where,int count){
		List<Inquiry> list = new ArrayList<>();
		String sql = "select i.inquiry_id, i.category, i.title, i.market_id, m.title, a.answer "
				+ "from inquiry i "
				+ "left join market m using(market_id) "
				+ "left join answer a using(inquiry_id) "
				+ "where "+where+" = ? "
				+ "order by i.date desc "
				+ "limit ?, 5";
		DBManager db = new DBManager();
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset=null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setInt(2, count);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Inquiry inquiry = new Inquiry();
				inquiry.setInquiry_id(rset.getInt("i.inquiry_id"));
				inquiry.setCategory(rset.getString("i.category"));
				inquiry.setTitle(rset.getString("i.title"));
				inquiry.setMarket_id(rset.getInt("i.market_id"));
				inquiry.setCheckAnswer(rset.getString("a.answer")!=null? true:false);
				inquiry.setmTitle(rset.getString("m.title"));
				list.add(inquiry);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rset!=null) {try { rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) {try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		System.out.println(list);
		return list;
	}

	public Inquiry detailInquiry(int inquiry_id) {
		Inquiry inquiry = new Inquiry();
		String sql = "select * "
				+ "from inquiry "
				+ "left join user using(user_id) "
				+ "left join answer using(inquiry_id) "
				+ "where inquiry_id = ?";
		DBManager db = new DBManager();
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset=null;
		conn=db.getConnection();
		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, inquiry_id);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				inquiry.setInquiry_id(rset.getInt("inquiry.inquiry_id"));
				inquiry.setCategory(rset.getString("inquiry.category"));
				inquiry.setTitle(rset.getString("inquiry.title"));
				inquiry.setContent(rset.getString("inquiry.content"));
				inquiry.setDate(rset.getString("inquiry.date"));
				inquiry.setMarket_id(rset.getInt("inquiry.market_id"));
				inquiry.setUser_id(rset.getInt("inquiry.user_id"));
				inquiry.setUser(rset.getString("user.user_name"));
				inquiry.setCheckAnswer(rset.getString("answer.answer")!=null? true:false);
				if(inquiry.isCheckAnswer()) {
					Answer answer= new Answer();
					answer.setAnswer(rset.getString("answer.answer"));
					answer.setDate(rset.getString("answer.date"));
					answer.setExpert_id(rset.getInt("answer.expert_id"));
					answer.setInquiry_id(inquiry.getInquiry_id());
					answer.setMarket_id(inquiry.getMarket_id());
					inquiry.setAnswer(answer);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rset!=null) {try { rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) {try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return inquiry;
	}
	/////////////////////////////////////////read
	/////////////////////////////////////////Update
	public int marketHit(int market_id, Connection conn) {
		int result = -1;
		String sql="update market set hit=hit+1 where market_id=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, market_id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result;
	}
	public int updateMarketDate(int market_id, Connection conn) {
		int result = -1;
		String sql = "UPDATE market SET "
				+ "date = NOW() "
				+ "where market_id = ?";
		boolean checkConn = false;
		if(conn==null) {
			DBManager db = new DBManager();
			conn=db.getConnection();
			checkConn=true;
		}
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, market_id);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(checkConn && conn!=null) {try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		
		return result;
	}
	public int updateMarket(MDto dto) {
		int result = -1;
		String sql = "UPDATE market SET "
				+ "title = ?, content = ?, price = ?, ip = ?, refund = ? "
				+ "WHERE market_id = ?";
		DBManager db = new DBManager();
		Connection conn = null; PreparedStatement pstmt = null;
		
		try {
			conn=db.getConnection();
			if(conn!=null) {System.out.println(1);}
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getPrice());
			pstmt.setString(4, InetAddress.getLocalHost().getHostAddress());
			pstmt.setString(5, dto.getRefund());
			pstmt.setInt(6, dto.getMarket_id());
			result=pstmt.executeUpdate();
			pstmt.close();
			System.out.println("상품 : " + result);
			result=updateMarketDate(dto.getMarket_id(),conn);
			System.out.println("date업데이트 : " + result);			
			result = updateImg(dto.getImages(),dto.getMarket_id(),conn);
			System.out.println("이미지 : " + result);
			for(Faq f : dto.getFaq()) {
				result = updateFaq(f,conn);
				System.out.println("faq들 : " + result);
			}
			if(dto.getDivision().equals("수업")) {
				result = updateClass(dto,conn);
				System.out.println("수업 : " + result);
			}
		} catch (SQLException | UnknownHostException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) {try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result;
	}
	public int updateClass(MDto dto, Connection conn) {
		int result =-1;
		String sql="update class set "
				+ "appointment = ?, "
				+ "proceed = ?, "
				+ "location = ?, "
				+ "startSchedule= ?, "
				+ "endSchedule = ? "
				+ "where market_id = ?";
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getAppointment());
			pstmt.setString(2, dto.getProceed());
			pstmt.setString(3, dto.getLocation());
			pstmt.setString(4, dto.getStartSchedule());
			pstmt.setString(5, dto.getEndSchedule());
			pstmt.setInt(6, dto.getMarket_id());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result;
		
	}
	public int updateFaq(Faq faq, Connection conn) {
		int result =-1;
		String sql = "UPDATE faq SET title = ?, content = ? WHERE market_id = ?";
		PreparedStatement pstmt= null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, faq.getTitle());
			pstmt.setString(2, faq.getContent());
			pstmt.setInt(3, faq.getMarket_id());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result;
	}
	public int updateImg(List<String> images, int market_id, Connection conn) {
		int result = -1;
		String sql = "UPDATE images SET "
				+ "img1 =?, "
				+ "img2 =?, "
				+ "img3 =?, "
				+ "img4 =?, "
				+ "img5 =?, "
				+ "img6 =?, "
				+ "img7 =?, "
				+ "img8 =?, "
				+ "img9 =?, "
				+ "img10 =? "
				+ "where market_id =?";
		PreparedStatement pstmt =null;
		try {
			int cnt = 1;
			pstmt = conn.prepareStatement(sql);
			for(String s:images) {
				pstmt.setString(cnt, s);
				cnt++;
			}
			for(int i=cnt; i <11; i++) {
				pstmt.setString(i, "no.img");
			}
			pstmt.setInt(11, market_id);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result;
	}
	public int updateTime(Time time, Connection conn) {
		int result = -1;
		String sql = "UPDATE time SET "
				+ "day = ?, "
				+ "starttime = ?, "
				+ "endtime= ? "
				+ "where time_id=?";
		PreparedStatement pstmt=null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, time.getDay());
			pstmt.setString(2, time.getStarttime());
			pstmt.setString(3,time.getEndtime());
			pstmt.setInt(4, time.getMarket_id());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result;
	}
	///여기부터
	public int updateInquiry(Inquiry inquiry) {
		int result = -1;
		String sql = "UPDATE inquiry SET\r\n"
				+ "title = ?,\r\n"
				+ "content = ?,\r\n"
				+ "date = NOW(),\r\n"
				+ "ip = ?\r\n"
				+ "where inquiry_id = ?";
		DBManager db = new DBManager();
		Connection conn = null; PreparedStatement pstmt=null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inquiry.getTitle());
			pstmt.setString(2, inquiry.getContent());
			pstmt.setString(3, InetAddress.getLocalHost().getHostAddress());
			pstmt.setInt(4, inquiry.getInquiry_id());
			result = pstmt.executeUpdate();
		} catch (SQLException | UnknownHostException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) {try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result;
	}
	public int updateAnswer(Answer answer) {
		int result = -1;
		String sql = "UPDATE answer \r\n"
				+ "SET answer = ?,\r\n"
				+ "date = NOW()\r\n"
				+ "WHERE inquiry_id = ?";
		DBManager db = new DBManager();
		Connection conn = null; PreparedStatement pstmt = null;
		try {
			conn = db.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, answer.getAnswer());
			pstmt.setInt(2,answer.getInquiry_id());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) {try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result;
	}
	/////////////////////////////////////////Update
	
	/////////////////////////////////////////Delete
	public int deleteMarket(MDto dto) {
		int result = -1;
		String sql = "DELETE FROM market\r\n"
					+ "WHERE market_id = ?";
		DBManager db = new DBManager();
		Connection conn = null; PreparedStatement pstmt=null;
		try {
			conn = db.getConnection();
			result = deleteAllFaq(dto.getMarket_id(),conn);
			result = deleteAllImages(dto.getMarket_id(),conn);
			result = deleteAllInquiry(dto.getMarket_id(),conn);
			if(dto.getDivision().equals("수업")) {
				result = deleteClass(dto.getMarket_id(),conn);
				result = deleteAllTime(dto.getMarket_id(),conn);
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getMarket_id());
			result=pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) {try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result;
	}
	public int deleteAllFaq(int market_id, Connection conn) {
		int result = -1;
		String sql = "DELETE FROM faq\r\n"
				+ "where market_id = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, market_id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result;
	}
	public int deleteAllImages(int market_id, Connection conn) {
		int result = -1;
		String sql = "DELETE FROM images\r\n"
				+ "where market_id = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, market_id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result;
	}
	public int deleteClass(int market_id, Connection conn) {
		int result = -1;
		String sql = "DELETE FROM class\r\n"
				+ "where market_id = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, market_id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result;
	}
	public int deleteAllTime(int market_id, Connection conn) {
		int result = -1;
		String sql = "DELETE FROM time\r\n"
				+ "where market_id = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, market_id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result;
	}
	public int deleteAllInquiry(int market_id, Connection conn) {
		int result = -1;
		String sql = "DELETE FROM inquiry\r\n"
				+ "where market_id = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, market_id);
			result = pstmt.executeUpdate();
			pstmt.close();
			result = deleteAllAnswer(market_id,conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result;
	}
	public int deleteInquiry(int inquiry_id) {
		int result = -1;
		String sql = "DELETE FROM inquiry\r\n"
				+ "where inquiry_id = ?";
		DBManager db = new DBManager();
		Connection conn = null; PreparedStatement pstmt = null; 
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, inquiry_id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result;
	}
	public int deleteAllAnswer(int market_id, Connection conn) {
		int result = -1;
		String sql = "DELETE FROM answer\r\n"
				+ "where market_id = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, market_id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result;
	}
	public int deleteAnswer(int inquiry_id) {
		int result = -1;
		String sql = "DELETE FROM answer\r\n"
				+ "where inquiry_id = ?";
		DBManager db = new DBManager();
		Connection conn = null; PreparedStatement pstmt = null; 
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, inquiry_id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result;
	}
	/////////////////////////////////////////Delete
	/////////////////////////////////////////해인
	public List<Category1Dto> category1() {
	      List<Category1Dto> list = new ArrayList<>();
	      String sql = "select * from category1";
	      DBManager db = new DBManager();
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;

	      try {
	         conn = db.getConnection();
	         pstmt = conn.prepareStatement(sql);
	         rset = pstmt.executeQuery();
	         while (rset.next()) {
	            list.add(new Category1Dto(rset.getInt("category1_id"), rset.getString("category1_name")));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         if (rset != null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
	         if (pstmt != null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
	         if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
	      }
	      return list;
	   }
}
