package com.qjl.attendance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qjl.attendance.dto.EmployeeDto;
import com.qjl.attendance.entity.Employee;
import com.qjl.attendance.mapper.EmployeeMapper;
import com.qjl.attendance.service.IEmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Override
	public Employee getEmployeeById(Long employeeid) {
		return employeeMapper.getEmployeeById(employeeid);
	}
	
	@Override
	public List<Employee> listEmployee(Employee employee) {
		return employeeMapper.listEmployee(employee);
	}

	@Override
	public List<EmployeeDto> listEmployeeDto(Employee employee) {
		return employeeMapper.listEmployeeDto(employee);
	}

	@Override
	public int updateEmployee(Employee employee) {
		return employeeMapper.updateEmployee(employee);
	}
	
	@Override
	public int insertEmployee(Employee employee) {
		return employeeMapper.insertEmployee(employee);
	}

	@Override
	public int deleteEmployee(Integer employeeId) {
		return employeeMapper.deleteEmployee(employeeId);
	}

}
