package com.crud.dto;

public class Certificate {
	private int expert_id;
	private int certificate_no;
	private String certificate_entry;
	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Certificate(int expert_id, int certificate_no, String certificate_entry) {
		super();
		this.expert_id = expert_id;
		this.certificate_no = certificate_no;
		this.certificate_entry = certificate_entry;
	}
	public int getExpert_id() {
		return expert_id;
	}
	public void setExpert_id(int expert_id) {
		this.expert_id = expert_id;
	}
	public int getCertificate_no() {
		return certificate_no;
	}
	public void setCertificate_no(int certificate_no) {
		this.certificate_no = certificate_no;
	}
	public String getCertificate_entry() {
		return certificate_entry;
	}
	public void setCertificate_entry(String certificate_entry) {
		this.certificate_entry = certificate_entry;
	}
	@Override
	public String toString() {
		return "certificate [expert_id=" + expert_id + ", certificate_no=" + certificate_no + ", certificate_entry="
				+ certificate_entry + "]";
	}
	
}
