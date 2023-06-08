package com.crud.dto;

public class UserExpertCategoryCityDto {
	
	private UserDto user;
	private ExpertDto expert;
	private CategoryDto category;
	private AreaCityDto city;
	
	public UserExpertCategoryCityDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserExpertCategoryCityDto(UserDto user, ExpertDto expert, CategoryDto category, AreaCityDto city) {
		super();
		this.user = user;
		this.expert = expert;
		this.category = category;
		this.city = city;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public ExpertDto getExpert() {
		return expert;
	}

	public void setExpert(ExpertDto expert) {
		this.expert = expert;
	}

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	public AreaCityDto getCity() {
		return city;
	}

	public void setCity(AreaCityDto city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "UserExpertCategoryCityDto [user=" + user + ", expert=" + expert + ", category=" + category + ", city="
				+ city + "]";
	}
	
	
	
	
	

}
