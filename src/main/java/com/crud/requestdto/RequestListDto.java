package com.crud.requestdto;

public class RequestListDto {
	private int request_id;
	private String category2_name;
	private String create_date;
	private int status;
	private int count;
	public RequestListDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "RequestListDto [request_id=" + request_id + ", category2_name=" + category2_name + ", create_date="
				+ create_date + ", status=" + status + ", count=" + count + "]";
	}
	public RequestListDto(int request_id, String category2_name, String create_date, int status, int count) {
		super();
		this.request_id = request_id;
		this.category2_name = category2_name;
		this.create_date = create_date;
		this.status = status;
		this.count = count;
	}
	public int getRequest_id() {
		return request_id;
	}
	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}
	public RequestListDto(String category2_name, String create_date, int status, int count) {
		super();
		this.category2_name = category2_name;
		this.create_date = create_date;
		this.status = status;
		this.count = count;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
}
