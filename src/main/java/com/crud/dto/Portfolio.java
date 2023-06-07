package com.company.dto;

public class Portfolio {
	private int expert_id;
	private int portfolio;
	private String portfolio_entry;
	public Portfolio() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Portfolio(int expert_id, int portfolio, String portfolio_entry) {
		super();
		this.expert_id = expert_id;
		this.portfolio = portfolio;
		this.portfolio_entry = portfolio_entry;
	}
	public int getExpert_id() {
		return expert_id;
	}
	public void setExpert_id(int expert_id) {
		this.expert_id = expert_id;
	}
	public int getPortfolio() {
		return portfolio;
	}
	public void setPortfolio(int portfolio) {
		this.portfolio = portfolio;
	}
	public String getPortfolio_entry() {
		return portfolio_entry;
	}
	public void setPortfolio_entry(String portfolio_entry) {
		this.portfolio_entry = portfolio_entry;
	}
	@Override
	public String toString() {
		return "portfolio [expert_id=" + expert_id + ", portfolio=" + portfolio + ", portfolio_entry=" + portfolio_entry
				+ "]";
	}
	
	
}
