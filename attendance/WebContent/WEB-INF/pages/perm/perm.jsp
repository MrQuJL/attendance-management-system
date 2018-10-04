<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp" %>
<% String path = request.getContextPath(); %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>权限管理</title>
	<link href="${ctx}/lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/lib/jquery-ztree/3.5.12/css/zTreeStyle/zTreeStyle.min.css" rel="stylesheet" type="text/css"/>
	<link href="${ctx}/css/select2.min.css" rel="stylesheet" type="text/css" />
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
    <script type="text/javascript" src="${ctx}/lib/jquery-ztree/3.5.12/js/jquery.ztree.all-3.5.min.js"></script>
    <script type="text/javascript" src="${ctx}/lib/select2.min.js"></script>
    <style type="text/css">
    	table tr td{padding:5px 4px 0 10px;}
    </style>
</head>
<body>
	<div class="l-clear"></div>
	<table>
		<tr>
			<td>考勤员列表：</td>
			<td>
				<select id="adminList" style="width:120px;">
					<option value="">--请选择--</option>
					<c:forEach items="${workerList}" var="worker">
						<option value="${worker.adminid}">${worker.adminaccount}</option>
					</c:forEach>
				</select>
			</td>
			<td>
				<input class="liger-button" type="button" value="保存" onclick="save();" />
			</td>
		</tr>
	</table>
	<div id="container" class="ztree" style="width:400px;height:400px;margin: 6px 0 0 6px;">
		
	</div>
<script type="text/javascript">
	var tree;
	function getPermission() { // 选择考勤员时触发该函数
		if ($("#adminList").val() == "") {
			$("#container").html("");
			return false;
		}
		
		// 初始化zTree的参数
		var setting = {check:{enable:true,nocheckInherit:true},view:{selectedMulti:false},
			data:{simpleData:{enable:true}},callback:{beforeClick:function(id, node){
				tree.checkNode(node, !node.checked, true, true);
				return false;
			}}};
	    /*zNodes数据格式
	    	[{'id':'1','pId':'2','name':'部门'},
	    	 {'id':'1','pId':'2','name':'部门'},
	    	 {'id':'1','pId':'2','name':'部门'}
	    	]*/
	    var zNodes;
	    var checkeds;
	    // 查询出所有的部门列表以及需要默认选择的节点
		$.ajax({
			type : "post",
			url : "${ctx}/listDeptTree",
			data : {"workerId" : $("#adminList").val()},
			dataType : "json",
			success : function(data){
				zNodes = data.tree;
				checkeds = data.checkeds;
			},
			async: false
		});
		// 初始化树结构
		tree = $.fn.zTree.init($("#container"), setting, zNodes);
		// 默认选择节点
		for (var i = 0; i < checkeds.length; i++) {
			var node = tree.getNodeByParam("id",checkeds[i]);
			try{tree.checkNode(node, true, false);}catch(e){}
		}
		
		// 默认展开全部节点
		tree.expandAll(true);
	}
	$("#adminList").change(function(){
		getPermission();
	});
	// 保存对权限的修改
	function save() {
		// 1.获取选中的checkbox
		var deptIds = [], nodes = tree.getCheckedNodes(true);
		// 2.组成数组
		for(var i=0; i<nodes.length; i++) {
			deptIds.push(nodes[i].id);
		}
		// 3.向后台发送请求
		$.ajax({
			type : "post",
			url : "${ctx}/savePerm",
			data : {"deptIds" : JSON.stringify(deptIds), "adminId" : $("#adminList").val()},
			dataType : "json",
			success : function(data) {
				if (data.flag == true) {
					$.ligerDialog.success("保存用户权限成功!");
				} else {
					$.ligerDialog.error("保存用户权限失败!");
				}
			}
		});
	}
	// 初始化select2控件
	$("#adminList").select2();
</script>
</body>
</html>