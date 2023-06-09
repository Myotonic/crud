package com.crud.requestdto;

public class RequestedListDto {
	private String category2_name;
	private String create_date;
	private String user_name;
	private String content;
	private int request_id;
	private int mystatus;
	
	public int getMystatus() {
		return mystatus;
	}
	public void setMystatus(int mystatus) {
		this.mystatus = mystatus;
	}
	@Override
	public String toString() {
		return "RequestedListDto [category2_name=" + category2_name + ", create_date=" + create_date + ", user_name="
				+ user_name + ", content=" + content + ", request_id=" + request_id + "]";
	}
	public RequestedListDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestedListDto(String category2_name, String create_date, String user_name, String content,
			int request_id) {
		super();
		this.category2_name = category2_name;
		this.create_date = create_date;
		this.user_name = user_name;
		this.content = content;
		this.request_id = request_id;
	}
	public String getCategory2_name() {
		return category2_name;
	}
	public void setCategory2_name(String category2_name) {
		this.category2_name = category2_name;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRequest_id() {
		return request_id;
	}
	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}
	
}
