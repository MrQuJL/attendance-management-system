package com.qjl.attendance.entity;

public class Admin {
    private Long adminid;

    private String adminaccount;

    private String adminpwd;

    private Short adminstate;

    private Short adminright;

    public Long getAdminid() {
        return adminid;
    }

    public void setAdminid(Long adminid) {
        this.adminid = adminid;
    }

    public String getAdminaccount() {
        return adminaccount;
    }

    public void setAdminaccount(String adminaccount) {
        this.adminaccount = adminaccount == null ? null : adminaccount.trim();
    }

    public String getAdminpwd() {
		return adminpwd;
	}

	public void setAdminpwd(String adminpwd) {
		this.adminpwd = adminpwd;
	}

	public Short getAdminstate() {
        return adminstate;
    }

    public void setAdminstate(Short adminstate) {
        this.adminstate = adminstate;
    }

    public Short getAdminright() {
        return adminright;
    }

    public void setAdminright(Short adminright) {
        this.adminright = adminright;
    }
}