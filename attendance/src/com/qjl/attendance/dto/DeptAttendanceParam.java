package com.qjl.attendance.dto;

import java.util.Date;

/**
 * 类描述：封装了考勤公告的查询条件
 * 全限定性类名: com.qjl.attendance.dto.DeptAttendanceParam
 * @author 曲健磊
 * @date 2018年9月7日上午10:14:45
 * @version V1.0
 */
public class DeptAttendanceParam {

	private Date attDate; // 考勤时间
	
	private Integer attFlag; // 考勤时段 1-上午 2-下午

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
	
}
