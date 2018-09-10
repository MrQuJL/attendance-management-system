package com.qjl.attendance.service;

import java.util.List;

import com.qjl.attendance.dto.AttendanceSummary;

/**
 * 类描述：考勤汇总
 * 全限定性类名: com.qjl.attendance.service.IAttendanceSummaryService
 * @author 曲健磊
 * @date 2018年9月9日下午8:42:07
 * @version V1.0
 */
public interface IAttendanceSummaryService {

	/**
	 * 按年月进行考勤汇总
	 * @param year
	 * @param month
	 * @return
	 */
	List<AttendanceSummary> listAttendanceSummary(String year, String month);
	
}
