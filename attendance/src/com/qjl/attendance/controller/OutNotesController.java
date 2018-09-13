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
import com.qjl.attendance.dto.NotesDto;
import com.qjl.attendance.dto.NotesQueryParam;
import com.qjl.attendance.entity.Admin;
import com.qjl.attendance.entity.AttendanceType;
import com.qjl.attendance.entity.Department;
import com.qjl.attendance.entity.Notes;
import com.qjl.attendance.service.IAttendanceTypeService;
import com.qjl.attendance.service.IDepartmentService;
import com.qjl.attendance.service.IEmployeeService;
import com.qjl.attendance.service.INotesService;

/**
 * 类描述：处理对出差单的请求
 * 全限定性类名: com.qjl.attendance.controller.OutNotesController
 * @author 曲健磊
 * @date 2018年9月6日上午9:19:31
 * @version V1.0
 */
@Controller
public class OutNotesController {
	
	@Autowired
	private INotesService notesService;
	
	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	private IDepartmentService departmentService;
	
	@Autowired
	private IAttendanceTypeService attendanceTypeService;
	
	/**
	 * 处理前往单据列表页面的请求
	 * @return
	 */
	@RequestMapping("/gotoOutNotesMgr")
	public String gotoOutNotesMgr(HttpServletRequest request) {
		// 1.查询出所有的请假类型
		List<AttendanceType> typeList = attendanceTypeService.listAttendanceType();
		// 2.查询出所有的部门
		List<Department> deptList = departmentService.listDepartment(null);
		// 3.设置到request域
		request.setAttribute("typeList", typeList);
		request.setAttribute("deptList", deptList);
		
		return "out_notes/notesList";
	}
	
	/**
	 * 处理前往单据添加页面的请求
	 * @return
	 */
	@RequestMapping("/gotoOutNotesEdit")
	public String gotoOutNotesEdit(HttpServletRequest request) {
		// 1.查询出所有的员工
		List<EmployeeDto> empList = employeeService.listEmployeeDto(null);
		// 2.查询出所有的请假类型
		List<AttendanceType> typeList = attendanceTypeService.listAttendanceType();
		
		request.setAttribute("empList", empList);
		request.setAttribute("typeList", typeList);
		
		return "out_notes/notesEdit";
	}
	
	/**
	 * 处理前往单据修改页面的请求
	 * @return
	 */
	@RequestMapping("/gotoOutNotesUpdate")
	public String gotoOutNotesUpdate(Long noteId, HttpServletRequest request) {
		// 1.查询出所有的员工
		List<EmployeeDto> empList = employeeService.listEmployeeDto(null);
		// 2.查询出所有的请假类型
		List<AttendanceType> typeList = attendanceTypeService.listAttendanceType();
		
		request.setAttribute("empList", empList);
		request.setAttribute("typeList", typeList);
		
		// 3.查询出当前这条请假单的请假信息
		Notes notes = notesService.getNotesByNoteId(noteId);
		request.setAttribute("notes", notes);
		
		return "out_notes/notesUpdate";
	}
	
	/**
	 * 查询出所有的出差单列表
	 * @param notesQueryParam
	 * @return
	 */
	@RequestMapping("/listOutNotesDto")
	public @ResponseBody Map<String, Object> listOutNotesDto(NotesQueryParam notesQueryParam) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// 设置请假类型为出差
		Long typeId = attendanceTypeService.getAttTypeIdByName("出差");
		notesQueryParam.setNoteTypeId(typeId);
		
		List<NotesDto> notesDtoList = notesService.listNotes(notesQueryParam);
		
		resultMap.put("Total", notesDtoList.size());
		resultMap.put("Rows", notesDtoList);
		
		return resultMap;
	}
	
	/**
	 * 添加请假单
	 * @param notes
	 * @param session
	 * @return
	 */
	@RequestMapping("/insertOutNotes")
	public @ResponseBody Map<String, Object> insertOutNotes(Notes notes, HttpSession session) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		Long typeId = attendanceTypeService.getAttTypeIdByName("出差");
		Admin admin = (Admin) session.getAttribute("admin");
		notes.setOperatorid(admin.getAdminid());
		notes.setNotetypeid(typeId);
		
		int rows = notesService.insertNotes(notes);
		if (rows > 0) {
			resultMap.put("flag", true);
		} else {
			resultMap.put("flag", false);
		}
		
		return resultMap;
	}
	
	/**
	 * 修改出差单
	 * @param notes
	 * @param session
	 * @return
	 */
	@RequestMapping("/updateOutNotes")
	public @ResponseBody Map<String, Object> updateOutNotes(Notes notes, HttpSession session) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		Admin admin = (Admin) session.getAttribute("admin");
		Long typeId = attendanceTypeService.getAttTypeIdByName("出差");
		notes.setOperatorid(admin.getAdminid());
		notes.setNotetypeid(typeId);
		int rows = notesService.updateNotes(notes);
		if (rows > 0) {
			resultMap.put("flag", true);
		} else {
			resultMap.put("flag", false);
		}
		return resultMap;
	}
	
	/**
	 * 删除请假单
	 * @param noteId
	 * @return
	 */
	@RequestMapping("/deleteOutNotes")
	public @ResponseBody Map<String, Object> deleteOutNotes(Long noteId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int rows = notesService.deleteNotes(noteId);
		if (rows > 0) {
			resultMap.put("flag", 1);
		} else {
			resultMap.put("flag", 0);
		}
		
		return resultMap;
	}
	
}
