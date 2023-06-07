package com.company.dto;

import java.util.List;

public class Expert_profileDto {
	private int expert_id;
	private int expert_review_no;
	private String user_intro;
	private String user_name;
	private List<Certificate>certi;
	private List<Career>career;
	private List<Portfolio>portfolio;
	private List<Education>edu;
	public Expert_profileDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Expert_profileDto(int expert_id, int expert_review_no, String user_intro, String user_name,
			List<Certificate> certi, List<Career> career, List<Portfolio> portfolio, List<Education> edu) {
		super();
		this.expert_id = expert_id;
		this.expert_review_no = expert_review_no;
		this.user_intro = user_intro;
		this.user_name = user_name;
		this.certi = certi;
		this.career = career;
		this.portfolio = portfolio;
		this.edu = edu;
	}
	public int getExpert_id() {
		return expert_id;
	}
	public void setExpert_id(int expert_id) {
		this.expert_id = expert_id;
	}
	public int getExpert_review_no() {
		return expert_review_no;
	}
	public void setExpert_review_no(int expert_review_no) {
		this.expert_review_no = expert_review_no;
	}
	public String getUser_intro() {
		return user_intro;
	}
	public void setUser_intro(String user_intro) {
		this.user_intro = user_intro;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public List<Certificate> getCerti() {
		return certi;
	}
	public void setCerti(List<Certificate> certi) {
		this.certi = certi;
	}
	public List<Career> getCareer() {
		return career;
	}
	public void setCareer(List<Career> career) {
		this.career = career;
	}
	public List<Portfolio> getPortfolio() {
		return portfolio;
	}
	public void setPortfolio(List<Portfolio> portfolio) {
		this.portfolio = portfolio;
	}
	public List<Education> getEdu() {
		return edu;
	}
	public void setEdu(List<Education> edu) {
		this.edu = edu;
	}
	@Override
	public String toString() {
		return "Expert_profileDto [expert_id=" + expert_id + ", expert_review_no=" + expert_review_no + ", user_intro="
				+ user_intro + ", user_name=" + user_name + ", certi=" + certi + ", career=" + career + ", portfolio="
				+ portfolio + ", edu=" + edu + "]";
	}

	
}
