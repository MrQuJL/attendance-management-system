package com.qjl.attendance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qjl.attendance.dto.AttRecordParam;
import com.qjl.attendance.entity.AttendanceRecord;
import com.qjl.attendance.mapper.AttendanceRecordMapper;
import com.qjl.attendance.service.IAttendanceRecordService;

/**
 * 类描述：操作考勤记录
 * 全限定性类名: com.qjl.attendance.service.impl.AttendanceRecordServiceImpl
 * @author 曲健磊
 * @date 2018年9月5日上午11:15:37
 * @version V1.0
 */
@Service("attendanceRecord")
public class AttendanceRecordServiceImpl implements IAttendanceRecordService {

	@Autowired
	private AttendanceRecordMapper attendanceRecordMapper;
	
	@Override
	public List<AttendanceRecord> listAttRecord(AttRecordParam attRecordParam) {
		
		List<AttendanceRecord> attRecordList = attendanceRecordMapper.listAttRecord(attRecordParam);
		
		
		
		return attRecordList;
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
	public int saveRecord(List<AttendanceRecord> attRecordList) {
		// 1.查询考勤记录是否存在
		
		// 2.存在先删除再添加
		
		// 3.不存在直接添加
		int totalRows = 0;
		for (int i = 0; i < attRecordList.size(); i++) {
			AttendanceRecord attRecord = attRecordList.get(i);
			
			int count = attendanceRecordMapper.countAttRecord(attRecord);
			
			if (count > 0) { // 存在，先删除
				attendanceRecordMapper.deleteAttRecord(attRecord);
			}
			int insertRows = attendanceRecordMapper.insertAttRecord(attRecord);
			totalRows += insertRows; 
		}
		return totalRows;
	}

}
