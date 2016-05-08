<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="assets/utils/jquery/jquery.min.js"></script>
<script type="text/javascript" src="assets/utils/jquery/jquery.sha1.js"></script>
<script>
	function gotologin(){
		$("#loginAndRegister").submit();
	}
</script>
<body>
<h2>Hello World!</h2>
	<div>
		<form action="user/gotologin" id="loginAndRegister" method="post">
			<input type="button" value="登录" onclick="gotologin();"/>
		</form>
	</div>
</body>
</html>
