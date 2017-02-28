<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title> addSkilltalkPage.jsp.html </title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="Keywords" content="KeyWords, KeyWords"/>
	<meta name="description" content=""/>
	<meta name="author" content="Nothing" />
	<style type="text/css">
		*{margin:0px;padding:0px;}
		body{font-size:12px;font-family:"微软雅黑";}
		.content_page{width:auto;min-height:712px;border:1px solid #b6c0c9;border-radius:5px;margin:5px 4px 0 5px;}
		.main{width:300px;margin:10px auto;}
		input{font-family:"微软雅黑";}
		fieldset{border:1px dashed;}
		label{width:100px;display:inline-block;text-align:right;margin-top:10px;}
		.cz{text-align:center;margin-bottom:10px;margin-top:10px}
		.cz input{border:0 none;background:#7a929c;border-radius:3px;padding:1px 8px 1px 8px;font-family:"微软雅黑";color:#fff;cursor:pointer;}
	</style>
</head>
<body>
	<div class="content_page">
		<div class="main">
			<fieldset>
				<legend style="brder:1px solid red;">添加</legend>
				<form action="${pageContext.request.contextPath}/homepage/addSkilltalk.do" method="post" id="addForm" enctype="multipart/form-data">
					<label>科目：</label><input type="text" name="title" id="title" required/>
					<label>图片：</label><input type="file" name="image" id="image" required/>
					<label>分类：</label><input type="text" name="category" id="category" required/>
					<div class="cz">
						<input type="reset" value="还 原"/>
						<input type="submit" value="添 加" id="addBtn1"/>
						<input type="button" value="添 加" id="addBtn2" style="display:none"/>
					</div>
				</form>
			</fieldset>
		</div>
	</div>
	<canvas id="Canvas" >  
	</canvas> 
	<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery-1.8.0.js"></script>
	<script type="text/javascript">
		$("#image").css("width", parseInt($("#title").css("width"))+4);
		
		if (!document.getElementById("Canvas").getContext){          
            //alert("不支持html5");
            $("#addBtn1").hide();
            $("#addBtn2").show();
        }
		
		$("#addBtn2").click(function(){
			var msg = "";
        	if($("#image").val() == ""){
        		msg = "请上传一个图片文件！"; 
    			$("#image").focus();
    		}else if($("#title").val() == ""){
        		msg = "标题不能为空！";
    			$("#title").focus();
    		}else if($("#category").val() == ""){
        		msg = "分类不能为空！";
    			$("#category").focus();
    		}
        	
        	if(msg != ""){
        		alert(msg);
        	}else{
        		$("#addForm").submit();
        	}
		});
	</script>
</body>
</html>
