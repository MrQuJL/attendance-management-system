package com.qjl.attendance.mapper;

import java.util.List;

import com.qjl.attendance.dto.TodayAttendance;
import com.qjl.attendance.dto.TodayAttendanceParam;

/**
 * 类描述：用于统计今日考勤数据
 * 全限定性类名: com.qjl.attendance.mapper.TodayAttendanceMapper
 * @author 曲健磊
 * @date 2018年9月6日下午9:02:53
 * @version V1.0
 */
public interface TodayAttendanceMapper {
	
	/**
	 * 查询今日考勤信息
	 * @param param 部门id，出勤时段，出勤状态
	 * @return
	 */
	List<TodayAttendance> listTodayAttendance(TodayAttendanceParam param);
	
}
