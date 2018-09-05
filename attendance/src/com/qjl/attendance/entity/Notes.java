package com.qjl.attendance.entity;

import java.util.Date;

public class Notes {
	
    private Long noteid;

    private Long employeeid;

    private Long notetypeid;

    private String cause;

    private Date fillintime;

    private String directorsign;

    private String administrationsign;

    private String presidentsign;

    private Date startdate;

    private String starttime;

    private Date enddate;

    private String endtime;

    private Long proxyid;

    private String projectname;
    
    private String notememo;

    private Long operatorid;

    public Long getNoteid() {
        return noteid;
    }

    public void setNoteid(Long noteid) {
        this.noteid = noteid;
    }

    public Long getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Long employeeid) {
        this.employeeid = employeeid;
    }

    public Long getNotetypeid() {
        return notetypeid;
    }

    public void setNotetypeid(Long notetypeid) {
        this.notetypeid = notetypeid;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause == null ? null : cause.trim();
    }

    public Date getFillintime() {
        return fillintime;
    }

    public void setFillintime(Date fillintime) {
        this.fillintime = fillintime;
    }

    public String getDirectorsign() {
        return directorsign;
    }

    public void setDirectorsign(String directorsign) {
        this.directorsign = directorsign == null ? null : directorsign.trim();
    }

    public String getAdministrationsign() {
        return administrationsign;
    }

    public void setAdministrationsign(String administrationsign) {
        this.administrationsign = administrationsign == null ? null : administrationsign.trim();
    }

    public String getPresidentsign() {
        return presidentsign;
    }

    public void setPresidentsign(String presidentsign) {
        this.presidentsign = presidentsign == null ? null : presidentsign.trim();
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

    public Long getProxyid() {
		return proxyid;
	}

	public void setProxyid(Long proxyid) {
		this.proxyid = proxyid;
	}
	
	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getNotememo() {
        return notememo;
    }

    public void setNotememo(String notememo) {
        this.notememo = notememo == null ? null : notememo.trim();
    }

    public Long getOperatorid() {
        return operatorid;
    }

    public void setOperatorid(Long operatorid) {
        this.operatorid = operatorid;
    }
    
}