package com.company.dto;

public class Category2Dto {
	
	private int category2_id;
	private String category2_name;
	private int category1_id;
	
	
	public Category2Dto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Category2Dto(int category2_id, String category2_name, int category1_id) {
		super();
		this.category2_id = category2_id;
		this.category2_name = category2_name;
		this.category1_id = category1_id;
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


	@Override
	public String toString() {
		return "Category2Dto [category2_id=" + category2_id + ", category2_name=" + category2_name + ", category1_id="
				+ category1_id + "]";
	}
	
	

}
