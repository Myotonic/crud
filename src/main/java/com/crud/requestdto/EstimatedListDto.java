package com.crud.requestdto;

public class EstimatedListDto {
	private String user_name;
	private int review;
	private int price;
	private int estimate_id;
	private int request_id;
	
	public EstimatedListDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EstimatedListDto [user_name=" + user_name + ", review=" + review + ", price=" + price + ", estimate_id="
				+ estimate_id + ", request_id=" + request_id + "]";
	}
	public EstimatedListDto(String user_name, int review, int price, int estimate_id, int request_id) {
		super();
		this.user_name = user_name;
		this.review = review;
		this.price = price;
		this.estimate_id = estimate_id;
		this.request_id = request_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getReview() {
		return review;
	}
	public void setReview(int review) {
		this.review = review;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getEstimate_id() {
		return estimate_id;
	}
	public void setEstimate_id(int estimate_id) {
		this.estimate_id = estimate_id;
	}
	public int getRequest_id() {
		return request_id;
	}
	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}
	
}
