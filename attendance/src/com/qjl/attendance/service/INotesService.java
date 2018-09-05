package com.qjl.attendance.service;

import java.util.List;

import com.qjl.attendance.dto.NotesDto;
import com.qjl.attendance.dto.NotesQueryParam;
import com.qjl.attendance.entity.Notes;

/**
 * 类描述：单据服务层接口
 * 全限定性类名: com.qjl.attendance.service.INotesService
 * @author 曲健磊
 * @date 2018年9月1日下午4:10:27
 * @version V1.0
 */
public interface INotesService {

	/**
	 * 查询满足条件的单据列表
	 * @param notesQueryParam 封装查询条件
	 * @return
	 */
	List<NotesDto> listNotes(NotesQueryParam notesQueryParam);
	
	/**
	 * 添加一条请假单
	 * @param notes
	 * @return
	 */
	int insertNotes(Notes notes);
	
	/**
	 * 删除一条请假单
	 * @param notesId
	 * @return
	 */
	int deleteNotes(Long notesId);
	
}
