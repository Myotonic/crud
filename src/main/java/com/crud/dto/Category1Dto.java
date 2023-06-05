package com.crud.dto;

public class Category1Dto {
	private int category1_id;
	private String category1_name;
	
	public Category1Dto() { super(); }
	
	public int getCategory1_id() { return category1_id; } public void setCategory1_id(int category1_id) { this.category1_id = category1_id; }
	public String getCategory1_name() { return category1_name; } public void setCategory1_name(String category1_name) { this.category1_name = category1_name; }
	
	public Category1Dto(int category1_id, String category1_name) {
		super();
		this.category1_id = category1_id;
		this.category1_name = category1_name;
	}
	
	@Override
	public String toString() {
		return "Category1Dto [category1_id=" + category1_id + ", category1_name=" + category1_name + "]";
	}
}
