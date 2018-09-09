package com.qjl.attendance.service;

import java.util.List;

import com.qjl.attendance.dto.AdminDto;
import com.qjl.attendance.entity.Admin;

/**
 * 类描述：用户服务接口
 * 全限定性类名: com.qjl.attendance.service.IAdminService
 * @author 曲健磊
 * @date 2018年8月30日上午9:35:23
 * @version V1.0
 */
public interface IAdminService {

	/**
	 * true则登录成功，false失败
	 * @param admin
	 * @return
	 */
	Admin loginAdmin(Admin admin);
	
	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return
	 */
	Admin getAdminById(Long id);
	
	/**
	 * 查询用户信息
	 * @return
	 */
	List<AdminDto> listAllAdmin();
	
	/**
	 * 查询出所有的考勤员
	 * @return
	 */
	List<Admin> listAdminWork();
	
	/**
	 * 添加员工
	 * @return
	 */
	int insertAdmin(Admin admin);
	
	/**
	 * 删除员工
	 * @param adminid
	 * @return
	 */
	int deleteAdmin(Long adminid);
	
	/**
	 * 修改用户
	 * @param admin
	 * @return
	 */
	int updateAdmin(Admin admin);
	
	/**
	 * 修改密码
	 * @param admin
	 * @return
	 */
	boolean updatePwd(Admin admin);
	
}
