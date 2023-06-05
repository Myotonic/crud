package com.company.dto;

public class UserDto {

	private int user_id;
	private String user_name;
	private String user_email;
	private String user_pass;
	private String user_date;
	private String user_ip;
	
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDto(int user_id, String user_name, String user_email, String user_pass, String user_date,
			String user_ip) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_pass = user_pass;
		this.user_date = user_date;
		this.user_ip = user_ip;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}

	public String getUser_date() {
		return user_date;
	}

	public void setUser_date(String user_date) {
		this.user_date = user_date;
	}

	public String getUser_ip() {
		return user_ip;
	}

	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}

	@Override
	public String toString() {
		return "UserDto [user_id=" + user_id + ", user_name=" + user_name + ", user_email=" + user_email
				+ ", user_pass=" + user_pass + ", user_date=" + user_date + ", user_ip=" + user_ip + "]";
	}
	
	
	
	
}


//+------------+--------------+------+-----+-------------------+-------------------+
//| Field      | Type         | Null | Key | Default           | Extra             |
//+------------+--------------+------+-----+-------------------+-------------------+
//| user_id    | int          | NO   | PRI | NULL              | auto_increment    |
//| user_name  | varchar(50)  | NO   |     | NULL              |                   |
//| user_email | varchar(250) | NO   |     | NULL              |                   |
//| user_pass  | varchar(100) | NO   |     | NULL              |                   |
//| user_date  | datetime     | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
//| user_ip    | varchar(50)  | NO   |     | NULL              |                   |
//+------------+--------------+------+-----+-------------------+-------------------+


