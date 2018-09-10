package com.qjl.attendance.mapper;

import java.util.List;

import com.qjl.attendance.dto.AttendanceSummary;

/**
 * 类描述：查询考勤汇总的信息
 * 全限定性类名: com.qjl.attendance.mapper.AttendanceSummaryMapper
 * @author 曲健磊
 * @date 2018年9月9日下午8:38:31
 * @version V1.0
 */
public interface AttendanceSummaryMapper {
	
	/**
	 * 按年月进行考勤汇总
	 * @param year
	 * @param month
	 * @return
	 */
	List<AttendanceSummary> listAttendanceSummary(String year, String month);
	
}
