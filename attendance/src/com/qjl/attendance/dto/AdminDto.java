package com.qjl.attendance.dto;

/**
 * 类描述：将用户的角色和状态用中文表示
 * 全限定性类名: com.qjl.attendance.dto.AdminDto
 * @author 曲健磊
 * @date 2018年8月30日上午8:59:20
 * @version V1.0
 */
public class AdminDto {

	private Long adminid;

    private String adminaccount;

    private String adiminpwd;

    private String adminstate; // 是否被冻结

    private String adminright; // 是否是超级管理员

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
		this.adminaccount = adminaccount;
	}

	public String getAdiminpwd() {
		return adiminpwd;
	}

	public void setAdiminpwd(String adiminpwd) {
		this.adiminpwd = adiminpwd;
	}

	public String getAdminstate() {
		return adminstate;
	}

	public void setAdminstate(String adminstate) {
		this.adminstate = adminstate;
	}

	public String getAdminright() {
		return adminright;
	}

	public void setAdminright(String adminright) {
		this.adminright = adminright;
	}
    
}
