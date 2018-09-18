package com.qjl.attendance.dto;

/**
 * 类描述：
 * 全限定性类名: com.qjl.attendance.dto.TodayAttendance
 * @author 曲健磊
 * @date 2018年9月6日下午8:46:05
 * @version V1.0
 */
public class TodayAttendance {
	
	private String employeeName;
	
	private String departmentName;
	
	private String attendanceDate;
	
	private String week;
	
	private String attStatus;

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getAttendanceDate() {
		return attendanceDate;
	}

	public void setAttendanceDate(String attendanceDate) {
		this.attendanceDate = attendanceDate;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getAttStatus() {
		return attStatus;
	}

	public void setAttStatus(String attStatus) {
		this.attStatus = attStatus;
	}
	
}
