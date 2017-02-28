<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
-webkit-transition: all 0.2s ease-in;
		  -moz-transition: all 0.2s ease-in;
		  -o-transition: all 0.2s ease-in;
		  -ms-transition: all 0.2s ease-in;
		  transition: all 0.2s ease-in;}
/*链接的默认状态定义参数最多，a的高宽和li保持一致才能使font里面的行高生效，使用text-align使文字水平居中，color必须单独设置，用来定义文字颜色.这里的display:block;把a已经变成了块状元素，如果li里有其他a，并且没有li没有设置高度和a一样，其他a就会独占换行显示。*/
#nav li a:hover{color:#fff;background:url(${pageContext.request.contextPath}/rx/images/nav_on.gif);
	-webkit-transform:rotate(10deg);
		  -moz-transform:rotate(10deg);
		  -o-transform:rotate(10deg);
		  -ms-transform:rotate(10deg);
		  transform:rotate(10deg);}/*这种状态只设置要改变的属性（图片和文字颜色）即可*/
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
		.nav li:first-child::before{
        	  background: none;
			}
            
	.nav li:last-child::after{
    		  background: none;
			}
#form1{float:right; margin:9px 30px 0 0;}
#form1 p{float:left;}
#search{width:208px;border:0;color:#808080;}
#main{width:1002px; clear:both;}
#main img{width:936px;height:36px;padding-left:33px;}
.fz1{font:12px "Times New Roman", Times, sans-serif;}
.fz1 span{color:red;}
.fz2{font:12px "微软雅黑","Times New Roman", Times, sans-serif;}
.fz3{color:#323433; margin:5px 0;}
#fr1{padding:10px 32px 30px 0; float:right;}
#main1{width:936px;height:460px;padding-left:33px;clear:both;}/*必须清除fr1的浮动，否则不换行*/
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



*{margin:0px;padding:0px;}
		body{font-size:12px;font-family:"微软雅黑";}
		.content_page{width:auto;min-height:712px;border:1px solid #b6c0c9;border-radius:5px;margin:5px 4px 0 5px;}
		.main{width:300px;margin:10px auto;}
		input{font-family:"微软雅黑";}
		select{font-family:"微软雅黑";}
		textarea{font-family:"微软雅黑";}
		fieldset{border:1px dashed;}
		label{width:100px;display:inline-block;text-align:right;margin-top:10px;}
		.cz{text-align:center;margin-bottom:10px;margin-top:10px;    float: left;    margin-left: 100px}
		.cz input{border:0 none;background:#7a929c;border-radius:3px;padding:1px 8px 1px 8px;font-family:"微软雅黑";color:#fff;cursor:pointer;}
</style>
<title>论坛-个人资料</title>
</head>
<body>
<div id="container">
    <div id="header" style="position:relative;">
        <img src="${pageContext.request.contextPath}/rx/images/logo1.jpg" alt="" />
       <div style="float:right;margin-top:45px;margin-right:5px">
	        <a href="#">收藏本页</a>&nbsp;|&nbsp;<a href="#">设为首页</a>
        </div>
       	<div style="position:absolute;top:2px;right:5px;font-family:'微软雅黑';display:none;" id="yjdl"> 
       		<font color='#6d7373'>欢迎您：</font><s:if test="#session.session_user.nickname==''"><a href="#" style="font-size:12px;text-decoration:none;color:red">${session_user.username }</a></s:if><s:else><a href="#" style="font-size:12px;text-decoration:none;color:red">${session_user.username }</a></s:else> | <a href="${pageContext.request.contextPath}/user/loginout.do" style="font-size:12px;text-decoration:none">注销</a>
       	</div>
       	<div style="position:absolute;top:2px;right:5px;font-family:'微软雅黑';" id="mydl"> 
       		<a href="${pageContext.request.contextPath}/user/loginpage.do" style="font-size:12px;text-decoration:none">登陆</a> | <a href="#" style="font-size:12px;text-decoration:none">注册</a>
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
                <p><input type="text" value="" name="text1" id="search"/></p>
                <p><input type="image" src="${pageContext.request.contextPath}/rx/images/search.gif" name="serchbutton" /></p>
            </form>
    </div>
    <div id="main">
    
        <div id="main1" style="width:960px;border:1px dotted #d5d5d5;">
        	<div class="main">
			<fieldset>
				<legend style="brder:1px solid red;">Your Message：</legend>
				<form action="${pageContext.request.contextPath}/user/updateSelfUser.do" method="post" id="updateForm">
					<input type="hidden" name="id" value="${updateuser.id}" />
					<label>ID：</label><input type="text" name="updateuser.id" value="${updateuser.id}" readonly="readonly" title="用户id不允许被修改" id="idWidth"/>
					<label>用户名：</label><input type="text" value="${updateuser.username}" readonly="readonly" title="用户登陆账号不允许被修改"/>
					
					<label>密码：</label><input type="password" required name="updateuser.password" value="${updateuser.password}" title="普通管理员只能修改自己的密码！" id="password"/>
					<label>昵称：</label><input type="text" name="updateuser.nickname" value="${updateuser.nickname}" required id="nickname"/>
					<label>邮箱：</label><input type="email" name="updateuser.email" value="${updateuser.email}" required id="email"/>
					<label>性别：</label><s:if test="updateuser.sex==1"><select name="updateuser.sex"><option value="1" selected>男</option><option value="2">女</option></select></s:if><s:else><select name="updateuser.sex"><option value="1">男</option><option value="2" selected>女</option></select></s:else>
					<label>学院：</label><input type="text" name="updateuser.academe" value="${updateuser.academe}" required id="academe"/>
					<label>年级：</label><select id="grade" name="updateuser.grade">
											<option value="大一">大一</option>
											<option value="大二">大二</option>
											<option value="大三">大三</option>
											<option value="大四">大四</option>
											<option value="研一">研一</option>
											<option value="研二">研二</option>
											<option value="研三">研三</option>
											<option value="博一">博一</option>
											<option value="博二">博二</option>
											<option value="博三">博三</option>
											<option value="博四">博四</option>
											<option value="教师">教师</option>
											<option value="其他">其他</option>
										</select>
					<label>爱好：</label><input type="text" name="updateuser.hobby" value="${updateuser.hobby}" required id="hobby"/>
					<label style="float:left">简介：</label><textarea name="updateuser.remark" rows="5" style="float:left;margin-top:11px;" required id="remark">${updateuser.remark}</textarea>
					<div class="cz">
						<input type="reset" value="还 原"/>
						<input type="submit" value="更 改" id="updateBtn1"/>
						<input type="button" value="更 改" id="updateBtn2" style="display:none"/>
					</div>
				</form>
			</fieldset>
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
		<script type="text/javascript">
			if("${session_user.username}"!= ""){
				$("#yjdl").show();
				$("#mydl").hide();
			}else{
				$("#yjdl").hide();
				$("#mydl").show();
			};
			
			$("#grade option").each(function(){
				if("${updateuser.grade}"==$(this).text()){
					$(this).attr("selected", "selected");
				}
			}); 
			
			$("select").css("width", parseInt($("#idWidth").css("width"))+4);
			$("textarea").css("width", parseInt($("#idWidth").css("width"))+4).css("max-width", parseInt($("#idWidth").css("width"))+4);
			
			if("${updateFlag}" != ""){
				alert("${updateFlag}");
			}
			
			if (!document.getElementById("Canvas").getContext){          
	            //alert("不支持html5");
	            $("#updateBtn1").hide();
	            $("#updateBtn2").show();
	        }
			
			$("#updateBtn2").click(function(){
	        	var msg = "";
	        	if($("#password").val() == ""){
	        		msg = "密码不能为空！"; 
	    			$("#password").focus();
	    		}else if($("#nickname").val() == ""){
	        		msg = "用户昵称不能为空！";
	    			$("#nickname").focus();
	    		}else if($("#email").val() == ""){
	        		msg = "邮箱不能为空！";
	    			$("#email").focus();
	    		}else if($("#academe").val() == ""){
	        		msg = "学院不能为空！";
	    			$("#academe").focus();
	    		}else if($("#hobby").val() == ""){
	        		msg = "爱好不能为空！";
	    			$("#hobby").focus();
	    		}else if($("#remark").val() == ""){
	        		msg = "简介不能为空！";
	    			$("#remark").focus();
	    		} 
	        	
	        	if(msg != ""){
	        		alert(msg);
	        	}else{
	        		$("#updateForm").submit();
	        	}
			});
		</script>
</body>
</html>
