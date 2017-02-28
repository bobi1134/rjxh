<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<title>软件协会—协会简介</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="description" content="川农软件协会网站" />
	<meta name="keywords" content="软件协会，川农" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/rx/css/reset.css" type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/rx/css/all.css" type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/rx/css/sub.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/rx/css/css.css" type="text/css" />
	<link rel="Bookmark"  type="image/x-icon"  href="${pageContext.request.contextPath}/rx/images/favicon.ico"/>
	<link rel="icon"  type="image/x-icon" href="${pageContext.request.contextPath}/rx/images/favicon.ico" />  
	<link rel="shortcut icon"  type="image/x-icon" href="${pageContext.request.contextPath}/rx/images/favicon.ico" /> 
	
</head>
<body>
	  <div id="container">
            <div id="header"><img src="${pageContext.request.contextPath}/rx/images/logo.jpg" alt="" />
                <ul id="nav">
	                <li><a href="${pageContext.request.contextPath}">首页</a></li>
	                <li><a href="${pageContext.request.contextPath}/xhjj/introduce.do" style="background:url(${pageContext.request.contextPath}/rx/images/nav_on.gif)">协会简介</a></li>
	                <li><a href="${pageContext.request.contextPath}/bmfc/style.do">部门风采</a></li>
	                <li><a href="${pageContext.request.contextPath}/bbs/bbs.do">协会论坛</a></li>
	                <li><a href="${pageContext.request.contextPath}/zxdt/news.do">最新动态</a></li>
	                <li><a href="${pageContext.request.contextPath}/lxwm/contact.do">联系我们</a></li>
                </ul>
                <form id="form1" action='' method="GET">
                    <p>
                        <input type="text" class="text1" value="" />
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
				<li ><a href="javascript:void(0)"><s:property value='title'/></a></li>
			</s:iterator>	
		</ul>
	</div> 
<script type="text/javascript" src="${pageContext.request.contextPath}/rx/js/bannerku.js"></script><!--jquery特效库-->
<script type="text/javascript" src="${pageContext.request.contextPath}/rx/js/banner.js"></script><!--jquery特效函数-->
<script type="text/javascript">
	$("#banner_submenu li:first").addClass("current");
</script>
           
	<div id="main-i">
    	<h1 class="title-i">四川农业大学学生软件协会</h1>
    	<hr size="1px" width="100%">
        <div id="word">
        	<s:iterator value="associationIntroduces">
        		<p><s:property value="title"/>：</p><s:property value="content"/><br/>
        	</s:iterator>
		</div>
        <h1>照片墙:</h1>
        <div id="playimages" class="play"> 
    <ul class="big_pic"> 
		<div class="prev"></div> 
		<div class="next"></div> 
 
		<div class="text">加载图片说明……</div> 
		<div class="length">计算图片数量……</div> 
		
		<a class="mark_left" href="javascript:;"></a> 
		<a class="mark_right" href="javascript:;"></a> 
		<div class="bg"></div> 
		<s:iterator value="associationImgIntroduces">
			<li style="z-index:1;"><img src="${pageContext.request.contextPath}/rx/images/<s:property value="image"/>" /></li>
		</s:iterator>
    </ul> 
    <div class="small_pic"> 
        <ul style="width:780px;"> 
	        <s:iterator value="associationImgIntroduces">
				<li style="filter: 100; opacity: 1;"><img src="${pageContext.request.contextPath}/rx/images/<s:property value="image"/>" /></li>
			</s:iterator>
        </ul> 
    </div> 
</div> 
    

    
</div> 
 
		
	</div>





            <div id="footer" style="margin-left:170px;">
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
        <script type="text/javascript">
(function(){
  var o = document.getElementById("word");
  var s = o.innerHTML;
  var p = document.createElement("span");
  var n = document.createElement("a");
  p.innerHTML = s.substring(0,84);
  n.innerHTML = s.length > 84 ? "...详细" : "";
  n.href = "###";
  n.onclick = function(){
    if (n.innerHTML == "...详细"){
      n.innerHTML = "收起";
      p.innerHTML = s;
    }else{
      n.innerHTML = "...详细";
      p.innerHTML = s.substring(0,84);
    }
  }
  o.innerHTML = "";
  o.appendChild(p);
  o.appendChild(n);
})();



