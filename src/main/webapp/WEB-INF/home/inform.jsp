<%@page pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>邓迎宏游戏网站-资讯</title>
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
				<a title="手机游戏" href="#">首页</a><span>&gt;</span>
				<a title="手机游戏资讯" href="#">资讯</a><span>&gt;</span>新闻
			</div>
			<!-- 此处是用户的状态栏 -->
			<%@include file="../state.jsp" %>
		</div>
	</div>
		<article style="height:1200px;overflow:auto" class=news_outer id=articles>
		<c:forEach var="imt" items="${informats }">
		<section>
			<hgroup>
				<h2>
					<a href="#" title="#">${imt.name }</a>
				</h2>
				<h3><fmt:formatDate value="${imt.upTime }" pattern="yyyy年MM月dd日 HH:mm:ss"/></h3>
			</hgroup>
			<div class=news_txt>
				<p style="font-size:20px">${imt.inform }</p>
				<figure>
					<a href="#" title="当滑雪遇上探险活宝《Ski Safari》：今冬上架">
					<img width=280px height=200px src="${imt.img }"></a>
				</figure>
			</div>
		</section>
		</c:forEach>
	</article>
	<footer class="mBottom">
		<!-- 引入底部文件foot.jsp -->
		<%@include file="../footer.jsp" %>
	</footer>
<script type="text/javascript">
    //baidu统计代码
    var _bdhmProtocol = (("https:" == document.location.protocol) ? "https//" : " http//");
    document.write(unescape("%3Cscript src='" + _bdhmProtocol));
</script>
</body>
</html>



