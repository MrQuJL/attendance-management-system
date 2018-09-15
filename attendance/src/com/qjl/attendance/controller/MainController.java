package com.qjl.attendance.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qjl.attendance.entity.Admin;
import com.qjl.attendance.entity.Department;
import com.qjl.attendance.service.IAdminService;
import com.qjl.attendance.service.IDepartmentService;

/**
 * 类描述：用于处理前往主页面以及一些公共页面的请求
 * 全限定性类名: com.qjl.attendence.controller.MainController
 * @author 曲健磊
 * @date 2018年8月24日下午6:13:19
 * @version V1.0
 */
@Controller
public class MainController {
	
	@Autowired
	private IDepartmentService departmentService;
	
	@Autowired
	private IAdminService adminService;
	
	/**
	 * 前往登录页面
	 * @return
	 */
	@RequestMapping("/gotoLogin")
	public String gotoLogin() {
		return "login";
	}
	
	/**
	 * 处理前往系统首页的请求
	 * @return 系统首页的视图名
	 */
	@RequestMapping("/gotoMain")
	public String gotoMain() {
		return "main/main";
	}
	
	/**
	 * 处理前往欢迎页面的请求
	 * @return 欢迎页面的视图名
	 */
	@RequestMapping("/gotoWelcome")
	public String gotoWelcome() {
		return "main/welcome";
	}
	
	/**
	 * 处理前往部门页面的请求
	 * @return job页面的视图名
	 */
	@RequestMapping("/gotoDeptMgr")
	public String gotoDeptMgr() {
		return "dept/dept1List";
	}
	
	/**
	 * 处理前往部门页面的请求
	 * @return job页面的视图名
	 */
	@RequestMapping("/gotoDeptEdit")
	public String gotoDeptEdit(Long id, HttpServletRequest request) {
		// 根据id查询部门信息
		
		Department department = departmentService.getDeptById(id);
		request.setAttribute("departmentid", department.getDepartmentid());
		request.setAttribute("departmentname", department.getDepartmentname());
		request.setAttribute("starttimeam", department.getStarttimeam());
		request.setAttribute("endtimeam", department.getEndtimeam());
		request.setAttribute("starttimepm", department.getStarttimepm());
		request.setAttribute("endtimepm", department.getEndtimepm());
		request.setAttribute("parentid", department.getParentid());
		
		return "dept/deptEdit";
	}
	
	/**
	 * 处理前往职位页面的请求
	 * @return job页面的视图名
	 */
	@RequestMapping("/gotoPositionMgr")
	public String gotoPositionMgr() {
		return "position/positionList";
	}
	
	/**
	 * 处理前往employee页面的请求
	 * @return emp页面的视图名
	 */
	@RequestMapping("/gotoEmpMgr")
	public String gotoEmpMgr(HttpServletRequest request) {
		// 查询所有的一级部门
		Department department = new Department();
		department.setParentid(0L);
		
		List<Department> departmentList = departmentService.listDepartment(department);
		request.setAttribute("dept1List", departmentList);
		
		return "emp/empList";
	}
	
	/**
	 * 处理前往用户页面的请求
	 * @return emp页面的视图名
	 */
	@RequestMapping("/gotoUserMgr")
	public String gotoUserMgr() {
		return "user/userList";
	}
	
	/**
	 * 处理前往权限页面的请求
	 * @return emp页面的视图名
	 */
	@RequestMapping("/gotoPermMgr")
	public String gotoPermMgr(HttpSession session) {
		// 查询出所有的考勤员列表
		List<Admin> workList = adminService.listAdminWork();
		session.setAttribute("workerList", workList);
		return "perm/perm";
	}
	
	/**
	 * 处理前往修改密码页面的请求
	 * @return emp页面的视图名
	 */
	@RequestMapping("/gotoPwdMgr")
	public String updatePwd() {
		return "main/updatePwd";
	}
	
}
