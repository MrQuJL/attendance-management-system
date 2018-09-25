package com.qjl.attendance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qjl.attendance.dto.TreeDto;
import com.qjl.attendance.entity.Department;
import com.qjl.attendance.mapper.DepartmentMapper;
import com.qjl.attendance.mapper.EmployeeMapper;
import com.qjl.attendance.service.IDepartmentService;

/**
 * 类描述：IDepartmentService的实现类
 * 全限定性类名: com.qjl.attendance.service.impl.DepartmentServiceImpl
 * @author 曲健磊
 * @date 2018年8月28日下午3:49:06
 * @version V1.0
 */
@Service
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Override
	public Department getDeptById(Long id) {
		return departmentMapper.getDeptById(id);
	}
	
	@Override
	public List<Department> listDepartment(Department department) {
		return departmentMapper.listDepartment(department);
	}

	@Override
	public List<TreeDto> listDeptTree() {
		return departmentMapper.listDeptTree();
	}
	
	@Override
	public int insertDepartment(Department department) {
		return departmentMapper.insertDepartment(department);
	}

	@Override
	public int updateDepartment(Department department) {
		return departmentMapper.updateDepartment(department);
	}

	/**
	 * 0 -> 有子部门
	 * -1 -> 有员工
	 * 大于0 -> 正常删除
	 */
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
	public int deleteDepartment(Long id) {
		// 1.删除前先判断该部门是否有子部门
		int childs = departmentMapper.countParentDept(id);
		
		if (childs != 0) { // 有子部门
			return 0;
		}
		// 2.判断该部门下是否有员工
		int empNum = employeeMapper.countEmployeeByDeptId(id);
		if (empNum != 0) {
			return -1;
		}
		
		return departmentMapper.deleteDepartment(id);
	}

}
