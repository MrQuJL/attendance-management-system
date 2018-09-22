<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>编辑用户信息</title>
    <link href="${ctx}/lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${ctx}/lib/jquery/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="${ctx}/lib/json2.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/core/base.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/ligerui.min.js"></script>
    <style type="text/css">
    	table{margin:auto;}
    	table tr td{padding:8px 4px 0 6px;}
    </style>
</head>
<body style="padding:10px">
	<form id="adminForm">
		<table>
			<tr>
				<td style="text-align:right;">
					用户名称:
					<input type="hidden" id="adminid" name="adminid" value="${adminid}" />	
				</td>
				<td>
					<input type="text" id="adminaccount" name="adminaccount" value="${adminaccount}" />
				</td>
			</tr>
			<tr>
				<td style="text-align:right;">是否是超级管理员：</td>
				<td>
					<c:choose>
				 		<c:when test="${adminright == 1}"> <!-- 管理员 -->
				 			<input type="radio" name="adminright" value="1" checked="checked" />超级管理员
				 			<input type="radio" name="adminright" value="0" />考勤员
				 		</c:when>
				 		<c:otherwise> <!-- 考勤员 -->
				 			<input type="radio" name="adminright" value="1" />超级管理员
				 			<input type="radio" name="adminright" value="0" checked="checked" />考勤员
				 		</c:otherwise>
				 	</c:choose>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:center;padding-top:16px;">
					<input class="liger-button" type="button" value="修改用户" onclick="update();" />
				</td>
			</tr>
		</table>
 	</form>
<script type="text/javascript">
	function update() {
		var name = $("#adminaccount").val();
    	if (name == "") {
    		$.ligerDialog.error("员工名称不能为空!");
    		return false;
    	}
    	// 修改员工
    	var adminData = $("#adminForm").serialize();
    	$.ajax({
    		type : "post",
    		url : "${ctx}/updateAdmin",
    		data : adminData,
    		dataType : "json",
    		success : function(data) {
    			if (data.flag == 1) {
    				$.ligerDialog.success('修改成功!', function(){
						parent.location.reload();
					});
    			} else {
    				$.ligerDialog.error("修改员工失败，请联系系统管理员!");
    			}
    		}
    	});
	}
</script>
</body>
</html>