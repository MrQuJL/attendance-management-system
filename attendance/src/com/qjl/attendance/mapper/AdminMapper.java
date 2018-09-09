package com.qjl.attendance.mapper;

import java.util.List;

import com.qjl.attendance.dto.AdminDto;
import com.qjl.attendance.entity.Admin;

/**
 * 类描述：用于访问ATT_ADMIN表的数据
 * 全限定性类名: com.qjl.attendance.mapper.AdminMapper
 * @author 曲健磊
 * @date 2018年8月30日上午9:26:19
 * @version V1.0
 */
public interface AdminMapper {
	
	/**
	 * 验证用户登录
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
	 * 添加用户
	 * @return
	 */
	int insertAdmin(Admin admin);
	
	/**
	 * 删除用户
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
	 * 更新密码
	 * @param admin
	 * @return
	 */
	int updatePwd(Admin admin);
	
}
