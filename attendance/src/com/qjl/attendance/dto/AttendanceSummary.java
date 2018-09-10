package com.qjl.attendance.dto;

/**
 * 类描述：存储考勤汇总的相关数据
 * 全限定性类名: com.qjl.attendance.dto.AttendanceSummary
 * @author 曲健磊
 * @date 2018年9月9日下午8:02:04
 * @version V1.0
 */
public class AttendanceSummary {
	
	private Long employeeid; // 员工id
	
	private String departmentname; // 部门名称
	
	private String employeename; // 员工名称
	
	private Integer chidao; // 迟到
	
	private Integer bingjia; // 病假
	
	private Integer shijia; // 事假
	
	private Integer chanjia; // 产假
	
	private Integer sangjia; // 丧假
	
	private Integer hunjia; // 婚假
	
	private Integer gongxiu; // 公休
	
	private Integer chuchai; // 出差
	
	private Integer kuanggong; // 旷工
	
	private Integer chuqin; // 出勤

	public Long getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Long employeeid) {
		this.employeeid = employeeid;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public Integer getChidao() {
		return chidao;
	}

	public void setChidao(Integer chidao) {
		this.chidao = chidao;
	}

	public Integer getBingjia() {
		return bingjia;
	}

	public void setBingjia(Integer bingjia) {
		this.bingjia = bingjia;
	}

	public Integer getShijia() {
		return shijia;
	}

	public void setShijia(Integer shijia) {
		this.shijia = shijia;
	}

	public Integer getChanjia() {
		return chanjia;
	}

	public void setChanjia(Integer chanjia) {
		this.chanjia = chanjia;
	}

	public Integer getSangjia() {
		return sangjia;
	}

	public void setSangjia(Integer sangjia) {
		this.sangjia = sangjia;
	}

	public Integer getHunjia() {
		return hunjia;
	}

	public void setHunjia(Integer hunjia) {
		this.hunjia = hunjia;
	}

	public Integer getGongxiu() {
		return gongxiu;
	}

	public void setGongxiu(Integer gongxiu) {
		this.gongxiu = gongxiu;
	}

	public Integer getChuchai() {
		return chuchai;
	}

	public void setChuchai(Integer chuchai) {
		this.chuchai = chuchai;
	}

	public Integer getKuanggong() {
		return kuanggong;
	}

	public void setKuanggong(Integer kuanggong) {
		this.kuanggong = kuanggong;
	}

	public Integer getChuqin() {
		return chuqin;
	}

	public void setChuqin(Integer chuqin) {
		this.chuqin = chuqin;
	}
	
}
