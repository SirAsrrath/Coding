package com.codingdojo.omikuji.models;

public class Person {


	private int number;
	private String cityName;
	private String personName;
	private String hobby;
	private String thing;
	private String comment;
	
	public Person(String personName,String cityName,String hobby,String thing, String comment,int number) {
		this.personName = personName;
		this.cityName = cityName;
		this.comment = comment;
		this.thing = thing;
		this.hobby = hobby;
		this.number = number;
	}
	
	
	// Getters & Setters
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getThing() {
		return thing;
	}

	public void setThing(String thing) {
		this.thing = thing;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
