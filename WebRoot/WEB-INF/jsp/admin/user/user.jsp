<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="xy" uri="/Nohting-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<title> user.jsp </title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="Keywords" content="KeyWords, KeyWords"/>
		<meta name="description" content=""/>
		<meta name="author" content="Nothing"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/tool_css/pageStyle/css.css"/>
		<style type="text/css">
			*{margin:0px;padding:0px;}
			body{font-size:12px;font-family:"微软雅黑";}
			img{border:0px}
			.content_page{width:auto;min-height:712px;border:1px solid #b6c0c9;border-radius:5px;margin:5px 4px 0 5px;}
			.search{margin:5px 0 5px 0}
			.search input{font-family:"微软雅黑";}
			.search .btn{border:0 none;background:#7a929c;border-radius:3px;padding:1px 8px 1px 8px;font-family:"微软雅黑";color:#fff;cursor:pointer;}
		</style>
	</head>
	<body>
		<script type="text/javascript">
			if("${addFlag}" != ""){
				alert("${addFlag}");
			}
			if("${deleteFlag}" != ""){
				alert("${deleteFlag}");
			}
		</script>
		<div class="content_page">
			<div class="search">
				<form action="${pageContext.request.contextPath}/user/getUser.do" method="post">
					用户名：<input type="text" name="searchuser.username" value="${searchuser.username}" id="username"/>&nbsp;&nbsp;
					昵称：<input type="text" name="searchuser.nickname" value="${searchuser.nickname}" id="nickname"/>&nbsp;&nbsp;
					学院：<input type="text" name="searchuser.academe" value="${searchuser.academe}" id="academe"/>&nbsp;&nbsp;
					<input type="button" value="清 空" class="btn" id="resetAll">
					<input type="submit" value="搜 索" class="btn" title="搜索条件为And，与关系"/>
				</form>
			</div>
		
			<table width="100%" border="1" style="border:#c2c6cc 1px solid; border-collapse:collapse;">
				<tr style="background-color:#f5f7fa; color:#1f324d;" align="left" height="25">
					<th>ID</th>
					<th>用户名</th>
					<s:if test="#session.session_user.username=='admin'">
						<th>密码</th>
					</s:if>
					<th>昵称</th>
					<th>邮箱</th>
					<th>性别</th>
					<th>学院</th>
					<th>年级</th>
					<th>爱好</th>
					<th>简介</th>
					<th>角色</th>
					<th colspan="2" align="center">操作</th>
				</tr>
				<s:iterator value="users">
					<tr>
						<td><s:property value="id"/></td>
						<td><s:property value="username"/></td>
						<s:if test="#session.session_user.username=='admin'">
							<td><s:property value="password"/></td>
						</s:if>
						<td><s:property value="nickname"/></td>
						<td><s:property value="email"/></td>
						<td>
							<s:if test="sex==1">男</s:if>
							<s:else>女</s:else>
						</td>
						<td><s:property value="academe"/></td>
						<td><s:property value="grade"/></td>
						<td><s:property value="hobby"/></td>
						<td><s:property value="remark"/></td>
						<td>
							<s:if test="role==1">
								<s:if test="username=='admin'"><font color="red">超级管理员</font></s:if>
								<s:else>普通管理员</s:else>
							</s:if>
							<s:else>普通会员</s:else>
						</td>
						<td align="center"><a href="${pageContext.request.contextPath}/user/updateUserPage.do?updateuser.id=${id}"><img src="${pageContext.request.contextPath}/admin/images/update.gif" width="13" height="13" style="vertical-align:middle;" title="更改"/></a></td>
						<s:if test="username=='admin'">
						</s:if>
						<s:elseif test="username==#session.session_user.username">
						</s:elseif>
						<s:else>
							<td align="center"><a href="${pageContext.request.contextPath}/user/deleteUser.do?deleteId=${id}" onclick="return confirm('你确定要删除？')"><img src="${pageContext.request.contextPath}/admin/images/delete.png" width="13" height="13" style="vertical-align:middle;" title="删除"/></a></td>
						</s:else>
					</tr>				
				</s:iterator>
			</table>
			<div style="margin-top:10px;">
	     		<xy:pager pageIndex="${pageModel.pageIndex}" 
	     				  pageSize="${pageModel.pageSize}" 
	     				  recordCount="${pageModel.recordCount}" 
	     				  submitUrl="${pageContext.request.contextPath}/user/getUser.do?pageModel.pageIndex={0}" />
            </div>
		</div>
		<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery-1.8.0.js"></script>
		<script type="text/javascript">
			$("#resetAll").click(function(){
				$("#username").val("");
				$("#nickname").val("");
				$("#academe").val("");
			});
		</script>
	</body>
</html>