package kr.or.kosta.dto;

public class Nutrient {

	private String menuName;
	private String ingrdient;
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getIngrdient() {
		return ingrdient;
	}
	public void setIngrdient(String ingrdient) {
		this.ingrdient = ingrdient;
	}
	@Override
	public String toString() {
		return "Nutrient [menuName=" + menuName + ", ingrdient=" + ingrdient + "]";
	}
	
	
	
}
