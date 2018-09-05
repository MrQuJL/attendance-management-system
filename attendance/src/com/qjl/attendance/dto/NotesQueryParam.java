package com.qjl.attendance.dto;

import java.util.Date;

/**
 * 类描述：封装对单据的请求参数
 * 全限定性类名: com.qjl.attendance.dto.NotesQueryParam
 * @author 曲健磊
 * @date 2018年9月1日下午3:51:50
 * @version V1.0
 */
public class NotesQueryParam {

	private Long noteTypeId; // 请假类型ID
	
	private Long deptId; // 部门ID
	
	private Date applyDate; // 申请日期
	
	private String empName; // 员工姓名

	public Long getNoteTypeId() {
		return noteTypeId;
	}

	public void setNoteTypeId(Long noteTypeId) {
		this.noteTypeId = noteTypeId;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
}
