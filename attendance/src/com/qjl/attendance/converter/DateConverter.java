package com.qjl.attendance.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

import com.github.pagehelper.util.StringUtil;

/**
 * 类描述：负责将欠他传递过来的String类型的日期字符串转换成日期对象
 * 全限定性类名: com.qjl.pems.converter.DateConverter
 * @author 曲健磊
 * @date 2018年8月15日下午9:55:44
 * @version V1.0
 */
public class DateConverter implements Converter<String, Date> {

	/**
	 * 将 yyyy-MM-dd 格式的字符串转换成日期对象
	 */
	@Override
	public Date convert(String dateStr) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		if (StringUtil.isNotEmpty(dateStr)) { // 解决：查询不选择日期默认传过来""，导致解析日期抛出异常
			try {
				date = sdf.parse(dateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return date;
	}

}
