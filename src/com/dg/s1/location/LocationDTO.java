package com.dg.s1.location;

public class LocationDTO {
	
	//DTO Data Transfer Object
	//Data 덩어리
	
	//1. 멤버변수는 모두 private
	//2. Getter / Setter 생성
	//3. 생성자는 여러개 가능. 단, 디포르 생성자 필요
	//4. 멤버변수의 데이터타입과 변수명은 DB의 Column과 일치
	
	private int location_id;
	private String street_address;
	private String postal_code;
	
	public int getLocation_id() {
		return location_id;
	}
	
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	
	public String getStreet_address() {
		return street_address;
	}
	
	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}

	public String getPostal_code() {
		return postal_code;
	}
	
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState_province() {
		return state_province;
	}
	
	public void setState_province(String state_province) {
		this.state_province = state_province;
	}

	public String getCountry_id() {
		return country_id;
	}

	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}
	private String city;
	private String state_province;
	private String country_id; 
	
}
