package com.clinic.pet.dto;

import java.sql.Timestamp;

public class NewsBoardVO {
	
	private int news_num;
	private String news_title;
	private Timestamp news_date;
	private String news_name;
	private int news_hit;
	private String news_content;
	
	
	public NewsBoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewsBoardVO(int news_num, String news_title, Timestamp news_date, String news_name, int news_hit,
			String news_content) {
		super();
		this.news_num = news_num;
		this.news_title = news_title;
		this.news_date = news_date;
		this.news_name = news_name;
		this.news_hit = news_hit;
		this.news_content = news_content;
	}
	
	public int getNews_num() {
		return news_num;
	}
	public void setNews_num(int news_num) {
		this.news_num = news_num;
	}
	public String getNews_title() {
		return news_title;
	}
	public void setNews_title(String news_title) {
		this.news_title = news_title;
	}
	public Timestamp getNews_date() {
		return news_date;
	}
	public void setNews_date(Timestamp news_date) {
		this.news_date = news_date;
	}
	public String getNews_name() {
		return news_name;
	}
	public void setNews_name(String news_name) {
		this.news_name = news_name;
	}
	public int getNews_hit() {
		return news_hit;
	}
	public void setNews_hit(int news_hit) {
		this.news_hit = news_hit;
	}
	public String getNews_content() {
		return news_content;
	}
	public void setNews_content(String news_content) {
		this.news_content = news_content;
	}
	
}
