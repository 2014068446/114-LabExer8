package com.BEAN;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TVSeries")
public class TVSeries {

	private Long id;
	private String title;
	private int season;
	private int year;
	
	@Id
	@GeneratedValue
	@Column(name="USER_ID")	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="TITLE")
	public String getTitle() {
		return title;
	}
	public void setTitle(String name) {
		this.title = name;
	}
	
	@Column(name="SEASON")
	public int getSeason() {
		return season;
	}
	public void setSeason(int a) {
		this.season = a;
	}
	
	@Column(name="YEAR")
	public int getYear() {
		return year;
	}
	public void setYear(int b) {
		this.year = b;
	}
	
	

}
