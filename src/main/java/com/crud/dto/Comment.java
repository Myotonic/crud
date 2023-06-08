package com.crud.dto;

public class Comment {
	private int comment_no;
	private int like_no;
	private String comment_con;
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comment(int comment_no, int like_no, String comment_con) {
		super();
		this.comment_no = comment_no;
		this.like_no = like_no;
		this.comment_con = comment_con;
	}
	public int getComment_no() {
		return comment_no;
	}
	public void setComment_no(int comment_no) {
		this.comment_no = comment_no;
	}
	public int getLike_no() {
		return like_no;
	}
	public void setLike_no(int like_no) {
		this.like_no = like_no;
	}
	public String getComment_con() {
		return comment_con;
	}
	public void setComment_con(String comment_con) {
		this.comment_con = comment_con;
	}
	
	@Override
	public String toString() {
		return "Comment [comment_no=" + comment_no + ", like_no=" + like_no + ", comment_con=" + comment_con + "]";
	}

	
}
