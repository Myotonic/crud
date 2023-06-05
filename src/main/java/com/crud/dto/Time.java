package com.crud.dto;

public class Time {
	private int time_id;
	private String day;
	private String starttime;
	private String endtime;
	private int market_id;
	public Time() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Time(int time_id, String day, String starttime, String endtime, int market_id) {
		super();
		this.time_id = time_id;
		this.day = day;
		this.starttime = starttime;
		this.endtime = endtime;
		this.market_id = market_id;
	}
	public Time(String day, String starttime, String endtime) {
		super();
		this.day = day;
		this.starttime = starttime;
		this.endtime = endtime;
	}
	@Override
	public String toString() {
		return "Time [time_id=" + time_id + ", day=" + day + ", starttime=" + starttime + ", endtime=" + endtime
				+ ", market_id=" + market_id + "]";
	}
	public int getTime_id() {
		return time_id;
	}
	public void setTime_id(int time_id) {
		this.time_id = time_id;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public int getMarket_id() {
		return market_id;
	}
	public void setMarket_id(int market_id) {
		this.market_id = market_id;
	}
}
