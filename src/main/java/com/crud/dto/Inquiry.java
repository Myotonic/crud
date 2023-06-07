package com.crud.dto;

public class Inquiry {
	private int inquiry_id;
	private String category;
	private String title;
	private String content;
	private String date;
	private String ip;
	private int market_id;
	private String mTitle;
	private int user_id;
	private String user;
	private Answer answer;
	private boolean checkAnswer;
	public Inquiry() {
		super();
	}
	public Inquiry(int inquiry_id, String category, String title, String content, String date, String ip, int market_id,
			String mTitle, int user_id, String user, Answer answer, boolean checkAnswer) {
		super();
		this.inquiry_id = inquiry_id;
		this.category = category;
		this.title = title;
		this.content = content;
		this.date = date;
		this.ip = ip;
		this.market_id = market_id;
		this.mTitle = mTitle;
		this.user_id = user_id;
		this.user = user;
		this.answer = answer;
		this.checkAnswer = checkAnswer;
	}
	@Override
	public String toString() {
		return "Inquiry [inquiry_id=" + inquiry_id + ", category=" + category + ", title=" + title + ", content="
				+ content + ", date=" + date + ", ip=" + ip + ", market_id=" + market_id + ", mTitle=" + mTitle
				+ ", user_id=" + user_id + ", user=" + user + ", answer=" + answer + ", checkAnswer=" + checkAnswer
				+ "]";
	}
	public int getInquiry_id() {
		return inquiry_id;
	}
	public void setInquiry_id(int inquiry_id) {
		this.inquiry_id = inquiry_id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getMarket_id() {
		return market_id;
	}
	public void setMarket_id(int market_id) {
		this.market_id = market_id;
	}
	public String getmTitle() {
		return mTitle;
	}
	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Answer getAnswer() {
		return answer;
	}
	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	public boolean isCheckAnswer() {
		return checkAnswer;
	}
	public void setCheckAnswer(boolean checkAnswer) {
		this.checkAnswer = checkAnswer;
	}
	
	
}
