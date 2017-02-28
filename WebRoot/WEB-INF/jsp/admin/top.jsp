<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title> top.html </title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="Keywords" content="KeyWords, KeyWords"/>
	<meta name="description" content=""/>
	<meta name="author" content="Nothing"/>
	<style type="text/css">
		*{margin:0px;padding:0px;}
		body{font-size:12px;font-family:"微软雅黑";background:url(${pageContext.request.contextPath}/admin/images/bg.jpg)}
		a{text-decoration:none;color:#7adce5;}
		a:hover{color:#92afcd}

		.top_page .right{float:right;}
		.top_page .right .r_1{margin-top:48px;  margin-left:333px;}
		.top_page .right .r_2{height:23px;  margin-right: 45px;  margin-top: 9px;}
		.top_page .right .r_2 .part_1{width:43px;height:22px;background:url(${pageContext.request.contextPath}/admin/images/left.jpg);float:left;margin-top: 1px;}
		.top_page .right .r_2 .center{height:22px;background:url(${pageContext.request.contextPath}/admin//images/center.jpg);float:left;margin-top: 1px;line-height:22px;padding-le}
		.top_page .right .r_2 .part_2{width:40px;height:22px;background:url(${pageContext.request.contextPath}/admin//images/right.jpg);float:left;  margin-top: 1px}
	</style>
</head>
	<body>
		<div class="top_page">
			<img src="${pageContext.request.contextPath}/admin/images/logo.jpg" width="519" height="103"/>
			<div class="right">
				<div class="r_1">
					<a href="${pageContext.request.contextPath}">网站首页</a>&nbsp;&nbsp;<font style="color:#fff;">|</font>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/user/loginout.do">安全退出</a>
				</div>
				<div class="r_2">
					<div class="part_1"></div>
					<div class="center">
						<span class="span_1">当前登陆：【<a href="${pageContext.request.contextPath}/user/updateUserPage.do?updateuser.id=${session_user.id}&self=self" target="content"><span style="color:red">${session_user.nickname}</span></a>】，您属于：<s:if test="#session.session_user.username=='admin'"><font color="red">超级管理员</font></s:if><s:else><font color="red">普通管理员</font></s:else></span>&nbsp;&nbsp;
						<span class="span_2">Time：<span id="nowTime">2015-05-22 12:12:12</span></span>
					</div> 
					<div class="part_2"></div>
				</div>
			</div>
		</div>
		<script type="text/javascript">
		function doSomething(time){
	  		i = parseInt(time);
	  		if( i / 10 < 1){
	  			i = "0" + i;
	  		}
	  		return i;
	  	}
	    function setDate() {
			var date = new Date();
			var year = date.getFullYear();
			nowDate1 = year + "-" + doSomething((date.getMonth() + 1)) + "-" + doSomething(date.getDate())+"  ";
			nowDate1 += doSomething(date.getHours()) + ":" + doSomething(date.getMinutes()) + ":" + doSomething(date.getSeconds());
			document.getElementById("nowTime").innerHTML = nowDate1;
			setTimeout('setDate()', 1000);
		}
	  	setDate();
	</script>
	</body>
</html>
