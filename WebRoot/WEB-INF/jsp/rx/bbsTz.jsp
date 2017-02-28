<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>论坛-川农软件协会</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/rx/css/reset.css" type="text/css" />
	<link rel="icon"  type="image/x-icon" href="${pageContext.request.contextPath}/rx/images/favicon.ico" />  
	<link rel="shortcut icon"  type="image/x-icon" href="${pageContext.request.contextPath}/rx/images/favicon.ico" /> 
	<style type="text/css">
		#container{width:1002px; margin:0 auto;}
		#header{width:1002px;height:70px; background:#e5eae4;}
		#header img{width:417px;height:70px;float:left;}
		#header a{font:13px "微软雅黑",Times,serif; color:#6d7373;}
		#header a:hover{text-decoration:underline; color:#fb9c00;}
		#navigate{width:1002px;height:41px;background:url(${pageContext.request.contextPath}/rx/images/navigate.jpg);}
		#nav li{width:90px;height:37px;float:left;padding-right:2px;}
		#nav li a{width:90px;height:37px;display:block;background:url(${pageContext.request.contextPath}/rx/images/nav_bg.gif);text-align:center; color:#402c25; font:14px/37px simhei,微软雅黑;
		-webkit-transition: all 0.2s ease-in;-moz-transition: all 0.2s ease-in;-o-transition: all 0.2s ease-in;-ms-transition: all 0.2s ease-in;transition: all 0.2s ease-in;}
		/*链接的默认状态定义参数最多，a的高宽和li保持一致才能使font里面的行高生效，使用text-align使文字水平居中，color必须单独设置，用来定义文字颜色.这里的display:block;把a已经变成了块状元素，如果li里有其他a，并且没有li没有设置高度和a一样，其他a就会独占换行显示。*/
		#nav li a:hover{color:#fff;background:url(${pageContext.request.contextPath}/rx/images/nav_on.gif);
			-webkit-transform:rotate(10deg);-moz-transform:rotate(10deg);-o-transform:rotate(10deg);-ms-transform:rotate(10deg); transform:rotate(10deg);}/*这种状态只设置要改变的属性（图片和文字颜色）即可*/
				  .nav li::after{
					  right: 0;
					  background: -moz-linear-gradient(top, rgba(255,255,255,0), rgba(255,255,255,.2) 50%, rgba(255,255,255,0));
					  background: -webkit-linear-gradient(top, rgba(255,255,255,0), rgba(255,255,255,.2) 50%, rgba(255,255,255,0));
					  background: -o-linear-gradient(top, rgba(255,255,255,0), rgba(255,255,255,.2) 50%, rgba(255,255,255,0));
					  background: -ms-linear-gradient(top, rgba(255,255,255,0), rgba(255,255,255,.2) 50%, rgba(255,255,255,0));
					  background: linear-gradient(top, rgba(255,255,255,0), rgba(255,255,255,.2) 50%, rgba(255,255,255,0));
					}
					.nav li::before{
					  left: 0;
					  background: -moz-linear-gradient(top, #ff625a, #9e3e3a 50%, #ff625a);
					  background: -webkit-linear-gradient(top, #ff625a, #9e3e3a 50%, #ff625a);
					  background: -o-linear-gradient(top, #ff625a, #9e3e3a 50%, #ff625a);
					  background: -ms-linear-gradient(top, #ff625a, #9e3e3a 50%, #ff625a);
					  background: linear-gradient(top, #ff625a, #9e3e3a 50%, #ff625a);
					}
		/*删除第一项和最后一项导航分隔线*/
		.nav li:first-child::before{background: none;}
		            
		.nav li:last-child::after{background: none;}
		#form1{float:right; margin:9px 30px 0 0;}
		#form1 p{float:left;}
		#search{width:208px;border:0;color:#808080;}
		#main{width:1002px; clear:both;}
		
		.fz1{font:12px "Times New Roman", Times, sans-serif;}
		.fz1 span{color:red;}
		.fz2{font:12px "微软雅黑","Times New Roman", Times, sans-serif;}
		.fz3{color:#323433; margin:5px 0;}
		#fr1{padding:10px 32px 30px 0; float:right;}
		#fie1{border:1px dashed #e4e2e3;}
		#fie1 legend{font:16px "黑体","Times New Roman", Times, sans-serif;}
		#ul1{width:312px; height:420px;padding-right:10px;float:left;}
		#ul1 li{text-align:right; height:20px;padding-bottom:5px;font:13px "微软雅黑","Times New Roman", Times, sans-serif;}
		#ul1 li span{color:red;}
		#ul2 li{height:20px;padding-bottom:5px;}
		#ul2{width:300px; height:420px;float:left;}
		#ul2 li{font:13px "微软雅黑","Times New Roman", Times, sans-serif;}
		/*ul1按页面设置width，设置padding-right与ul2保持间距，ul1左浮动是为了让ul2能同排显示，其中的li中文字必须右对齐，故使用text-align:right;。
		ul2也按页面设置width，其中内容必须左对齐，而左浮动也正好达到了这个效果*/
		.text1{width:60px;}
		#vipregedit textarea{width:200px; height:100px; margin:20px 0;}/*直接用css定义高宽，margin用来控制与上下行之间的距离*/
		#main2{width:1002px;height:6px;background:gray url(${pageContext.request.contextPath}/rx/images/mian2_bg.jpg) repeat-x; margin-top:15px;}
		#footer{width:1002px;height:72px; padding:0 30px 15px 0;}/*高度设置和logo2一样，padding设置右边底部空白*/
		#footer img{float:left; width:130px;height:72px;}/*不建议此设置，会影响footer里面所有img*/
		#footer ul li{float:left;margin:15px 0 5px 0;text-align:center;font:11px "微软雅黑","Times New Roman", Times, sans-serif; width:650px; height:25px; }/*width控制ul与img的距离.如果不浮动，ul将不会在img右边,也可以浮动外层ul。后影响：ul后面有同级img，没有设置ul的高度，故ul失去块状的地位，后续img可以直接紧跟*/
		.bl{color:#1144b7;}
		.gr{color:#7e6c6c;}
		.fl{float:left;}
		.fr{float:right;}
		#img2{width:170px;height:72px; float:right; margin:0 10px 0 0;}
		#img2 img{width:77px;height:17px; float:right;}
		.beiyong{border:1px dashed red;}
	
		/** mycss start */
		#main1{width:1002px;font-family:"微软雅黑";border:1px dashed #d5d5d5;margin:0 auto;overflow:auto;}
		#main1	.tz{width:950px;margin:0 auto;}
		#main1	.tz .title_area{border-bottom:1px solid #d5d5d5;overflow:auto;margin-top:5px;}
		#main1	.tz .t_title{float:left;max-width:600px;white-space:nowrap; overflow:hidden; text-overflow:ellipsis;margin-right:10px;}
		#main1	.tz .t_date{float:right}
		#main1	.tz .t_user{float:right;max-width:100px;white-space:nowrap; overflow:hidden; text-overflow:ellipsis;margin-right:10px;}
		#main1	.tz .content{max-width:950px;word-break:break-all;margin-top:5px;border:1px solid #d5d5d5;}
		#main1	.tz .content img{max-width:950px}
		#main1	.tz .remark_area{margin-top:20px;}
		#main1	.tz .remark_area a{color:#00f}
		#main1	.tz .remark_area div{margin-top:5px;}
		#main1	.tz .remark_area .add-sub-remark{margin-bottom:5px;display:none}
		#main1	.tz .remark_area .add-sub-remark .remark{width:600px;font-family:"微软雅黑"}
		#main1	.tz .remark_area .add-sub-remark .addBtn{border:0 none;background:#7a929c;border-radius:3px;padding:1px 8px 1px 8px;font-family:"微软雅黑";color:#fff;cursor:pointer;}
		#main1	.tz .remark_area .sq{display:none}
		#main1	.tz .remark_area img{display:inline-block;}
		
		#main1 .tz .add-remark{margin:20px 0 15px 0;}
		#main1 .tz .add-remark .remark{width:600px;font-family:"微软雅黑";padding: 5px 5px 5px 5px;}
		#main1 .tz .add-remark .remark img{display:inline-block;}
		#main1 .tz .add-remark .addBtn{border:0 none;background:#7a929c;border-radius:3px;padding:5px 8px 5px 8px;font-family:"微软雅黑";color:#fff;cursor:pointer;margin:5px 0 5px 0;float:left}
		#main1 .tz .add-remark .addBQ{border:0 none;background:#7a929c;border-radius:3px;padding:5px 8px 5px 8px;font-family:"微软雅黑";color:#fff;cursor:pointer;margin:5px 0 5px 5px;float:left;}
		#main1 .tz .add-remark .remark{width:950px;min-height:100px;border:1px solid #eee;outline: none;}
		#main1 .tz .add-remark .biaoqing{float:left;margin-top:10px;margin-left:30px;display:none}
		#main1 .tz .add-remark .biaoqing ul li{float:left;margin-left:15px;cursor:pointer;}
		/** end mycss */
	</style>
	<script type="text/javascript">
		if("${addFlag}"!=""){
			if("${addFlag}"=="success"){
				alert("评论成功！");
			}else{
				alert("评论失败！");
			}
		}
		if("${tcTip}" != ""){
			alert("${tcTip}");
		}
		if("${loginTip}" != ""){
			alert("${loginTip}");
			window.location = "${pageContext.request.contextPath}/user/loginpage.do";
		}
	</script>
</head>
<body>
<div id="container">
    <div id="header" style="position:relative;">
        <img src="${pageContext.request.contextPath}/rx/images/logo1.jpg" alt="" />
       <div style="float:right;margin-top:45px;margin-right:5px">
        </div>
       	<div style="position:absolute;top:2px;right:5px;font-family:'微软雅黑';display:none;" id="yjdl"> 
       		<font color='#6d7373'>欢迎您：</font><s:if test="#session.session_user.nickname==''"><a href="#" style="font-size:12px;text-decoration:none;color:red">${session_user.username }</a></s:if><s:else><a href="#" style="font-size:12px;text-decoration:none;color:red">${session_user.username }</a></s:else> | <a href="${pageContext.request.contextPath}/user/loginout.do" style="font-size:12px;text-decoration:none">注销</a>
       	</div>
       	<div style="position:absolute;top:2px;right:5px;font-family:'微软雅黑';" id="mydl"> 
       		<a href="${pageContext.request.contextPath}/user/loginpage.do" style="font-size:12px;text-decoration:none">登陆</a> | <a href="${pageContext.request.contextPath}/user/register.do" style="font-size:12px;text-decoration:none">注册</a>
       	</div>
    </div>
    <div id="navigate">
	        <ul id="nav">                
	                <li><a href="${pageContext.request.contextPath}">首页</a></li>
	                <li><a href="${pageContext.request.contextPath}/xhjj/introduce.do">协会简介</a></li>
	                <li><a href="${pageContext.request.contextPath}/bmfc/style.do">部门风采</a></li>
	                <li><a href="${pageContext.request.contextPath}/bbs/bbs.do" style="background:url(${pageContext.request.contextPath}/rx/images/nav_on.gif)">协会论坛</a></li>
	                <li><a href="${pageContext.request.contextPath}/zxdt/news.do">最新动态</a></li>
	                <li><a href="${pageContext.request.contextPath}/lxwm/contact.do">联系我们</a></li>
            </ul>
            <form id="form1">
                <p><input type="text"  id="search" onkeydown="if(event.keyCode==13)return false;"/></p>
                <p><input type="image" src="${pageContext.request.contextPath}/rx/images/search.gif"  /></p>
            </form>
    </div>
    <div id="main">
        <div id="main1">
        	<div class="tz">
        		<div class="title_area">
        			<span class="t_title"><s:property value="tz.title"/></span>
        			<span class="t_date"><s:date name="tz.date" format="yyyy-MM-dd"/></span>
        			<s:if test="tz.user.nickname==''">
	        			<span class="t_user"><s:property value="tz.user.username"/></span>
        			</s:if>
        			<s:else>
	        			<span class="t_user"><s:property value="tz.user.nickname"/></span>
        			</s:else>
        		</div>
        		<div class="content"><s:property value="tz.message" escapeHtml="false"/></div>
        		<div class="remark_area">
        			<s:iterator value="remarks" status="xh">
        				<div style="border-bottom:1px solid #d5d5d5;margin-top:20px">
	        				<div >
	        					<span class="hfUserId" style="display:none"><s:property value="userId"/></span>
	        					<span class="remarkId" style="display:none"><s:property value="id"/></span>
	        					<s:property value="#xh.index+1"/>楼：<br/>
	        					<%-- (<s:property value="userId"/>) --%>
	        					【<span class="needAnswer"><s:if test="user.nickname==''"><s:property value="user.username"/></s:if><s:else><s:property value="user.nickname"/></s:else> </span>】
	        					 评论楼主：<s:property value="content" escapeHtml="false"/>
	        					<a href="javacript:void(0);" class="hf">回复</a>
	        					<a href="javacript:void(0);" class="sq">收起</a>
	        				</div>
	        				<s:iterator value="subRemarks" var="subRemark">
	        					<div class="kkk">
		        					<%-- [<s:property value="userId" />] --%>
		        					<span class="hfUserId" style="display:none"><s:property value="userId"/></span>
		        					【<span class="needAnswer"><s:if test="user.nickname==''"><s:property value="user.username"/></s:if><s:else><s:property value="user.nickname"/></s:else></span>】
		        					回复【<s:property value="remarkUser"/>】：<s:property value="content"/>
		        					<a href="javacript:void(0);" class="hf">回复</a>
		        					<a href="javacript:void(0);" class="sq">收起</a>
		        				</div>
	        				</s:iterator>
	        				<div class="add-sub-remark">
	        					<form class="addSubRemarkForm">
		        					<input type="text" name="subRemarkContent" class="remark"/>
		        					<input type="button" value="回复" class="addBtn"/>
	        					</form>
	        				</div>
	        			</div>
        			</s:iterator>
        		</div>
        		<!-- 在这里回复 -->
        		<div class="add-remark">
        			<div style="color:#f00;margin-bottom:2px;">Tip：在这里评论帖子</div>
        			<div class="remark" contenteditable="true" id="remarkContent_jy"></div>
        			<form action="${pageContext.request.contextPath}/bbs/addRemark.do" method="post" id="addRemarkForm">
        				<s:token></s:token>
	  					<input type="hidden" value="${id}" name="id"/>
	  					<input type="hidden" name="remarkContent" id="remarkContent"/>
	  					<input type="button" value="评 论" class="addBtn" id="addRemarkBtn"/>
	  					<input type="button" value="表 情" class="addBQ"/>
        			</form>
  					<div class="biaoqing">
  						<ul class="face_ul">
							<li><img src="${pageContext.request.contextPath}/rx/images/face/01.gif" width="18" height="18"/></li>
							<li><img src="${pageContext.request.contextPath}/rx/images/face/02.gif" width="18" height="18"/></li>
							<li><img src="${pageContext.request.contextPath}/rx/images/face/03.gif" width="18" height="18"/></li>
							<li><img src="${pageContext.request.contextPath}/rx/images/face/04.gif" width="18" height="18"/></li>
							<li><img src="${pageContext.request.contextPath}/rx/images/face/05.gif" width="18" height="18"/></li>
							<li><img src="${pageContext.request.contextPath}/rx/images/face/06.gif" width="18" height="18"/></li>
							<li><img src="${pageContext.request.contextPath}/rx/images/face/07.gif" width="18" height="18"/></li>
							<li><img src="${pageContext.request.contextPath}/rx/images/face/08.gif" width="18" height="18"/></li>
							<li><img src="${pageContext.request.contextPath}/rx/images/face/09.gif" width="18" height="18"/></li>
							<li><img src="${pageContext.request.contextPath}/rx/images/face/10.gif" width="18" height="18"/></li>
							<li><img src="${pageContext.request.contextPath}/rx/images/face/11.gif" width="18" height="18"/></li>
							<li><img src="${pageContext.request.contextPath}/rx/images/face/12.gif" width="18" height="18"/></li>
							<li><img src="${pageContext.request.contextPath}/rx/images/face/13.gif" width="18" height="18"/></li>
							<li><img src="${pageContext.request.contextPath}/rx/images/face/14.gif" width="18" height="18"/></li>
							<li><img src="${pageContext.request.contextPath}/rx/images/face/15.gif" width="18" height="18"/></li>
							<li><img src="${pageContext.request.contextPath}/rx/images/face/16.gif" width="18" height="18"/></li>
							<li><img src="${pageContext.request.contextPath}/rx/images/face/17.gif" width="18" height="18"/></li>
							<li><img src="${pageContext.request.contextPath}/rx/images/face/18.gif" width="18" height="18"/></li>
							<li><img src="${pageContext.request.contextPath}/rx/images/face/19.gif" width="18" height="18"/></li>
						</ul>
  					</div>
  				</div>
        	</div>
        </div>
        <div id="main2"></div>
        </div>
        
        <div id="footer">
            <img src="${pageContext.request.contextPath}/rx/images/logo2.jpg" alt="" />
            <ul>
            <li class="bl">关于我们&nbsp;&nbsp;&nbsp;联系我们&nbsp;&nbsp;&nbsp;帮助中心&nbsp;&nbsp;&nbsp;网站地图</li>
            <li class="gr"> &#169;Copyright&#169;2014&nbsp;www.xsrjxh.com&nbsp;Powered&nbsp;By&nbsp;html&nbsp;Version&nbsp;1.0.0&nbsp;四川农业大学软件协会版权所有
            </li>
            </ul>
            <!--必须加div/p外框，img很难突破权限，而且必须使用id-->
        </div>  
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery-1.8.0.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/rx/js/bbsTz.js"></script>
	<script type="text/javascript">
		var path = "${pageContext.request.contextPath}";
		var name = "";
		if("${session_user.nickname}"==""){
			name = "${session_user.username}";
		}else{
			name = "${session_user.nickname}";
		}
		
		if("${session_user.username}"!= ""){
			$("#yjdl").show();
			$("#mydl").hide();
		}else{
			$("#yjdl").hide();
			$("#mydl").show();
		};
	</script>
	
</body>
</html>

