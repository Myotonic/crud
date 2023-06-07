package com.company.dto;

public class Career {
	private int expert_id;
	private int career;
	private String career_entry;
	public Career() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Career(int expert_id, int career, String career_entry) {
		super();
		this.expert_id = expert_id;
		this.career = career;
		this.career_entry = career_entry;
	}
	public int getExpert_id() {
		return expert_id;
	}
	public void setExpert_id(int expert_id) {
		this.expert_id = expert_id;
	}
	public int getCareer() {
		return career;
	}
	public void setCareer(int career) {
		this.career = career;
	}
	public String getCareer_entry() {
		return career_entry;
	}
	public void setCareer_entry(String career_entry) {
		this.career_entry = career_entry;
	}
	@Override
	public String toString() {
		return "career [expert_id=" + expert_id + ", career=" + career + ", career_entry=" + career_entry + "]";
	}
	
}
