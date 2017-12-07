package kr.or.kosta.dao;
/*
* @FileName : AdminDao
* @Project : McOrder
* @Date : 2017.12.06
* @Author : 최한나
*/ 
import java.util.List;

import kr.or.kosta.dto.Admin;
import kr.or.kosta.dto.Member;
import kr.or.kosta.dto.Restaurant;

public interface AdminDao {

	/*
	 * @method Name : getAdminList
	 * @date : 2017.12.06
	 * @author :2017.12.06. : 최한나
	 * @description : 하위 관리자 리스트 보기
	 * @param spec : 
	 * @return : List<Admin>
	 */
	public List<Admin> getAdminList();
	
	
	/*
	 * @method Name : addAdmin
	 * @date : 2017.12.06
	 * @author :2017.12.06. : 최한나
	 * @description : 하위 관리자 테이블에 등록
	 * @param spec : Admin admin
	 * @return : void
	 */
	public void addAdmin(Admin admin);
	
	/*
	 * @method Name : deleteAdmin
	 * @date : 2017.12.06
	 * @author :2017.12.06. : 최한나
	 * @description : 하위 관리자 삭제
	 * @param spec : Admin admin
	 * @return : void
	 */
	public void deleteAdmin(int branchCode);
	
	/*
	 * @method Name : addAdminToMember
	 * @date : 2017.12.06
	 * @author :2017.12.06. : 최한나
	 * @description : 하위 관리자를 멤버 테이블에 등록
	 * @param spec : Member member
	 * @return : void
	 */
	public void addAdminToMember(Member member);
	
	/*
	 * @method Name : addRestaurant
	 * @date : 2017.12.06
	 * @author :2017.12.06. : 최한나
	 * @description : 매장정보등록
	 * @param spec : 
	 * @return : void
	 */
	public void addRestaurant(int branchCode, String addr1, String addr2);
	
	public Restaurant getRestaurant(int branchCode);
}
