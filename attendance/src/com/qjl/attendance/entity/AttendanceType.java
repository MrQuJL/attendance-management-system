package com.qjl.attendance.entity;

public class AttendanceType {
	
    private Long typeid;

    private String typename;

    private Short typecategory;

    public Long getTypeid() {
        return typeid;
    }

    public void setTypeid(Long typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public Short getTypecategory() {
        return typecategory;
    }

    public void setTypecategory(Short typecategory) {
        this.typecategory = typecategory;
    }
}