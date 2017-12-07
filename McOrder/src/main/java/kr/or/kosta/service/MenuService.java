package kr.or.kosta.service;
/*
* @FileName : MenuService
* @Project : McOrder
* @Date : 2017.12.27 
* @Author : 최한나, 염주호
*/
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.kosta.dao.MenuDao;
import kr.or.kosta.dto.BurgerSet;
import kr.or.kosta.dto.Menu;

@Service
public class MenuService {
	@Autowired
	private SqlSession session;
	
	/*
	 * @method Name : getMenuDetail
	 * @date : 2017.11.29
	 * @author :2017.11.29. : 최한나
	 * @description :  메뉴 상세보기
	 * @param spec : String menuName
	 * @return : Menu
	 */
	public Menu getMenuDetail(String menuName) {
		
		MenuDao menudao = session.getMapper(MenuDao.class);
		Menu menu = menudao.getMenuDetail(menuName);
		
		return menu;
	}
	/*
	 * @method Name : addMenu
	 * @date : 2017.11.30
	 * @author :2017.11.30. : 염주호
	 * @description :  메뉴 등록
	 * @param spec : Menu menu
	 * @return : void
	 */
	/*
	 * @method Name : addMenu
	 * @date : 2017.12.07
	 * @author :2017.12.07. : 최한나 
	 * @description :  메뉴 등록시 세트메뉴 체크하면 세트테이블에도 등록하기
	 * @param spec : Menu menu
	 * @return : void
	 */
	@Transactional
	public void addMenu(Menu menu) {
		
		MenuDao menudao = session.getMapper(MenuDao.class);
		System.out.println("서비스 여기까진 왔지?");
		System.out.println(menu.toString());
		try {
			menudao.addMenu(menu);
			menudao.addNutrient(menu);
			BurgerSet burgerSet = new BurgerSet();
			burgerSet.setSetMenuName(menu.getMenuName()+"세트");
			burgerSet.setMenuType(menu.getMenuType());
			burgerSet.setMenuName(menu.getMenuName());
			if(menu.getMenuType()==4) {
				menudao.addBurgerSet(burgerSet);
			}
		} catch (Exception e) {
			System.out.println("Transaction 예외 발생" + e.getMessage());
			throw e; // 예외 발생 시기면 : 자동 rollback
		}
		
		
	}
	/*
	 * @method Name : getMenuList
	 * @date : 2017.11.29
	 * @author :2017.11.29. : 최한나
	 * @description :  최상위 관리자가 보는 메뉴리스트
	 * @param spec : 
	 * @return : List<Menu>
	 */
	public List<Menu> getMenuList(){
		
		MenuDao menudao = session.getMapper(MenuDao.class);
		List<Menu> list = menudao.getMenuList();
		return list;
	}
	/*
	 * @method Name : addMenuListRowAdmin
	 * @date : 2017.12.03
	 * @author :2017.12.03. : 염주호
	 * @description :  하위관리자 최상위 관리자의 메뉴 중 원하는 메뉴등록
					      하위 관리자가 최상위관리자가 등록한 메뉴 리스트들 중 판매원하는 메뉴들 체크해서 등록
	 * @param spec : int branchCode, Map<String, Object> paramMap
	 * @return : void
	 */
	public void addMenuListRowAdmin(int branchCode, Map<String, Object> paramMap) {
		
		MenuDao menudao = session.getMapper(MenuDao.class);
		menudao.deleteResMenu(branchCode);			//먼저 테이블 꺠끗하게 delete
		System.out.println("service단 : " + paramMap.toString());
		session.insert("addMenuListRowAdmin",paramMap);
		//menudao.addMenuListRowAdmin(paramMap, branchCode);	//list를 담은 menuMap을 보냄		
	}
	
	/*
	 * @method Name : getMenuRowAdmin
	 * @date : 2017.12.03
	 * @author :2017.12.03. : 염주호
	 * @description :  하위관리자 메뉴리스트 뿌리기
	 * @param spec : int branchCode
	 * @return : List<String>
	 */
	public List<String> getMenuRowAdmin(int branchCode) {
		MenuDao menudao = session.getMapper(MenuDao.class);
		List<String> list = menudao.getMenuRowAdmin(branchCode);
		
		return list;
	}
	
	// 하위 관리자가 최상위관리자가 등록한 메뉴 리스트들 중 판매원하는 메뉴들 체크해서 등록
	public int addMenu(int branchCode, List<Menu> list) {
		return 0;
	}
	
	// 하위관리자가 만약 메뉴등록페이지에와서 체크하고 등록버튼누르면 일단 그 매장에 있는 
	// 메뉴리스트를 전체 지우고 체크한부분들을 다시 등록시키는 것이므로 선행될 전체 삭제 서비스
	public int deleteMenu(int branchCode) {
		return 0;
	}
	
	// 최상위 관리자가 메뉴 삭제
	public int deleteMenu(String menuName) {
		return 0;
	}
	
	// 최상위 관리자가 메뉴 수정
	public int updateMenu(Menu menu) {
		return 0;
	}
	
	
}
