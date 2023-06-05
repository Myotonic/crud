package com.crud.dto;

import java.util.ArrayList;
import java.util.List;

public class MDto {
	private int market_id;
	private String title;
	private String content;
	private int hit;
	private String date;
	private int price;
	private String ip;
	private String refund;
	private String division;
	private int expert_id, category1_id, category2_id;
	private String appointment, proceed, startSchedule, endSchedule, location;
	private List<Time> time;
	private List<String> images;
	private List<Faq> faq;
	private List<Inquiry> inquiry;
	private String category1_name, category2_name;
	private String expert_name;
	public MDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MDto(int market_id, String title, String content, int hit, String date, int price, String ip, String refund,
			String division, int expert_id, int category1_id, int categort2_id, String appointment, String proceed,
			String startSchedule, String endSchedule, String location, List<Time> time, List<String> images,
			List<Faq> faq, List<Inquiry> inquiry, String category1_name, String category2_name, String expert_name) {
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
		this.expert_id = expert_id;
		this.category1_id = category1_id;
		this.category2_id = categort2_id;
		this.appointment = appointment;
		this.proceed = proceed;
		this.startSchedule = startSchedule;
		this.endSchedule = endSchedule;
		this.location = location;
		this.time = time;
		this.images = images;
		this.faq = faq;
		this.inquiry = inquiry;
		this.category1_name = category1_name;
		this.category2_name = category2_name;
		this.expert_name = expert_name;
	}
	public MDto(int market_id, String title, int price, String category2_name, String images, int hit) {
		super();
		this.market_id = market_id;
		this.title = title;
		this.price = price;
		this.category2_name = category2_name;
		this.images = new ArrayList<>();
		this.images.add(images);
		this.hit = hit;
	}
	@Override
	public String toString() {
		return "MDto [market_id=" + market_id + ", title=" + title + ", content=" + content + ", hit=" + hit + ", date="
				+ date + ", price=" + price + ", ip=" + ip + ", refund=" + refund + ", division=" + division
				+ ", expert_id=" + expert_id + ", category1_id=" + category1_id + ", categort2_id=" + category2_id
				+ ", appointment=" + appointment + ", proceed=" + proceed + ", startSchedule=" + startSchedule
				+ ", endSchedule=" + endSchedule + ", location=" + location + ", time=" + time + ", images=" + images
				+ ", faq=" + faq + ", inquiry=" + inquiry + ", category1_name=" + category1_name + ", category2_name="
				+ category2_name + ", expert_name=" + expert_name + "]";
	}
	public String getExpert_name() {
		return expert_name;
	}
	public void setExpert_name(String expert_name) {
		this.expert_name = expert_name;
	}
	public String getCategory1_name() {
		return category1_name;
	}
	public void setCategory1_name(String category1_name) {
		this.category1_name = category1_name;
	}
	public String getCategory2_name() {
		return category2_name;
	}
	public void setCategory2_name(String category2_name) {
		this.category2_name = category2_name;
	}
	public String getEndSchedule() {
		return endSchedule;
	}
	public void setEndSchedule(String endSchedule) {
		this.endSchedule = endSchedule;
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
	public int getExpert_id() {
		return expert_id;
	}
	public void setExpert_id(int expert_id) {
		this.expert_id = expert_id;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAppointment() {
		return appointment;
	}
	public void setAppointment(String appointment) {
		this.appointment = appointment;
	}
	public String getProceed() {
		return proceed;
	}
	public void setProceed(String proceed) {
		this.proceed = proceed;
	}
	public String getStartSchedule() {
		return startSchedule;
	}
	public void setStartSchedule(String startSchedule) {
		this.startSchedule = startSchedule;
	}
	public List<Time> getTime() {
		return time;
	}
	public void setTime(List<Time> time) {
		this.time = time;
	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	public List<Faq> getFaq() {
		return faq;
	}
	public void setFaq(List<Faq> faq) {
		this.faq = faq;
	}
	public List<Inquiry> getInquiry() {
		return inquiry;
	}
	public void setInquiry(List<Inquiry> inquiry) {
		this.inquiry = inquiry;
	}
	
}
