<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
	<title>软件协会—用户注册</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="description" content="川农软件协会网站" />
	<meta name="keywords" content="软件协会，川农" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/rx/css/reset.css" type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/rx/css/all.css" type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/rx/css/sub.css" type="text/css" />
	<link rel="Bookmark"  type="image/x-icon"  href="${pageContext.request.contextPath}/rx/images/favicon.ico"/>
	<link rel="icon"  type="image/x-icon" href="${pageContext.request.contextPath}/rx/images/favicon.ico" />  
	<link rel="shortcut icon"  type="image/x-icon" href="${pageContext.request.contextPath}/rx/images/favicon.ico" />
	<!-- login css -->
	<style type="text/css">
		.login{font-size:12px;width:1000px;height:400px;border:1px dotted #d5d5d5;font-family:"微软雅黑";float:left;;}
		.login .l_main{width:500px;height:220px;border:1px dotted #d5d5d5;margin:90px auto;}
		.login .l_main label{width:200px;display:inline-block;margin-top:30px;text-align:center}
		.login .l_main input{width:200px;padding:0 5px 0 5px}
		.login .l_main .button{width:333px;height:30px;display:block;margin:20px auto;text-align:center;line-height:30px;font-size:16px;background-color:#eee;border-radius:5px;cursor:pointer;font-family:"微软雅黑";outline:none;border: 0 none;color:#666}
		.login .l_main .button:hover{background:#d5d5d5;color:#000}
	</style> 
</head>
    <body>
        <div id="container">
            <div id="header"><img src="${pageContext.request.contextPath}/rx/images/logo.jpg" alt="" />
                <ul id="nav">
                	<li><a href="${pageContext.request.contextPath}">首页</a></li>
	                <li><a href="${pageContext.request.contextPath}/xhjj/introduce.do">协会简介</a></li>
	                <li><a href="${pageContext.request.contextPath}/bmfc/style.do">部门风采</a></li>
	                <li><a href="${pageContext.request.contextPath}/bbs/bbs.do" style="background:url(${pageContext.request.contextPath}/rx/images/nav_on.gif)">协会论坛</a></li>
	                <li><a href="${pageContext.request.contextPath}/zxdt/news.do">最新动态</a></li>
	                <li><a href="${pageContext.request.contextPath}/lxwm/contact.do">联系我们</a></li>
                </ul>
                <form id="form1" action=''>
                    <p>
                        <input type="text" class="text1" value="" />
                    </p>
                    <p>
                         <input type="image" src="${pageContext.request.contextPath}/rx/images/search.gif"  class="search" />
                    </p>
                </form>
            </div>
            
            <!-- 登陆区代码 -->
            <div class="login">
            	<div class="l_main" style="position:relative;">
            		<form id="registerForm" method="post">
            			<label>账号：</label><input type="text" id="username" name="registerUser.username"/>
            			<label>密码：</label><input type="password" id="password" name="registerUser.password"/>
            			<label>验证码：</label><input type="text" id="verifyCode" name="yzm"/>
            			<img src="${pageContext.request.contextPath}/user/yzm.do" width="40" height="18" style="position:absolute;right:35px;bottom:77px" id="vimg"/>
            			<input type="button" value="注 册" class="button" id="registerBtn"/>
            		</form>
            	</div>
            </div>
            <!-- 登陆区代码 -->
            
           <div id="footer">
	           <ol>
	                <li><a href="#">常用文档下载</a>&nbsp;|&nbsp;</li><!--此处的竖线最好借鉴别人的-->
	                <li><a href="${pageContext.request.contextPath}/user/register.do">注册会员</a>&nbsp;|&nbsp;</li>
	                <li><a href="${pageContext.request.contextPath}/user/loginpage.do">登陆入口</a>&nbsp;|&nbsp;</li>
	                <li><a href="${pageContext.request.contextPath}/homepage/3dstreet.do">网站地图</a>&nbsp;|&nbsp;</li>
	                <li><a href="#">合作伙伴</a>&nbsp;|&nbsp;</li>
	                <li><a href="${pageContext.request.contextPath}/lxwm/contact.do">友情链接</a>&nbsp;|&nbsp;</li>
	                <li><a href="http://wpa.qq.com/msgrd?v=3&uin=534451834&site=qq&menu=yes" target="_blank">技术咨询</a></li>
	            </ol>
	           <p>&nbsp;&nbsp;2014 四川农业大学软件协会 版权所有 http://www.xsrjxh.com 川ICP备07070825号&nbsp;<a href="#">W3C Valid CSS</a>&nbsp;<a href="#">W3C Valid XHTML 1.0 Strict</a></p><!--文字中的间距直接用空格可以控制，不用使用padding和margin-->
	       </div>
	       <script type="text/javascript" src="${pageContext.request.contextPath}/rx/js/bannerku.js"></script>
	       <script type="text/javascript" src="${pageContext.request.contextPath}/rx/js/banner.js"></script>
	       <script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery-1.8.0.js"></script>
	       <script type="text/javascript" src="${pageContext.request.contextPath}/rx/js/bbsRegister.js"></script>
	       <script type="text/javascript">
	      	 	var path = "${pageContext.request.contextPath}";
	       </script>
    	</div>
    </body>
</html>