package kr.or.kosta.dto;

import java.sql.Date;

public class Menu {

	private String menuName;
	private int price;
	private int menuType;
	private Date startDate;
	private Date endDate;
	private String menuImage;
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getMenuType() {
		return menuType;
	}
	public void setMenuType(int menuType) {
		this.menuType = menuType;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getMenuImage() {
		return menuImage;
	}
	public void setMenuImage(String menuImage) {
		this.menuImage = menuImage;
	}
	@Override
	public String toString() {
		return "Menu [menuName=" + menuName + ", price=" + price + ", menuType=" + menuType + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", menuImage=" + menuImage + "]";
	}
	
	
	
}
