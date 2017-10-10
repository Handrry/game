<%@page pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>${name }游戏网站-主页</title>
<meta name="keywords" content="手机游戏" />
<meta name="description" content="下载最新手机游戏" />
<link rel="stylesheet" href="style/include/css/m.css" />
<script src="style/include/libs/zepto/zepto.min.js"></script>
<script src="style/include/libs/swipe/swipe.js"></script>
<script src="style/include/js/g-min.js"></script>
<script src="style/include/js/m.js"></script>
</head>
<body>
	<header class="m_header">
		<div class="topper">
			<!-- 引入搜索局域栏 -->
			<%@include file="../seek.jsp" %>
		</div>
		<nav class="m_nav">
			<div class="navMain">
				<!-- 导航区 -->
				<%@include file="../menu.jsp" %>
			</div>
		</nav>
		<div id="gallery" class="top_imgB">
			<!-- 引入jsp文件 图片区 -->
			<%@include file="../imgMenu.jsp" %>
			<nav></nav>
		</div>
	</header>
	<div class=map_wrap>
		<div class=s_navtitle>
			<div class=s_sitemap>
				<a title="手机游戏" href="#">首页</a>
			</div>
			<!-- 此处是用户的状态栏 -->
			<%@include file="../state.jsp" %>
		</div>
	</div>
	<article class=install_game>
		<section>
			<h1>
				<img src="images/install-game.png" alt="">
			</h1>
			<aside class=ins_info>
				<div class=info_inner>
					<p>
						<label>版本号：</label><span>V 3.1.0</span>
					</p>
					<p>
						<label>应用大小：</label><span>3.39MB</span>
					</p>
					<p>
						<label>更新时间：</label><span>2013年8月15日</span>
					</p>
					<p>
						适用于<em>Android1.6</em>以上系统机型
					</p>
				</div>
				<p class=client_downLoad>
					<a title="安卓游戏极游游戏下载"
						href="#"
						onclick="gf1();"></a>
				</p>
			</aside>
			<ul class=ins_desc>
				<li>361度搜罗最新、最全、最酷安卓游戏</li>
				<li>全新的社交系统，方便您轻松找到志同道合的玩友</li>
				<li>桌面化的游戏管理，方便、快捷、实用</li>
				<li>游戏升级智能检测，即使签名不一致，亦可以帮您一键成功搞定</li>
				<li>游戏订阅，最新最酷最好玩的安卓游戏推给最潮的你</li>
				<li>签到游戏，与百万游戏玩家展开地主争夺战，展现最具个性的你</li>
			</ul>
		</section>
	</article>
	<div class=slide_img>
		<aside>
			<img src="images/install-ui.png" alt="">
		</aside>
	</div>
	<aside class=akey_down>
		<h1 class=client_load>
			<a title="安卓游戏极游游戏下载"
				href="#"
				onclick="gf2();"></a>
		</h1>
	</aside>

	<footer class="mBottom">
		<!-- 引入底部文件foot.jsp -->
		<%@include file="../footer.jsp" %>
	</footer>
<script type="text/javascript">
    //baidu统计代码
    var _bdhmProtocol = (("https:" == document.location.protocol) ? " https//" : " http//");
    document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F776417633d30a5c201cb1e433abed5a5' type='text/javascript'%3E%3C/script%3E"));
</script>
</body>
</html>

