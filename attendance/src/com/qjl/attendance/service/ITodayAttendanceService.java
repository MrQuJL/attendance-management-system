package com.qjl.attendance.service;

import java.util.List;

import com.qjl.attendance.dto.TodayAttendance;
import com.qjl.attendance.dto.TodayAttendanceParam;

/**
 * 类描述：今日出勤服务层接口
 * 全限定性类名: com.qjl.attendance.service.ITodayAttendance
 * @author 曲健磊
 * @date 2018年9月6日下午9:29:06
 * @version V1.0
 */
public interface ITodayAttendanceService {

	/**
	 * 查询今日考勤信息
	 * @param param 部门id，出勤时段，出勤状态
	 * @return
	 */
	List<TodayAttendance> listTodayAttendance(TodayAttendanceParam param);
	
}
