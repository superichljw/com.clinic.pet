package com.clinic.pet.dto;

import java.sql.Timestamp;

public class VetClinicVO {
	
	private String usertype;
	private String userid;
	private String pwd;
	private String email;
	private Timestamp joindate;
	private String addr;
	private String name;
	
	private String phone;
	private String pettype;
	private String petname;
	private String petnum;
	private int personal;
	private int emailok;

	
	private String hospital_name;
	private String hospital_num;
	private String hospital_li;
	private int auth;
	
	
	public VetClinicVO(String usertype, String userid, String pwd, String email, Timestamp joindate, String addr,
			String name, String phone, String pettype, String petname, String petnum, int personal, int emailok,
			String hospital_name, String hospital_num, String hospital_li, int auth) {
		super();
		this.usertype = usertype;
		this.userid = userid;
		this.pwd = pwd;
		this.email = email;
		this.joindate = joindate;
		this.addr = addr;
		this.name = name;
		this.phone = phone;
		this.pettype = pettype;
		this.petname = petname;
		this.petnum = petnum;
		this.personal = personal;
		this.emailok = emailok;

		this.hospital_name = hospital_name;
		this.hospital_num = hospital_num;
		this.hospital_li = hospital_li;
		this.auth = auth;
	}
	

	
	@Override
	public String toString() {
		return "VetClinicVO [usertype=" + usertype + ", userid=" + userid + ", pwd=" + pwd + ", email=" + email
				+ ", joindate=" + joindate + ", addr=" + addr + ", name=" + name + ", phone=" + phone + ", pettype="
				+ pettype + ", petname=" + petname + ", petnum=" + petnum + ", personal=" + personal + ", emailok="
				+ emailok +  ", hospital_name=" + hospital_name + ", hospital_num="
				+ hospital_num + ", hospital_li=" + hospital_li + ", auth=" + auth + "]";
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getJoindate() {
		return joindate;
	}
	public void setJoindate(Timestamp joindate) {
		this.joindate = joindate;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPettype() {
		return pettype;
	}
	public void setPettype(String pettype) {
		this.pettype = pettype;
	}
	public String getPetname() {
		return petname;
	}
	public void setPetname(String petname) {
		this.petname = petname;
	}
	public String getPetnum() {
		return petnum;
	}
	public void setPetnum(String petnum) {
		this.petnum = petnum;
	}
	public int getPersonal() {
		return personal;
	}
	public void setPersonal(int personal) {
		this.personal = personal;
	}
	public int getEmailok() {
		return emailok;
	}
	public void setEmailok(int emailok) {
		this.emailok = emailok;
	}
	
	public String getHospital_name() {
		return hospital_name;
	}
	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}
	public String getHospital_num() {
		return hospital_num;
	}
	public void setHospital_num(String hospital_num) {
		this.hospital_num = hospital_num;
	}
	public String getHospital_li() {
		return hospital_li;
	}
	public void setHospital_li(String hospital_li) {
		this.hospital_li = hospital_li;
	}
	public int getAuth() {
		return auth;
	}
	public void setAuth(int auth) {
		this.auth = auth;
	}
	public VetClinicVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
