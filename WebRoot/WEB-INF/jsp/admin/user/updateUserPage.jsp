<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title> updateUserPage.html </title>
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
		select{font-family:"微软雅黑";}
		textarea{font-family:"微软雅黑";}
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
				<legend style="brder:1px solid red;">用户资料修改</legend>
				<form action="${pageContext.request.contextPath}/user/updateUser.do" method="post" id="updateForm">
					<label>ID：</label><input type="text" name="updateuser.id" value="${updateuser.id}" readonly="readonly" title="用户id不允许被修改" id="idWidth"/>
					<label>用户名：</label><input type="text" value="${updateuser.username}" readonly="readonly" title="用户登陆账号不允许被修改"/>
					
					<s:if test="self==1">
						<label>密码：</label><input type="text" required name="updateuser.password" value="${updateuser.password}" title="普通管理员只能修改自己的密码！" id="password"/>
					</s:if>
					<s:elseif test="#session.session_user.username=='admin'">
						<label>密码：</label><input type="text" required name="updateuser.password" value="${updateuser.password}" title="只有admin用户才能修改所有人的密码，普通管理员请点击top页面个人信息进行修改！" id="password"/>
					</s:elseif>
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
					<label>角色：</label><s:if test="updateuser.username=='admin'"><select disabled="disabled" title="admin用户不允许被修改角色" style="width:140px"><option>管理员</option></select></s:if><s:else><select name="updateuser.role"><s:if test="updateuser.role==1"><option value="1" selected>管理员</option><option value="2">普通会员</option></s:if><s:else><option value="1">管理员</option><option value="2" selected>普通会员</option></s:else></select></s:else>
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
