package com.crud.dto;

public class City {
	private int area_id;
	private int city_id;
	private String city_name;
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	public City(int area_id, int city_id, String city_name) {
		super();
		this.area_id = area_id;
		this.city_id = city_id;
		this.city_name = city_name;
	}
	public int getArea_id() {
		return area_id;
	}
	public void setArea_id(int area_id) {
		this.area_id = area_id;
	}
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	@Override
	public String toString() {
		return "city [area_id=" + area_id + ", city_id=" + city_id + ", city_name=" + city_name + "]";
	}
	
}
