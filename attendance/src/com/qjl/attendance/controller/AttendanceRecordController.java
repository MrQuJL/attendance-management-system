package com.qjl.attendance.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.qjl.attendance.dto.AttRecordDto;
import com.qjl.attendance.dto.AttRecordParam;
import com.qjl.attendance.entity.Admin;
import com.qjl.attendance.entity.AttendanceRecord;
import com.qjl.attendance.entity.AttendanceType;
import com.qjl.attendance.entity.Department;
import com.qjl.attendance.entity.Employee;
import com.qjl.attendance.service.IAttendanceRecordService;
import com.qjl.attendance.service.IAttendanceTypeService;
import com.qjl.attendance.service.IDepartmentService;
import com.qjl.attendance.service.IEmployeeService;
import com.qjl.attendance.service.INotesService;
import com.qjl.attendance.service.IPopedomService;

/**
 * 类描述：负责处理对考勤记录的请求
 * 全限定性类名: com.qjl.attendance.controller.AttendanceRecordController
 * @author 曲健磊
 * @date 2018年9月3日下午7:26:18
 * @version V1.0
 */
@Controller
public class AttendanceRecordController {
	
	@Autowired
	private INotesService notesService;
	
	@Autowired
	private IPopedomService popedomService;
	
	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	private IDepartmentService departmentService;
	
	@Autowired
	private IAttendanceTypeService attendanceTypeService;
	
	@Autowired
	private IAttendanceRecordService attendanceRecordService;
	
	/**
	 * 处理前往考勤列表的请求
	 * @return 
	 */
	@RequestMapping("/gotoAttandanceMgr")
	public String gotoAttandanceMgr(HttpServletRequest request, HttpSession session) {
		// 1.查询出当前考勤员所拥有的部门权限
		Admin admin = (Admin) session.getAttribute("admin");
		List<Long> deptIds = popedomService.listAllWorkerPerm(admin.getAdminid());
		List<Department> deptList = departmentService.listDepartment(null);
		for (Iterator<Department> it = deptList.iterator(); it.hasNext();) {
			Department dept = it.next();
			if (!deptIds.contains(dept.getDepartmentid())) {
				it.remove();
			}
		}
		// 2.查询出所有的考勤类型
		List<AttendanceType> allAttList = attendanceTypeService.listAllAttType();
		
		request.setAttribute("deptList", deptList);
		request.setAttribute("allAttList", allAttList);
		
		return "attendance/attendanceList";
	}
	
	/**
	 * 处理查询考勤记录的请求
	 * @param param 接收查询条件的参数
	 * @return 
	 */
	@RequestMapping("/listAttendanceRecord")
	public @ResponseBody Map<String, Object> listAttendanceRecord(AttRecordParam param) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		// 1.查询出当前部门的所有员工
		Employee employee = new Employee();
		employee.setDepartmentid(param.getDeptId());
		List<Employee> empList = employeeService.listEmployee(employee);
		
		// 2.查询出当前部门当前日期,当前时间段,当前部门的员工的考勤记录
		List<AttendanceRecord> attList = attendanceRecordService.listAttRecord(param);
		
		// 3.将有考勤记录的员工信息追加相应的考勤信息
		List<AttRecordDto> ardList = new ArrayList<AttRecordDto>();
		for (int i = 0; i < empList.size(); i++) { // 员工信息列表
			Employee emp = empList.get(i);
			AttRecordDto ard = new AttRecordDto();
			
			ard.setEmployeeid(emp.getEmployeeid());
			ard.setEmployeename(emp.getEmployeename());
			ard.setCardnumber(emp.getCardnumber());
			
			for (int j = 0; j < attList.size(); j++) { // 员工考勤信息列表
				AttendanceRecord record = attList.get(j);
				if (emp.getEmployeeid().equals(record.getEmployeeid())) {
					// 从该员工的考勤记录取出(考勤类型id,单据信息,考勤备注)
					ard.setAttendancetypeid(record.getAttendancetypeid());
					ard.setAttendancememo(record.getAttendancememo());
					ard.setNoteStr("");
					// 设置单据信息(001-事假单)
					// 需求：根据noteid获取noteTypeName
					if (record.getNoteid() != null) {
						String noteTypeName = notesService.getNoteTypeNameByNoteId(record.getNoteid());
						ard.setNoteStr(record.getNoteid() + "-" + noteTypeName + "单");
					}
				}
			}
			ardList.add(ard);
		}
		
		resultMap.put("Rows", ardList);
		resultMap.put("Total", ardList.size());
		
		return resultMap;
	}
	
	/**
	 * 保存考勤记录
	 * @param attRecordList 考勤记录列表
	 * @return 添加考勤记录成功与否的标志
	 */
	@RequestMapping("/saveAttendanceRecord")
	public @ResponseBody Map<String, Object> saveAttendanceRecord(@RequestParam("objArray") String objArray,
		HttpSession session) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// 设置进行该操作的考勤员id
		Admin admin = (Admin) session.getAttribute("admin");
		
		System.out.println(objArray);
		
		// 1.解析考勤记录字符串
		JSONArray attArray = JSON.parseArray(objArray);
		List<AttendanceRecord> attList = new ArrayList<AttendanceRecord>();
		for (int i = 0; i < attArray.size(); i++) {
			AttendanceRecord attRecord = attArray.getObject(i, AttendanceRecord.class);
			attRecord.setAdminid(admin.getAdminid()); // 设置考勤人员的id
			attList.add(attRecord);
			System.out.println(attRecord);
		}
		// 2.保存考勤记录
		int totalRows = attendanceRecordService.saveRecord(attList);
		if (totalRows == attList.size()) {
			resultMap.put("flag", true);
		} else {
			resultMap.put("flag", false);
		}
		return resultMap;
	}
	
}
