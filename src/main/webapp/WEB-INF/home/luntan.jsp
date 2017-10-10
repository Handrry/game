<%@page pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>邓迎宏游戏网站-论坛</title>
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
	        <a href="home">首页</a><span>&gt;</span>欢迎您,${user.getNickName() }
	    </div>
		<!-- 此处是用户的状态栏 -->
		<%@include file="../state.jsp" %>
	</div>
	<div class=wap_main>
		<div class=mRank>
			<ul class=mr_list>
				<c:forEach var="c" items="${message }">
				 	<li>
						<a title="@" href="#">
						<div class=mImgBox>
								<img src="${c.path }" width=58 height=58 alt="@" />
						</div>
						<div class=rank_txt>
								<figure><span>${c.nickName }:</span>${c.words }</figure>
						</div>
						</a>
						<div class=ooo>
							<span style="font-size:bold;width:76px;height:42px;position:absolute;right:10px;top:22px;">
							${c.sayTime }</span>
						</div>
						<div class=clear></div>
					</li>
				</c:forEach>
			</ul>
			<form action="" method="post">
				<!--分页-->
                <div id="pages">
					<c:if test="${page==1 }">
						<a href="">上一页</a>
					</c:if>
					<c:if test="${page!=1 }">
						<a href="toluntan.tan?page=${page-1 }">上一页</a>
					</c:if>
	
					<!-- 
	                	begin：循环起始位置；
	                	end：循环终止位置；
	                -->
					<c:forEach begin="1" end="${total }" var="i">
						<!-- 若循环到了当前页，则将页码高亮显示 -->
						<c:if test="${i==page }">
							<a href="toluntan.tan?page=${i }" class="current_page">${i }</a>
						</c:if>
						<!-- 若不是当前页，则去掉高亮的样式 -->
						<c:if test="${i!=page }">
							<a href="toluntan.tan?page=${i }">${i }</a>
						</c:if>
					</c:forEach>
	
					<!-- 当前页是最后一页，则不能点下一页 -->
					<c:if test="${page==total }">
						<a href="">下一页</a>
					</c:if>
					<c:if test="${page!=total }">
						<a href="toluntan.tan?page=${page+1 }">下一页</a>
					</c:if>
				</div>
			</form>
		</div>
	</div>
	<!-- 此处是写玩家可以留言 -->
	<form action="word.tan" method="post">
		<input type="submit" value="留言" style="height:30px;width:45px;margin-left:30px"/>
		<input type="text" name="word" style=" height: 35px;width: 445px "/>
	</form>
	
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



