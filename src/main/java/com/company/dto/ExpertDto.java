package com.company.dto;

public class ExpertDto {
	
	private int expert_id;
	private String expert_intro;
	private String expert_date;
	private String expert_range;
	private int user_id;
	private int city_id;
	private int category2_id;
	
	
	public ExpertDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ExpertDto(int expert_id, String expert_intro, String expert_date, String expert_range, int user_id,
			int city_id, int category2_id) {
		super();
		this.expert_id = expert_id;
		this.expert_intro = expert_intro;
		this.expert_date = expert_date;
		this.expert_range = expert_range;
		this.user_id = user_id;
		this.city_id = city_id;
		this.category2_id = category2_id;
	}


	public int getExpert_id() {
		return expert_id;
	}


	public void setExpert_id(int expert_id) {
		this.expert_id = expert_id;
	}


	public String getExpert_intro() {
		return expert_intro;
	}


	public void setExpert_intro(String expert_intro) {
		this.expert_intro = expert_intro;
	}


	public String getExpert_date() {
		return expert_date;
	}


	public void setExpert_date(String expert_date) {
		this.expert_date = expert_date;
	}


	public String getExpert_range() {
		return expert_range;
	}


	public void setExpert_range(String expert_range) {
		this.expert_range = expert_range;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public int getCity_id() {
		return city_id;
	}


	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}


	public int getCategory2_id() {
		return category2_id;
	}


	public void setCategory2_id(int category2_id) {
		this.category2_id = category2_id;
	}


	@Override
	public String toString() {
		return "ExpertDto [expert_id=" + expert_id + ", expert_intro=" + expert_intro + ", expert_date=" + expert_date
				+ ", expert_range=" + expert_range + ", user_id=" + user_id + ", city_id=" + city_id + ", category2_id="
				+ category2_id + "]";
	}
	
	
	
	

}



/*

+--------------+--------------+------+-----+-------------------+-------------------+
| Field        | Type         | Null | Key | Default           | Extra             |
+--------------+--------------+------+-----+-------------------+-------------------+
| expert_id    | int          | NO   | PRI | NULL              | auto_increment    |
| expert_intro | varchar(255) | NO   |     | NULL              |                   |
| expert_date  | datetime     | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
| expert_range | varchar(200) | NO   |     | NULL              |                   |
| user_id      | int          | NO   | MUL | NULL              |                   |
| city_id      | int          | NO   | MUL | NULL              |                   |
| category2_id | int          | NO   | MUL | NULL              |                   |
+--------------+--------------+------+-----+-------------------+-------------------+
*
*
*/
