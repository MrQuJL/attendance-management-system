package com.qjl.attendance.service;

import java.util.List;

import com.qjl.attendance.dto.AttRecordParam;
import com.qjl.attendance.entity.AttendanceRecord;

/**
 * 类描述：考勤记录服务层接口
 * 全限定性类名: com.qjl.attendance.service.IAttendanceRecordService
 * @author 曲健磊
 * @date 2018年9月5日上午11:10:10
 * @version V1.0
 */
public interface IAttendanceRecordService {
	
	/**
	 * 查询满足条件的考勤记录
	 * @param attRecordParam 封装考勤条件(考勤日期,考勤时间段,考勤部门id)
	 * @return
	 */
	List<AttendanceRecord> listAttRecord(AttRecordParam attRecordParam);
	
	/**
	 * 保存考勤记录
	 * @param attRecordList 考勤记录列表
	 * @return
	 */
	int saveRecord(List<AttendanceRecord> attRecordList);
	
}
