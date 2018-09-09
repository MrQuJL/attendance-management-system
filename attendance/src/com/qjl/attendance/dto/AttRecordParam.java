package com.qjl.attendance.dto;

import java.util.Date;

/**
 * 类描述：封装对考勤记录的查询条件
 * 全限定性类名: com.qjl.attendance.dto.AttRecordParam
 * @author 曲健磊
 * @date 2018年9月3日下午7:28:16
 * @version V1.0
 */
public class AttRecordParam {

	private Date attDate; // 考勤日期
	
	private Integer attFlag; // 考勤时间段:上午-1,下午-2
	
	private Long deptId; // 考勤的部门

	public Date getAttDate() {
		return attDate;
	}

	public void setAttDate(Date attDate) {
		this.attDate = attDate;
	}

	public Integer getAttFlag() {
		return attFlag;
	}

	public void setAttFlag(Integer attFlag) {
		this.attFlag = attFlag;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	
}
