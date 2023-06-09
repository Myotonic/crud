package com.crud.requestdto;

public class EstimateDetailDto {
	private String user_name;
	private int review;
	private String city_name;
	private String career_entry;
	private String content;
	int price;
	public EstimateDetailDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EstimateDetailDto(String user_name, int review, String city_name, String career_entry, String content,
			int price) {
		super();
		this.user_name = user_name;
		this.review = review;
		this.city_name = city_name;
		this.career_entry = career_entry;
		this.content = content;
		this.price = price;
	}
	@Override
	public String toString() {
		return "EstimateDetailDto [user_name=" + user_name + ", review=" + review + ", city_name=" + city_name
				+ ", career_entry=" + career_entry + ", content=" + content + ", price=" + price + "]";
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
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public String getCareer_entry() {
		return career_entry;
	}
	public void setCareer_entry(String career_entry) {
		this.career_entry = career_entry;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
