package com.qjl.attendance.service;

import java.util.List;

import com.qjl.attendance.dto.TreeDto;
import com.qjl.attendance.entity.Department;

/**
 * 类描述：部门信息服务层接口
 * 全限定性类名: com.qjl.attendance.service.IDepartmentService
 * @author 曲健磊
 * @date 2018年8月28日下午3:48:17
 * @version V1.0
 */
public interface IDepartmentService {

	/**
	 * 根据id获取部门信息
	 * @param id
	 * @return
	 */
	Department getDeptById(Long id);
	
	/**
	 * 查询满足条件的部门信息
	 * @return
	 */
	List<Department> listDepartment(Department department);
	
	/**
	 * 以树形结构来存储查询出的部门列表
	 * @return
	 */
	List<TreeDto> listDeptTree();
	
	/**
	 * 添加部门
	 * @param department
	 * @return
	 */
	int insertDepartment(Department department);
	
	/**
	 * 修改部门
	 * @param department
	 * @return
	 */
	int updateDepartment(Department department);
	
	/**
	 * 删除部门
	 * @param id
	 * @return
	 */
	int deleteDepartment(Long id);
}
