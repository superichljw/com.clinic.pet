package com.clinic.pet.dto;

import java.sql.Timestamp;

public class BookingVO {
	
	private int booking_num;
	private String booking_id;
	private String booking_Name;
	private String booking_Add;
	private String booking_Tel;
	private String booking_Date;
	private Timestamp orderDate;
	
	public String getBooking_Date() {
		return booking_Date;
	}
	public void setBooking_Date(String booking_Date) {
		this.booking_Date = booking_Date;
	}
	
	
	public int getBooking_num() {
		return booking_num;
	}
	public void setBooking_num(int booking_num) {
		this.booking_num = booking_num;
	}
	public String getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(String booking_id) {
		this.booking_id = booking_id;
	}
	public String getBooking_Name() {
		return booking_Name;
	}
	public void setBooking_Name(String booking_Name) {
		this.booking_Name = booking_Name;
	}
	public String getBooking_Add() {
		return booking_Add;
	}
	public void setBooking_Add(String booking_Add) {
		this.booking_Add = booking_Add;
	}
	public String getBooking_Tel() {
		return booking_Tel;
	}
	public void setBooking_Tel(String booking_Tel) {
		this.booking_Tel = booking_Tel;
	}
	
	public Timestamp getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
	public BookingVO(int booking_num, String booking_id, String booking_Name, String booking_Add, String booking_Tel,
			String booking_Date, Timestamp orderDate) {
		super();
		this.booking_num = booking_num;
		this.booking_id = booking_id;
		this.booking_Name = booking_Name;
		this.booking_Add = booking_Add;
		this.booking_Tel = booking_Tel;
		this.booking_Date = booking_Date;
		this.orderDate = orderDate;
	}
	public BookingVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
