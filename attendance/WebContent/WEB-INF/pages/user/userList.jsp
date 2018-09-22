<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp" %>
<!doctype html>
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
		var AdminData;
		$.ajax({
			type : "post",
			url : "${ctx}/listAdminDto",
			dataType : "json",
			success : function(data){
				AdminData = data;
			},
			async : false
		});
        $(f_initGrid);
        var manager, g;
        function f_initGrid()
        {
            $("#maingrid").ligerGrid({
                columns: [
                { display: '编号', name: 'adminid', width: 50},
                { display: '名称', name: 'adminaccount', width: 100},
                { display: '角色', name: 'adminright', width: 100},
                { display: '操作', name: 'adminid', isSort: false, render: function (rowdata, rowindex, value)
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
                data: AdminData, // 数据在这里===========================
                width: '100%'
            });
        }
        function deleteRow(rowid) // 删除用户
        {
            $.ligerDialog.confirm('确定删除?', function (yes)
            {
            	if (yes == false) {
            		return false;
            	}
            	$.ajax({
                	type : "post",
                	url : "${ctx}/deleteAdmin",
                	data : {"adminid" : rowid},
        			dataType : "json",
        			success : function(data){
        				if (data.flag == 1) {
        					$.ligerDialog.success('删除成功!', function(){
        						$.ajax({
        							type : "post",
        							url : "${ctx}/listAdminDto",
        							dataType : "json",
        							success : function(data){
        								AdminData = data;
        							},
        							async : false
        						});
        						f_initGrid();
        					});
        				} else {
        					$.ligerDialog.error('删除失败,请联系系统管理员!');
        				}
        			}
        		});
            });
        }
        function addUser() // 添加用户
        {
        	var name = $("#name").val();
        	if (name == "") {
        		$.ligerDialog.error("员工名称不能为空!");
        		return false;
        	}
        	
        	// 添加员工
        	var adminData = $("#adminForm").serialize();
        	$.ajax({
        		type : "post",
        		url : "${ctx}/insertAdmin",
        		data : adminData,
        		dataType : "json",
        		success : function(data) {
        			if (data.flag == 1) {
        				$.ligerDialog.success('添加成功!', function(){
    						$.ajax({
    							type : "post",
    							url : "${ctx}/listAdminDto",
    							dataType : "json",
    							success : function(data){
    								AdminData = data;
    							},
    							async : false
    						});
    						f_initGrid();
    					});
        			} else {
        				$.ligerDialog.error("添加员工失败，请联系系统管理员!");
        			}
        		}
        	});
        }
        function f_update(index) // 修改用户
        {
            $.ligerDialog.open({title:"修改用户信息", width: 400, height: 240, url: '${ctx}/gotoAdminEdit?adminid='+index, showMax: true, showMin: true, isResize: true, slide: false }); 
        }
    </script>
    <style type="text/css">
    	table{margin:auto;}
    	table tr td{padding:8px 4px 0 10px;}
    </style>
</head>
<body style="padding:10px">
 	<div class="l-clear"></div>
 	<fieldset style="border:2px solid #ccc;">
 		<legend style="margin-left:15px;">添加用户信息</legend>
	 	<form id="adminForm">
	 		<table>
	 			<tr>
	 				<td style="text-align:right;">名称：</td>
	 				<td>
	 					<input class="liger-textbox" type="text" id="name" name="adminaccount" />
	 				</td>
	 			</tr>
	 			<tr>
	 				<td style="text-align:right;">是否是超级管理员：</td>
	 				<td>
	 					<input type="radio" name="adminright" value="1" /> 超级管理员
	 					<input type="radio" name="adminright" value="0" checked /> 考勤员
	 				</td>
	 			</tr>
	 			<tr>
	 				<td colspan="2" style="padding:10px 0 10px 0">
	 					<div style="margin-left:86px;" class="liger-button" onclick="addUser();" data-width="90px">添加用户</div>
	 				</td>
	 			</tr>
	 		</table>
	 	</form>
	 </fieldset>
    <div id="maingrid" style="margin-top:20px"></div>
    
  	<div style="display:none;">
</div>
</body>
</html>