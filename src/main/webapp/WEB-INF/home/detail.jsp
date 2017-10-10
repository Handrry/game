<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${game.name }</title>
	<link rel="stylesheet" href="css1/style.css" type="text/css">
</head>
<body>
	<div id="page">
		<div id="header">
			<a href="index.html" id="logo"><img src="images1/logo.png" alt="LOGO"></a>
			<ul id="navigation">
				<li class="selected">
					<a href="home">主页</a>
				</li>
				<li>
					<a href="#">个人中心</a>
				</li>
			</ul>
		</div>
		<div id="contents">
			<div id="tab">
				<ul>
					<li class="selected">
						<a href="#">Featured</a>
					</li>
					<li>
						<a href="#">Recent</a>
					</li>
				</ul>
			</div>
			<div class="section" style="height:608;width:852px;">
					<div class="first" style="float:left">
						<img src="${game.gameImg }" alt="Img">
						<p>
							<span style="font-size:20px ;margin-left:40px">${game.name }</span> 
						</p>
						<p>
							<input type="button" value="开始游戏" style="height:40px;width:100px;margin-left:30px"/>
						</p>
					</div>
					<div style="float:right">
						<img src="images1/ring.jpg" alt="Img" style="margin-left:20px">
						<p style="width:406px;">
							${game.name }<span><i>上架时间:</i> <fmt:formatDate value="${game.gameTime }" pattern="yyyy年MM月dd日 HH:mm:ss"/></span>
							<br/>
							<span><i>游戏类型:</i> ${game.gameType }</span>
							<br/>
							${game.inform }
						</p>
					</div>
			</div>
		</div>
		<div id="footer">
			<p>
				© 邓迎宏. All rights reserved.
			</p>
		</div>
		<span class="extra"></span>
	</div>
</body>
</html>




