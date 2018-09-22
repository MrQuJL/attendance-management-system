<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <link href="${ctx}/lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${ctx}/lib/jquery/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="${ctx}/lib/json2.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/core/base.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/plugins/ligerDialog.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/plugins/ligerTextBox.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/plugins/ligerCheckBox.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/plugins/ligerComboBox.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/plugins/ligerGrid.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/plugins/ligerDateEditor.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/plugins/ligerSpinner.js"></script>
    <script type="text/javascript" src="${ctx}/lib/jquery/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/ligerui.min.js"></script>
    <script type="text/javascript">
		var EmployeeData;
		$.ajax({
			type : "post",
			url : "${ctx}/listPosition",
			dataType : "json",
			success : function(data){
				EmployeeData = data;
			},
			async : false
		});
        $(f_initGrid);
        function f_initGrid()
        {
            $("#maingrid").ligerGrid({
                columns: [
                { display: '职位编号', name: 'positionid', width: 50},
                { display: '职位名称', name: 'positionname', width: 200},
                { display: '操作', isSort: false, name: "positionid", render: function (rowdata, rowindex, value)
                {
                    var h = "";
                    h += "<a href='javascript:f_update(" + value + ")'>修改</a> ";
                    h += "<a href='javascript:deleteRow(" + value + ")'>删除</a> "; 
                    return h;
                }
                }
                ],
                onSelectRow: function (rowdata, rowindex)
                {
                    $("#txtrowindex").val(rowindex);
                },
                enabledEdit: true,clickToEdit:false, isScroll: false,
                data: EmployeeData, // 数据在这里===========================
                width: '100%'
            });
        }
        function deleteRow(rowid)
        {
            $.ligerDialog.confirm('确定删除?', function (yes)
            {
            	if (yes == false) {
            		return false;
            	}
                $.ajax({
                	type : "post",
                	url : "${ctx}/deletePosition",
                	data : {"positionid" : rowid},
        			dataType : "json",
        			success : function(data){
        				if (data.flag == 1) {
        					$.ligerDialog.success('删除成功!');
        					// 刷新数据
        					$.ajax({
        						type : "post",
        						url : "${ctx}/listPosition",
        						dataType : "json",
        						success : function(data){
        							EmployeeData = data;
        						},
        						async : false
        					});
        					$("#maingrid").ligerGrid({
        		                columns: [
        		                { display: '职位编号', name: 'positionid', width: 50},
        		                { display: '职位名称', name: 'positionname', width: 200},
        		                { display: '操作', isSort: false, name: "positionid", render: function (rowdata, rowindex, value)
        		                {
        		                    var h = "";
        		                    h += "<a href='javascript:f_update(" + value + ")'>修改</a> ";
        		                    h += "<a href='javascript:deleteRow(" + value + ")'>删除</a> "; 
        		                    return h;
        		                }
        		                }
        		                ],
        		                onSelectRow: function (rowdata, rowindex)
        		                {
        		                    $("#txtrowindex").val(rowindex);
        		                },
        		                enabledEdit: true,clickToEdit:false, isScroll: false,
        		                data: EmployeeData, // 数据在这里===========================
        		                width: '100%'
        		            });
        				} else {
        					$.ligerDialog.error('删除失败，请联系系统管理员!');
        				}
        			},
                });
            });
        }
        function addDept()
        {
        	if ($("#position").val() == "") {
        		$.ligerDialog.error('职位名称不能为空!');
        		return false;
        	}
            // 添加职位1
        	$.ajax({
    			type : "post",
    			url : "${ctx}/insertPosition",
    			data : {"positionname" : $("#position").val()},
    			dataType : "json",
    			success : function(data){
    				if (data.flag == 1) {
    					$.ligerDialog.success('添加成功!');
    					// 刷新数据
    					$.ajax({
    						type : "post",
    						url : "${ctx}/listPosition",
    						dataType : "json",
    						success : function(data){
    							EmployeeData = data;
    						},
    						async : false
    					});
    					$("#maingrid").ligerGrid({
    		                columns: [
    		                { display: '职位编号', name: 'positionid', width: 50},
    		                { display: '职位姓名', name: 'positionname', width: 200},
    		                { display: '操作', isSort: false, name: "positionid", render: function (rowdata, rowindex, value)
    		                {
    		                    var h = "";
    		                    h += "<a href='javascript:f_update(" + value + ")'>修改</a> ";
    		                    h += "<a href='javascript:deleteRow(" + value + ")'>删除</a> "; 
    		                    return h;
    		                }
    		                }
    		                ],
    		                onSelectRow: function (rowdata, rowindex)
    		                {
    		                    $("#txtrowindex").val(rowindex);
    		                },
    		                enabledEdit: true,clickToEdit:false, isScroll: false,
    		                data: EmployeeData, // 数据在这里===========================
    		                width: '100%'
    		            });
    				} else {
    					$.ligerDialog.error('添加失败，请联系系统管理员!');
    				}
    			},
    		});
        }
        function f_update(index) // 修改职务
        {
            $.ligerDialog.open({title:"修改职位信息", width: 360, height: 260, url: '${ctx}/editPosition?id='+index, showMax: true, showMin: true, isResize: true, slide: false }); 
        }
    </script>
    <style type="text/css">
    	table{margin:auto;}
    	table tr td{padding:8px 4px 8px 10px;}
    </style>
</head>
<body style="padding:10px">
 	<div class="l-clear"></div>
 	
 	<fieldset style="border:2px solid #ccc;">
 		<legend style="margin-left:15px;">添加一级部门</legend>
 		<table>
 			<tr>
 				<td>*职位名称:</td>
 				<td><input type="text" id="position" /></td>
 				<td>
 					<div class="liger-button" onclick="addDept();" data-width="100">添加职位</div>
 				</td>
 			</tr>
 		</table>
	</fieldset>
	
    <div id="maingrid" style="margin-top:20px"></div>
    
  	<div style="display:none;">
</div>
</body>
</html>