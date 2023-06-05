package com.crud.dto;

public class Answer {
	private int inquiry_id;
	private String answer;
	private String date;
	private int expert_id;
	private int market_id;
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Answer(int inquiry_id, String answer, String date, int expert_id, int market_id) {
		super();
		this.inquiry_id = inquiry_id;
		this.answer = answer;
		this.date = date;
		this.expert_id = expert_id;
		this.market_id = market_id;
	}
	@Override
	public String toString() {
		return "Answer [inquiry_id=" + inquiry_id + ", answer=" + answer + ", date=" + date + ", expert_id=" + expert_id
				+ ", market_id=" + market_id + "]";
	}
	public int getInquiry_id() {
		return inquiry_id;
	}
	public void setInquiry_id(int inquiry_id) {
		this.inquiry_id = inquiry_id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getExpert_id() {
		return expert_id;
	}
	public void setExpert_id(int expert_id) {
		this.expert_id = expert_id;
	}
	public int getMarket_id() {
		return market_id;
	}
	public void setMarket_id(int market_id) {
		this.market_id = market_id;
	}
	
}
