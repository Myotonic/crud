package com.crud.dao;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.crud.dbmanager.DBManager;
import com.crud.dto.AreaDto;
import com.crud.dto.Category1Dto;
import com.crud.dto.Category2Dto;
import com.crud.dto.CityDto;
import com.crud.dto.ExpertDto;
import com.crud.dto.UserDto;

public class MemberDao {
	public int insertUser(UserDto dto) {
		int result = -1;
		String sql = "insert into user(user_name, user_email, user_pass, user_ip) values(?,?,?,?)";
		DBManager db = new DBManager();
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUser_name());
			pstmt.setString(2, dto.getUser_email());
			pstmt.setString(3, dto.getUser_pass());
			pstmt.setString(4, InetAddress.getLocalHost().getHostAddress());
			result = pstmt.executeUpdate();
		} catch (SQLException | UnknownHostException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}

		return result;
	}

	public int insertExpert(ExpertDto dto) {
		int result = -1;
		String sql = "insert into expert (user_id, category2_id, city_id, expert_intro, expert_range) values (?, ?, ?, ?, ?)";
		DBManager db = new DBManager();
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, dto.getUser_id());
			pstmt.setInt(2, dto.getCategory2_id());
			pstmt.setInt(3, dto.getCity_id());
			pstmt.setString(4, dto.getExpert_intro());
			pstmt.setString(5, dto.getExpert_range());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return result;
	}

	public int insertArea(AreaDto dto) {
		int result = -1;
		String sql = "insert into Area(Area_name) values(?)";
		DBManager db = new DBManager();
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getArea_name());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return result;
	}

	public int getAreaId(String name) {
		int result = -1;
		String sql = "select * from area where area_name = ?";
		DBManager db = new DBManager();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt("area_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if (pstmt != null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return result;
	}


	public int insertCity(CityDto dto) {
		int result = -1;
		String sql = "insert into City(city_name, area_id) values(?, ?)";
		DBManager db = new DBManager();
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCity_name());
			pstmt.setInt(2, dto.getArea_id());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return result;
	}

	public int getCityId(String name) {
		int result = -1;
		String sql = "select * from city where city_name = ?";
		DBManager db = new DBManager();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt("city_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if (pstmt != null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return result;
	}
	public String getCityName(int city_id) {
		String result = "";
		String sql = "select * from city where city_id = ?";
		DBManager db = new DBManager();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, city_id);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getString("city_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return result;
	}

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

	public List<Category2Dto> category2(int category1_id) {
		List<Category2Dto> list = new ArrayList<>();
		String sql = "select * from category2 where category1_id = ?";
		DBManager db = new DBManager();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, category1_id);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				list.add(new Category2Dto(rset.getInt("category2_id"), rset.getString("category2_name"),
						rset.getInt("category1_id")));
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

	public int getUserId(String email) {
		int result = -1;
		String sql = "select * from user where user_email = ?";
		DBManager db = new DBManager();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt("user_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return result;
	}
	public UserDto getUser(int user_id) {
		UserDto result = new UserDto();
		String sql = "select * from user where user_id = ?";
		DBManager db = new DBManager();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user_id);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result.setUser_name(rset.getString("user_name"));
				result.setUser_email(rset.getString("user_email"));
				result.setUser_pass(rset.getString("user_pass"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return result;
	}

	public int getExpertId(int user_id) {
		int result = -1;
		String sql = "select * from expert where user_id = ?";
		DBManager db = new DBManager();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user_id);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt("expert_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return result;
	}
	
	public String getCategory2Name(int category2Id) {
		String categoryName = null;
		String sql = "SELECT category2_name FROM category2 WHERE category2_id = ?";
		DBManager db = new DBManager();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, category2Id);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				categoryName = rset.getString("category2_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}

		return categoryName;
	}

	public boolean isUser(String email, String password) {
		String sql = "select count(*) from user where user_email = ? and user_pass = ?";
		DBManager db = new DBManager();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		boolean isUser = false;

		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				int count = rset.getInt(1);
				isUser = count > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}

		return isUser;
	}

	public boolean isExpert(String email, String password) {
		String sql = "SELECT COUNT(*) FROM expert e INNER JOIN user u ON e.user_id = u.user_id WHERE u.user_email = ? AND u.user_pass = ?";
		DBManager db = new DBManager();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		boolean expert = false;

		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				int count = rset.getInt(1);
				expert = count > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if (pstmt != null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}

		return expert;
	}

	public String login(String email, String pass) {
		String result = null;
		if (isExpert(email, pass)) {
			result = "expert";
		} else if (isUser(email, pass)) {
			result = "user";
		}
		return result;
	}

	public boolean updatePassword(String email, String newPass) {
		String sql = "update user set user_pass = ? where user_email = ?";
		DBManager db = new DBManager();
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean success = false;

		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPass);
			pstmt.setString(2, email);

			success = pstmt.executeUpdate() > 0;

		} catch (SQLException  e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}

		return success;
	}
	
	public boolean updateUserName(int user_id, String newName) {
		String sql = "update user set user_name = ? where user_id = ?";
		DBManager db = new DBManager();
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean success = false;

		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newName);
			pstmt.setInt(2, user_id);

			success = pstmt.executeUpdate() > 0;

		} catch (SQLException  e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}

		return success;
	}

	public boolean deleteMember(int user_id) {
		String sql = "delete from user where user_id = ?";
		DBManager db = new DBManager();
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean success = false;

		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user_id);

			success = pstmt.executeUpdate() > 0; 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}

		return success;
	}

}
