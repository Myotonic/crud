package com.company.dto;

import java.util.List;

public class BoardResult {
    private List<bWriterDto> boardList;
    private List<Comment> commentList;
    private List<City> bCity;
    private List<Area> bArea;
    private List<category1> cate1;
    private List<category2> cate2;
    private List<User> user;
    private List<Expert> expert;
	public BoardResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardResult(List<bWriterDto> boardList, List<Comment> commentList, List<City> bCity, List<Area> bArea,
			List<category1> cate1, List<category2> cate2, List<User> user, List<Expert> expert) {
		super();
		this.boardList = boardList;
		this.commentList = commentList;
		this.bCity = bCity;
		this.bArea = bArea;
		this.cate1 = cate1;
		this.cate2 = cate2;
		this.user = user;
		this.expert = expert;
	}
	public List<bWriterDto> getBoardList() {
		return boardList;
	}
	public void setBoardList(List<bWriterDto> boardList) {
		this.boardList = boardList;
	}
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
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
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	public List<Expert> getExpert() {
		return expert;
	}
	public void setExpert(List<Expert> expert) {
		this.expert = expert;
	}
	@Override
	public String toString() {
		return "BoardResult [boardList=" + boardList + ", commentList=" + commentList + ", bCity=" + bCity + ", bArea="
				+ bArea + ", cate1=" + cate1 + ", cate2=" + cate2 + ", user=" + user + ", expert=" + expert + "]";
	}
	
}
