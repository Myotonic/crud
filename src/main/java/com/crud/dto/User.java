package com.company.dto;

import java.util.List;

public class User {
	private int user_id;
	private String user_name;
	private String user_email;
	private String user_pass;
	private String user_date;
	private String user_ip;
	private List<bWriterDto>user_write;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int user_id, String user_name, String user_email, String user_pass, String user_date, String user_ip,
			List<bWriterDto> write) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_pass = user_pass;
		this.user_date = user_date;
		this.user_ip = user_ip;
		this.user_write = write;
	}
	
	public User(int user_id, String user_name, String user_email, String user_pass, String user_date, String user_ip) {
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
	public List<bWriterDto> getWrite() {
		return user_write;
	}
	public void setWrite(List<bWriterDto> write) {
		this.user_write = write;
	}
	@Override
	public String toString() {
		return "user [user_id=" + user_id + ", user_name=" + user_name + ", user_email=" + user_email + ", user_pass="
				+ user_pass + ", user_date=" + user_date + ", user_ip=" + user_ip + ", write=" + user_write + "]";
	}
	
	
}
