<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="xy" uri="/Nohting-tags"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title> tz.html </title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="Keywords" content="KeyWords, KeyWords"/>
	<meta name="description" content=""/>
	<meta name="author" content="Nothing" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/tool_css/pageStyle/css.css"/>
	<style type="text/css">
		*{margin:0px;padding:0px;}
		body{font-size:12px;font-family:"微软雅黑";}
		.content_page{width:auto;height:712px;border:1px solid #b6c0c9;border-radius:5px;margin:5px 4px 0 5px;}
	</style>
	<script type="text/javascript">
		if("${addFlag}"!=""){
			if("${addFlag}"=="success"){
				alert("添加成功！");
			}else{
				alert("添加失败！");
			}
		}
	</script>
</head>
<body>
	<div class="content_page">
	<span class="tipInfo"><marquee>${session_user.nickname}管理员，你好！在操作栏下面，您可以对论坛设置置顶帖！后续会增加，过滤违规发帖内容、关小黑屋功能，敬请期待！</marquee></span>
		<table width="100%" border="1" style="border:#c2c6cc 1px solid; border-collapse:collapse; width:100%; table-layout:fixed;">
			<tr style="background-color:#f5f7fa; color:#1f324d;" align="left" height="25">
				<th>ID</th>
				<th>标题</th>
				<th>内容</th>
				<th>日期</th>
				<th>发帖人</th>
				<th colspan="2" align="center">操作</th>
			</tr>
			<s:iterator value="tzs">
				<tr>
					<td><s:property value="id"/></td>
					<td style="word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;"><s:property value="title"/></td>
					<td style="word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;"><s:property value="message"/></td>
					<td><s:date name="date" format="yyyy-MM-dd HH:mm:ss"/></td>
					<td>
						<s:if test="user.nickname==''">
							<s:property value="user.username"/>
						</s:if>
						<s:else>
							<s:property value="user.nickname"/>
						</s:else>
					</td>
					<td align="center">
						<s:if test="zd==1">
							<a href="${pageContext.request.contextPath}/bbs/qxZd.do?id=${id}"><img src="${pageContext.request.contextPath}/rx/images/zding.gif" width="31" height="17" style="vertical-align:middle;" title="取消置顶"/></a>
						</s:if>
						<s:else>
							<a href="${pageContext.request.contextPath}/bbs/szZd.do?id=${id}"><img src="${pageContext.request.contextPath}/rx/images/qx.jpg" width="31" height="17" style="vertical-align:middle;" title="置顶"/></a>
						</s:else>
					</td>
					<td align="center"><a href="${pageContext.request.contextPath}/bbs/deleteTz.do?id=${id}" onclick="return confirm('你确定要删除？')"><img src="${pageContext.request.contextPath}/admin/images/delete.png" width="13" height="13" style="vertical-align:middle;" title="删除"/></a></td>
				</tr>
			</s:iterator>
		</table>
		<div style="margin-bottom:10px;margin-top:10px;">
	   		<xy:pager pageIndex="${pageModel.pageIndex}" 
	   				  pageSize="${pageModel.pageSize}" 
	   				  recordCount="${pageModel.recordCount}" 
   				  	submitUrl="${pageContext.request.contextPath}/hotanswer/hotanswer_ht.do?pageModel.pageIndex={0}" />
         </div>
	</div>
</body>
</html>
