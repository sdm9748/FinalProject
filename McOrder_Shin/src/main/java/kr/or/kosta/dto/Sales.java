package kr.or.kosta.dto;

import java.sql.Date;

public class Sales {

	private Date salesDate;
	private int totalDailySales;
	private int branchCode;
	public Date getSalesDate() {
		return salesDate;
	}
	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}
	public int getTotalDailySales() {
		return totalDailySales;
	}
	public void setTotalDailySales(int totalDailySales) {
		this.totalDailySales = totalDailySales;
	}
	public int getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}
	@Override
	public String toString() {
		return "Sales [salesDate=" + salesDate + ", totalDailySales=" + totalDailySales + ", branchCode=" + branchCode
				+ "]";
	}
	
	
	
}
