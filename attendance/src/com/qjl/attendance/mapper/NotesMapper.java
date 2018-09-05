package com.qjl.attendance.mapper;

import java.util.List;

import com.qjl.attendance.dto.NotesDto;
import com.qjl.attendance.dto.NotesQueryParam;
import com.qjl.attendance.entity.Notes;

/**
 * 类描述：访问单据数据
 * 全限定性类名: com.qjl.attendance.mapper.NotesMapper
 * @author 曲健磊
 * @date 2018年9月1日下午3:50:31
 * @version V1.0
 */
public interface NotesMapper {
	
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
