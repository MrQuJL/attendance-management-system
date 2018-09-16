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
	 * 查询除了某个类型以外的单据列表
	 * @param notesQueryParam 查询条件
	 * @return
	 */
	List<NotesDto> listNotesExecludeType(NotesQueryParam notesQueryParam);
	
	/**
	 * 根据单据id查询单据的类型名称
	 * @param noteId
	 * @return
	 */
	String getNoteTypeNameByNoteId(Long noteId);
	
	/**
	 * 根据单据id查询单据的详细信息
	 * @param noteId 单据id
	 * @return 单据的详细信息
	 */
	Notes getNotesByNoteId(Long noteId);
	
	/**
	 * 添加请假单
	 * @param notes
	 * @return
	 */
	int insertNotes(Notes notes);
	
	/**
	 * 修改请假单
	 * @param notes
	 * @return
	 */
	int updateNotes(Notes notes);
	
	/**
	 * 删除一条请假单
	 * @param notesId
	 * @return
	 */
	int deleteNotes(Long notesId);
	
}
