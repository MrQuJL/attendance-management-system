package com.qjl.attendance.dto;

import java.util.Date;

/**
 * 类描述：封装了对今日考勤页面的查询条件
 * 全限定性类名: com.qjl.attendance.dto.TodayAttendanceParam
 * @author 曲健磊
 * @date 2018年9月6日下午9:04:11
 * @version V1.0
 */
public class TodayAttendanceParam {

	private Integer deptId; // 部门id
	
	private Date curDate; // 要考勤的日期
	
	private Integer attFlag; // 出勤时段 1-上午 1-下午
	
	private Integer attStatus; // 考勤状态 1-正常 2-非正常 3-未知

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	
	public Date getCurDate() {
		return curDate;
	}

	public void setCurDate(Date curDate) {
		this.curDate = curDate;
	}

	public Integer getAttFlag() {
		return attFlag;
	}

	public void setAttFlag(Integer attFlag) {
		this.attFlag = attFlag;
	}

	public Integer getAttStatus() {
		return attStatus;
	}

	public void setAttStatus(Integer attStatus) {
		this.attStatus = attStatus;
	}
	
}
