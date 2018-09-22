<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp" %>
<!doctype html>
<html>
<head>
    <title>考勤汇总页面</title>
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
		var summary;
        function f_initGrid()
        {
            $("#maingrid").ligerGrid({
                columns: [
	                { display: '编号', name: 'employeeid'},
	                { display: '部门', name: 'departmentname'},
	                { display: '姓名', name: 'employeename'},
	                { display: '迟到', name: 'chidao'},
	                { display: '病假', name: 'bingjia'},
	                { display: '事假', name: 'shijia'},
	                { display: '产假', name: 'chanjia'},
	                { display: '丧假', name: 'sangjia'},
	                { display: '婚假', name: 'hunjia'},
	                { display: '公休', name: 'gongxiu'},
	                { display: '出差', name: 'chuchai'},
	                { display: '旷工', name: 'kuanggong'},
	                { display: '出勤', name: 'chuqin'},
                ],
                isScroll: false,
                data: summary, // 数据在这里===========================
                width: '100%'
            });
        }
        function queryAttendanceSummary() // 条件查询单据
        {
        	// 1.获取部门id
        	var year = $("#year").val();
        	// 2.获取出勤时段
        	var month = $("#month").val();
        	
        	var queryParam = {};
        	queryParam.year = year;
        	queryParam.month = month;
        	
        	// 5.发送ajax请求
        	$.ajax({
        		type : "post",
        		url : "${ctx}/listAttendanceSummary",
        		data : queryParam,
        		dataType : "json",
        		success : function(data) {
    				summary = data;
    				f_initGrid();
        		}
        	});
        }
    </script>
</head>
<body style="padding:10px">
 	<div class="l-clear"></div>
 	<fieldset style="border:1px solid #ccc;">
 		<legend style="margin-left:20px;">检索条件</legend>
 		<table id="noteTab">
	 		<tr>
	 			<td>汇总按年月：</td>
	 			<td>
	 				<input id="year" />
	 			</td>
	 			<td>年</td>
	 			<td>
	 				<input id="month" />
	 			</td>
	 			<td>月</td>
	 			<td>
	 				<input class="liger-button" type="button" onclick="queryAttendanceSummary();" value="查询" />
	 			</td>
	 		</tr>
	 	</table>
 	</fieldset>
 	
    <div id="maingrid" style="margin-top:20px"></div><br />
   	
  	<div style="display:none;">
</div>
<script type="text/javascript">
	$("#year").ligerDateEditor({
		format : "yyyy"
	});
	
	$("#month").ligerDateEditor({
		format : "MM"
	});
</script>
</body>
</html>