<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp" %>
<!doctype html>
<html>
<head>
    <title>考勤公告页面表</title>
    <link href="${ctx}/lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/css/select2.min.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${ctx}/lib/jquery/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/core/base.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/plugins/ligerDialog.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/plugins/ligerTextBox.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/plugins/ligerCheckBox.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/plugins/ligerComboBox.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/plugins/ligerGrid.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/plugins/ligerDateEditor.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/plugins/ligerSpinner.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/ligerui.min.js"></script>
    <script type="text/javascript" src="${ctx}/lib/common.js"></script>
    <script type="text/javascript" src="${ctx}/lib/select2.min.js"></script>
    <style type="text/css">
    	#noteTab tr td{padding:10px 5px 10px 8px;}
    </style>
    <script type="text/javascript">
    	var bulletin;
	    function f_initGrid()
	    {
	        $("#maingrid").ligerGrid({
	            columns: [
	                { display: '部门', name: 'deptName', width: 100},
	                { display: '出勤情况', name: 'attendanceResult'},
	            ],
	            isScroll: false,
	            data: bulletin, // 数据在这里===========================
	            width: '100%'
	        });
	    }
        function queryAttBulletin() // 条件查询公告信息
        {
        	// 1.获取出勤时间
        	var attDate = $("#bulletinDate").val();
        	// 2.获取出勤时段
        	var attFlag = $("#attFlag").val();
        	
        	if (attDate == "" || attFlag == "" || attDate == undefined || attFlag == undefined) {
        		$.ligerDialog.error("出勤时间或者出勤时段不能为空");
        		return false;
        	}
        	
        	var queryParam = {};
        	queryParam.attDate = attDate;
        	queryParam.attFlag = attFlag;
        	
        	// 5.发送ajax请求
        	$.ajax({
        		type : "post",
        		url : "${ctx}/listAttendanceBulletin",
        		data : queryParam,
        		dataType : "json",
        		success : function(data) {
        			bulletin = data;
        			f_initGrid();
        		}
        	});
        }
    </script>
</head>
<body style="padding:10px">
 	<div class="l-clear"></div>
 	<fieldset style="border:1px solid #ccc;">
 		<legend style="margin-left:20px;">查询条件</legend>
 		<table id="noteTab">
	 		<tr>
	 			<td>生成公告日期时间：</td>
	 			<td>
	 				<input id="bulletinDate" type="text" />
	 			</td>
	 			<td>
	 				<select style="width:120px;" id="attFlag">
						<option value="1">上午</option>
						<option value="2">下午</option>
					</select>
	 			</td>
	 			<td>
	 				<input class="liger-button" type="button" onclick="queryAttBulletin();" value="生成公告" />
	 			</td>
	 		</tr>
	 	</table>
 	</fieldset>
 	
    <div id="maingrid" style="margin-top:20px">
    </div>
    
  	<div style="display:none;">
</div>
<script type="text/javascript">
	$("#attFlag").select2();
	$("#bulletinDate").ligerDateEditor();
</script>
</body>
</html>