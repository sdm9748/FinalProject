package kr.or.kosta.service;
/*
* @FileName : AdminService
* @Project : McOrder
* @Date : 2017.12.06 
* @Author : 최한나
*/ 
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.kosta.dao.AdminDao;
import kr.or.kosta.dao.MemberDao;
import kr.or.kosta.dto.Admin;
import kr.or.kosta.dto.Member;

@Service
public class AdminService {
	
	
	@Autowired
	private SqlSession session;
	
	/*
	* @method Name : getAdminList
	* @date  : 2017.12.06
	* @author :2017.12.06. : 최한나
	* @description : 하위관리자 리스트 보기
	* @param spec : 
	* @return : List<Admin>
	*/ 
	public List<Admin> getAdminList(){
		
		AdminDao adminDao = session.getMapper(AdminDao.class);
		System.out.println("서비스");
		List<Admin>	list = adminDao.getAdminList();
		System.out.println("관리자 서비스에서 리스트 : " + list.toString());
		return list;
		
	}
	
	/*
	* @method Name : deleteAdmin
	* @date  : 2017.12.06
	* @author :2017.12.06. : 최한나
	* @description : 하위관리자 삭제하고 다시 리스트 가져가기
	* @param spec : int branchCode
	* @return : List<Admin>
	*/ 
	@Transactional
	public List<Admin> deleteAdmin(int branchCode) {
		
		AdminDao adminDao = session.getMapper(AdminDao.class);
		MemberDao memberDao = session.getMapper(MemberDao.class);
		
		List<Admin> list = null;
		try {
			adminDao.deleteAdmin(branchCode);
			// 회원탈퇴 메소드없나..? 있으면 중간에 추가해주기
			list = adminDao.getAdminList();
			
		} catch (Exception e) {
			System.out.println("Transaction 예외 발생" + e.getMessage());
			throw e; // 예외 발생 시기면 : 자동 rollback
		}
		
		
		return list;
	}
	
	/*
	* @method Name : addAdmin
	* @date  : 2017.12.06
	* @author :2017.12.06. : 최한나
	* @description : 하위관리자 멤버테이블에 등록시키고 관리자 테이블에도 등록시키기
	* @param spec : Member member
	* @return : void
	*/ 
	@Transactional
	public void addAdmin(Member member) {
		
		AdminDao adminDao = session.getMapper(AdminDao.class);
		
		Admin admin = new Admin();
		System.out.println("관리자등록서비스1 : " +member.getId());
		System.out.println("관리자등록서비스2 :" + member.getName());
		admin.setBranchCode(Integer.parseInt(member.getId()));
		admin.setRole("ROLE_ADMIN");
		admin.setName(member.getName());
		
		System.out.println("관리자등록서비스 member branchCode : " + admin.getBranchCode());
		try {

			// 회원테이블에 추가하고 가공할떄 set으로 Admin에 값 넣어주기
			adminDao.addAdminToMember(member);
			// 어드민테이블에 그 아이디로 또 추가 
			adminDao.addAdmin(admin);
			
		} catch (Exception e) {
			System.out.println("Transaction 예외 발생" + e.getMessage());
			throw e; // 예외 발생 시기면 : 자동 rollback
		}
		
		
	}
}
