package com.qjl.attendance.service;

import java.util.List;

/**
 * 类描述：考勤员权限服务接口
 * 全限定性类名: com.qjl.attendance.service.IPopedomService
 * @author 曲健磊
 * @date 2018年9月1日上午9:14:24
 * @version V1.0
 */
public interface IPopedomService {

	/**
	 * 更新考勤员的部门权限
	 * @param workerId 考勤员id
	 * @param deptIds 部门id
	 * @return 是否全部更新成功
	 */
	boolean updateWorkerPerm(Long workerId, Integer[] deptIds);
	
	/**
	 * 查询出当前考勤员所拥有的部门权限
	 * @param workerId
	 * @return
	 */
	List<Long> listAllWorkerPerm(Long workerId);
	
}
