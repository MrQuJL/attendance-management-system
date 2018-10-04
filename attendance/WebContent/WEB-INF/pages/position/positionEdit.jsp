<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>职位修改</title>
    <link href="${ctx}/lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${ctx}/lib/jquery/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="${ctx}/lib/json2.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/core/base.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/plugins/ligerForm.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/plugins/ligerDateEditor.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/plugins/ligerComboBox.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/plugins/ligerCheckBox.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/plugins/ligerButton.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/plugins/ligerDialog.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/plugins/ligerRadio.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/plugins/ligerTextBox.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/plugins/ligerGrid.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/plugins/ligerSpinner.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/plugins/ligerTextBox.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/plugins/ligerTip.js"></script>
    <script type="text/javascript" src="${ctx}/lib/jquery/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="${ctx}/lib/ligerUI/js/ligerui.min.js"></script>
    <script type="text/javascript">
		function update() {
			$.ajax({
				type : "post",
				url : "${ctx}/updatePosition",
				data : {"positionid" : $("#positionId").val(), "positionname" : $("#positionName").val()},
				dataType : "json",
				success : function(data) {
					if (data.flag == 1) {
						$.ligerDialog.success('修改成功!', function(){
							$.ajax({
				    			type : "post",
				    			url : "${ctx}/listPosition",
				    			dataType : "json",
				    			success : function(data){
				    				window.parent.EmployeeData = data;
				    			}
				    		});
				            window.parent.location.reload();
						});
					} else {
						$.ligerDialog.error('修改失败,请联系系统管理员!');
					}
				}
			});
		}
	</script>
    <style type="text/css">
        body{ font-size:12px;}
        table{margin:auto;}
    	table tr td{padding:8px 4px 8px 10px;}
    </style>
</head>
<body style="background: white; font-size: 12px;"> 
	<div class="l-clear"></div>
	<fieldset style="border:2px solid #ccc;">
 		<legend style="margin-left:15px;">修改职位信息</legend>
	    <form>
	    	<table>
	    		<tr>
	    			<td>职位名称：</td>
	    			<td>
	    				<input type="hidden" id="positionId" name="positionId" value="${positionid}" />
	    				<input type="text" id="positionName" name="positionName" value="${positionname}" />
	    			</td>
	    			<td>
	    				<input type="button" value="修改职位" onclick="update();" class="liger-button" />
	    			</td>
	    		</tr>
	    	</table>
	    </form>
	</fieldset>
</body>
</html>