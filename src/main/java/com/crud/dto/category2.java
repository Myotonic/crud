package com.company.dto;

import java.util.ArrayList;
import java.util.List;

public class category2 {
	private int category2_id;
	private String category2_name;
	List<category1> category1 =new ArrayList<>();
	public category2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public category2(int category2_id, String category2_name, List<com.company.dto.category1> category1) {
		super();
		this.category2_id = category2_id;
		this.category2_name = category2_name;
		this.category1 = category1;
	}
	
	public category2(int category2_id, String category2_name) {
		super();
		this.category2_id = category2_id;
		this.category2_name = category2_name;
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
	public List<category1> getCategory1() {
		return category1;
	}
	public void setCategory1(List<category1> category1) {
		this.category1 = category1;
	}
	@Override
	public String toString() {
		return "category2 [category2_id=" + category2_id + ", category2_name=" + category2_name + ", category1="
				+ category1 + "]";
	}
	
	
}
