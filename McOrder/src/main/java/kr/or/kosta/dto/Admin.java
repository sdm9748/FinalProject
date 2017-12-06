package kr.or.kosta.dto;
/*
* @FileName : Admin
* @Project : McOrder
* @Date : 2017.12.27 
* @Author : 최한나, 김수진, 염주호
*/ 
public class Admin {

	private int branchCode;
	private String role;
	private String name;
	
	
	public int getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Admin [branchCode=" + branchCode + ", role=" + role + ", name=" + name + "]";
	}
	
	
	
	
	
}
