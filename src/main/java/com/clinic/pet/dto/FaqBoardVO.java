package com.clinic.pet.dto;

import java.sql.Timestamp;

public class FaqBoardVO {
	
	private int faq_num;
	private String faq_title;
	private Timestamp faq_date;
	private String faq_name;
	private int faq_hit;
	private String faq_content;
	
	public FaqBoardVO(int faq_num, String faq_title, Timestamp faq_date, String faq_name, int faq_hit,
			String faq_content) {
		super();
		this.faq_num = faq_num;
		this.faq_title = faq_title;
		this.faq_date = faq_date;
		this.faq_name = faq_name;
		this.faq_hit = faq_hit;
		this.faq_content = faq_content;
	}
	public FaqBoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getFaq_num() {
		return faq_num;
	}
	public void setFaq_num(int faq_num) {
		this.faq_num = faq_num;
	}
	public String getFaq_title() {
		return faq_title;
	}
	public void setFaq_title(String faq_title) {
		this.faq_title = faq_title;
	}
	public Timestamp getFaq_date() {
		return faq_date;
	}
	public void setFaq_date(Timestamp faq_date) {
		this.faq_date = faq_date;
	}
	public String getFaq_name() {
		return faq_name;
	}
	public void setFaq_name(String faq_name) {
		this.faq_name = faq_name;
	}
	public int getFaq_hit() {
		return faq_hit;
	}
	public void setFaq_hit(int faq_hit) {
		this.faq_hit = faq_hit;
	}
	public String getFaq_content() {
		return faq_content;
	}
	public void setFaq_content(String faq_content) {
		this.faq_content = faq_content;
	}
	
	
}
