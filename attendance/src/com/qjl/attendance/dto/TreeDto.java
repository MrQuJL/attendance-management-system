package com.qjl.attendance.dto;

/**
 * 类描述：树节点
 * 全限定性类名: com.qjl.attendance.dto.TreeDto
 * @author 曲健磊
 * @date 2018年8月31日下午9:28:40
 * @version V1.0
 */
public class TreeDto {

	private Integer id;
	
	private Integer pId;
	
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
