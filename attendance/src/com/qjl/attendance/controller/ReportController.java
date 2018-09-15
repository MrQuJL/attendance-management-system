package com.qjl.attendance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qjl.attendance.dto.AttendanceSummary;
import com.qjl.attendance.dto.DeptAttendance;
import com.qjl.attendance.dto.DeptAttendanceParam;
import com.qjl.attendance.dto.TodayAttendance;
import com.qjl.attendance.dto.TodayAttendanceParam;
import com.qjl.attendance.entity.Department;
import com.qjl.attendance.service.IAttendanceBulletinService;
import com.qjl.attendance.service.IAttendanceSummaryService;
import com.qjl.attendance.service.IDepartmentService;
import com.qjl.attendance.service.ITodayAttendanceService;

/**
 * 类描述：处理报表请求
 * 全限定性类名: com.qjl.attendance.controller.ReportController
 * @author 曲健磊
 * @date 2018年9月6日下午7:50:37
 * @version V1.0
 */
@Controller
public class ReportController {
	
	@Autowired
	private IDepartmentService departmentService;
	
	@Autowired
	private ITodayAttendanceService todayAttendanceService;
	
	@Autowired
	private IAttendanceBulletinService attendanceBulletinService;
	
	@Autowired
	private IAttendanceSummaryService attendanceSummaryService;
	
	/**
	 * 前往日报表统计考勤页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/gotoTodayAttendance")
	public String listAdminDto(HttpServletRequest request) {
		List<Department> deptList = departmentService.listDepartment(null);
		request.setAttribute("deptList", deptList);
		return "report/reportList";
	}
	
	/**
	 * 查询今日考勤信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/listTodayAttendance")
	public @ResponseBody Map<String, Object> listTodayAttendance(TodayAttendanceParam param, HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<TodayAttendance> todayAttendanceList = todayAttendanceService.listTodayAttendance(param);
		resultMap.put("Rows", todayAttendanceList);
		resultMap.put("Total", todayAttendanceList.size());
		
		return resultMap;
	}
	
	/**
	 * 前往考勤公告页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/gotoAttendanceBulletin")
	public String gotoAttendanceBulletin(HttpServletRequest request) {
		return "report/attBulletin";
	}
	
	/**
	 * 查询指定日期的考勤公告页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/listAttendanceBulletin")
	public @ResponseBody Map<String, Object> listAttendanceBulletin(DeptAttendanceParam param,
		HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<DeptAttendance> attList = attendanceBulletinService.listAttendanceBulletin(param);
		resultMap.put("Rows", attList);
		resultMap.put("Total", attList.size());
		
		return resultMap;
	}
	
	/**
	 * 前往考勤汇总页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/gotoAttendanceSummary")
	public String gotoAttendanceSummary(HttpServletRequest request) {
		return "report/attSummary";
	}
	
	/**
	 * 考勤汇总
	 * @param year
	 * @param month
	 * @return
	 */
	@RequestMapping("/listAttendanceSummary")
	public @ResponseBody Map<String, Object> listAttendanceSummary(String year, String month) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<AttendanceSummary> attSumaryList = attendanceSummaryService.listAttendanceSummary(year, month);
		resultMap.put("Rows", attSumaryList);
		resultMap.put("Total", attSumaryList.size());
		
		return resultMap;
	}
	
}