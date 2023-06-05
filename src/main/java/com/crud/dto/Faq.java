package com.crud.dto;

public class Faq {
	private int faq_id;
	private String title;
	private String content;
	private int market_id;
	public Faq() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Faq(int faq_id, String title, String content, int market_id) {
		super();
		this.faq_id = faq_id;
		this.title = title;
		this.content = content;
		this.market_id = market_id;
	}
	public Faq(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	@Override
	public String toString() {
		return "Faq [faq_id=" + faq_id + ", title=" + title + ", content=" + content + ", market_id=" + market_id + "]";
	}
	public int getFaq_id() {
		return faq_id;
	}
	public void setFaq_id(int faq_id) {
		this.faq_id = faq_id;
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
	public int getMarket_id() {
		return market_id;
	}
	public void setMarket_id(int market_id) {
		this.market_id = market_id;
	}

}
