<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="xy" uri="/Nohting-tags"%>
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
			-webkit-transform:rotate(10deg);-moz-transform:rotate(10deg);-o-transform:rotate(10deg);-ms-transform:rotate(10deg);transform:rotate(10deg);}/*这种状态只设置要改变的属性（图片和文字颜色）即可*/
		.nav li::after{right: 0;
			  background: -moz-linear-gradient(top, rgba(255,255,255,0), rgba(255,255,255,.2) 50%, rgba(255,255,255,0));
			  background: -webkit-linear-gradient(top, rgba(255,255,255,0), rgba(255,255,255,.2) 50%, rgba(255,255,255,0));
			  background: -o-linear-gradient(top, rgba(255,255,255,0), rgba(255,255,255,.2) 50%, rgba(255,255,255,0));
			  background: -ms-linear-gradient(top, rgba(255,255,255,0), rgba(255,255,255,.2) 50%, rgba(255,255,255,0));
			  background: linear-gradient(top, rgba(255,255,255,0), rgba(255,255,255,.2) 50%, rgba(255,255,255,0));
			}
		.nav li::before{left: 0;
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
		#main img{width:936px;height:36px;}
		.fz1{font:12px "Times New Roman", Times, sans-serif;}
		.fz1 span{color:red;}
		.fz2{font:12px "微软雅黑","Times New Roman", Times, sans-serif;}
		.fz3{color:#323433; margin:5px 0;}
		#fr1{padding:10px 32px 30px 0; float:right;}
		#main1{width:1002px;clear:both;}/*必须清除fr1的浮动，否则不换行*/
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
	
		/** 自定义css start */
		#main1{font-family:"微软雅黑";border:1px dashed #d5d5d5;margin:0 auto;}
		#main1 .xh,.title{float:left}
		#main1 .name,.time{float:right}
		#main1 .xh{margin-right:5px;}
		#main1 .title{width:600px;white-space:nowrap; overflow:hidden; text-overflow:ellipsis;}
		#main1 .name{max-width:100px;white-space:nowrap; overflow:hidden; text-overflow:ellipsis;margin-right:10px;}
		
		.addTz{width:946px;margin:0 auto;margin-top:18px;margin-bottom:18px;}
		input{font-family:"微软雅黑";}
		.addTz .add_title{width:944px}
		.add_btn{border:0 none;background:#7a929c;border-radius:3px;padding:1px 8px 1px 8px;font-family:"微软雅黑";color:#fff;cursor:pointer;margin-top:10px;}
		/** end 自定义css */
	</style>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/tool_css/pageStyle/css.css"/>
	<script type="text/javascript">
		if("${addFlag}"!=""){
			if("${addFlag}"=="success"){
				alert("添加成功！");
			}else{
				alert("添加失败！");
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
	        <a href="javascript:void(0)" id="scby">收藏本页</a>&nbsp;|&nbsp;<a href="javascript:void(0)" onclick="SetHome(this,'${pageContext.request.contextPath}/bbs/bbs.do');">设为首页</a>
        </div>
       	<div style="position:absolute;top:2px;right:5px;font-family:'微软雅黑';display:none" id="yjdl"> 
       		<font color='#6d7373'>欢迎您：</font><s:if test="#session.session_user.nickname==''"><a href="${pageContext.request.contextPath}/user/getSelf.do?id=${session_user.id}" style="font-size:12px;text-decoration:none;color:red">${session_user.username }</a></s:if><s:else><a href="${pageContext.request.contextPath}/user/self.do?id=${session_user.id}" style="font-size:12px;text-decoration:none;color:red">${session_user.username }</a></s:else> | <a href="${pageContext.request.contextPath}/user/loginout.do" style="font-size:12px;text-decoration:none">注销</a>
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
            <form id="form1" action="" >
                <p><input type="text" value="" id="search"/></p>
                <p><input type="image" src="${pageContext.request.contextPath}/rx/images/search.gif"/></p>
            </form>
    </div>
    <div id="main">
    	<!-- 叠加数据 start -->
        <div id="main1">
        	<s:iterator value="tzs"  status="status">
        		<div style="border-bottom:1px solid #d5d5d5;overflow:auto;width:946px;margin:10px auto;padding-bottom:2px;">
        			<s:if test="zd==1">
		        		<img src="${pageContext.request.contextPath}/rx/images/zding.gif" style="width:30px;height:17px;float:left;margin-right:3px"/>
        			</s:if>
	        		<div class="xh"><s:property value="#status.index+1"/>、</div>
	        		<div class="title"><a href="${pageContext.request.contextPath}/bbs/getTz.do?id=${id}" style="color:#000"><s:property value="title"/></a></div>
	        		<div class="time"><s:date name="date" format="yyyy-MM-dd"/> </div>
	        		<s:if test="user.nickname==''">
		        		<div class="name" title="${user.username}"><s:property value="user.username"/></div>
	        		</s:if>
	        		<s:else>
		        		<div class="name" title="${user.nickname}"><s:property value="user.nickname"/></div>
	        		</s:else>
	        	</div>
        	</s:iterator>
	    	<!-- 分页 start -->
	    	<div style="margin-bottom:10px;margin-top:10px;">
		   		<xy:pager pageIndex="${pageModel.pageIndex}" 
		   				  pageSize="${pageModel.pageSize}" 
		   				  recordCount="${pageModel.recordCount}" 
	   				  	submitUrl="${pageContext.request.contextPath}/bbs/bbs.do?pageModel.pageIndex={0}" />
	         </div>
	    	<!-- end 分页 -->
	    	<!-- 发表帖子 start -->
	    	<s:if test="#session.session_user.username!=''">
	    		<div class="addTz">
		    		<div style="margin-bottom:5px;color:#f00">Tip：在这里发帖</div>
		    		<form action="${pageContext.request.contextPath}/bbs/addTz.do" method="post" id="addForm">
		    			<s:token></s:token>
						<input type="text" placeholder="标题" required class="add_title" id="title" name="title"/><br/><br/>
						<textarea id="editorContainer" name="content">内容</textarea>   
						<textarea id="jy_content" style="display:none"></textarea>
						<input type="button" class="add_btn" id="addBtn" value="发 帖"/> 		
		    		</form>
		    	</div>
	    	</s:if>
	    	<s:else>
	    		<div style="color:red;text-align:center;margin:10px 0;">
	    			登陆后才能发帖！
	    		</div>
	    	</s:else>
	    	<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery-1.8.0.js"></script>
			<script type="text/javascript" src="${pageContext.request.contextPath}/cj/ueditor/ueditor.config.js"></script>
			<script type="text/javascript" src="${pageContext.request.contextPath}/cj/ueditor/ueditor.all.js"></script>
			<script type="text/javascript" src="${pageContext.request.contextPath}/cj/ueditor/lang/zh-cn/zh-cn.js"></script>
			<script type="text/javascript">
				var ue = UE.getEditor("editorContainer",{
					initialFrameWidth:946,
					initialFrameHeight:200,
					autoHeightEnabled: false,
					initialStyle:"p{line-height:1em; font-family:'微软雅黑';font-size:14px}",
				});
				
				$("#addBtn").click(function(){
					$("#jy_content").html(UE.getEditor("editorContainer").getContent());
					var msg = "";
		        	if($("#title").val() == ""){
		        		msg = "标题不能为空！"; 
		    			$("#title").focus();
		    		}else if($("#content").val() == ""){
		        		msg = "内容不能为空！";
		    			$("#content").focus();
		    		}
		        	
		        	if(msg != ""){
		        		alert(msg);
		        	}else{
		        		$("#addForm").submit();
		        	}
				});
			</script>
	    	<!-- end 发表帖子 -->
        </div>
    	<!-- end 叠加数据 -->
    	
    	
        <div id="main2">
        </div>
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
		<script type="text/javascript">
			if("${session_user.username}"!= ""){
				$("#yjdl").show();
				$("#mydl").hide();
			}else{
				$("#yjdl").hide();
				$("#mydl").show();
			};
			
			
			$("#scby").click(function(){
	            var a="${pageContext.request.contextPath}/bbs/bbs.do";
	            var b="xxxx";
      			if(document.all){
      				window.external.AddFavorite(a,b);
      			}else if(window.sidebar){
      				window.sidebar.addPanel(b,a,"");
      			}
	      		else{
	      			alert("对不起，您的浏览器不支持此操作!\n请您使用菜单栏或Ctrl+D收藏本页。");
	      		}
			});
			
			
			function SetHome(obj,url){   
				try{     
					obj.style.behavior='url(#default#homepage)';     
					obj.setHomePage(url);   
				}catch(e){     
					if(window.netscape){      
						try{        
							netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");      
						}catch(e){        
							alert("抱歉，此操作被浏览器拒绝！\n\n请在浏览器地址栏输入“about:config”并回车然后将[signed.applets.codebase_principal_support]设置为'true'");      
						}     
					}else{     
						alert("抱歉，您所使用的浏览器无法完成此操作。\n\n您需要手动将【"+url+"】设置为首页。");     
					}  
				} 
			} 
		</script>
</body>
</html>