var g_aImgInfo=
[
	<s:iterator value="associationImgIntroduces">
	{info: "<s:property value='imgtitle'/>", href: 'javascript:void(0)'},
	</s:iterator>
	
];
var oDiv=null;
var oUlContent=null;
var oUlBtn=null;
var aLiImg=null;
var aLiBtn=null;
var oBtnPrev=null;
var oBtnNext=null;
var oTxtInfo=null;
var oTxtLength=null;
var oMarkPrev=null;
var oMarkNext=null;
var g_aTimerImg=[];
var g_aTimerBtn=[];
var g_oTimerUl=null;
var g_oTimerAutoPlay=null;
var g_aLiBtnAlpha=[];
var g_iNowImg=0;
var g_iZIndexBase=2;
window.onload=function ()
{
	var i=0;
	
	//获取各类元素
	oDiv=document.getElementById('playimages');
	oUlContent=oDiv.getElementsByTagName('ul')[0];
	oUlBtn=oDiv.getElementsByTagName('ul')[1];
	
	oBtnPrev=oDiv.getElementsByTagName('div')[0];
	oBtnNext=oDiv.getElementsByTagName('div')[1];
	
	oTxtInfo=oDiv.getElementsByTagName('div')[2];
	oTxtLength=oDiv.getElementsByTagName('div')[3];
	
	oMarkPrev=oDiv.getElementsByTagName('a')[0];
	oMarkNext=oDiv.getElementsByTagName('a')[1];
	
	aLiImg=oUlContent.getElementsByTagName('li');
	aLiBtn=oUlBtn.getElementsByTagName('li');
	
	//为元素添加属性
	oTxtInfo.innerHTML=g_aImgInfo[0].info;
	oTxtLength.innerHTML='1/'+aLiImg.length;
	
	oMarkPrev.href=g_aImgInfo[0].href;
	oMarkNext.href=g_aImgInfo[0].href;
	
	oBtnPrev.miaovOpacity=0;
	oBtnNext.miaovOpacity=0;
	
	oBtnPrev.miaovTime=0;
	oBtnNext.miaovTime=0;
	
	oUlBtn.style.width=aLiBtn[0].offsetWidth*aLiBtn.length+'px';
	
	//为元素添加事件
	function showPrev()
	{
		showBtn(oBtnPrev);
		hideBtn(oBtnNext);
		
		stopAutoPlay();
	}
	
	function showNext()
	{
		hideBtn(oBtnPrev);
		showBtn(oBtnNext);
		
		stopAutoPlay();
	}
	
	function hideAll()
	{
		hideBtn(oBtnPrev);
		hideBtn(oBtnNext);
		
		startAutoPlay();
	}
	
	oMarkPrev.onmouseover	=showPrev;
	oBtnPrev.onmouseover	=showPrev;
	oMarkNext.onmouseover	=showNext;
	oBtnNext.onmouseover	=showNext;
	
	oBtnPrev.onmouseout		=hideAll;
	oBtnNext.onmouseout		=hideAll;
	oMarkPrev.onmouseout	=hideAll;
	oMarkNext.onmouseout	=hideAll;
	
	oBtnPrev.onmousedown	=gotoPrev;
	oBtnNext.onmousedown	=gotoNext;
	
	oUlBtn.onmouseover		=stopAutoPlay;
	oUlBtn.onmouseout		=startAutoPlay;
	
	for(i=0;i<aLiBtn.length;i++)
	{
		aLiBtn[i].miaovIndex=i;
		aLiBtn[i].onmouseover=function ()
		{
			if(g_iNowImg!=this.miaovIndex)
			{
				showLiBtn(this.miaovIndex);
			}
		};
		aLiBtn[i].onmouseout=function ()
		{
			if(g_iNowImg!=this.miaovIndex)
			{
				hideLiBtn(this.miaovIndex);
			}
		};
		aLiBtn[i].onmousedown=function ()
		{
			gotoImg(this.miaovIndex);
		};
		g_aTimerBtn[i]=null;
		g_aLiBtnAlpha[i]=60;
	}
	
	g_aLiBtnAlpha[0]=100;
	
	startAutoPlay();
};
function showBtn(oBtn)
{
	if(oBtn.miaovTimer)
	{
		clearInterval(oBtn.miaovTimer);
	}
	
	oBtn.miaovTimer=setInterval
	(
		function ()
		{
			if(oBtn.miaovOpacity<100)
			{
				oBtn.miaovOpacity+=10;
				
				oBtn.style.display='block';
				oBtn.style.filter="alpha(opacity:"+oBtn.miaovOpacity+")";
				oBtn.style.opacity=oBtn.miaovOpacity/100;
			}
			else
			{
				oBtn.style.filter="";
				oBtn.style.opacity="";
				
				clearInterval(oBtn.miaovTimer);
				oBtn.miaovTimer=0;
			}
		}, 30
	);
}
function hideBtn(oBtn)
{
	if(oBtn.miaovTimer)
	{
		clearInterval(oBtn.miaovTimer);
	}
	
	oBtn.miaovTimer=setInterval
	(
		function ()
		{
			if(oBtn.miaovOpacity>0)
			{
				oBtn.miaovOpacity-=10;
				
				oBtn.style.filter="alpha(opacity:"+oBtn.miaovOpacity+")";
				oBtn.style.opacity=oBtn.miaovOpacity/100;
			}
			else
			{
				oBtn.style.display='none';
				oBtn.style.filter="";
				oBtn.style.opacity="";
				
				clearInterval(oBtn.miaovTimer);
				oBtn.miaovTimer=0;
			}
		}, 30
	);
}
function gotoImg(index)
{
	if(index==g_iNowImg)
	{
		return;
	}
	
	aLiImg[index].style.height='0px';
	aLiImg[index].style.display='block';
	aLiImg[index].style.zIndex=g_iZIndexBase++;
	
	if(g_aTimerImg[index])
	{
		clearInterval(g_aTimerImg[index]);
	}
	g_aTimerImg[index]=setInterval("slideDown("+index+")", 30);
	
	for(i=0;i<aLiBtn.length;i++)
	{
		if(i==index)
		{
			showLiBtn(i);
		}
		else
		{
			hideLiBtn(i);
		}
	}
	
	moveUlBtn(index);
	
	oTxtInfo.innerHTML=g_aImgInfo[index].info;
	oTxtLength.innerHTML=(index+1)+'/'+aLiImg.length;
	
	oMarkPrev.href=g_aImgInfo[index].href;
	oMarkNext.href=g_aImgInfo[index].href;
	
	g_iNowImg=index;
}
function slideDown(index)
{
	var h=aLiImg[index].offsetHeight+10;
	
	if(h>=oUlContent.offsetHeight)
	{
		h=oUlContent.offsetHeight;
		
		clearInterval(g_aTimerImg[index]);
		g_aTimerImg[index]=null;
	}
	
	aLiImg[index].style.height=h+'px';
}
function gotoNext()
{
	gotoImg((g_iNowImg+1)%aLiImg.length);
}
function gotoPrev()
{
	gotoImg((g_iNowImg-1+aLiImg.length)%aLiImg.length);
}
function showLiBtn(index)
{
	if(g_aTimerBtn[index])
	{
		clearInterval(g_aTimerBtn[index]);
	}
	g_aTimerBtn[index]=setInterval("showLiBtnInner("+index+")", 30);
}
function showLiBtnInner(index)
{
	var alpha=g_aLiBtnAlpha[index]+10;
	
	if(alpha>=100)
	{
		aLiBtn[index].style.filter='';
		aLiBtn[index].style.opacity='1';
		
		clearInterval(g_aTimerBtn[index]);
		g_aTimerBtn[index]=null;
	}
	else
	{
		aLiBtn[index].style.filter='alpha(opacity:'+alpha+')';
		aLiBtn[index].style.opacity=alpha/100;
	}
	
	g_aLiBtnAlpha[index]=alpha;
}
function hideLiBtn(index)
{
	if(g_aTimerBtn[index])
	{
		clearInterval(g_aTimerBtn[index]);
	}
	g_aTimerBtn[index]=setInterval("hideLiBtnInner("+index+")", 30);
}
function hideLiBtnInner(index)
{
	var alpha=g_aLiBtnAlpha[index]-10;
	
	if(alpha<=60)
	{
		alpha=60;
		
		clearInterval(g_aTimerBtn[index]);
		g_aTimerBtn[index]=null;
	}
	aLiBtn[index].style.filter='alpha(opacity:'+alpha+')';
	aLiBtn[index].style.opacity=alpha/100;
	
	g_aLiBtnAlpha[index]=alpha;
}
function moveUlBtn(index)
{
	var iTarget=0;
	
	if(index==0)
	{
		index=1;
	}
	else if(index==aLiBtn.length-1)
	{
		index=aLiBtn.length-2;
	}
	
	iTarget=-(index-1)*aLiBtn[0].offsetWidth;
	
	if(g_oTimerUl)
	{
		clearInterval(g_oTimerUl);
	}
	
	g_oTimerUl=setInterval("moveUlBtnInner("+iTarget+")", 30);
}
function moveUlBtnInner(iTarget)
{
	var iSpeed=(iTarget-oUlBtn.offsetLeft)/7;
	
	if(iSpeed>0)
	{
		iSpeed=Math.ceil(iSpeed);
	}
	else
	{
		iSpeed=Math.floor(iSpeed);
	}
	
	if(oUlBtn.offsetLeft==iTarget)
	{
		clearInterval(g_oTimerUl);
		g_oTimerUl=null;
	}
	else
	{
		oUlBtn.style.left=oUlBtn.offsetLeft+iSpeed+'px';
	}
}
function startAutoPlay()
{
	if(g_oTimerAutoPlay)
	{
		clearInterval(g_oTimerAutoPlay);
	}
	
	g_oTimerAutoPlay=setInterval(gotoNext, 3000);
}
function stopAutoPlay()
{
	if(g_oTimerAutoPlay)
	{
		clearInterval(g_oTimerAutoPlay);
		g_oTimerAutoPlay=null;
	}
}





 </script>
</body>
</html>