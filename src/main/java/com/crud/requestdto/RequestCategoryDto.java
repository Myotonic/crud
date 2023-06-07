package com.crud.requestdto;

public class RequestCategoryDto {
	int category2_id;
	String category2_name;
	int category1_id;
	String category1_name;
	public RequestCategoryDto() {
		super();
	}
	@Override
	public String toString() {
		return "ViewCategoryDto [category2_id=" + category2_id + ", category2_name=" + category2_name
				+ ", category1_id=" + category1_id + ", category1_name=" + category1_name + "]";
	}
	public RequestCategoryDto(int category2_id, String category2_name, int category1_id, String category1_name) {
		super();
		this.category2_id = category2_id;
		this.category2_name = category2_name;
		this.category1_id = category1_id;
		this.category1_name = category1_name;
	}
	public int getCategory2_id() {
		return category2_id;
	}
	public void setCategory2_id(int category2_id) {
		this.category2_id = category2_id;
	}
	public String getCategory2_name() {
		return category2_name;
	}
	public void setCategory2_name(String category2_name) {
		this.category2_name = category2_name;
	}
	public int getCategory1_id() {
		return category1_id;
	}
	public void setCategory1_id(int category1_id) {
		this.category1_id = category1_id;
	}
	public String getCategory1_name() {
		return category1_name;
	}
	public void setCategory1_name(String category1_name) {
		this.category1_name = category1_name;
	}
	
	
}
