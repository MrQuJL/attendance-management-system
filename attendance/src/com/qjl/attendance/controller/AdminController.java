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

import com.qjl.attendance.dto.AdminDto;
import com.qjl.attendance.entity.Admin;
import com.qjl.attendance.entity.Employee;
import com.qjl.attendance.service.IAdminService;

/**
 * 类描述：负责处理用户的相关请求
 * 全限定性类名: com.qjl.attendance.controller.AdminController
 * @author 曲健磊
 * @date 2018年8月30日上午9:22:32
 * @version V1.0
 */
@Controller
public class AdminController {
	
	@Autowired
	private IAdminService adminService;
	
	/**
	 * 处理前查询employee列表的请求
	 * @return json格式的emplist字符串
	 */
	@RequestMapping("/listAdminDto")
	public @ResponseBody Map<String, Object> listAdminDto(Employee employee) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<AdminDto> adminList = adminService.listAllAdmin();
		resultMap.put("Rows", adminList);
		resultMap.put("Total", adminList.size());
		
		return resultMap;
	}
	
	/**
	 * 前往员工新增/修改页面
	 * @param employee
	 * @param request
	 * @return
	 */
	@RequestMapping("/gotoAdminEdit")
	public String gotoAdminEdit(Admin admin, HttpServletRequest request, HttpSession session) {
		
		Admin admin1 = adminService.getAdminById(admin.getAdminid());
		
		request.setAttribute("adminid", admin1.getAdminid());
		request.setAttribute("adminaccount", admin1.getAdminaccount());
		request.setAttribute("adminright", admin1.getAdminright());
		
		return "user/userEdit";
	}
	
	/**
	 * 添加用户
	 * @param employee
	 * @return
	 */
	@RequestMapping("/insertAdmin")
	public @ResponseBody Map<String, Object> insertAdmin(Admin admin) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int rows = adminService.insertAdmin(admin);
		
		resultMap.put("flag", rows);
		
		return resultMap;
	}
	
	/**
	 * 修改
	 * @param employee
	 * @return
	 */
	@RequestMapping("/updateAdmin")
	public @ResponseBody Map<String, Object> updateAdmin(Admin admin) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int rows = adminService.updateAdmin(admin);
		
		resultMap.put("flag", rows);
		
		return resultMap;
	}
	
	/**
	 * 删除
	 * @param adminid
	 * @return
	 */
	@RequestMapping("/deleteAdmin")
	public @ResponseBody Map<String, Object> deleteAdmin(Long adminid) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int rows = adminService.deleteAdmin(adminid);
		
		resultMap.put("flag", rows);
		
		return resultMap;
	}
	
	/**
	 * 修改密码
	 * @param adminid
	 * @return
	 */
	@RequestMapping("/updatePwd")
	public @ResponseBody Map<String, Object> updatePwd(Admin admin, HttpSession session) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		boolean flag = adminService.updatePwd(admin);
		
		if (flag) {
			resultMap.put("flag", 1); // 修改成功
			// 刷新session中的用户信息
			Admin sAdmin = (Admin) session.getAttribute("admin");
			sAdmin.setAdminpwd(admin.getAdminpwd());
			session.setAttribute("admin", sAdmin);
		} else {
			resultMap.put("flag", 0);
		}
		
		return resultMap;
	}
	
}
