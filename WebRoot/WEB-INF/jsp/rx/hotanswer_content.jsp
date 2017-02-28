<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
<title>软件协会—热点答疑</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="description" content="川农软件协会网站" />
<meta name="keywords" content="软件协会，川农" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/rx/css/reset.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/rx/css/all.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/rx/css/sub.css" type="text/css" />
<link rel="Bookmark"  type="image/x-icon"  href="${pageContext.request.contextPath}/rx/images/favicon.ico"/>
<link rel="icon"  type="image/x-icon" href="./image${pageContext.request.contextPath}/rx/favicon.ico" />  
<link rel="shortcut icon"  type="image/x-icon" href="${pageContext.request.contextPath}/rx/images/favicon.ico" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/tool_css/pageStyle/css.css"/> 
<style type="text/css">
    .prev_next a{color:#000;}
    .prev_next a:Hover{text-decoration:underline;}
    #content img{max-width:960px}
</style>
<script>
window.onload=function()
{
var today = new Date(); //新建一个Date对象
    var date = today.getDate();//查询当月日期
    var day = today.getDay();//查询当前星期几
    var month = today.getMonth()+1;//查询月份
    var year = today.getFullYear();//查询年份 
    var hour=today.getHours();
    var miunte=today.getMinutes();
    var morning="";
    if (hour>8 & hour<=12) morning="上午好";
    if (hour>12 & hour<=19) morning="上午好";
    if (hour>19 & hour<=24) morning="晚上好";
    if (hour>24 & hour<=8) morning="凌晨好";
    var week=""; 
    if (day==0) week='星期日';
    if (day==1) week='星期一';
    if (day==2) week='星期二';
    if (day==3) week='星期三';
    if (day==4) week='星期四';
    if (day==5) week='星期五';
    if (day==6) week='星期六';
    var element=document.getElementById('time');
    element.innerHTML=year+"年"+month+"月"+date+"日 "+week+" "+morning;

}
</script>

</head>
    <body>
        <div id="container">
              <div id="header"><img src="${pageContext.request.contextPath}/rx/images/logo.jpg" alt="" />
                  <ul id="nav">
                  	<li><a href="${pageContext.request.contextPath}">首页</a></li>
	                <li><a href="${pageContext.request.contextPath}/xhjj/introduce.do">协会简介</a></li>
	                <li><a href="${pageContext.request.contextPath}/bmfc/style.do">部门风采</a></li>
	                <li><a href="${pageContext.request.contextPath}/bbs/bbs.do">协会论坛</a></li>
	                <li><a href="${pageContext.request.contextPath}/zxdt/news.do">最新动态</a></li>
	                <li><a href="${pageContext.request.contextPath}/lxwm/contact.do">联系我们</a></li>
                  </ul>
                  <form id="form1" action='' >
                      <p>
                          <input type="text" class="text1" value="" onkeydown="if(event.keyCode==13)return false;"/>
                      </p>
                      <p>
                           <input type="image" src="${pageContext.request.contextPath}/rx/images/search.gif" class="search" />
                      </p>
                  </form>
              </div>
    <div id="banner">
	        <ul class="slide-pic">
				<s:iterator value="banners">        
		        	<li class="current"><a href="#"><img alt="" src="${pageContext.request.contextPath}/rx/images/<s:property value='image'/>"/></a></li>
		        </s:iterator>
			</ul>
			<ul class="slide-li slide-txt" id="banner_submenu">
				<s:iterator value="banners">  
					<li ><a href="#"><s:property value='title'/></a></li>
				</s:iterator>	
			</ul>
    </div> 
<script type="text/javascript" src="${pageContext.request.contextPath}/rx/js/bannerku.js"></script><!--jquery特效库-->
<script type="text/javascript" src="${pageContext.request.contextPath}/rx/js/banner.js"></script><!--jquery特效函数-->
<script type="text/javascript">
	$("#banner_submenu li:first").addClass("current");
</script>
    <div id="mainbody">
       
       <!--插入雅安市当前天气-->
       <div class="time-wea">
        <!--插入当前日期-->
        <div id="time"></div>
        <div class="wea">
       	 <iframe style="font-size: 20px;" name="sinaWeatherTool" src="http://weather.news.sina.com.cn/chajian/iframe/weatherStyle1.html?city=%E9%9B%85%E5%AE%89" width="200" height="20" marginwidth="0" marginheight="0" hspace="0" vspace="0" frameborder="0" scrolling="no"></iframe>
         </div>
        </div>
        <div id="content">
        	<h1>热点答疑</h1>
            <a class="a1" href="#">MORE&nbsp;&gt;&gt;</a>
            <hr width="1000" style="float:left;"/>
            <div style="width:940px;margin:20px auto;font-size:20px;text-align:center;font-family:'微软雅黑'">
	           <s:property value="hotAnswer.title"/>
            </div>
            <div style="width:960px;margin:20px auto;font-size:14px;font-family:'微软雅黑';letter-spacing:.2em;" id="content">
	           <s:property value="hotAnswer.content" escapeHtml="false"/>
            </div>
        </div>
    </div>
    <div id="footer" style="margin:5px auto;">
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
</div>
