package com.qjl.attendance.dto;

import com.qjl.attendance.entity.Notes;

/**
 * 类描述：单据（申请人姓名，请假类型名称，代理人姓名）
 * 全限定性类名: com.qjl.attendance.dto.NotesDto
 * @author 曲健磊
 * @date 2018年9月1日下午3:49:12
 * @version V1.0
 */
public class NotesDto extends Notes {
	
	private String employeename;
	
	private String notetypename;
	
	private String proxyname;

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getNotetypename() {
		return notetypename;
	}

	public void setNotetypename(String notetypename) {
		this.notetypename = notetypename;
	}

	public String getProxyname() {
		return proxyname;
	}

	public void setProxyname(String proxyname) {
		this.proxyname = proxyname;
	}
	
}
