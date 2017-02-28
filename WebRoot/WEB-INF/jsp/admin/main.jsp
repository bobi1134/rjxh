<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title> 后台管理系统-四川农业大学软件协会 </title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="Keywords" content="KeyWords, KeyWords"/>
	<meta name="description" content=""/>
	<meta name="author" content="Nothing"/>
	<link rel="Bookmark"  type="image/x-icon"  href="${pageContext.request.contextPath}/rx/images/favicon.ico"/>
<link rel="icon"  type="image/x-icon" href="${pageContext.request.contextPath}/rx/images/favicon.ico" />  
<link rel="shortcut icon"  type="image/x-icon" href="${pageContext.request.contextPath}/rx/images/favicon.ico" />   
</head>
	<frameset rows="103,*,1" frameborder="no">
		<frame src="${pageContext.request.contextPath}/user/top.do" scrolling="no" noresize="noresize"/>
		<frameset cols="200,*">
			<frame src="${pageContext.request.contextPath}/user/left.do" scrolling="no" noresize="noresize" />
			<frameset rows="*,22">				
				<frame src="${pageContext.request.contextPath}/user/content.do" scrolling="yes" noresize="noresize" marginwidth="0" name="content"/>
				<frame src="${pageContext.request.contextPath}/user/content_bottom.do" scrolling="no" noresize="noresize" />
			</frameset>
		</frameset>
		<frame src="${pageContext.request.contextPath}/user/bottom.do" scrolling="no" noresize="noresize" />
	</frameset>
</html>
