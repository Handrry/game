<%@page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改信息</title>
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
			修改个人信息
		</h2>
		<div class="land2">
			<form action="amend.com" method="post" enctype="multipart/form-data">
				<p style="font-size:20px;margin-left: 80px">个人头像</p>
				<span class="error" style="margin-left: 80px;display:inline-block"><i>${cuowu }</i>
				<img src="${img }" style="float:right"></span>
				<input name="photo" class="pwdbg" type="file" style="margin-left: 80px"><br/>
				<input type="submit"  value="确认" style="margin-left: 80px;margin-top:20px;"/>
			</form> 
			<form action="amends.com" method="post">
			<ul class="mailreg" style="float:left;margin-left:30px;">
				<li>
					<p class="error"><span class="suc"></span><i></i></p>
					<p>昵称</p>
					<input name="nickname" id="r_login_name" class="mailbg" type="text" placeholder="请输入昵称">
				</li>
				<li>
					<p class="error"><span class="suc"></span><i></i></p>
					<p>密码</p>
					<input name="password" id="r_name" type="text" placeholder="3-18位中英文、数字、下划线">
				</li>
				<li>
					<p class="error"><span class="suc"></span><i></i></p>
					<p>热爱游戏</p>
					<input name="text" id="r_password2" class="pwdbg" type="text" placeholder="请输入您喜爱的游戏">
				</li>	
			</ul> 
			<div class="land3">
				<input type="submit" value="修改" id="i1">
				<input type="button" value="取消" id="i2">
			</div>
			</form>
		</div>
	</div>
	<div class="foot">
		<p>欢迎使用修改页面，开发人员Carry</p>
	</div>
</body>
</html>







