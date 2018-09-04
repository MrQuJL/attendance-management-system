package com.qjl.attendance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qjl.attendance.entity.AttendanceType;
import com.qjl.attendance.mapper.AttendanceTypeMapper;
import com.qjl.attendance.service.IAttendanceTypeService;

/**
 * 类描述：IAttendanceTypeService接口的实现类
 * 全限定性类名: com.qjl.attendance.service.impl.AttendanceTypeImpl
 * @author 曲健磊
 * @date 2018年9月1日下午6:22:28
 * @version V1.0
 */
@Service("attendanceType")
public class AttendanceTypeImpl implements IAttendanceTypeService {

	@Autowired
	private AttendanceTypeMapper attendanceTypeMapper;
	
	@Override
	public List<AttendanceType> listAttendanceType() {
		return attendanceTypeMapper.listAttendanceType();
	}

}
