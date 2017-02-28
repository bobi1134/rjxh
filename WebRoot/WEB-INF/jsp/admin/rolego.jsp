<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Insert title here</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="Keywords" content="KeyWords, KeyWords"/>
		<meta name="description" content=""/>
		<meta name="author" content="Nothing"/>
	</head>
	<body>
		<script type="text/javascript">
			if("${session_user.role}" == 1){
				window.location = "${pageContext.request.contextPath}/user/admin.do";
			}else{
				window.location = "${pageContext.request.contextPath}/bbs/bbs.do";
			}
		</script>
	</body>
</html>