package com.qjl.attendance.mapper;

import java.util.List;

import com.qjl.attendance.dto.AttRecordParam;
import com.qjl.attendance.entity.AttendanceRecord;

/**
 * 类描述：访问考勤记录数据
 * 全限定性类名: com.qjl.attendance.mapper.AttendanceRecordMapper
 * @author 曲健磊
 * @date 2018年9月5日上午9:48:19
 * @version V1.0
 */
public interface AttendanceRecordMapper {
	
	/**
	 * 查询满足条件的考勤记录
	 * @param attRecordParam 封装考勤条件(考勤日期,考勤时间段,考勤部门id)
	 * @return
	 */
	List<AttendanceRecord> listAttRecord(AttRecordParam attRecordParam);
	
	/**
	 * 添加一条考勤记录
	 * @param attRecord 考勤记录
	 * @return
	 */
	int insertAttRecord(AttendanceRecord attRecord);
	
	/**
	 * 统计满足条件的考勤记录数目
	 * @param attRecord 封装查询条件(员工id,考勤日期,考勤时间段)
	 * @return
	 */
	int countAttRecord(AttendanceRecord attRecord);
	
	/**
	 * 删除满足条件的考勤记录
	 * @param attRecord 封装查询条件(员工id,考勤日期,考勤时间段)
	 * @return
	 */
	int deleteAttRecord(AttendanceRecord attRecord);
	
}
