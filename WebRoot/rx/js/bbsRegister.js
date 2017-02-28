$("#registerBtn").click(function(){
	var username = $("#username").val();
	var password = $("#password").val();
	var verifyCode = $("#verifyCode").val();
	var msg = "";
	if(username==""){
		msg = "用户名不能为空！";
		$("#username").focus();
	}else if(!/^\w{5,20}$/.test(username)){
		msg = "请输入5-10位由数字或英文字母组成的用户名！";
		$("#username").focus();
	}else if(password==""){
		msg = "密码不能为空！";
		$("#password").focus();
	}else if(verifyCode==""){
		msg = "验证码不能为空！";
		$("#verifyCode").focus();
	}
	
	if(msg!=""){
		alert(msg);
	}else{
		//异步注册
		if(username!=""){
			$.ajax({
				type:"post",
				url:path+"/user/registerUser.do",
				dataType:"json",
				data : $("#registerForm").serialize(),
				success:function(json){
					if(json.input_username=="kong"){
						alert("为什么不输入用户名？");
					}
					
					if(json.input_password=="kong"){
						alert("为什么不输入密码？");
					}
					
					if(json.input_yzm=="kong"){
						alert("为什么不输入验证码？");
					}
					
					if(json.yzm=="error"){
						alert("验证码错误！");
						$("#vimg").trigger("click");
					}
					
					if(json.exist=="true"){
						alert("该用户名已经存在！！");
						$("#username").val("");
						$("#username").focus();
					}
					
					if(json.zc=="ok"){
						alert("注册成功，正在跳转登陆界面！");
						window.location = path+"/user/loginpage.do";
					}
				},
				error:function(){
					alert("服务器错误，请稍后再试！");
				}
			});
		}
	}
});


$("#vimg").click(function()
{
	$("#vimg").attr("src", path+"/user/yzm.do?random=" + Math.random());
});











$("#username").blur(function(){
	var username = $("#username").val();
	if(username!=""){
		$.ajax({
			type:"post",
			url:"${pageContext.request.contextPath}/user/jyUserExist.do?checkUsername="+username,
			dataType:"json",
			success:function(json){
				if(json.exist == "true"){
					alert("该用户名已存在！");
					$("#username").val("");
					$("#username").focus();
				}
			},
			error:function(){
				alert("服务器错误，请稍后再试！");
			}
		});
	}
});





















