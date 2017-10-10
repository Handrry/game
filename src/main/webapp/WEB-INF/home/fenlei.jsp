<%@page pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>邓迎宏游戏网站-分类</title>
<link rel="stylesheet" href="style/include/css/m.css" />
<script src="style/include/libs/zepto/zepto.min.js"></script>
<script src="style/include/libs/swipe/swipe.js"></script>
<script src="style/include/js/g-min.js"></script>
<script src="style/include/js/m.js"></script>
<script>
	function fun(btn){
		var span = btn.getElementsByTagName("span")[0].innerHTML;
		console.log(span);
		location.href="todetail.fen?name="+span;
	}
</script>
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
       		 <a href="#">首页</a><span>&gt;</span>热门应用
   		 </div>
		 <!-- 此处是用户的状态栏 -->
		 <%@include file="../state.jsp" %>
</div>
<article class="g_app">
    <dl>
        <dt>冒险</dt>
        <dd>
	        <c:forEach var="r" items="${risk }">
	        	<a onclick="fun(this)" target="_blank">
	        		<span>${r.name }</span>
	        	</a>
	        </c:forEach>
        </dd>
    </dl>
    <dl>
        <dt>动作</dt>
        <dd>
        <c:forEach var="a" items="${action }">
	        <a onclick="fun(this)" target="_blank">
	        	<span>${a.name }</span>
	        </a>
        </c:forEach>
        </dd>
    </dl>
    <dl>
        <dt>棋牌</dt>
        <dd>
        <c:forEach var="c" items="${chess }">
	        <a onclick="fun(this)" target="_blank">
	        	<span>${c.name }</span>
	        </a>
        </c:forEach>
        </dd>
    </dl>
    <dl>
        <dt>射击</dt>
        <dd>
        <c:forEach var="s" items="${shoot }">
	        <a onclick="fun(this)" target="_blank">
	        	<span>${s.name }</span>
	        </a>
        </c:forEach>
        </dd>
    </dl>
    <dl>
        <dt>其他</dt>
        <dd><a href="#" target="_blank"><span>通通免<br>费电话</span></a><a href="#" target="_blank"><span>搜狐<br>微博</span></a><a href="#" target="_blank"><span>百度<br>搜索</span></a><a href="#" target="_blank"><span>百度<br>应用</span></a></dd>
    </dl>
</article>
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



