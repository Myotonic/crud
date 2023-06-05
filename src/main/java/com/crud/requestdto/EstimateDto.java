package com.crud.requestdto;

public class EstimateDto {
	private int estimateID;
	private int requestID;
	private int expertID;
	private String content;
	private int price;
	private String createDate;
	public EstimateDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EstimateDto(int estimateID, int requestID, int expertID, String content, int price, String createDate) {
		super();
		this.estimateID = estimateID;
		this.requestID = requestID;
		this.expertID = expertID;
		this.content = content;
		this.price = price;
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "EstimateDto [estimateID=" + estimateID + ", requestID=" + requestID + ", expertID=" + expertID
				+ ", content=" + content + ", price=" + price + ", createDate=" + createDate + "]";
	}
	public int getEstimateID() {
		return estimateID;
	}
	public void setEstimateID(int estimateID) {
		this.estimateID = estimateID;
	}
	public int getRequestID() {
		return requestID;
	}
	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}
	public int getExpertID() {
		return expertID;
	}
	public void setExpertID(int expertID) {
		this.expertID = expertID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	
}
