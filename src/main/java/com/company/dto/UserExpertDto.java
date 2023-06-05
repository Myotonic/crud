package com.company.dto;

public class UserExpertDto {
	
	private UserDto user;
	private ExpertDto expert;
	
	
	public UserExpertDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserExpertDto(UserDto user, ExpertDto expert) {
		super();
		this.user = user;
		this.expert = expert;
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


	@Override
	public String toString() {
		return "UserExpertDto [user=" + user + ", expert=" + expert + "]";
	}
	
	
	

}
