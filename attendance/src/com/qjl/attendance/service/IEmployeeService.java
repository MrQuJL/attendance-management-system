package com.qjl.attendance.service;

import java.util.List;

import com.qjl.attendance.dto.EmployeeDto;
import com.qjl.attendance.entity.Employee;

/**
 * 类描述：员工信息服务层接口
 * 全限定性类名: com.qjl.attendance.service.IEmployeeService
 * @author 曲健磊
 * @date 2018年8月28日下午2:59:18
 * @version V1.0
 */
public interface IEmployeeService {

	/**
	 * 根据id查询员工信息
	 * @param id
	 * @return
	 */
	Employee getEmployeeById(Long employeeid);
	
	/**
	 * 查询所有的员工信息
	 * @return
	 */
	List<Employee> listEmployee(Employee employee);
	
	/**
	 * 查询所有的员工信息(包含职位名称和部门名称)
	 * @return
	 */
	List<EmployeeDto> listEmployeeDto(Employee employee);
	
	/**
	 * 添加员工
	 * @param employee
	 * @return
	 */
	int insertEmployee(Employee employee);
	
	/**
	 * 修改员工
	 * @param employee
	 * @return
	 */
	int updateEmployee(Employee employee);
	
	/**
	 * 删除员工
	 * @param employeeId
	 * @return
	 */
	int deleteEmployee(Integer employeeId);
	
}
