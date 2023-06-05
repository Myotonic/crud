package com.company.dto;

public class AreaCityDto {
	
	private AreaDto area;
	private CityDto city;
	
	public AreaCityDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AreaCityDto(AreaDto area, CityDto city) {
		super();
		this.area = area;
		this.city = city;
	}

	public AreaDto getArea() {
		return area;
	}

	public void setArea(AreaDto area) {
		this.area = area;
	}

	public CityDto getCity() {
		return city;
	}

	public void setCity(CityDto city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "AreaCityDto [area=" + area + ", city=" + city + "]";
	}
	
	
	
	
	
	

}
