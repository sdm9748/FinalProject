package kr.or.kosta.dto;

import java.util.List;

public class Restaurant {

	private int branchCode;
	private String branchName;
	private String branchAddress;
	
	public int getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchAddress() {
		return branchAddress;
	}
	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}
	
	@Override
	public String toString() {
		return "Restaurant [branchCode=" + branchCode + ", branchName=" + branchName + ", branchAddress="
				+ branchAddress + "]";
	}
	

}