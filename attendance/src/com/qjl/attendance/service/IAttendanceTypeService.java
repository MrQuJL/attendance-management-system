package com.qjl.attendance.service;

import java.util.List;

import com.qjl.attendance.entity.AttendanceType;

/**
 * 类描述：用户服务接口
 * 全限定性类名: com.qjl.attendance.service.IAdminService
 * @author 曲健磊
 * @date 2018年8月30日上午9:35:23
 * @version V1.0
 */
public interface IAttendanceTypeService {
	
	/**
	 * 查询出所有的请假类型
	 * @return
	 */
	List<AttendanceType> listAttendanceType();
	
}
