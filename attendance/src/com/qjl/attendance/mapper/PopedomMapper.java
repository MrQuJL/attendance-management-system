package com.qjl.attendance.mapper;

import java.util.List;

import com.qjl.attendance.entity.AdminPopedom;

/**
 * 类描述：处理对用户的权限
 * 全限定性类名: com.qjl.attendance.mapper.PopedomMapper
 * @author 曲健磊
 * @date 2018年9月1日上午9:02:17
 * @version V1.0
 */
public interface PopedomMapper {
	
	/**
	 * 查询出当前考勤员所拥有的部门权限
	 * @param workerId
	 * @return
	 */
	List<Long> listAllWorkerPerm(Long workerId);
	
	/**
	 * 删除当前考勤员对所有部门的权限
	 * @param workerId
	 * @return
	 */
	int deleteAllWorkerPerm(Long workerId);
	
	/**
	 * 向数据库中增加一个考勤员对某个部门的权限
	 * @param popedom
	 * @return
	 */
	int insertPerm(AdminPopedom popedom);
	
}
