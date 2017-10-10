<%@page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎注册</title>
<style>
	body {
		background: url(img/login.jpg) repeat-x top;
	}
	.land {
		border: 1px solid #ccc;
	}
	.head {
		height: 51px;
		width: 100%;
	}
	.head a{
		line-height: 51px;
		text-decoration: none;
		font-size: 20px;
	}
	.head span {
		position: fixed;
		right: 10px;
	}
	.head>a {
		position: fixed;
		left: 10px;
	}
	.land {
		width: 668px;
		height: 592px;
		margin: 0 auto;
	}
	.land h2 {
		text-align: center;
	}
	li {
		list-style-type: none;
	}
	.mailreg input {
		height: 35px;
		width: 445px;
	}
	.foot {
		margin: 0 auto;
	}
	.foot p {
		height: 40px;
		width: 100%;
		line-height: 35px;
		text-align: center;
	}
	.land3 {
		clear: both;
	}
	.land3 input:hover {
		cursor:pointer;
	}
	.land3 input {
		width: 60px;
		height: 40px;
	}
	#i1 {
		margin-left: 80px;
	}
	#i2 {
		margin-left: 160px;
	}
	body div {
		border: 0;
	}
</style>
<script type="text/javascript">
	function $F(id){
		return $(id).value;
	}
	function $(id){
		return document.getElementById(id);
	}
	function getXhr(){
		var xhr = null;
		if(window.XMLHttpRequest){
			xhr = new XMLHttpRequest();
		} else {
			xhr = new ActiveXObject('Microsoft.XMLHttp');
		}
		return xhr;
	}
	function check(){
		var xhr = getXhr();
		xhr.open('get','check.com?email='+$F('login'),true);
		xhr.onreadystatechange = function(){
			if(xhr.readyState==4 && xhr.status==200){
				var txt = xhr.responseText;
				$("suc").innerHTML=txt;
			}
		};
		xhr.send(null);
	}
	function checkPwd(){
		if($F("r_password")!=$F("r_password2")){
			$("ck_pwd").innerHTML="密码不一致";
		}
	}
</script>
</head>
<body>
	<div class="head">
		<a href="home">回到主页</a>
		<span>
			<a href="login.do">[登陆]</a>|<a href="#">[注册]</a>
		</span>
	</div>
	<div class="land">
		<h2>
			会员注册
		</h2>
		<form action="land.com" method="post">
		<div class="land2">
			<ul class="mailreg" style="float:left;margin-left:30px;">
				<li>
					<p class="error"></p>
					<p>邮箱账号: &nbsp;&nbsp;<i id="suc"></i></p>
					<input onblur="check();" name="email" id="login" class="mailbg" type="text" placeholder="请输入邮箱账号">
				</li>
				<li>
					<p class="error"></p>
					<p>昵称:</p>
					<input name="nickname" id="r_name" type="text" placeholder="3-18位中英文、数字、下划线">
				</li>
				<li>
					<p class="error"></p>
					<p>设置密码:</p>
					<input id="r_password" class="pwdbg" type="password" placeholder="请输入密码（6-16位数字、字母或字符的组合）">
				</li>
				<li>
					<p class="error"></p>
					<p>确认密码: <span id="ck_pwd" style="color:red"></span></p>
					<input onblur="checkPwd();" name="password" id="r_password2" class="pwdbg" type="password" placeholder="请输入密码（6-16位数字、字母或字符的组合）">
				</li>	
			</ul> 
		</div>
		<div class="land3">
			<input type="submit" value="注册" id="i1">
			<input type="button" value="取消" id="i2">
		</div>
		</form> 
	</div>
	<div class="foot">
		<p>欢迎注册本网站，开发人员Carry</p>
	</div>
</body>
</html>







