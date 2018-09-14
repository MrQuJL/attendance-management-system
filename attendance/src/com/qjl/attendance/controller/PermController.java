package com.qjl.attendance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.qjl.attendance.dto.TreeDto;
import com.qjl.attendance.service.IDepartmentService;
import com.qjl.attendance.service.IPopedomService;

/**
 * 类描述：处理对权限的请求
 * 全限定性类名: com.qjl.attendance.controller.PermController
 * @author 曲健磊
 * @date 2018年8月31日下午9:33:09
 * @version V1.0
 */
@Controller
public class PermController {
	
	@Autowired
	private IDepartmentService departmentService;
	
	@Autowired
	private IPopedomService popedomService;
	
	/**
	 * 查询出所有的部门
	 * @return json格式的emplist字符串
	 */
	@RequestMapping("/listDeptTree")
	public @ResponseBody Map<String, Object> listDeptTree(@RequestParam("workerId") Long workerId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<TreeDto> treeList = departmentService.listDeptTree();
		
		List<Long> deptIds = popedomService.listAllWorkerPerm(workerId);
		
		resultMap.put("tree", treeList);
		resultMap.put("checkeds", deptIds);
		
		return resultMap;
	}
	
	/**
	 * 保存当前考勤员对部门的权限
	 * @param deptIds 部门id列表
	 * @param adminId 考勤员id
	 * @return
	 */
	@RequestMapping("/savePerm")
	public @ResponseBody Map<String, Object> savePerm(@RequestParam("deptIds") String deptIds,
		@RequestParam("adminId") Long adminId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		JSONArray array = JSON.parseArray(deptIds);
		Integer[] ids = new Integer[array.size()];
		int i = 0;
		for (Object object : array) {
			ids[i++] = (Integer) object;
		}
		
		boolean flag = popedomService.updateWorkerPerm(adminId, ids);
		if (flag) {
			resultMap.put("flag", true);
		} else {
			resultMap.put("flag", false);
		}
		return resultMap;
	}
	
}
