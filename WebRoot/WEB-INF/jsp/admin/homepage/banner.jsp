<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title> banner.html </title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="Keywords" content="KeyWords, KeyWords"/>
	<meta name="description" content=""/>
	<meta name="author" content="Nothing" />
	<style type="text/css">
		*{margin:0px;padding:0px;}
		body{font-size:12px;font-family:"微软雅黑";}
		img{border:0}
		.main{width:auto;border:1px solid #b6c0c9;border-radius:5px;margin:5px 4px 0 5px;}
		.addBtn{background:#7a929c;border-radius:3px;padding:1px 8px 1px 8px;color:#fff;margin:5px 0px 5px 0px;display:block;width:30px;text-align:center;height:22px;line-height:22px;text-decoration:none}
	</style>
	<script type="text/javascript">
		if("${updateFlag}"!=""){
			if("${updateFlag}"=="success"){
				alert("修改成功！");
			}else{
				alert("修改失败！");
			}
		}
		if("${deleteFlag}"!=""){
			if("${deleteFlag}"=="success"){
				alert("删除成功！");
			}else{
				alert("删除失败！");
			}
		}
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
	<div class="main">
		<a href="${pageContext.request.contextPath}/homepage/addBannerPage.do" class="addBtn" target="content">添 加</a>
		<table width="100%" border="1" style="border:#c2c6cc 1px solid; border-collapse:collapse;">
			<tr style="background-color:#f5f7fa; color:#1f324d;" align="left" height="25">
				<th>ID</th>
				<th align="center">图片</th>
				<th>标题</th>
				<th colspan="2">操作</th>
			</tr>
			<s:iterator value="banners">
				<tr>
					<td><s:property value="id"/></td>
					<td align="center"><img src="${pageContext.request.contextPath}/rx/images/<s:property value="image"/>"  width="400" height="150"/></td>
					<td><s:property value="title"/></td>
					<td align="center"><a href="${pageContext.request.contextPath}/homepage/updateBannerPage.do?id=${id}"><img src="${pageContext.request.contextPath}/admin/images/update.gif" width="13" height="13" style="vertical-align:middle;" title="更改"/></td>
					<td align="center"><a href="${pageContext.request.contextPath}/homepage/deleteBanner.do?id=${id}" onclick="return confirm('你确定要删除？')"><img src="${pageContext.request.contextPath}/admin/images/delete.png" width="13" height="13" style="vertical-align:middle;" title="删除"/></a></td>
				</tr>
			</s:iterator>
		</table>
	</div>
</body>
</html>
