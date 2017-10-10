<%@page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎登陆</title>
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
	#imgcode {
		height: 35px;
    	width: 60px;
    	margin-left: 80px;
	}
</style>
</head>
<body>
	<div class="head">
		<a href="home">欢迎来到网站管理系统后台</a>
		<span>
			<a href="#">[登陆]</a>|<a href="home">[退出]</a>
		</span>
	</div>
	<div class="land">
		<h2>
			管理员登陆
		</h2>
		<form action="backlogin.cn" method="post">
		<div class="land2">
			<ul class="mailreg" style="float:left;margin-left:30px;">
				<li>
					<p class="error"><span class="suc"></span><i></i></p>
					<p>账号</p>
					<input name="admin_name" id="r_login_name" class="mailbg" type="text" placeholder="请输入管理员账号">
					<span>${error }</span>
				</li>
				<li>
					<p class="error"><span class="suc"></span><i></i></p>
					<p>密码</p>
					<input name="password" id="r_password" class="pwdbg" type="password" placeholder="请输入密码（6-16位数字、字母或字符的组合）">
				</li>
				<li>
					<p>验证码</p>
					<input id="imgcode" type="text" name="code" />
					<img style="vertical-align:-15px" src="createImg.do" onclick="this.setAttribute('src','createImg.do?x='+Math.random());" alt="验证码" title="点击更换" />
				</li>	
			</ul>  
		</div>
		<div class="land3">
			<input type="submit" value="登陆" id="i1">
			<input type="reset" value="重置" id="i2">
		</div>
		</form>
	</div>
	<div class="foot">
		<p>欢迎注册本网站，开发人员Carry</p>
	</div>
</body>
</html>






