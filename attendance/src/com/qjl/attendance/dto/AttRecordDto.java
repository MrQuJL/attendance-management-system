package com.qjl.attendance.dto;

import com.qjl.attendance.entity.AttendanceRecord;

/**
 * 类描述:封装从数据库中查询出的每一条考勤记录
 * 全限定性类名: com.qjl.attendance.dto.AttRecordDto
 * @author 曲健磊
 * @date 2018年9月3日下午7:36:57
 * @version V1.0
 */
public class AttRecordDto extends AttendanceRecord {

	private String employeename;

	private String cardnumber;
	
	private String noteStr;

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getNoteStr() {
		return noteStr;
	}

	public void setNoteStr(String noteStr) {
		this.noteStr = noteStr;
	}

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	
}
