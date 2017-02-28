<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title> contact.html </title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="Keywords" content="KeyWords, KeyWords"/>
	<meta name="description" content=""/>
	<meta name="author" content="Nothing" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/tool_css/pageStyle/css.css"/>
	<style type="text/css">
		*{margin:0px;padding:0px;}
		body{font-size:12px;font-family:"微软雅黑";}
		.content_page{width:auto;min-height:712px;border:1px solid #b6c0c9;border-radius:5px;margin:5px 4px 0 5px;}
		.addBtn{float:left;background:#7a929c;border-radius:3px;padding:1px 8px 1px 8px;color:#fff;margin:5px 0px 5px 5px;display:block;text-align:center;height:22px;line-height:22px;text-decoration:none}
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
	<div class="content_page">
		<a href="${pageContext.request.contextPath}/lxwm/addFlPage.do" class="addBtn" target="content">添加分类</a>
		<a href="${pageContext.request.contextPath}/lxwm/addBtPage.do" class="addBtn" target="content">添加标题</a>
		<table width="100%" border="1" style="border:#c2c6cc 1px solid; border-collapse:collapse; table-layout:fixed;">
			<tr style="background-color:#f5f7fa; color:#1f324d;" align="left">
				<th>ID</th>
				<th>分类</th>
				<th>标题</th>
				<th>内容</th>
				<th colspan="2" align="center">操作</th>
			</tr>
			<s:iterator value="contacts">
				<tr>
					<td><s:property value="id"/></td>
					<td><s:property value="category"/></td>
					<td><s:property value="contactSub.title"/></td>
					<td style="word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;"><s:property value="contactSub.content"/></td>
					<td align="center"><a href="${pageContext.request.contextPath}/lxwm/updateContactPage.do?id=${contactSub.id}"><img src="${pageContext.request.contextPath}/admin/images/update.gif" width="13" height="13" style="vertical-align:middle;" title="更改"/></a></td>
					<td align="center"><a href="${pageContext.request.contextPath}/lxwm/deleteSubContact.do?id=${contactSub.id}&belongId=${contactSub.belongId}" onclick="return confirm('你确定要删除？')"><img src="${pageContext.request.contextPath}/admin/images/delete.png" width="13" height="13" style="vertical-align:middle;" title="删除"/></a></td>
				</tr>
			</s:iterator>
		</table>
	</div>
</body>
</html>
