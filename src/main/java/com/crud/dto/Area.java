package com.crud.dto;

import java.util.List;

public class Area {
	private int area_id;
	private String area_name;
	private List<City>city_id;
	public Area() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Area(int area_id, String area_name, List<City> city_id) {
		super();
		this.area_id = area_id;
		this.area_name = area_name;
		this.city_id = city_id;
	}
	
	public Area(int area_id, String area_name) {
		super();
		this.area_id = area_id;
		this.area_name = area_name;
	}
	public int getArea_id() {
		return area_id;
	}
	public void setArea_id(int area_id) {
		this.area_id = area_id;
	}
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	public List<City> getCity_id() {
		return city_id;
	}
	public void setCity_id(List<City> city_id) {
		this.city_id = city_id;
	}
	@Override
	public String toString() {
		return "area [area_id=" + area_id + ", area_name=" + area_name + ", city_id=" + city_id + "]";
	}
	
}
