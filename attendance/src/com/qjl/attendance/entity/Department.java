package com.qjl.attendance.entity;

public class Department {

    private Long departmentid;

    private String departmentname;

    private String starttimeam;

    private String endtimeam;

    private String starttimepm;

    private String endtimepm;

    private Long parentid;

	public Long getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(Long departmentid) {
		this.departmentid = departmentid;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public String getStarttimeam() {
		return starttimeam;
	}

	public void setStarttimeam(String starttimeam) {
		this.starttimeam = starttimeam;
	}

	public String getEndtimeam() {
		return endtimeam;
	}

	public void setEndtimeam(String endtimeam) {
		this.endtimeam = endtimeam;
	}

	public String getStarttimepm() {
		return starttimepm;
	}

	public void setStarttimepm(String starttimepm) {
		this.starttimepm = starttimepm;
	}

	public String getEndtimepm() {
		return endtimepm;
	}

	public void setEndtimepm(String endtimepm) {
		this.endtimepm = endtimepm;
	}

	public Long getParentid() {
		return parentid;
	}

	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}

	@Override
	public String toString() {
		return "Department [departmentid=" + departmentid + ", departmentname=" + departmentname + ", starttimeam="
				+ starttimeam + ", endtimeam=" + endtimeam + ", starttimepm=" + starttimepm + ", endtimepm=" + endtimepm
				+ ", parentid=" + parentid + "]";
	}
	
}