package com.crud.dao;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crud.dbmanager.DBManager;
import com.crud.dto.AdminDto;
import com.crud.dto.AreaCityDto;
import com.crud.dto.AreaDto;
import com.crud.dto.Category1Dto;
import com.crud.dto.Category2Dto;
import com.crud.dto.CategoryDto;
import com.crud.dto.CityDto;
import com.crud.dto.ExpertDto;
import com.crud.dto.MarketDto;
import com.crud.dto.UserDto;
import com.crud.dto.UserExpertCategoryCityDto;
import com.crud.dto.UserExpertDto;
import com.crud.dto.UserMarketCategoryDto;

public class AdminDao {

	public AdminDto result (AdminDto dto){    // 관리자 홈. 로그인 결과 페이지
		
		AdminDto result = new AdminDto();
		
		
		String sql = "select * from admin where admin_email=?";
		
		
		DBManager db = new DBManager();
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		
		try {
			
			conn = db.getConnection();
			
			pstmt =conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getAdmin_email());
			
			
			rset = pstmt.executeQuery();
			
			
			if(rset.next()) {
				
				
				
				result = new AdminDto(rset.getInt("admin_num"), rset.getString("admin_pass"), rset.getString("admin_name"), rset.getString("admin_email"), rset.getString("admin_date"), rset.getString("admin_ip"));
				
				
			}
			
			
			
			
			
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
		
		
		
		
		
		
		
		return result;
	}
	
	


/*

+--------------+--------------+------+-----+-------------------+-------------------+
| Field        | Type         | Null | Key | Default           | Extra             |
+--------------+--------------+------+-----+-------------------+-------------------+
| expert_id    | int          | NO   | PRI | NULL              | auto_increment    |
| expert_intro | varchar(255) | NO   |     | NULL              |                   |
| expert_date  | datetime     | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
| expert_range | varchar(200) | NO   |     | NULL              |                   |
| user_id      | int          | NO   | MUL | NULL              |                   |
| city_id      | int          | NO   | MUL | NULL              |                   |
| category2_id | int          | NO   | MUL | NULL              |                   |
+--------------+--------------+------+-----+-------------------+-------------------+
*
*
*/

public List<UserExpertDto> exportList(){  //userdto와 expertdto를 합쳐서 dto를 만듬
	
	List<UserExpertDto> result = new ArrayList<>();
	
	
	String sql = "SELECT u.user_id, u.user_name, u.user_email, u.user_date, e.expert_id, e.expert_intro, e.expert_date, e.expert_range, e.user_id, e.category2_id, e.city_id " +
            "FROM user u " +
            "LEFT JOIN expert e ON u.user_id = e.user_id " +
            "LEFT JOIN category2 c2 ON e.category2_id = c2.category2_id " +
            "LEFT JOIN city c ON e.city_id = c.city_id order by u.user_id desc";
		
	
	
	DBManager db = new DBManager();
	Connection conn= null;
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	
	
	
	try {
		
		conn = db.getConnection();
		
		pstmt =conn.prepareStatement(sql);
		
		
		rset = pstmt.executeQuery();
		
		
		while(rset.next()) {
			
			
			
			 UserDto userDto = new UserDto();
			 userDto.setUser_id(rset.getInt("user_id"));
			 userDto.setUser_name(rset.getString("user_name"));
			 userDto.setUser_email(rset.getString("user_email"));
			 userDto.setUser_date(rset.getString("user_date"));
			 
			 ExpertDto expertDto = new ExpertDto();
			 expertDto.setExpert_id(rset.getInt("expert_id"));
			 expertDto.setExpert_intro(rset.getString("expert_intro"));
			 expertDto.setExpert_date(rset.getString("expert_date"));
			 expertDto.setExpert_range(rset.getString("expert_range"));
			 expertDto.setUser_id(rset.getInt("user_id"));
			 expertDto.setCategory2_id(rset.getInt("category2_id"));
			 expertDto.setCity_id(rset.getInt("city_id"));

			
			 result.add(new UserExpertDto(userDto, expertDto));
			
			
		}
		
		
		
		
		
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
	
	
	
	
	
	
	
	return result;
}
	
public UserExpertCategoryCityDto exportDetail(UserDto dto){  //userdto와 expertdto를 합쳐서 dto를 만듬. 파라미터는 userdto에서 user_id를 뽑아서 디테일을 뿌릴것.
	
	UserExpertCategoryCityDto result = new UserExpertCategoryCityDto();
	
	
	String sql = "select u.user_id, user_name, user_email, user_date, expert_id, expert_intro, expert_date, expert_range, category2_name, category1_name , city_name, area_name "
			+ "from user u "
			+ "left join expert e using(user_id) "
			+ "left join category2 using(category2_id) "
			+ "left join category1 using(category1_id) "
			+ "left join city using(city_id) "
			+ "left join area using(area_id) "
			+ "where u.user_id = ?";
		
	
	
	DBManager db = new DBManager();
	Connection conn= null;
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	
	
	
	try {
		
		conn = db.getConnection();
		
		pstmt =conn.prepareStatement(sql);
		pstmt.setInt(1, dto.getUser_id());
		
		
		rset = pstmt.executeQuery();
		
		
		
		while(rset.next()) {
			
			
			
			 UserDto userDto = new UserDto();
			 userDto.setUser_id(rset.getInt("user_id"));
			 userDto.setUser_name(rset.getString("user_name"));
			 userDto.setUser_email(rset.getString("user_email"));
			 userDto.setUser_date(rset.getString("user_date"));
			 
			 ExpertDto expertDto = new ExpertDto();
			 expertDto.setExpert_id(rset.getInt("expert_id"));
			 expertDto.setExpert_intro(rset.getString("expert_intro"));
			 expertDto.setExpert_date(rset.getString("expert_date"));
			 expertDto.setExpert_range(rset.getString("expert_range"));
			
			 CategoryDto categoryDto = new CategoryDto();
			 Category1Dto category1 = new Category1Dto();
			 category1.setCategory1_name(rset.getString("category1_name"));
			 Category2Dto category2 = new Category2Dto();
			 category2.setCategory2_name(rset.getString("category2_name"));
			 categoryDto.setCategory1(category1);
			 categoryDto.setCategory2(category2);
			 
			 AreaCityDto areaCityDto = new AreaCityDto();
			 
			 AreaDto area = new AreaDto();
			 area.setArea_name(rset.getString("area_name"));
			 CityDto city = new CityDto();
			 city.setCity_name(rset.getString("city_name"));

			 areaCityDto.setArea(area);
			 areaCityDto.setCity(city);
			 
			 result = new UserExpertCategoryCityDto(userDto, expertDto, categoryDto, areaCityDto);
			
			
		}
		
		
		
		
		
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
	
	
	
	
	
	
	
	return result;
}
	


public int expertEdit(UserExpertCategoryCityDto dto) {
	
	int result = -1;
	
	String sql = "update user u "
			+ "left join expert e using(user_id) "
			+ "left join category2 using(category2_id) "
			+ "left join category1 using(category1_id) "
			+ "left join city using(city_id) "
			+ "left join area using(area_id) "
			+ "set user_name = ?, expert_intro = ?, expert_range=?, category2_id=(select category2_id from category2 where category2_name =?), "
			+ "city_id=(select city_id from city where city_name=?) "
			+ "where u.user_id= ?";
	
	
	DBManager db = new DBManager();
	Connection conn= null;
	PreparedStatement pstmt = null;
	
	

	try {
		
		conn = db.getConnection();
		
		pstmt =conn.prepareStatement(sql);
		pstmt.setString(1, dto.getUser().getUser_name());
		pstmt.setString(2, dto.getExpert().getExpert_intro());
		pstmt.setString(3, dto.getExpert().getExpert_range());
		pstmt.setString(4, dto.getCategory().getCategory2().getCategory2_name());
		pstmt.setString(5, dto.getCity().getCity().getCity_name());
		pstmt.setInt(6, dto.getUser().getUser_id());
		
		
		result = pstmt.executeUpdate();
		
	
		
	}catch(Exception e) {
		e.printStackTrace();
		
	}finally {
		
		
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
	
	
	
	
	return result;
	
}


public int expertDelete(UserExpertCategoryCityDto dto) {
	
	int result = -1;
	
//	String sql = "delete from market where expert_id=?";
//	
//	String sql1 = "delete from expert where user_id = ? ";
//	
	String sql2 = "delete "
			+ "from user "
			+ "where user_id = ?";
	
	
	DBManager db = new DBManager();
	Connection conn= null;
	PreparedStatement pstmt = null;
	
	

	try {
		
		conn = db.getConnection();
		
		
//		pstmt =conn.prepareStatement(sql);
//		pstmt.setInt(1, dto.getUser().getUser_id());
//		
		
//		pstmt =conn.prepareStatement(sql1);
//		pstmt.setInt(1, dto.getUser().getUser_id());
//		
//		 pstmt.executeUpdate();
		
		pstmt =conn.prepareStatement(sql2);
		pstmt.setInt(1, dto.getUser().getUser_id());
		
		
		result = pstmt.executeUpdate();
		
	
		
	}catch(Exception e) {
		e.printStackTrace();
		
	}finally {
		
		
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
	
	
	
	
	return result;
	
}


public List<Category2Dto> category1(UserExpertCategoryCityDto dto) {
	
	List<Category2Dto> result = new ArrayList<>();
	
	String sql = "select * from category2 left join category1 using(category1_id) where category1_id = ?";
	
	DBManager db = new DBManager();
	Connection conn= null;
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	
try {
		
		conn = db.getConnection();
		
		pstmt =conn.prepareStatement(sql);
		
		System.out.println(".........1");
		pstmt.setInt(1, dto.getCategory().getCategory1().getCategory1_id());
		
		System.out.println(".........2");
		
		rset = pstmt.executeQuery();
		System.out.println(".........3");
		
		while(rset.next()) {
						
			System.out.println(".........4");
			
			result.add(new Category2Dto(rset.getInt("category2_id"), rset.getString("category2_name"), rset.getInt("category1_id")));
			
			
			System.out.println(".........5");
			
		}
		
		
		
		
		
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
	
	
	return result;
}

public CategoryDto category(UserExpertDto dto){  // 유저dto와 전문가dto를 합쳐서 만든 dto에서 category2_id를 받아서 카테고리 네임을 뿌릴 에정.
	
	CategoryDto result = new CategoryDto();
	
	
	String sql = "select category1_id, category2_id from category2 where category2_id = ?";
		
	
	
	DBManager db = new DBManager();
	Connection conn= null;
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	
	
	
	try {
		
		conn = db.getConnection();
		
		pstmt =conn.prepareStatement(sql);
		
		pstmt.setInt(1, dto.getExpert().getCategory2_id());
		
		
		rset = pstmt.executeQuery();
		
		
		if(rset.next()) {
			
			
			Category1Dto category1 = new Category1Dto();
			
			category1.setCategory1_id(Integer.parseInt(rset.getString("category1_id")));
			
			
			Category2Dto category2 = new Category2Dto();
			
			category2.setCategory2_id(Integer.parseInt(rset.getString("category2_id")));
			
			
			
			result = new CategoryDto(category1, category2);
			
			
		}
		
		
		
		
		
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
	
	
	
	
	
	
	
	return result;
}



	
	public AdminDto login (AdminDto dto){    //관리자 로그인 
		
		AdminDto result = new AdminDto();
		
		
		String sql = "select * from admin where admin_email=? and admin_pass=?";
		
		
		DBManager db = new DBManager();
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		
		try {
			
			conn = db.getConnection();
			
			pstmt =conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getAdmin_email());
			pstmt.setString(2, dto.getAdmin_pass());
			
			rset = pstmt.executeQuery();
			
			System.out.println(rset);
			

				if(rset.next()) {
					
					
					
					
					result = new AdminDto(rset.getInt("admin_num"), rset.getString("admin_pass"), rset.getString("admin_name"), rset.getString("admin_email"), rset.getString("admin_date"), rset.getString("admin_ip"));
					
					
				}
				
			

			
			
			
			
			
			
			
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
		
		
		
		
		
		
		
		return result;
	}
	
	
	public int join(AdminDto dto) {   //관리자 회원가입.
		
		int result = -1;
		

		String sql = "insert into admin (admin_pass, admin_name, admin_email, admin_ip) values (?, ?, ?, ?)";
		
		
		DBManager db = new DBManager();
		Connection conn= null;
		PreparedStatement pstmt = null;
		
		
		
		
		try {
			
			conn = db.getConnection();
			
			pstmt =conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getAdmin_pass() );
			pstmt.setString(2, dto.getAdmin_name());
			pstmt.setString(3, dto.getAdmin_email());
			pstmt.setString(4, InetAddress.getLocalHost().getHostAddress());
			
			result = pstmt.executeUpdate();
			
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			
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
		
		
		
		
		
		
		return result;
	}
	
	public AdminDto findId (AdminDto dto){    //관리자 로그인 
		
		AdminDto result = new AdminDto();
		
		
		String sql = "select * from admin where admin_name=? and admin_num=?";
		
		
		DBManager db = new DBManager();
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		
		try {
			
			conn = db.getConnection();
			
			pstmt =conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getAdmin_name());
			pstmt.setInt(2, dto.getAdmin_num());
			
			rset = pstmt.executeQuery();
			
			System.out.println(rset);
			
			
//			String id = rset.getString("admin_email");
//			String pass = rset.getString("admin_pass");
//		
			
			
				if(rset.next()) {
					
					
					
					
					result = new AdminDto(rset.getInt("admin_num"), rset.getString("admin_pass"), rset.getString("admin_name"), rset.getString("admin_email"), rset.getString("admin_date"), rset.getString("admin_ip"));
					
					
				}
				
			

			
			
			
			
			
			
			
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
		
		
		
		
		
		
		
		return result;
	}
	
	

	public AdminDto IdCheck (AdminDto dto){    //아이디 중복 체크.
		
		AdminDto result = new AdminDto();
		
		
		String sql = "select * from admin where admin_email=?";
		
		
		DBManager db = new DBManager();
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		
		try {
			
			conn = db.getConnection();
			
			pstmt =conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getAdmin_email());
			
			rset = pstmt.executeQuery();
			
			System.out.println(rset);
			
	
			
			
				if(rset.next()) {
					
					
					
					
					result = new AdminDto(rset.getInt("admin_num"), rset.getString("admin_pass"), rset.getString("admin_name"), rset.getString("admin_email"), rset.getString("admin_date"), rset.getString("admin_ip"));
					
					
				}
		
			
			
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
		
		
		
		return result;
	}
	
	
	public List<UserMarketCategoryDto> marketList(){  //userdto와 marketdto를 합쳐서 dto를 만듬
		
		List<UserMarketCategoryDto> result = new ArrayList<>();
		
		
		String sql = "select u.user_id, user_name, user_email, m.market_id, title, content, date, price, refund, division, category1_name, category2_name "
					+"from market m "
					+ "join user_market um using(market_id) "
					+ "join user u using(user_id) "
					
					+ "left join category1 using(category1_id) "
					+ "left join category2 using(category2_id) order by u.user_id desc";
			
		
		
		DBManager db = new DBManager();
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		
		try {
			
			conn = db.getConnection();
			
			pstmt =conn.prepareStatement(sql);
			
			
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {
				
				
				
				 UserDto userDto = new UserDto();
				 userDto.setUser_id(rset.getInt("user_id"));
				 userDto.setUser_name(rset.getString("user_name"));
				 userDto.setUser_email(rset.getString("user_email"));
				 
				 

				 MarketDto marketDto = new MarketDto();
				 marketDto.setMarket_id(rset.getInt("market_id"));
				 marketDto.setTitle(rset.getString("title"));
				 marketDto.setContent(rset.getString("content"));
				 marketDto.setDate(rset.getString("date"));
				 marketDto.setPrice(rset.getInt("price"));
				 marketDto.setRefund(rset.getString("refund"));
				 marketDto.setDivision(rset.getString("division"));
				 
				 
				 CategoryDto categoryDto = new CategoryDto();
				 Category1Dto category1 = new Category1Dto();
				 category1.setCategory1_name(rset.getString("category1_name"));
				 categoryDto.setCategory1(category1);
				 
				 Category2Dto category2 = new Category2Dto();
				 category2.setCategory2_name(rset.getString("category2_name"));
				 categoryDto.setCategory2(category2);
				 
				 
				 
				 result.add(new UserMarketCategoryDto(userDto, marketDto, categoryDto));
				
				
				
			}
			
			
			
			
			
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
		
	
		
		
		return result;
	}
	public UserMarketCategoryDto marketDetail(UserMarketCategoryDto dto){  
		
		UserMarketCategoryDto result = new UserMarketCategoryDto();
		
		
		String sql ="select u.user_id, user_name, user_email, m.market_id, title, content, date, price, refund, division, category1_name, category2_name "
				+"from market m "
				+ "join user_market um using(market_id) "
				+ "join user u using(user_id) "
				+ "left join category1 using(category1_id) "
				+ "left join category2 using(category2_id) "
					+"where m.market_id = ?";
			
		
		
		DBManager db = new DBManager();
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		
		try {
			
			conn = db.getConnection();
			
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1,dto.getMarket().getMarket_id());
			
			
			rset = pstmt.executeQuery();
			
			
			if(rset.next()) {
				
				
				
				 UserDto user = new UserDto();
				 user.setUser_id(rset.getInt("user_id"));
				 user.setUser_name(rset.getString("user_name"));
				 user.setUser_email(rset.getString("user_email"));
				 
				 

				 MarketDto market = new MarketDto();
				 market.setMarket_id(rset.getInt("market_id"));
				 market.setTitle(rset.getString("title"));
				 market.setContent(rset.getString("content"));
				 market.setDate(rset.getString("date"));
				 market.setPrice(rset.getInt("price"));
				 market.setRefund(rset.getString("refund"));
				 market.setDivision(rset.getString("division"));
				 
				 
				 
				 CategoryDto category = new CategoryDto();
				 Category1Dto category1 = new Category1Dto();
				 Category2Dto category2 = new Category2Dto();
				 
				 category1.setCategory1_name(rset.getString("category1_name"));
				 category2.setCategory2_name(rset.getString("category2_name"));
				 
				 
				 category.setCategory1(category1);
				 category.setCategory2(category2);
				 
				 
				 
				 result = new UserMarketCategoryDto(user, market, category);
				
				
				
			}
			
			
			
			
			
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
		
	
		
		
		return result;
	}
	
	
	public int MarketEdit(UserMarketCategoryDto dto) {
		
		int result = -1;
		
		String sql ="UPDATE market AS ma "
			    + "JOIN user_market AS um ON ma.market_id = um.market_id "
			    + "JOIN user AS u ON um.user_id = u.user_id "
			    + "LEFT JOIN category1 AS c1 ON ma.category1_id = c1.category1_id "
			    + "LEFT JOIN category2 AS c2 ON ma.category2_id = c2.category2_id "
			    + "SET ma.title = ?, ma.content = ?, ma.date = ?, ma.price = ?, ma.refund = ?, ma.division = ?, ma.category1_id = ?, ma.category2_id = (SELECT category2_id FROM category2 WHERE category2_name = ?) "
			    + "WHERE ma.market_id = ?";
	
		
		DBManager db = new DBManager();
		Connection conn= null;
		PreparedStatement pstmt = null;
		
		
try {
			
			conn = db.getConnection();
			
			pstmt =conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getMarket().getTitle());
			pstmt.setString(2, dto.getMarket().getContent());
			pstmt.setString(3, dto.getMarket().getDate());
			pstmt.setInt(4, dto.getMarket().getPrice());
			pstmt.setString(5, dto.getMarket().getRefund());
			pstmt.setString(6, dto.getMarket().getDivision());
			pstmt.setInt(7, dto.getCategory().getCategory1().getCategory1_id());
			pstmt.setString(8, dto.getCategory().getCategory2().getCategory2_name());
			pstmt.setInt(9,dto.getMarket().getMarket_id());
			
			result = pstmt.executeUpdate();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
		
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
		
		
		
		
		
		
		return result;
	}
	
	public int MarketDelete(UserMarketCategoryDto dto) {
		
		int result =-1;
		
		String sql1 = "delete from user_market where market_id = ? ";
		String sql2 = "delete from market where market_id=?";
		
		

		DBManager db = new DBManager();
		Connection conn= null;
		PreparedStatement pstmt = null;
		
		

		
		try {
			
			conn = db.getConnection();
			
			
			pstmt =conn.prepareStatement(sql1);
			pstmt.setInt(1,dto.getMarket().getMarket_id());
			pstmt.executeUpdate();
			
			pstmt =conn.prepareStatement(sql2);
			pstmt.setInt(1,dto.getMarket().getMarket_id());
			//pstmt.setInt(2, dto.getMarket().getMarket_id());
			
			result = pstmt.executeUpdate();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
		
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
		
		
		
		return result;
	}
	
	
	public int newPass(AdminDto dto) {
		
		int result = -1;
		
String sql = "update admin set admin_pass=? where admin_email=?";
		
		
		DBManager db = new DBManager();
		Connection conn= null;
		PreparedStatement pstmt = null;
		
		
		
		
		try {
			
			conn = db.getConnection();
			
			pstmt =conn.prepareStatement(sql);
			
			
			pstmt.setString(1, dto.getAdmin_pass());
			
			pstmt.setString(2, dto.getAdmin_email());
			
			
	
			result = pstmt.executeUpdate();
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			
		
			
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
		
		
		
		
		return result;
	}
	
	
	
}
