package com.company.dto;

public class CategoryDto {
	
	
	private Category1Dto category1;
	private Category2Dto category2;
	
	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryDto(Category1Dto category1, Category2Dto category2) {
		super();
		this.category1 = category1;
		this.category2 = category2;
	}

	public Category1Dto getCategory1() {
		return category1;
	}

	public void setCategory1(Category1Dto category1) {
		this.category1 = category1;
	}

	public Category2Dto getCategory2() {
		return category2;
	}

	public void setCategory2(Category2Dto category2) {
		this.category2 = category2;
	}

	@Override
	public String toString() {
		return "CategoryDto [category1=" + category1 + ", category2=" + category2 + "]";
	}
	
	
	

}
