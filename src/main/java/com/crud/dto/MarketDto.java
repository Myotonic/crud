package com.crud.dto;

public class MarketDto {
	
	private int market_id;
	private String title, content;
	private int hit;
	private String date;
	private int price;
	private String ip, refund, division;
	private int category1_id, category2_id;
	
	public MarketDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MarketDto(int market_id, String title, String content, int hit, String date, int price, String ip,
			String refund, String division, int category1_id, int category2_id) {
		super();
		this.market_id = market_id;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.date = date;
		this.price = price;
		this.ip = ip;
		this.refund = refund;
		this.division = division;
		this.category1_id = category1_id;
		this.category2_id = category2_id;
	}

	public int getMarket_id() {
		return market_id;
	}

	public void setMarket_id(int market_id) {
		this.market_id = market_id;
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

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getRefund() {
		return refund;
	}

	public void setRefund(String refund) {
		this.refund = refund;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public int getCategory1_id() {
		return category1_id;
	}

	public void setCategory1_id(int category1_id) {
		this.category1_id = category1_id;
	}

	public int getCategory2_id() {
		return category2_id;
	}

	public void setCategory2_id(int category2_id) {
		this.category2_id = category2_id;
	}

	@Override
	public String toString() {
		return "MarketDto [market_id=" + market_id + ", title=" + title + ", content=" + content + ", hit=" + hit
				+ ", date=" + date + ", price=" + price + ", ip=" + ip + ", refund=" + refund + ", division=" + division
				+ ", category1_id=" + category1_id + ", category2_id=" + category2_id + "]";
	}
	
	
	
	

}



//+--------------+--------------+------+-----+-------------------+-------------------+
//| Field        | Type         | Null | Key | Default           | Extra             |
//+--------------+--------------+------+-----+-------------------+-------------------+
//| market_id    | int          | NO   | PRI | NULL              | auto_increment    |
//| title        | varchar(100) | NO   |     | NULL              |                   |
//| content      | text         | NO   |     | NULL              |                   |
//| hit          | int          | NO   |     | 0                 |                   |
//| date         | datetime     | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
//| price        | int          | NO   |     | NULL              |                   |
//| ip           | varchar(50)  | NO   |     | NULL              |                   |
//| refund       | text         | NO   |     | NULL              |                   |
//| division     | varchar(45)  | NO   |     | NULL              |                   |
//| category1_id | int          | NO   | MUL | NULL              |                   |
//| category2_id | int          | NO   | MUL | NULL              |                   |
//+--------------+--------------+------+-----+-------------------+-------------------+
//11 rows in set (0.00 sec)
