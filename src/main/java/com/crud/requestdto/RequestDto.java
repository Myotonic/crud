package com.crud.requestdto;

public class RequestDto {
	private int request_id;
	private int user_id;
	private int category2_id;
	private int city_id;
	private String create_date;
	private String work_date;
	private String content;
	private int status;
	@Override
	public String toString() {
		return "RequestDto [request_id=" + request_id + ", user_id=" + user_id + ", category2_id=" + category2_id
				+ ", city_id=" + city_id + ", create_date=" + create_date + ", work_date=" + work_date + ", content="
				+ content + ", status=" + status + "]";
	}
	public RequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestDto(int request_id, int user_id, int category2_id, int city_id, String create_date, String work_date,
			String content, int status) {
		super();
		this.request_id = request_id;
		this.user_id = user_id;
		this.category2_id = category2_id;
		this.city_id = city_id;
		this.create_date = create_date;
		this.work_date = work_date;
		this.content = content;
		this.status = status;
	}
	public int getRequest_id() {
		return request_id;
	}
	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getCategory2_id() {
		return category2_id;
	}
	public void setCategory2_id(int category2_id) {
		this.category2_id = category2_id;
	}
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
