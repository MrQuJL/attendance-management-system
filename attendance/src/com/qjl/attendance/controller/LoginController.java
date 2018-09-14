package com.qjl.attendance.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qjl.attendance.entity.Admin;
import com.qjl.attendance.service.IAdminService;

/**
 * 类描述：验证登录
 * 全限定性类名: com.qjl.attendance.controller.LoginController
 * @author 曲健磊
 * @date 2018年8月30日下午10:02:45
 * @version V1.0
 */
@Controller
public class LoginController {

	@Autowired
	private IAdminService adminService;
	
	/**
	 * 验证用户登录
	 * @param admin
	 * @param session
	 * @return
	 */
	@RequestMapping("/login")
	public @ResponseBody Map<String, Object> login(Admin admin, HttpSession session) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		Admin dbAdmin = adminService.loginAdmin(admin);
		
		if (dbAdmin != null) { // 登录成功
			resultMap.put("flag", true);
			session.setAttribute("admin", dbAdmin);
		} else { // 失败
			resultMap.put("flag", false);
		}
		return resultMap;
	}
	
}
