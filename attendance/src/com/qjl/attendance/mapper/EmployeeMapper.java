package com.qjl.attendance.mapper;

import java.util.List;

import com.qjl.attendance.dto.EmployeeDto;
import com.qjl.attendance.entity.Employee;

/**
 * 类描述：用于访问ATT_EMPLOYEE表的数据
 * 全限定性类名: com.qjl.attendance.mapper.EmployeeMapper
 * @author 曲健磊
 * @date 2018年8月28日下午2:54:53
 * @version V1.0
 */
public interface EmployeeMapper {
	
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
