<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title> content.html </title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="Keywords" content="KeyWords, KeyWords"/>
	<meta name="description" content=""/>
	<meta name="author" content="Nothing" />
	<style type="text/css">
		*{margin:0px;padding:0px;}
		body{font-size:12px;font-family:"微软雅黑";}
		img{border:0}
		.content_page{width:auto;height:712px;border:1px solid #b6c0c9;border-radius:5px;margin:5px 4px 0 5px;}
		.btn{background:#7a929c;border-radius:3px;padding:1px 8px 1px 8px;color:#fff;margin:5px 0px 5px 5px;display:block;width:30px;text-align:center;height:22px;line-height:22px;text-decoration:none;float:left}
		.update{width:300px;height:200px;margin:10px auto}
		
		fieldset{border:1px dashed;}
		input{font-family:"微软雅黑";}
		label{width:100px;display:inline-block;text-align:right;margin-top:10px;}
		.cz{text-align:center;margin-bottom:10px;margin-top:10px}
		.cz input{border:0 none;background:#7a929c;border-radius:3px;padding:1px 8px 1px 8px;font-family:"微软雅黑";color:#fff;cursor:pointer;}
		#checkbox{margin-top:2px}
		
		.add{width:300px;height:200px;margin:10px auto}
	</style>
	<script type="text/javascript">
		if("${updateFlag}"!=""){
			if("${updateFlag}"=="success"){
				alert("修改成功！");
			}else{
				alert("修改失败！");
			}
		}
		if("${addFlag}"!=""){
			if("${addFlag}"=="success"){
				alert("添加成功！");
			}else{
				alert("添加失败！");
			}
		}
	</script>
</head>
<body>
	<div class="content_page">
		<a href="#" class="btn" id="updateInfo">更 新</a>
		<a href="#" class="btn" id="addCategory">添 加</a>
		<table width="100%" border="1" style="border:#c2c6cc 1px solid; border-collapse:collapse;">
			<tr style="background-color:#f5f7fa; color:#1f324d;" align="center" height="25">
				<th>科目</th>
				<th>图片</th>
				<th>分类</th>
				<th>操作</th>
			</tr>
			<tr align="center">
				<td rowspan="${skill.category_sub_size+2}">${skill.title}</td>
			</tr>
			<tr align="center">
				<td rowspan="${skill.category_sub_size+1}"><img width="50" height="50" src="${pageContext.request.contextPath}/rx/images/<s:property value="skill.image"/>" style="vertical-align:middle;"></td>
			</tr>
			<s:iterator value="skill.category_sub" var="name" status="num"> 
				<tr align="center">
	               	<td>${name}</td>
					<td align="center"><a href="${pageContext.request.contextPath}/homepage/deleteSubSkilltalk.do?category=${name}&id=${id}" onclick="return confirm('你确定要删除？')"><img src="${pageContext.request.contextPath}/admin/images/delete.png" width="13" height="13" style="vertical-align:middle;" title="删除"/></a></td>
				</tr>
            </s:iterator>
		</table>
		
		<div class="update" style="display:none">
			<fieldset>
				<legend style="brder:1px solid red;">Banner图修改</legend>
				<form action="${pageContext.request.contextPath}/homepage/updateSkilltalk.do" method="post" id="updateForm" enctype="multipart/form-data">
					<label>ID：</label><input type="text" name="id" value="${skill.id}" readonly="readonly" title="id不允许被修改" id="updateId"/>
					<label>科目：</label><input type="text" name="title" value="${skill.title}" id="title" required/>
					<label>更改图片：</label><input type="checkbox" id="checkbox"/><input type="text" style="display:none"/>
					<div style="display:none" class="imgControl"><label>图片：</label><input type="file" name="image" id="image"/></div>
					<div class="cz">
						<input type="reset" value="还 原"/>
						<input type="submit" value="更 改" id="updateBtn1"/>
						<input type="button" value="更 改" id="updateBtn2" style="display:none"/>
					</div>
				</form>
			</fieldset>
		</div>
		
		<div class="add" style="display:none">
			<fieldset>
				<legend style="brder:1px solid red;">添加分类</legend>
				<form action="${pageContext.request.contextPath}/homepage/addSubSkilltalk.do" method="post" id="addForm">
					<label>ID：</label><input type="text" name="id" value="${skill.id}" readonly="readonly" title="id不允许被修改"/>
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
		var flag = false;
		$("#checkbox").click(function(){
			if ($(this).attr("checked") == "checked") {
				$(".imgControl").show();
				$("#image").attr("required", true);
				flag = true;
				$("#image").css("width", parseInt($("#updateId").css("width"))+4);
			}else{
				$(".imgControl").hide();
				$("#image").attr("required", false);
				flag = false;
			}

		});
		
		if (!document.getElementById("Canvas").getContext){          
            //alert("不支持html5");
            $("#updateBtn1").hide();
            $("#updateBtn2").show();
            
            $("#addBtn1").hide();
            $("#addBtn2").show();
        }
		
		$("#updateBtn2").click(function(){
			var msg = "";
        	if($("#title").val() == ""){
        		msg = "科目不能为空！";
    			$("#title").focus();
    		}else if($("#image").val() == ""){
        		if(flag == true){
        			msg = "请上传一个图片文件！"; 
        			$("#image").focus();
        		}
    		}			
        	if(msg != ""){
        		alert(msg);
        	}else{
        		$("#updateForm").submit();
        	}
		});
		
		$("#addBtn2").click(function(){
        	if($("#category").val() == ""){
        		alert("分类不能为空！");
    			$("#category").focus();
    		}else{
    			$("#addForm").submit();
    		}
		});
		
		$("#updateInfo").click(function(){
			$(".update").show();
			$(".add").hide();
		});
		$("#addCategory").click(function(){
			$(".update").hide();
			$(".add").show();
			
		});
	</script>
</body>
</html>
