package com.company.dto;

public class Education {
	private int expert_id;
	private int education;
	private String education_entry;
	public Education() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Education(int expert_id, int education, String education_entry) {
		super();
		this.expert_id = expert_id;
		this.education = education;
		this.education_entry = education_entry;
	}
	public int getExpert_id() {
		return expert_id;
	}
	public void setExpert_id(int expert_id) {
		this.expert_id = expert_id;
	}
	public int getEducation() {
		return education;
	}
	public void setEducation(int education) {
		this.education = education;
	}
	public String getEducation_entry() {
		return education_entry;
	}
	public void setEducation_entry(String education_entry) {
		this.education_entry = education_entry;
	}
	@Override
	public String toString() {
		return "education [expert_id=" + expert_id + ", education=" + education + ", education_entry=" + education_entry
				+ "]";
	}
	
	
}
