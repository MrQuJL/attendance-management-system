package com.qjl.attendance.mapper;

import java.util.List;

import com.qjl.attendance.entity.Position;

/**
 * 类描述：position
 * 全限定性类名: com.qjl.attendance.mapper.PositionMapper
 * @author 曲健磊
 * @date 2018年8月27日下午4:25:08
 * @version V1.0
 */
public interface PositionMapper {
	
	/**
	 * 查询所有的职位信息
	 * @return
	 */
	List<Position> listPosition();
	
	/**
	 * 根据职位编号获取职位信息
	 * @param id
	 * @return
	 */
	Position getPositionById(Integer id);
	
	/**
	 * 添加职位
	 * @param position
	 * @return
	 */
	int insertPosition(String positionName);
	
	/**
	 * 删除职位
	 * @param id
	 * @return
	 */
	int deletePosition(Integer id);
	
	/**
	 * 修改职位
	 * @param position
	 * @return
	 */
	int updatePosition(Position position);
}
