package com.qjl.attendance.entity;

import java.util.Date;

public class AttendanceRecord {

    private Long attendanceid;

    private Long employeeid;

    private Date attendancedate;

    private Short attendanceflag;

    private Short attendancetypeid;

    private String attendancememo;

    private Long adminid;

    private Long noteid;

    public Long getAttendanceid() {
        return attendanceid;
    }

    public void setAttendanceid(Long attendanceid) {
        this.attendanceid = attendanceid;
    }

    public Long getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Long employeeid) {
		this.employeeid = employeeid;
	}

	public Date getAttendancedate() {
        return attendancedate;
    }

    public void setAttendancedate(Date attendancedate) {
        this.attendancedate = attendancedate;
    }

    public Short getAttendanceflag() {
        return attendanceflag;
    }

    public void setAttendanceflag(Short attendanceflag) {
        this.attendanceflag = attendanceflag;
    }

    public Short getAttendancetypeid() {
        return attendancetypeid;
    }

    public void setAttendancetypeid(Short attendancetypeid) {
        this.attendancetypeid = attendancetypeid;
    }

    public String getAttendancememo() {
        return attendancememo;
    }

    public void setAttendancememo(String attendancememo) {
        this.attendancememo = attendancememo == null ? null : attendancememo.trim();
    }

    public Long getAdminid() {
        return adminid;
    }

    public void setAdminid(Long adminid) {
        this.adminid = adminid;
    }

    public Long getNoteid() {
        return noteid;
    }

    public void setNoteid(Long noteid) {
        this.noteid = noteid;
    }

	@Override
	public String toString() {
		return "AttendanceRecord [attendanceid=" + attendanceid + ", employeeid=" + employeeid + ", attendancedate="
				+ attendancedate + ", attendanceflag=" + attendanceflag + ", attendancetypeid=" + attendancetypeid
				+ ", attendancememo=" + attendancememo + ", adminid=" + adminid + ", noteid=" + noteid + "]";
	}
    
}