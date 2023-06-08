package com.crud.dto;

public class category1 {
	private int category1_id;
	private String category1_name;
	public category1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public category1(int category1_id, String category1_name) {
		super();
		this.category1_id = category1_id;
		this.category1_name = category1_name;
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
	@Override
	public String toString() {
		return "category1 [category1_id=" + category1_id + ", category1_name=" + category1_name + "]";
	}
	
	
}
