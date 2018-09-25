package com.qjl.attendance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qjl.attendance.dto.NotesDto;
import com.qjl.attendance.dto.NotesQueryParam;
import com.qjl.attendance.entity.Notes;
import com.qjl.attendance.mapper.NotesMapper;
import com.qjl.attendance.service.INotesService;

/**
 * 类描述：INotesService的实现类
 * 全限定性类名: com.qjl.attendance.service.impl.NotesServiceImpl
 * @author 曲健磊
 * @date 2018年9月1日下午4:11:31
 * @version V1.0
 */
@Service("notesService")
public class NotesServiceImpl implements INotesService {

	@Autowired
	private NotesMapper notesMapper;
	
	@Override
	public List<NotesDto> listNotes(NotesQueryParam notesQueryParam) {
		return notesMapper.listNotes(notesQueryParam);
	}

	@Override
	public List<NotesDto> listNotesExecludeType(NotesQueryParam notesQueryParam) {
		return notesMapper.listNotesExecludeType(notesQueryParam);
	}
	
	@Override
	public String getNoteTypeNameByNoteId(Long noteId) {
		return notesMapper.getNoteTypeNameByNoteId(noteId);
	}
	
	@Override
	public Notes getNotesByNoteId(Long noteId) {
		return notesMapper.getNotesByNoteId(noteId);
	}
	
	@Override
	public int insertNotes(Notes notes) {
		return notesMapper.insertNotes(notes);
	}

	@Override
	public int updateNotes(Notes notes) {
		return notesMapper.updateNotes(notes);
	}
	
	@Override
	public int deleteNotes(Long notesId) {
		return notesMapper.deleteNotes(notesId);
	}

}
