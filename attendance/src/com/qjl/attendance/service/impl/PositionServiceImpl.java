package com.qjl.attendance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qjl.attendance.entity.Position;
import com.qjl.attendance.mapper.PositionMapper;
import com.qjl.attendance.service.IPositionService;

/**
 * 类描述：service实现类
 * 全限定性类名: com.qjl.attendance.service.impl.PositionServiceImpl
 * @author 曲健磊
 * @date 2018年8月27日下午4:28:08
 * @version V1.0
 */
@Service("positionService")
public class PositionServiceImpl implements IPositionService {

	@Autowired
	private PositionMapper positionMapper;
	
	@Override
	public List<Position> listPosition() {
		return positionMapper.listPosition();
	}

	@Override
	public Position getPositionById(Integer id) {
		return positionMapper.getPositionById(id);
	}
	
	@Override
	public int insertPosition(String positionName) {
		return positionMapper.insertPosition(positionName);
	}

	@Override
	public int deletePosition(Integer id) {
		return positionMapper.deletePosition(id);
	}

	@Override
	public int updatePosition(Position position) {
		return positionMapper.updatePosition(position);
	}

}
