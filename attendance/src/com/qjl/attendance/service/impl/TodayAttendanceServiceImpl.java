package com.qjl.attendance.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qjl.attendance.dto.TodayAttendance;
import com.qjl.attendance.dto.TodayAttendanceParam;
import com.qjl.attendance.mapper.TodayAttendanceMapper;
import com.qjl.attendance.service.ITodayAttendanceService;

/**
 * 类描述：查询今日考勤信息
 * 全限定性类名: com.qjl.attendance.service.impl.TodayAttendanceServiceImpl
 * @author 曲健磊
 * @date 2018年9月6日下午9:31:10
 * @version V1.0
 */
@Service("todayAttendanceService")
public class TodayAttendanceServiceImpl implements ITodayAttendanceService {

	@Autowired
	private TodayAttendanceMapper todayAttendanceMapper;
	
	@Override
	public List<TodayAttendance> listTodayAttendance(TodayAttendanceParam param) {
		List<TodayAttendance> todayAttendanceList = todayAttendanceMapper.listTodayAttendance(param);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String str = sdf.format(new Date());
		
		// 使用流筛选出当天的考勤信息
		todayAttendanceList = todayAttendanceList.stream()
			.filter((t)->t.getAttendanceDate().
				equals(str))
			.collect(Collectors.toList());
		
		// 将日期转换为星期
		for (int i = 0; i < todayAttendanceList.size(); i++) {
			TodayAttendance todayAttendance = todayAttendanceList.get(i);
			String date = todayAttendance.getWeek();
			Date week = null;
			Calendar c = Calendar.getInstance();
			try {
				week = sdf.parse(date);
				c.setTime(week);
				int weekday = c.get(Calendar.DAY_OF_WEEK);
				switch(weekday) {
					case 1: todayAttendance.setWeek("星期日");break;
					case 2: todayAttendance.setWeek("星期一");break;
					case 3: todayAttendance.setWeek("星期二");break;
					case 4: todayAttendance.setWeek("星期三");break;
					case 5: todayAttendance.setWeek("星期四");break;
					case 6: todayAttendance.setWeek("星期五");break;
					case 7: todayAttendance.setWeek("星期六");break;
				}
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		}
		
		return todayAttendanceList;
	}

}
