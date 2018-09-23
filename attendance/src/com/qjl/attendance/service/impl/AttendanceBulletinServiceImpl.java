package com.qjl.attendance.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qjl.attendance.dto.DeptAttendance;
import com.qjl.attendance.dto.DeptAttendanceParam;
import com.qjl.attendance.dto.TodayAttendance;
import com.qjl.attendance.dto.TodayAttendanceParam;
import com.qjl.attendance.entity.Department;
import com.qjl.attendance.entity.Employee;
import com.qjl.attendance.mapper.DepartmentMapper;
import com.qjl.attendance.mapper.EmployeeMapper;
import com.qjl.attendance.mapper.TodayAttendanceMapper;
import com.qjl.attendance.service.IAttendanceBulletinService;

/**
 * 类描述：考勤公告
 * 全限定性类名: com.qjl.attendance.service.impl.AttendanceBulletinServiceImpl
 * @author 曲健磊
 * @date 2018年9月7日上午10:18:44
 * @version V1.0
 */
@Service("attendanceBulletinService")
public class AttendanceBulletinServiceImpl implements IAttendanceBulletinService {

	@Autowired
	private TodayAttendanceMapper todayAttendanceMapper;
	
	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	/**
	 * 查询今日的考勤公告
	 * @param param 封装查询条件
	 * @return 所有部门的考勤信息
	 */
	@Override
	public List<DeptAttendance> listAttendanceBulletin(DeptAttendanceParam param) {
		// 1.查询出所有的部门
		List<Department> deptList = departmentMapper.listDepartment(null);
		
		// 2.查询出每个部门的所有员工
		Map<String, List<Employee>> deptEmpMap = new HashMap<String, List<Employee>>();
		for (int i = 0; i < deptList.size(); i++) {
			Employee employee = new Employee();
			employee.setDepartmentid(deptList.get(i).getDepartmentid());
			List<Employee> empList = employeeMapper.listEmployee(employee);
			
			// 把每个部门以及部门下的所有员工放入map
			deptEmpMap.put(deptList.get(i).getDepartmentname(), empList);
		}
		
		// 3.查询出每个部门当天时间段的考勤情况
		Map<String, List<TodayAttendance>> attMap = new HashMap<String, List<TodayAttendance>>();
		TodayAttendanceParam tParam = new TodayAttendanceParam();
		tParam.setCurDate(param.getAttDate());
		tParam.setAttFlag(param.getAttFlag());
		
		// 查询出每个部门当天的考勤情况
		for (int i = 0; i < deptList.size(); i++) {
			tParam.setDeptId(deptList.get(i).getDepartmentid().intValue());
			List<TodayAttendance> tAList = todayAttendanceMapper.listTodayAttendance(tParam);
			
			// 把每个部门以及对应的考勤情况放到map中
			attMap.put(deptList.get(i).getDepartmentname(), tAList);
		}
		
		// 4.从所有人中去筛选满足条件的
		List<DeptAttendance> finalList = new ArrayList<DeptAttendance>();
		Set<String> deptSet = deptEmpMap.keySet();
		for (Iterator<String> it = deptSet.iterator(); it.hasNext(); ) {
			
			DeptAttendance deptAttendance = new DeptAttendance(); // 记录这个部门今天的出勤情况
			
			String dName = it.next();
			
			deptAttendance.setDeptName(dName);
			
			StringBuilder result = new StringBuilder();
			
			List<Employee> empList = deptEmpMap.get(dName); // 该部门下的所有员工
			List<TodayAttendance> attList = attMap.get(dName); // 该部门今天的考勤情况
			
			for (int i = 0; i < empList.size(); i++) { // 员工列表
				Employee emp = empList.get(i);
				boolean flag = false; // 判断这个员工是没考过勤
				for (int j = 0; j < attList.size(); j++) { // 考勤列表
					TodayAttendance att = attList.get(j);
					if (att.getEmployeeName().equals(emp.getEmployeename())) {
						flag = true;
						if (!"出勤".equals(att.getAttStatus())) { // 该员工考过勤了，但是，未正常出勤
							result.append(emp.getEmployeename()).append("(未正常出勤)");
						}
					}
				}
				if (flag == false) { // 该员工根本没考过勤
					result.append(emp.getEmployeename()).append("(未正常出勤)");
				}
			}
			if (result.length() == 0) {
				result.append("全勤");
			}
			deptAttendance.setAttendanceResult(result.toString());
			finalList.add(deptAttendance);
		}
		return finalList;
	}

}
