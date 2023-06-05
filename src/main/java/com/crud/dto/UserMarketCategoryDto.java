package com.crud.dto;

public class UserMarketCategoryDto {
	
	private UserDto user;
	private MarketDto market;
	private CategoryDto category;
	
	public UserMarketCategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserMarketCategoryDto(UserDto user, MarketDto market, CategoryDto category) {
		super();
		this.user = user;
		this.market = market;
		this.category = category;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public MarketDto getMarket() {
		return market;
	}

	public void setMarket(MarketDto market) {
		this.market = market;
	}

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "UserMarketCategoryDto [user=" + user + ", market=" + market + ", category=" + category + "]";
	}
	
	
	
	

}
