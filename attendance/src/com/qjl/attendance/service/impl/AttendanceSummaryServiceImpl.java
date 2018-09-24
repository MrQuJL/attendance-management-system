package com.qjl.attendance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qjl.attendance.dto.AttendanceSummary;
import com.qjl.attendance.mapper.AttendanceSummaryMapper;
import com.qjl.attendance.service.IAttendanceSummaryService;

/**
 * 类描述：考勤汇总接口的默认实现类
 * 全限定性类名: com.qjl.attendance.service.impl.AttendanceSummaryServiceImpl
 * @author 曲健磊
 * @date 2018年9月9日下午8:43:13
 * @version V1.0
 */
@Service("attendanceSummaryService")
public class AttendanceSummaryServiceImpl implements IAttendanceSummaryService {

	@Autowired
	private AttendanceSummaryMapper attendanceSummaryMapper;
	
	@Override
	public List<AttendanceSummary> listAttendanceSummary(String year, String month) {
		return attendanceSummaryMapper.listAttendanceSummary(year, month);
	}

}
