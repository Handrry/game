<%@page pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>邓迎宏游戏网站-排行</title>
<meta name="keywords" content="手机游戏" />
<meta name="description" content="下载最新手机游戏" />
<link rel="stylesheet" href="style/include/css/m.css" />
<script src="style/include/libs/zepto/zepto.min.js"></script>
<script src="style/include/libs/swipe/swipe.js"></script>
<script src="style/include/js/g-min.js"></script>
<script src="style/include/js/m.js"></script>
<style>
	#pages{
		font-size: 10px;
		height: 40px;
		width: 100%;
	}
	#pages a {
		font-size: 20px;
		line-height: 40px;
	}
</style>
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
<div class="map_wrap">
	    <div class="s_sitemap">
	    <a href="#">排行</a><span>&gt;</span>排行游戏
	    </div>
		<!-- 此处是用户的状态栏 -->
		<%@include file="../state.jsp" %>  
</div>
<article class="g_app">
	<c:forEach var="g" items="${games }">
    <dl>
        <p style="font-size:20px;margin-bottom: 10px;">排名:${g.rank }</p>
        <dd><a href="todetail.fen?name=${g.name }" target="_blank"><span>${g.name }</span></a></dd>
        <dd><span>${g.inform }</span></dd>
    </dl>
    </c:forEach>
</article>
<!-- 分页查询 -->
<div id="pages">
	<!-- 上一页判断 -->
	<c:if test="${page==1 }">
		<a href="">上一页</a>
	</c:if>
	<c:if test="${page!=1 }">
		<a href="topaihang.pai?page=${page-1 }">上一页</a>
	</c:if>
	<!-- 所有页数 -->
	<c:forEach begin="1" end="${total }" var="i">
		<!-- 若循环到了当前页，则将页码高亮显示 -->
		<c:if test="${i==page }">
			<a href="topaihang.pai?page=${i }" class="current_page">${i }</a>
		</c:if>
		<!-- 若不是当前页，则去掉高亮的样式 -->
		<c:if test="${i!=page }">
			<a href="topaihang.pai?page=${i }">${i }</a>
		</c:if>
	</c:forEach>
	<!-- 当前页是最后一页，则不能点下一页 -->
	<c:if test="${page==total }">
		<a href="">下一页</a>
	</c:if>
	<c:if test="${page!=total }">
		<a href="topaihang.pai?page=${page+1 }">下一页</a>
	</c:if>
</div>

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










