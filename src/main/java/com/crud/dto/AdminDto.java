package com.crud.dto;

public class AdminDto {

	private int admin_num;
	private String admin_pass, admin_name, admin_email, admin_date, admin_ip;
	public AdminDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminDto(int admin_num, String admin_pass, String admin_name, String admin_email, String admin_date,
			String admin_ip) {
		super();
		this.admin_num = admin_num;
		this.admin_pass = admin_pass;
		this.admin_name = admin_name;
		this.admin_email = admin_email;
		this.admin_date = admin_date;
		this.admin_ip = admin_ip;
	}
	public int getAdmin_num() {
		return admin_num;
	}
	public void setAdmin_num(int admin_num) {
		this.admin_num = admin_num;
	}
	public String getAdmin_pass() {
		return admin_pass;
	}
	public void setAdmin_pass(String admin_pass) {
		this.admin_pass = admin_pass;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_email() {
		return admin_email;
	}
	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}
	public String getAdmin_date() {
		return admin_date;
	}
	public void setAdmin_date(String admin_date) {
		this.admin_date = admin_date;
	}
	public String getAdmin_ip() {
		return admin_ip;
	}
	public void setAdmin_ip(String admin_ip) {
		this.admin_ip = admin_ip;
	}
	@Override
	public String toString() {
		return "AdminDto [admin_num=" + admin_num + ", admin_pass=" + admin_pass + ", admin_name=" + admin_name
				+ ", admin_email=" + admin_email + ", admin_date=" + admin_date + ", admin_ip=" + admin_ip + "]";
	}
	
	
	
	
	
}
