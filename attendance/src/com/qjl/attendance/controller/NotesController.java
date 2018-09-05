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
import com.qjl.attendance.entity.Notes;
import com.qjl.attendance.service.IAttendanceTypeService;
import com.qjl.attendance.service.IEmployeeService;
import com.qjl.attendance.service.INotesService;

/**
 * 类描述：处理对请假单的请求
 * 全限定性类名: com.qjl.attendance.controller.NotesController
 * @author 曲健磊
 * @date 2018年9月1日下午3:03:31
 * @version V1.0
 */
@Controller
public class NotesController {
	
	@Autowired
	private INotesService notesService;
	
	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	private IAttendanceTypeService attendanceTypeService;
	
	/**
	 * 处理前往单据列表页面的请求
	 * @return
	 */
	@RequestMapping("/gotoNotesMgr")
	public String gotoNotesMgr() {
		// 1.
		
		
		// 2.
		
		
		return "notes/notesList";
	}
	
	/**
	 * 处理前往单据编辑页面的请求
	 * @return
	 */
	@RequestMapping("/gotoNotesEdit")
	public String gotoNotesEdit(HttpServletRequest request) {
		// 1.查询出所有的员工
		List<EmployeeDto> empList = employeeService.listEmployeeDto(null);
		// 2.查询出所有的请假类型
		List<AttendanceType> typeList = attendanceTypeService.listAttendanceType();
		
		request.setAttribute("empList", empList);
		request.setAttribute("typeList", typeList);
		
		return "notes/notesEdit";
	}
	
	/**
	 * 查询出所有的请假单列表
	 * @param employee
	 * @return
	 */
	@RequestMapping("/listNotesDto")
	public @ResponseBody Map<String, Object> listNotesDto(NotesQueryParam notesQueryParam) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
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
	@RequestMapping("/insertNotes")
	public @ResponseBody Map<String, Object> insertNotes(Notes notes, HttpSession session) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		Admin admin = (Admin) session.getAttribute("admin");
		notes.setOperatorid(admin.getAdminid());
		int rows = notesService.insertNotes(notes);
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
	@RequestMapping("/deleteNotes")
	public @ResponseBody Map<String, Object> deleteNotes(Long noteId) {
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
