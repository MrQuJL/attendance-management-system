package com.qjl.attendance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qjl.attendance.dto.AdminDto;
import com.qjl.attendance.entity.Admin;
import com.qjl.attendance.mapper.AdminMapper;
import com.qjl.attendance.service.IAdminService;

/**
 * 类描述：用户服务接口的实现类
 * 全限定性类名: com.qjl.attendance.service.impl.AdminServiceImpl
 * @author 曲健磊
 * @date 2018年8月30日上午9:36:09
 * @version V1.0
 */
@Service("adminService")
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public Admin loginAdmin(Admin admin) {
		Admin dbAdmin = adminMapper.loginAdmin(admin);
		return dbAdmin;
	}
	
	@Override
	public Admin getAdminById(Long id) {
		return adminMapper.getAdminById(id);
	}
	
	@Override
	public List<AdminDto> listAllAdmin() {
		return adminMapper.listAllAdmin();
	}

	@Override
	public List<Admin> listAdminWork() {
		return adminMapper.listAdminWork();
	}
	
	@Override
	public int insertAdmin(Admin admin) {
		admin.setAdminpwd("123");
		admin.setAdminstate((short)1);
		return adminMapper.insertAdmin(admin);
	}

	@Override
	public int deleteAdmin(Long adminid) {
		return adminMapper.deleteAdmin(adminid);
	}

	@Override
	public int updateAdmin(Admin admin) {
		return adminMapper.updateAdmin(admin);
	}

	@Override
	public boolean updatePwd(Admin admin) {
		boolean flag = false;
		int rows = adminMapper.updatePwd(admin);
		if (rows > 0) {
			flag = true;
		}
		return flag;
	}

}
