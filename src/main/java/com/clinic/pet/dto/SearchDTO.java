package com.clinic.pet.dto;

public class SearchDTO extends noticePageDTO {

	private String searchVal;
	private String searchCol;

	public SearchDTO() {
		super();
	}

	public void makePage(int page, int pageDataCount, int totalDataCount, String searchCol, String searchVal) {
		makePage(page, pageDataCount, totalDataCount);
		this.searchCol = searchCol;
		this.searchVal = searchVal;
	}

	@Override
	public String toString() {
		return super.toString() + "\nSearchDTO [searchVal=" + searchVal + ", searchCol=" + searchCol + "]";
	}

	public String getSearchVal() {
		return searchVal;
	}

	public void setSearchVal(String searchVal) {
		this.searchVal = searchVal;
	}

	public String getSearchCol() {
		return searchCol;
	}

	public void setSearchCol(String searchCol) {
		this.searchCol = searchCol;
	}
}
