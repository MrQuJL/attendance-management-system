package com.qjl.attendance.entity;

public class Employee {
    private Long employeeid;

    private String employeename;

    private Short employeegender;

    private Long positionid;

    private Long departmentid;

    private String cardnumber;

    private Short employestate;

    private String employeememo;

	public Long getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Long employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public Short getEmployeegender() {
		return employeegender;
	}

	public void setEmployeegender(Short employeegender) {
		this.employeegender = employeegender;
	}

	public Long getPositionid() {
		return positionid;
	}

	public void setPositionid(Long positionid) {
		this.positionid = positionid;
	}

	public Long getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(Long departmentid) {
		this.departmentid = departmentid;
	}

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public Short getEmployestate() {
		return employestate;
	}

	public void setEmployestate(Short employestate) {
		this.employestate = employestate;
	}

	public String getEmployeememo() {
		return employeememo;
	}

	public void setEmployeememo(String employeememo) {
		this.employeememo = employeememo;
	}

}