package com.crud.dto;

public class CityDto {
	private int city_id;
	private String city_name;
	private int area_id;
	private float mapx;
	private float mapy;
	public CityDto() { super(); }
	public CityDto(int city_id, String city_name, int area_id) {
		super();
		this.city_id = city_id;
		this.city_name = city_name;
		this.area_id = area_id;
	}
	public float getMapx() {
		return mapx;
	}
	public void setMapx(float mapx) {
		this.mapx = mapx;
	}
	public float getMapy() {
		return mapy;
	}
	public void setMapy(float mapy) {
		this.mapy = mapy;
	}
	@Override
	public String toString() {
		return "CityDto [city_id=" + city_id + ", city_name=" + city_name + ", area_id=" + area_id + "]";
	}
	public int getCity_id() { return city_id; } public void setCity_id(int city_id) { this.city_id = city_id; }
	public String getCity_name() { return city_name; } public void setCity_name(String city_name) { this.city_name = city_name; }
	public int getArea_id() { return area_id; } public void setArea_id(int area_id) { this.area_id = area_id; }
	
}
