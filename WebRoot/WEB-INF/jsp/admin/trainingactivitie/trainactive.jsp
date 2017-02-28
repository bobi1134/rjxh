<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="xy" uri="/Nohting-tags"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title> trainactive.html </title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="Keywords" content="KeyWords, KeyWords"/>
	<meta name="description" content=""/>
	<meta name="author" content="Nothing" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/tool_css/pageStyle/css.css"/>
	<style type="text/css">
		*{margin:0px;padding:0px;}
		body{font-size:12px;font-family:"微软雅黑";}
		img{border:0}
		.main{width:auto;min-height:712px;border:1px solid #b6c0c9;border-radius:5px;margin:5px 4px 0 5px;}
		.addBtn{float:left;background:#7a929c;border-radius:3px;padding:1px 8px 1px 8px;color:#fff;margin:5px 0px 5px 0px;display:block;width:30px;text-align:center;height:22px;line-height:22px;text-decoration:none}
		.tipInfo{padding:1px 8px 1px 0px;margin:5px 0px 5px 0px;display:block;float:right;}
	</style>
	<script type="text/javascript">
		if("${addFlag}"!=""){
			if("${addFlag}"=="success"){
				alert("添加成功！");
			}else{
				alert("添加失败！");
			}
		}
		if("${updateFlag}"!=""){
			if("${updateFlag}"=="success"){
				alert("修改成功！");
			}else{
				alert("修改失败！");
			}
		}
	</script>
</head>
<body>
	<div class="main">
		<a href="${pageContext.request.contextPath}/trainactive/addTrainactiverPage.do" class="addBtn" target="content">添 加</a>
		<a href="${pageContext.request.contextPath}/trainactive/trainactive_ht.do?px=px" class="addBtn" target="content" style="margin-left:4px;">排 序</a>
		<span class="tipInfo"><marquee>${session_user.nickname}管理员，你好！在操作栏下面，您可以对首页的【培训与活动】模块显示的内容进行设置！注意：单个模块首页只能显示6条，你可以重新排序查看！</marquee></span>
		<table width="100%" border="1" style="border:#c2c6cc 1px solid; border-collapse:collapse; width:100%; table-layout:fixed;">
			<tr style="background-color:#f5f7fa; color:#1f324d;" align="left" height="25">
				<th>ID</th>
				<th>标题</th>
				<th>内容</th>
				<th>创建日期</th>
				<th colspan="3" align="center">操作</th>
			</tr>
			<s:iterator value="trainActives">
				<tr>
					<td><s:property value="id"/></td>
					<td style="word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;"><s:property value="title"/></td>
					<td style="word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;"><s:property value="content"/></td>
					<td><s:date name="date" format="yyyy-MM-dd HH:mm:ss"/></td>
					<s:if test="sy==1">
						<td align="center"><a href="${pageContext.request.contextPath}/trainactive/szsyTrainactive.do?id=${id}&sy=${sy}"><img src="${pageContext.request.contextPath}/admin/images/sy_1.jpg" width="15" height="15" style="vertical-align:middle;border-radius:10px" title="取消首页显示"/></a></td>
					</s:if>
					<s:else>
						<td align="center"><a href="${pageContext.request.contextPath}/trainactive/qxsyTrainactive.do?id=${id}&sy=${sy}"><img src="${pageContext.request.contextPath}/admin/images/sy_2.jpg" width="15" height="15" style="vertical-align:middle;border-radius:10px" title="设置首页显示"/></a></td>
					</s:else>
					<td align="center"><a href="${pageContext.request.contextPath}/trainactive/updateTrainactivePage.do?id=${id}"><img src="${pageContext.request.contextPath}/admin/images/update.gif" width="13" height="13" style="vertical-align:middle;" title="更改"/></a></td>
					<td align="center"><a href="${pageContext.request.contextPath}/trainactive/deleteTrainactive.do?id=${id}" onclick="return confirm('你确定要删除？')"><img src="${pageContext.request.contextPath}/admin/images/delete.png" width="13" height="13" style="vertical-align:middle;" title="删除"/></a></td>
				</tr>
			</s:iterator>
		</table>
		<div style="margin-bottom:10px;margin-top:10px;">
	   		<xy:pager pageIndex="${pageModel.pageIndex}" 
	   				  pageSize="${pageModel.pageSize}" 
	   				  recordCount="${pageModel.recordCount}" 
   				  	submitUrl="${pageContext.request.contextPath}/trainactive/trainactive_ht.do?pageModel.pageIndex={0}" />
         </div>
	</div>
</body>
</html>
