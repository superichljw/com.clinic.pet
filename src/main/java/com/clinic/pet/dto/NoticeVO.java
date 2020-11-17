package com.clinic.pet.dto;

import java.sql.Timestamp;

public class NoticeVO {
	private int notice_num;
	private String notice_title;
	private Timestamp notice_date;
	private String notice_name;
	private int notice_hit;
	private String notice_content;
	
	public NoticeVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NoticeVO(int notice_num, String notice_title, Timestamp notice_date, String notice_name, int notice_hit,
			String notice_content) {
		super();
		this.notice_num = notice_num;
		this.notice_title = notice_title;
		this.notice_date = notice_date;
		this.notice_name = notice_name;
		this.notice_hit = notice_hit;
		this.notice_content = notice_content;
	}
	public int getNotice_num() {
		return notice_num;
	}
	public void setNotice_num(int notice_num) {
		this.notice_num = notice_num;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public Timestamp getNotice_date() {
		return notice_date;
	}
	public void setNotice_date(Timestamp notice_date) {
		this.notice_date = notice_date;
	}
	public String getNotice_name() {
		return notice_name;
	}
	public void setNotice_name(String notice_name) {
		this.notice_name = notice_name;
	}
	public int getNotice_hit() {
		return notice_hit;
	}
	public void setNotice_hit(int notice_hit) {
		this.notice_hit = notice_hit;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
}
