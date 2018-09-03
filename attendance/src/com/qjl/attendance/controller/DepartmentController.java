package com.qjl.attendance.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qjl.attendance.entity.Department;
import com.qjl.attendance.service.IDepartmentService;

/**
 * 类描述：
 * 全限定性类名: com.qjl.attendance.controller.DeptController
 * @author 曲健磊
 * @date 2018年8月27日上午10:56:43
 * @version V1.0
 */
@Controller
public class DepartmentController {
	
	@Autowired
	private IDepartmentService departmentService;
	
	/**
	 * 前往某个部门的二级部门列表
	 * @param dept1Id
	 * @return
	 */
	@RequestMapping("/gotoDeptList2")
	public String gotoDeptList2(HttpServletRequest request, Integer dept1Id) {
		
		request.setAttribute("parentId", dept1Id);
		
		return "dept/dept2List";
	}
	
	/**
	 * 查询所有的一级部门
	 * @param dept1Id
	 * @return
	 */
	@RequestMapping("/listDept1")
	public @ResponseBody Map<String, Object> listDept1() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Department department = new Department();
		department.setParentid(0L);
		List<Department> deptList = departmentService.listDepartment(department);
		
		resultMap.put("Rows", deptList);
		resultMap.put("Total", deptList.size());
		
		return resultMap;
	}
	
	/**
	 * 查询所有的二级部门
	 * @param dept1Id
	 * @return
	 */
	@RequestMapping("/listDept2")
	public @ResponseBody Map<String, Object> listDept2(Long dept1Id) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// 查询所有的二级部门
		Department department = new Department();
		department.setParentid(dept1Id);
		List<Department> departmentList = new ArrayList<Department>();
		if (dept1Id != null) {
			departmentList = departmentService.listDepartment(department);
		}
		
		resultMap.put("list", departmentList);
		
		return resultMap;
	}
	
	/**
	 * 查询二级部门列表的详细信息
	 * @param dept1Id
	 * @return
	 */
	@RequestMapping("/getDept2List")
	public @ResponseBody Map<String, Object> getDept2List(Long dept1Id) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// 查询所有的二级部门
		Department department = new Department();
		department.setParentid(dept1Id);
		List<Department> departmentList = new ArrayList<Department>();
		if (dept1Id != null) {
			departmentList = departmentService.listDepartment(department);
		}
		
		resultMap.put("Rows", departmentList);
		resultMap.put("Total", departmentList.size());
		
		return resultMap;
	}
	
	/**
	 * 添加一级部门
	 * @param dept1Id
	 * @return
	 */
	@RequestMapping("/insertDept1")
	public @ResponseBody Map<String, Object> insertDept1(Department department) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		department.setParentid(0L);
		int rows = departmentService.insertDepartment(department);
		resultMap.put("flag", rows);
		
		return resultMap;
	}
	
	/**
	 * 添加二级部门
	 * @param dept1Id
	 * @return
	 */
	@RequestMapping("/insertDept2")
	public @ResponseBody Map<String, Object> insertDept2(Department department) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int rows = departmentService.insertDepartment(department);
		resultMap.put("flag", rows);
		
		return resultMap;
	}
	
	/**
	 * 删除一级部门
	 * @param dept1Id
	 * @return
	 */
	@RequestMapping("/deleteDept1")
	public @ResponseBody Map<String, Object> deleteDept1(Long departmentid) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int rows = departmentService.deleteDepartment(departmentid);
		resultMap.put("flag", rows);
		
		return resultMap;
	}

	/**
	 * 修改部门
	 * @param dept1Id
	 * @return
	 */
	@RequestMapping("/updateDepartment")
	public @ResponseBody Map<String, Object> updateDepartment(Department department) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int rows = departmentService.updateDepartment(department);
		resultMap.put("flag", rows);
		
		return resultMap;
	}
}
