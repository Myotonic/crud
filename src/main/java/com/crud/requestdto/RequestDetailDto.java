package com.crud.requestdto;

public class RequestDetailDto {
	String user_name;
	String city_name;
	String work_date;
	String content;
	int request_id;
	
	public int getRequest_id() {
		return request_id;
	}
	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}
	@Override
	public String toString() {
		return "RequestDetailDto [user_name=" + user_name + ", city_name=" + city_name + ", work_date=" + work_date
				+ ", content=" + content + "]";
	}
	public RequestDetailDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestDetailDto(String user_name, String city_name, String work_date, String content) {
		super();
		this.user_name = user_name;
		this.city_name = city_name;
		this.work_date = work_date;
		this.content = content;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public String getWork_date() {
		return work_date;
	}
	public void setWork_date(String work_date) {
		this.work_date = work_date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
