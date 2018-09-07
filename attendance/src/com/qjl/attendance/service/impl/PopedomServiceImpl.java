package com.qjl.attendance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qjl.attendance.entity.AdminPopedom;
import com.qjl.attendance.mapper.PopedomMapper;
import com.qjl.attendance.service.IPopedomService;

/**
 * 类描述：权限服务接口的实现类
 * 全限定性类名: com.qjl.attendance.service.impl.PopedomServiceImpl
 * @author 曲健磊
 * @date 2018年9月1日上午9:17:44
 * @version V1.0
 */
@Service("popedomService")
public class PopedomServiceImpl implements IPopedomService {

	@Autowired
	private PopedomMapper popedomMapper;
	
	/**
	 * 更新考勤员的部门权限
	 * @param workerId 考勤员id
	 * @param deptIds 部门id
	 * @return 是否全部更新成功
	 */
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
	public boolean updateWorkerPerm(Long workerId, Integer[] deptIds) {
		// 1.先删除该考勤员的所有权限
		popedomMapper.deleteAllWorkerPerm(workerId);
		// 2.再添加考勤员的新权限
		int rows = 0;
		for (Integer id : deptIds) {
			AdminPopedom popedom = new AdminPopedom();
			popedom.setAdminid(workerId);
			popedom.setDepartmentid((long) id);
			int temp = popedomMapper.insertPerm(popedom);
			rows += temp;
		}
		if (rows == deptIds.length) {
			return true;
		}
		return false;
	}

	/**
	 * 查询出当前考勤员所拥有的部门权限
	 * @param workerId
	 * @return
	 */
	@Override
	public List<Long> listAllWorkerPerm(Long workerId) {
		return popedomMapper.listAllWorkerPerm(workerId);
	}

}
