package com.qjl.attendance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qjl.attendance.entity.Position;
import com.qjl.attendance.service.IPositionService;

/**
 * 类描述：处理对职位的请求
 * 全限定性类名: com.qjl.attendance.controller.PositionController
 * @author 曲健磊
 * @date 2018年8月27日下午4:29:33
 * @version V1.0
 */
@Controller
public class PositionController {
	
	@Autowired
	private IPositionService positionService;
	
	@RequestMapping("/editPosition")
	public String editPosition(HttpServletRequest request, Integer id) {
		Position position = positionService.getPositionById(id);
		request.setAttribute("positionid", position.getPositionid());
		request.setAttribute("positionname", position.getPositionname());
		return "position/positionEdit";
	}
	
	@RequestMapping("/updatePosition")
	public @ResponseBody Map<String, Object> updatePosition(Position position) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int rows = positionService.updatePosition(position);
		
		resultMap.put("flag", rows);
		
		return resultMap;
	}
	
	@RequestMapping("/listPosition")
	public @ResponseBody Map<String, Object> listPosition() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<Position> positionList = positionService.listPosition();
		
		resultMap.put("Rows", positionList);
		resultMap.put("Total", positionList.size());
		
		return resultMap;
	}
	
	@RequestMapping("/insertPosition")
	public @ResponseBody Map<String, Object> insertPosition(@RequestParam("positionname") String positionName) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int rows = positionService.insertPosition(positionName);
		
		resultMap.put("flag", rows);
		
		return resultMap;
	}
	
	@RequestMapping("/deletePosition")
	public @ResponseBody Map<String, Object> deletePosition(@RequestParam("positionid") Integer positionId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int rows = positionService.deletePosition(positionId);
		
		resultMap.put("flag", rows);
		
		return resultMap;
	}
	
}
