package com.qjl.attendance.dto;

import com.qjl.attendance.entity.Employee;

/**
 * 类描述：包含职位名称和部门名称和性别(中文)和状态(中文)
 * 全限定性类名: com.qjl.attendance.dto.EmployeeDto
 * @author 曲健磊
 * @date 2018年8月28日下午3:14:16
 * @version V1.0
 */
public class EmployeeDto extends Employee {

	private String chgender;
	
	private String positionname;
	
	private String departmentname;

	private String chstate;

	public String getChgender() {
		return chgender;
	}

	public void setChgender(String chgender) {
		this.chgender = chgender;
	}

	public String getPositionname() {
		return positionname;
	}

	public void setPositionname(String positionname) {
		this.positionname = positionname;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public String getChstate() {
		return chstate;
	}

	public void setChstate(String chstate) {
		this.chstate = chstate;
	}
	
}
