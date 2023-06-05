package com.company.dto;

public class ExpertProfileDto {
	
	private ExpertDto expert;
	private int review_hit;
	
	public ExpertProfileDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExpertProfileDto(ExpertDto expert, int review_hit) {
		super();
		this.expert = expert;
		this.review_hit = review_hit;
	}

	public ExpertDto getExpert() {
		return expert;
	}

	public void setExpert(ExpertDto expert) {
		this.expert = expert;
	}

	public int getReview_hit() {
		return review_hit;
	}

	public void setReview_hit(int review_hit) {
		this.review_hit = review_hit;
	}

	@Override
	public String toString() {
		return "ExpertProfileDto [expert=" + expert + ", review_hit=" + review_hit + "]";
	}
	
	
	
	
	

}
