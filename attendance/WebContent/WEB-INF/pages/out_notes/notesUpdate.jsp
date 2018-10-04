<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp" %>
<!doctype html>
<html>
<head>
    <title>修改单据</title>
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
    	.right{text-align:right;}
    	#noteTab tr td{padding-top:10px;padding-left:10px;}
    </style>
</head>
<body style="padding:10px">
 	<div class="l-clear"></div>
	<fieldset title="修改出差单" style="border:2px solid #ccc;">
		<legend style="margin-left:16px;">修改出差单</legend>
		<form>
			<table id="noteTab" cellpadding="10px" cellspacing="10px">
				<tr>
					<td class="right">申请人：</td>
					<td>
						<input id="noteid" type="hidden" value="${notes.noteid}" />
						<select style="width:120px;" id="employeeid" name="employeeid">
							<c:forEach items="${empList}" var="emp">
								<c:choose>
									<c:when test="${emp.employeeid == notes.employeeid}">
										<option selected="selected" value="${emp.employeeid}">${emp.employeename}</option>
									</c:when>
									<c:otherwise>
										<option value="${emp.employeeid}">${emp.employeename}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="right">代理人：</td>
					<td>
						<select style="width:120px;" id="proxyid" name="proxyid">
							<c:forEach items="${empList}" var="emp">
								<c:choose>
									<c:when test="${emp.employeeid == notes.proxyid}">
										<option selected="selected" value="${emp.employeeid}">${emp.employeename}</option>
									</c:when>
									<c:otherwise>
										<option value="${emp.employeeid}">${emp.employeename}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="right">填表日期：</td>
					<td>
						<input id="fillintime" type="text" value="${notes.fillintime}" />
					</td>
				</tr>
				<tr>
					<td class="right">出差事由：</td>
					<td>
						<textarea id="cause" rows="3" cols="30">${notes.cause}</textarea>
					</td>
				</tr>
				<tr>
					<td class="right">请假起始时间：</td>
					<td>
						<input id="startdate" type="text" value="${notes.startdate}" />
						<script type="text/javascript">
							$("#startdate").ligerGetDateEditorManager().setValue("${notes.startdate}");
						</script>
					</td>
					<td style="position:relative;left:-66px;">
						<select style="width:120px;" id="starttime" name="starttime">
							<c:choose>
								<c:when test="${notes.starttime == 2}"> <!-- 下午 -->
									<option value="1">上午</option>
									<option value="2" selected="selected">下午</option>
								</c:when>
								<c:otherwise>
									<option value="1" selected="selected">上午</option>
									<option value="2">下午</option>
								</c:otherwise>
							</c:choose>
						</select>
					</td>
				</tr>
				<tr>
					<td class="right">请假截止时间：</td>
					<td>
						<input id="enddate" type="text" value="${notes.enddate}" />
						<script type="text/javascript">
							$("#enddate").ligerGetDateEditorManager().setValue("${notes.enddate}");
						</script>
					</td>
					<td style="position:relative;left:-66px;">
						<select style="width:120px;" id="endtime" name="endtime">
							<c:choose>
								<c:when test="${notes.endtime == 2}"> <!-- 下午 -->
									<option value="1">上午</option>
									<option value="2" selected="selected">下午</option>
								</c:when>
								<c:otherwise>
									<option value="1" selected="selected">上午</option>
									<option value="2">下午</option>
								</c:otherwise>
							</c:choose>
						</select>
					</td>
				</tr>
				<tr>
					<td class="right">主管经理意见：</td>
					<td>
						<textarea id="directorsign" rows="3" cols="30">${notes.directorsign}</textarea>
					</td>
				</tr>
				<tr>
					<th colspan="3" style="padding:10px 0 10px 0;">
						<input class="liger-button" style="margin-left:228px;" onclick="updateNotes();" type="button" value="修改" />
						<input class="liger-button" type="button" value="返回" onclick="cancel();" />
					</th>
				</tr>
			</table>
		</form>
	</fieldset>
  	<div style="display:none;">
</div>
<script type="text/javascript">
	// 初始化日期控件
	$("#fillintime").ligerDateEditor();
	$("#startdate").ligerDateEditor();
	$("#enddate").ligerDateEditor();
	
	// 设置日期
	$("#fillintime").ligerGetDateEditorManager().setValue(transDateOnlyDay("${notes.fillintime}"));
	$("#startdate").ligerGetDateEditorManager().setValue(transDateOnlyDay("${notes.startdate}"));
	$("#enddate").ligerGetDateEditorManager().setValue(transDateOnlyDay("${notes.enddate}"));
	
	$("#employeeid").select2();
	$("#notetypeid").select2();
	$("#proxyid").select2();
	$("#starttime").select2();
	$("#endtime").select2();
	
	function updateNotes() {
		// 1.获取值
		var noteid = $("#noteid").val();
		var employeeid = $("#employeeid").val();
		var proxyid = $("#proxyid").val();
		var notetypeid = $("#notetypeid").val();
		var fillintime = $("#fillintime").val();
		var cause = $("#cause").val();
		var startdate = $("#startdate").val();
		var starttime = $("#starttime").val();
		var enddate = $("#enddate").val();
		var endtime = $("#endtime").val();
		var directorsign = $("#directorsign").val(); // 主管
		var administrationsign = ""; // 行政部经理
		var presidentsign = ""; // 总裁审批
		
		var notes = {};
		notes.noteid = noteid;
		notes.employeeid = employeeid;
		notes.proxyid = proxyid;
		notes.notetypeid = notetypeid;
		notes.fillintime = fillintime;
		notes.cause = cause;
		notes.startdate = startdate;
		notes.starttime = starttime;
		notes.enddate = enddate;
		notes.endtime = endtime;
		notes.directorsign = directorsign;
		notes.administrationsign = administrationsign;
		notes.presidentsign = presidentsign;
		
		// 2.发送请求
		$.ajax({
			type : "post",
			url : "${ctx}/updateOutNotes",
			data : notes,
			dataType : "json",
			success : function(data){
				if (data.flag == true) {
					$.ligerDialog.success('修改单据成功!',function(){
						parent.location.reload();
					});
				} else {
					$.ligerDialog.success('添加单据失败，请联系系统管理员!');
				}
			}
		});
	}
	
	// 取消添加
	function cancel() {
		parent.location.reload();
	}
</script>
</body>
</html>