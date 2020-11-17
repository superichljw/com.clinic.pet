package com.clinic.pet.dto;

import java.sql.Timestamp;

public class QnaBoardVO {
	public int getQna_num() {
		return qna_num;
	}

	public void setQna_num(int qna_num) {
		this.qna_num = qna_num;
	}

	public String getQna_title() {
		return qna_title;
	}

	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}

	public Timestamp getQna_date() {
		return qna_date;
	}

	public void setQna_date(Timestamp qna_date) {
		this.qna_date = qna_date;
	}

	public String getQna_name() {
		return qna_name;
	}

	public void setQna_name(String qna_name) {
		this.qna_name = qna_name;
	}

	public int getQna_hit() {
		return qna_hit;
	}

	public void setQna_hit(int qna_hit) {
		this.qna_hit = qna_hit;
	}

	public String getQna_content() {
		return qna_content;
	}

	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}

	private int qna_num;
	private String qna_title;
	private Timestamp qna_date;
	private String qna_name;
	private int qna_hit;
	private String qna_content;
	
	public QnaBoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QnaBoardVO(int qna_num, String qna_title, Timestamp qna_date, String qna_name, int qna_hit,
			String qna_content) {
		super();
		this.qna_num = qna_num;
		this.qna_title = qna_title;
		this.qna_date = qna_date;
		this.qna_name = qna_name;
		this.qna_hit = qna_hit;
		this.qna_content = qna_content;
	}
	
	
}
