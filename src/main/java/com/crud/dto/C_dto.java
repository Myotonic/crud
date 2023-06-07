package com.company.dto;

import java.util.List;

public class C_dto {
	private int board_category_no;
	private String board_category_name;
	private List<bWriterDto> write;
	public C_dto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public C_dto(int board_category_no, String board_category_name, List<bWriterDto> write) {
		super();
		this.board_category_no = board_category_no;
		this.board_category_name = board_category_name;
		this.write = write;
	}
	public int getBoard_category_no() {
		return board_category_no;
	}
	public void setBoard_category_no(int board_category_no) {
		this.board_category_no = board_category_no;
	}
	public String getBoard_category_name() {
		return board_category_name;
	}
	public void setBoard_category_name(String board_category_name) {
		this.board_category_name = board_category_name;
	}
	public List<bWriterDto> getWrite() {
		return write;
	}
	public void setWrite(List<bWriterDto> write) {
		this.write = write;
	}
	@Override
	public String toString() {
		return "C_dto [board_category_no=" + board_category_no + ", board_category_name=" + board_category_name
				+ ", write=" + write + "]";
	}
	
	
}
