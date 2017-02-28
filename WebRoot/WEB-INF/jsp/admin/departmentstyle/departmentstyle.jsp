<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="xy" uri="/Nohting-tags"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title> departmentstyle.html </title>
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
		<table width="100%" border="1" style="border:#c2c6cc 1px solid; border-collapse:collapse; table-layout:fixed;">
			<tr style="background-color:#f5f7fa; color:#1f324d;" align="left">
				<th>ID</th>
				<th>协会组成</th>
				<th>简介</th>
				<th colspan="2" align="center">操作</th>
			</tr>
			<tr>
				<td>1</td>
				<td>协会简介</td>
				<td style="word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;"><s:property value="xxjj_about_dg.about"/></td>
				<td align="center"><a href="${pageContext.request.contextPath}/bmfc/subZcPage.do?zc=xhjj">下一级</a></td>
				<td align="center"><a href="${pageContext.request.contextPath}/bmfc/updateZcPage.do?id=${xxjj_about_dg.id}"><img src="${pageContext.request.contextPath}/admin/images/update.gif" width="13" height="13" style="vertical-align:middle;" title="更改"/></a></td>
			</tr>
			<tr>
				<td>2</td>
				<td>办公室</td>
				<td style="word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;"><s:property value="bgs_about_dg.about"/></td>
				<td align="center"><a href="${pageContext.request.contextPath}/bmfc/subZcPage.do?zc=bgs">下一级</a></td>
				<td align="center"><a href="${pageContext.request.contextPath}/bmfc/updateZcPage.do?id=${bgs_about_dg.id}"><img src="${pageContext.request.contextPath}/admin/images/update.gif" width="13" height="13" style="vertical-align:middle;" title="更改"/></a></td>
			</tr>
			<tr>
				<td>3</td>
				<td>技术部</td>
				<td style="word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;"><s:property value="jsb_about_dg.about"/></td>
				<td align="center"><a href="${pageContext.request.contextPath}/bmfc/subZcPage.do?zc=jsb">下一级</a></td>
				<td align="center"><a href="${pageContext.request.contextPath}/bmfc/updateZcPage.do?id=${jsb_about_dg.id}"><img src="${pageContext.request.contextPath}/admin/images/update.gif" width="13" height="13" style="vertical-align:middle;" title="更改"/></a></td>
			</tr>
			<tr>
				<td>4</td>
				<td>外联部</td>
				<td style="word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;"><s:property value="wlb_about_dg.about"/></td>
				<td align="center"><a href="${pageContext.request.contextPath}/bmfc/subZcPage.do?zc=wlb">下一级</a></td>
				<td align="center"><a href="${pageContext.request.contextPath}/bmfc/updateZcPage.do?id=${wlb_about_dg.id}"><img src="${pageContext.request.contextPath}/admin/images/update.gif" width="13" height="13" style="vertical-align:middle;" title="更改"/></a></td>
			</tr>
			<tr>
				<td>5</td>
				<td>组织部</td>
				<td style="word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;"><s:property value="zzb_about_dg.about"/></td>
				<td align="center"><a href="${pageContext.request.contextPath}/bmfc/subZcPage.do?zc=zzb">下一级</a></td>
				<td align="center"><a href="${pageContext.request.contextPath}/bmfc/updateZcPage.do?id=${zzb_about_dg.id}"><img src="${pageContext.request.contextPath}/admin/images/update.gif" width="13" height="13" style="vertical-align:middle;" title="更改"/></a></td>
			</tr>
		</table>
		<div style="margin-bottom:10px;margin-top:10px;">
	   		<xy:pager pageIndex="${pageModel.pageIndex}" 
	   				  pageSize="${pageModel.pageSize}" 
	   				  recordCount="${pageModel.recordCount}" 
   				  	submitUrl="${pageContext.request.contextPath}/xhjj/introduce_ht.do?pageModel.pageIndex={0}" />
         </div>
	</div>
</body>
</html>
