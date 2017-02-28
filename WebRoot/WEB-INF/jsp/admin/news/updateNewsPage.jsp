<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title> updateNewsPage.html </title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="Keywords" content="KeyWords, KeyWords"/>
	<meta name="description" content=""/>
	<meta name="author" content="Nothing" />
	<style type="text/css">
		*{margin:0px;padding:0px;}
		body{font-size:12px;font-family:"微软雅黑";}
		.content_page{width:auto;min-height:712px;border:1px solid #b6c0c9;border-radius:5px;margin:5px 4px 0 5px;}
		input{font-family:"微软雅黑";}
		
		.cz{margin-bottom:10px;margin-top:10px;}
		.cz input{border:0 none;background:#7a929c;border-radius:3px;padding:1px 8px 1px 8px;font-family:"微软雅黑";color:#fff;cursor:pointer;}
	</style>
</head>
<body>
	<div class="content_page">
		<form action="${pageContext.request.contextPath}/zxdt/updateNews.do" method="post" id="updateForm">
			<input type="hidden" name="new_.id" value="${new_.id}"/>
			<div style="margin:10px 0 10px 0;">
				标题：<input type="text" name="new_.title" value="${new_.title}" id="title" />
			</div>
			<textarea name="new_.content" id="editorContainer">${new_.content}</textarea>
			<textarea id="content" style="display:none"></textarea>
			<div class="cz">
				<input type="reset" value="还 原"/>
				<input type="button" value="更 改" id="updateBtn"/>
			</div>
		</form>
	</div>
	<canvas id="Canvas" >  
	</canvas> 
	<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery-1.8.0.js"></script>
	<!-- 网页编辑器js插件 -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/cj/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/cj/ueditor/ueditor.all.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/cj/ueditor/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript">
		if (!document.getElementById("Canvas").getContext){          
	        alert("您当前的浏览器不支持Ueditor的部分功能，请换一个浏览器试试！");
	    }
		
		var ue = UE.getEditor("editorContainer",{
			initialFrameWidth:$(".content_page").css("width"),
			initialFrameHeight:600,
			autoHeightEnabled: false,
			initialStyle:"p{line-height:1em; font-family:'微软雅黑';font-size:14px}",
		});
		
		$("#title").css("width", parseInt($(".content_page").css("width"))-40);
		
		
		//浏览器窗口大小更改时
		window.onresize=function(){  
			$("#title").css("width", parseInt($(".content_page").css("width"))-40);
		};
		
		$("#updateBtn").click(function(){
			$("#content").html(UE.getEditor("editorContainer").getContent());
			var msg = "";
        	if($("#title").val() == ""){
        		msg = "请输入标题！"; 
    			$("#title").focus();
    		}else if($("#content").val() == ""){
        		msg = "内容不能为空！";
    			$("#content").focus();
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
