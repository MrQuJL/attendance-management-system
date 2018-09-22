package com.qjl.attendance.service;

import java.util.List;

import com.qjl.attendance.dto.DeptAttendance;
import com.qjl.attendance.dto.DeptAttendanceParam;

/**
 * 类描述：处理考勤公告
 * 全限定性类名: com.qjl.attendance.service.IAttendanceBulletinService
 * @author 曲健磊
 * @date 2018年9月7日上午10:11:54
 * @version V1.0
 */
public interface IAttendanceBulletinService {

	/**
	 * 查询今日的考勤公告
	 * @param param 封装查询条件
	 * @return 所有部门的考勤信息
	 */
	List<DeptAttendance> listAttendanceBulletin(DeptAttendanceParam param);
	
}
