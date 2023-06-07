package com.company.dto;

import java.util.List;

public class bWriterDto {
	private int board_no;
	private String board_upload_day;
	private String board_title;
	private String board_content;
	private String board_ip;
	private String board_break_point;
	private int expert_id;
	private int user_id;
	private int board_category_no;
	private List<Comment>comment;
	private List<String>images;
	private List<City>bCity;
	private List<Area>bArea;
	private List<category1>cate1;
	private List<category2>cate2;
	public bWriterDto() {
		super();
	}
	public bWriterDto(int board_no, String board_upload_day, String board_title, String board_content, String board_ip,
			String board_break_point, int expert_id, int user_id, int board_category_no, List<Comment> comment,
			List<String> images, List<City> bCity, List<Area> bArea, List<category1> cate1, List<category2> cate2) {
		super();
		this.board_no = board_no;
		this.board_upload_day = board_upload_day;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_ip = board_ip;
		this.board_break_point = board_break_point;
		this.expert_id = expert_id;
		this.user_id = user_id;
		this.board_category_no = board_category_no;
		this.comment = comment;
		this.images = images;
		this.bCity = bCity;
		this.bArea = bArea;
		this.cate1 = cate1;
		this.cate2 = cate2;
	}
	
	public bWriterDto(int board_no, String board_upload_day, String board_title, String board_content, String board_ip,
			int expert_id, int user_id, int board_category_no) {
		super();
		this.board_no = board_no;
		this.board_upload_day = board_upload_day;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_ip = board_ip;
		this.expert_id = expert_id;
		this.user_id = user_id;
		this.board_category_no = board_category_no;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getBoard_upload_day() {
		return board_upload_day;
	}
	public void setBoard_upload_day(String board_upload_day) {
		this.board_upload_day = board_upload_day;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getBoard_ip() {
		return board_ip;
	}
	public void setBoard_ip(String board_ip) {
		this.board_ip = board_ip;
	}
	public String getBoard_break_point() {
		return board_break_point;
	}
	public void setBoard_break_point(String board_break_point) {
		this.board_break_point = board_break_point;
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
	public int getBoard_category_no() {
		return board_category_no;
	}
	public void setBoard_category_no(int board_category_no) {
		this.board_category_no = board_category_no;
	}
	public List<Comment> getComment() {
		return comment;
	}
	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	public List<City> getbCity() {
		return bCity;
	}
	public void setbCity(List<City> bCity) {
		this.bCity = bCity;
	}
	public List<Area> getbArea() {
		return bArea;
	}
	public void setbArea(List<Area> bArea) {
		this.bArea = bArea;
	}
	public List<category1> getCate1() {
		return cate1;
	}
	public void setCate1(List<category1> cate1) {
		this.cate1 = cate1;
	}
	public List<category2> getCate2() {
		return cate2;
	}
	public void setCate2(List<category2> cate2) {
		this.cate2 = cate2;
	}
	@Override
	public String toString() {
		return "bWriterDto [board_no=" + board_no + ", board_upload_day=" + board_upload_day + ", board_title="
				+ board_title + ", board_content=" + board_content + ", board_ip=" + board_ip + ", board_break_point="
				+ board_break_point + ", expert_id=" + expert_id + ", user_id=" + user_id + ", board_category_no="
				+ board_category_no + ", comment=" + comment + ", images=" + images + ", bCity=" + bCity + ", bArea="
				+ bArea + ", cate1=" + cate1 + ", cate2=" + cate2 + "]";
	}
	
}