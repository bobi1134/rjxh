<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title> left.html </title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="Keywords" content="KeyWords, KeyWords"/>
	<meta name="description" content=""/>
	<meta name="author" content="Nothing" />
	<style type="text/css">
		*{margin:0px;padding:0px;}
		body{font-size:12px;font-family:"微软雅黑";}
		a{text-decoration:none;color:#666;}
		a:hover{color:#92afcd}
		ul{list-style:none}

		.left_page{width:190px;height:800px;border:1px solid #b6c0c9;margin:5px 4px 0 5px; border-radius:5px;}
		.menu{  width:190px;  height: 30px;background:url(${pageContext.request.contextPath}/admin/images/bg_menu.jpg)}
		.menu img{  margin-left: 59px; margin-top: 7px;float: left;}
		.menu span{  margin-top: 6px;  display: inline-block; float: left;  margin-left: 2px;}
		.menu_sub li{width:190px;  height: 20px;  border-bottom: 1px solid #b6c0c9; line-height: 20px; text-align:center;}
		.rx{  position: absolute; bottom: 50px; transform:rotate(-45deg)}
	</style>	
</head>
<body>
	<div class="left_page">
		<div class="menu">
			<img src="${pageContext.request.contextPath}/admin/images/close.jpg" width="14" height="14"/>
			<span>用户管理</span>
		</div>				
		<ul class="menu_sub">
			<li><a href="${pageContext.request.contextPath}/user/getUser.do" target="content">查询用户</a></li>
			<li><a href="${pageContext.request.contextPath}/user/addUserPage.do" target="content">添加用户</a></li>
		</ul>
		<ul class="menu" id="menu_control">
			<li>
				<div class="menu">
					<img src="${pageContext.request.contextPath}/admin/images/close.jpg" width="14" height="14" class="img"/>
					<span>首页管理</span>
				</div>				
				<ul class="menu_sub">
					<li><a href="${pageContext.request.contextPath}/homepage/getBanner.do" target="content">Banner图</a></li>
					<li><a href="${pageContext.request.contextPath}/homepage/getSkilltalk.do" target="content">技术交流</a></li>
					<li><a href="${pageContext.request.contextPath}/hotanswer/hotanswer_ht.do" target="content">热点答疑</a></li>
					<li><a href="${pageContext.request.contextPath}/trainactive/trainactive_ht.do" target="content">培训活动</a></li>
				</ul>
			</li>
			<li>
				<div class="menu">
					<img src="${pageContext.request.contextPath}/admin/images/close.jpg" width="14" height="14"/>
					<span>菜单管理</span>
				</div>				
				<ul class="menu_sub">
					<li><a href="${pageContext.request.contextPath}/xhjj/baseInfo.do" target="content">协会简介</a></li>
					<li><a href="${pageContext.request.contextPath}/bmfc/style_ht.do" target="content">部门风采</a></li>
					<li><a href="${pageContext.request.contextPath}/zxdt/news_ht.do" target="content">最新动态</a></li>
					<li><a href="${pageContext.request.contextPath}/lxwm/getContact.do" target="content">联系我们</a></li>
				</ul>
			</li>
			<li>
				<div class="menu">
					<img src="${pageContext.request.contextPath}/admin/images/close.jpg" width="14" height="14"/>
					<span>论坛管理</span>
				</div>				
				<ul class="menu_sub">
					<li><a href="${pageContext.request.contextPath}/bbs/getTz_ht.do" target="content">帖子管理</a></li>
					<li><a href="${pageContext.request.contextPath}/bbs/addTzPage.do" target="content">管理员发帖</a></li>
				</ul>
			</li>
		</ul>
		<div class="rx"><img src="${pageContext.request.contextPath}/admin/images/rx.png"/></div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery-1.8.0.js"></script>
	<script type="text/javascript">
		$("#menu_control").children().find(".menu img").click(function(){
			if(!$(this).parent().parent().hasClass("click")){
				$(this).parent().parent().find("ul").slideUp("slow");
				$(this).parent().parent().addClass("click");
				$(this).parent().parent().find(".menu img").attr("src", "${pageContext.request.contextPath}/admin/images/open.jpg");
			}else{
				$(this).parent().parent().find("ul").slideDown("slow");
				$(this).parent().parent().removeClass("click");
				$(this).parent().parent().find(".menu img").attr("src", "${pageContext.request.contextPath}/admin/images/close.jpg");
			}			
		});
	</script>
</body>
</html>
