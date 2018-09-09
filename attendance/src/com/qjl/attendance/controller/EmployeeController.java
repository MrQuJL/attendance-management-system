package com.qjl.attendance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qjl.attendance.dto.EmployeeDto;
import com.qjl.attendance.entity.Department;
import com.qjl.attendance.entity.Employee;
import com.qjl.attendance.entity.Position;
import com.qjl.attendance.service.IDepartmentService;
import com.qjl.attendance.service.IEmployeeService;
import com.qjl.attendance.service.IPositionService;

/**
 * 类描述：负责处理对员工的请求
 * 全限定性类名: com.qjl.attendance.controller.EmployeeController
 * @author 曲健磊
 * @date 2018年8月28日下午3:06:47
 * @version V1.0
 */
@Controller
public class EmployeeController {
	
	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	private IPositionService positionService;
	
	@Autowired
	private IDepartmentService departmentService;
	
	/**
	 * 处理前查询employee列表的请求
	 * @return json格式的emplist字符串
	 */
	@RequestMapping("/listEmployeeDto")
	public @ResponseBody Map<String, Object> listEmployeeDto(Employee employee) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<EmployeeDto> employeeList = employeeService.listEmployeeDto(employee);
		resultMap.put("Rows", employeeList);
		resultMap.put("Total", employeeList.size());
		return resultMap;
	}
	
	/**
	 * 前往员工新增/修改页面
	 * @param employee
	 * @param request
	 * @return
	 */
	@RequestMapping("/gotoEmpEdit")
	public String gotoEmpEdit(Employee employee, HttpServletRequest request, HttpSession session) {
		// 1.查询出所有的职位列表以及部门列表
		List<Position> positionList = positionService.listPosition();
		List<Department> departmentList = departmentService.listDepartment(null);
		
		request.setAttribute("positionList", positionList);
		request.setAttribute("departmentList", departmentList);
		
		if (employee.getEmployeeid() != null) {
			request.setAttribute("flag", 1);
			Employee emp = employeeService.getEmployeeById(employee.getEmployeeid());
//			request.setAttribute("employee", emp);
			request.setAttribute("employeeid", emp.getEmployeeid());
			request.setAttribute("employeename", emp.getEmployeename());
			request.setAttribute("employeegender", emp.getEmployeegender());
			request.setAttribute("positionid", emp.getPositionid());
			request.setAttribute("departmentid", emp.getDepartmentid());
			request.setAttribute("cardnumber", emp.getCardnumber());
			request.setAttribute("employestate", emp.getEmployestate());
			request.setAttribute("employeememo", emp.getEmployeememo());
		}
		
		return "emp/empEdit";
	}
	
	/**
	 * 添加
	 * @param employee
	 * @return
	 */
	@RequestMapping("/insertEmployee")
	public @ResponseBody Map<String, Object> insertEmployee(Employee employee) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int rows = employeeService.insertEmployee(employee);
		
		resultMap.put("flag", rows);
		
		return resultMap;
	}
	
	/**
	 * 修改
	 * @param employee
	 * @return
	 */
	@RequestMapping("/updateEmployee")
	public @ResponseBody Map<String, Object> updateEmployee(Employee employee) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int rows = employeeService.updateEmployee(employee);
		
		resultMap.put("flag", rows);
		
		return resultMap;
	}
	
	/**
	 * 删除
	 * @param employeeid
	 * @return
	 */
	@RequestMapping("/deleteEmployee")
	public @ResponseBody Map<String, Object> deleteEmployee(Integer employeeid) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int rows = employeeService.deleteEmployee(employeeid);
		
		resultMap.put("flag", rows);
		
		return resultMap;
	}
	
}
