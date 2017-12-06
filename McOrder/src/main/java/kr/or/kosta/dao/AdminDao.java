package kr.or.kosta.dao;

import java.util.List;

import kr.or.kosta.dto.Admin;
import kr.or.kosta.dto.Member;

public interface AdminDao {

	public List<Admin> getAdminList();
	
	public void addAdmin(Admin admin);
	
	public void deleteAdmin(int branchCode);
	
	public void addAdminToMember(Member member);
}
