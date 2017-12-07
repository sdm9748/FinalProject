package kr.or.kosta.dto;

public class BurgerSet extends Menu {

	private String setMenuName;
	private int menuType;
	private String menuName;
	public String getSetMenuName() {
		return setMenuName;
	}
	public void setSetMenuName(String setMenuName) {
		this.setMenuName = setMenuName;
	}
	public int getMenuType() {
		return menuType;
	}
	public void setMenuType(int menuType) {
		this.menuType = menuType;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	@Override
	public String toString() {
		return "BurgerSet [setMenuName=" + setMenuName + ", menuType=" + menuType + ", menuName=" + menuName + "]";
	}
	
	
	
	
}
