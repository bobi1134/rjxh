<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title> updateStyleZcPage.html </title>
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
		textarea{font-family:"微软雅黑";}
		fieldset{border:1px dashed;}
		label{width:100px;display:inline-block;text-align:right;margin-top:10px;}
		.cz{text-align:center;margin:10px 100px 10px 0px;float:right}
		.cz input{border:0 none;background:#7a929c;border-radius:3px;padding:1px 8px 1px 8px;font-family:"微软雅黑";color:#fff;cursor:pointer;}
	</style>
</head>
<body>
	<div class="content_page">
		<div class="main">
			<fieldset>
				<legend style="brder:1px solid red;">部门风采基本信息修改</legend>
				<form action="${pageContext.request.contextPath}/bmfc/updateZc.do" method="post" id="updateForm">
					<label>ID：</label><input type="text" name="style.id" value="${style.id}" readonly="readonly" title="id不允许被修改" id="id"/>
					<label style="float:left">简介：</label><textarea name="style.about" rows="5" style="float:left;margin-top:11px;" required id="about">${style.about}</textarea>
					<div class="cz">
						<input type="reset" value="还 原"/>
						<input type="submit" value="更 改" id="updateBtn1"/>
						<input type="button" value="更 改" id="updateBtn2" style="display:none"/>
					</div>
				</form>
			</fieldset>
		</div>
	</div>
	<canvas id="Canvas" >  
	</canvas> 
	<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery-1.8.0.js"></script>
	<script type="text/javascript">
		$("textarea").css("width", parseInt($("#id").css("width"))+4).css("max-width", parseInt($("#id").css("width"))+4);
	
		
		/*******低版本ie使用********/
		if (!document.getElementById("Canvas").getContext){          
            //alert("不支持html5");
            $("#updateBtn1").hide();
            $("#updateBtn2").show();
        }
		
		$("#updateBtn2").click(function(){
			var msg = "";
        	if($("#about").val() == ""){
        		msg = "简介不能为空！"; 
    			$("#about").focus();
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
