package com.qjl.attendance.mapper;

import java.util.List;

import com.qjl.attendance.entity.AttendanceType;

/**
 * 类描述：访问请假类型数据
 * 全限定性类名: com.qjl.attendance.mapper.AttendanceTypeMapper
 * @author 曲健磊
 * @date 2018年9月1日下午6:14:50
 * @version V1.0
 */
public interface AttendanceTypeMapper {
	
	/**
	 * 查询出所有的请假类型
	 * @return
	 */
	List<AttendanceType> listAttendanceType();
	
}
