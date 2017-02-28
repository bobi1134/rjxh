<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		.content_page{width:auto;height:712px;border:1px solid #b6c0c9;border-radius:5px;margin:5px 4px 0 5px;}
	</style>
</head>
<body>
	<div class="content_page">
	</div>
	<canvas id="Canvas" >  
	</canvas>
	<script type="text/javascript">
		if (!document.getElementById("Canvas").getContext){          
	        alert("您当前的浏览器版本太低，部分功能可能无法实现，请换高版本浏览器使用，例谷歌、火狐、360等，不影响本系统功能的使用！");
	    }
	</script>
</body>
</html>
