package com.qjl.attendance.dto;

/**
 * 类描述：每个部门的考勤情况
 * 全限定性类名: com.qjl.attendance.dto.DeptAttendance
 * @author 曲健磊
 * @date 2018年9月7日上午10:05:54
 * @version V1.0
 */
public class DeptAttendance {
	
	private String deptName;
	
	private String attendanceResult;

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getAttendanceResult() {
		return attendanceResult;
	}

	public void setAttendanceResult(String attendanceResult) {
		this.attendanceResult = attendanceResult;
	}
	
}
