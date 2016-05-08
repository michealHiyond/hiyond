<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="../assets/utils/jquery/jquery.min.js"></script>
<script type="text/javascript" src="../assets/utils/jquery/jquery.sha1.js"></script>
<script>
function register(){
	loginAndRegister();
}
function login(){
	loginAndRegister();
}

function loginAndRegister(){
	var password = $.sha1($("#password").val().trim());
	console.log("password"+password);
	$("#password").val(password);
	$("#loginAndRegister").submit();
}
</script>
<body>
<h2>Hello World!</h2>
	<div>
		<form action="login" id="loginAndRegister" method="post">
			<input type="hidden" name="rebackUrl" value="${rebackUrl}">
			<table>
				<tr>
					<td>名字：</td>	<td><input type="text" name="name" value="${name}" id="name" /></td>
				</tr>
				<tr>
					<td>密码：</td>	<td><input type="password" name="password" value="${password}" id="password" /></td>
				</tr>
				<tr>
					<td><input type="button" value="登录" onclick="login();"/></td>
					<td><input type="button" value="注册" onclick="register();"/></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
