package com.qjl.attendance.mapper;

import java.util.List;

import com.qjl.attendance.dto.TreeDto;
import com.qjl.attendance.entity.Department;

/**
 * 类描述：department
 * 全限定性类名: com.qjl.attendance.mapper.DepartmentMapper
 * @author 曲健磊
 * @date 2018年8月27日下午4:20:37
 * @version V1.0
 */
public interface DepartmentMapper {
	
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
	 * 统计父部门id为parentid的部门数量
	 * @param parentid
	 * @return
	 */
	int countParentDept(Long parentid);
	
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
