package com.company.dto;

import java.util.List;

public class Expert {
	private int expert_id;
	private int user_id;
	private int city_id;
	private int category2_id;
	private String expert_date;
	private String expert_intro;
	private String expert_range;
	private List<bWriterDto>ex_write;
	public Expert() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Expert(int expert_id, int user_id, int city_id, int category2_id, String expert_date, String expert_intro,
			String expert_range, List<bWriterDto> ex_write) {
		super();
		this.expert_id = expert_id;
		this.user_id = user_id;
		this.city_id = city_id;
		this.category2_id = category2_id;
		this.expert_date = expert_date;
		this.expert_intro = expert_intro;
		this.expert_range = expert_range;
		this.ex_write = ex_write;
	}
	
	public Expert(int expert_id, int user_id, int city_id, int category2_id, String expert_date, String expert_intro,
			String expert_range) {

		this.expert_id = expert_id;
		this.user_id = user_id;
		this.city_id = city_id;
		this.category2_id = category2_id;
		this.expert_date = expert_date;
		this.expert_intro = expert_intro;
		this.expert_range = expert_range;
	}
	public int getExpert_id() {
		return expert_id;
	}
	public void setExpert_id(int expert_id) {
		this.expert_id = expert_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	public int getCategory2_id() {
		return category2_id;
	}
	public void setCategory2_id(int category2_id) {
		this.category2_id = category2_id;
	}
	public String getExpert_date() {
		return expert_date;
	}
	public void setExpert_date(String expert_date) {
		this.expert_date = expert_date;
	}
	public String getExpert_intro() {
		return expert_intro;
	}
	public void setExpert_intro(String expert_intro) {
		this.expert_intro = expert_intro;
	}
	public String getExpert_range() {
		return expert_range;
	}
	public void setExpert_range(String expert_range) {
		this.expert_range = expert_range;
	}
	public List<bWriterDto> getEx_write() {
		return ex_write;
	}
	public void setEx_write(List<bWriterDto> ex_write) {
		this.ex_write = ex_write;
	}
	@Override
	public String toString() {
		return "expert [expert_id=" + expert_id + ", user_id=" + user_id + ", city_id=" + city_id + ", category2_id="
				+ category2_id + ", expert_date=" + expert_date + ", expert_intro=" + expert_intro + ", expert_range="
				+ expert_range + ", ex_write=" + ex_write + "]";
	}
	
	
}
