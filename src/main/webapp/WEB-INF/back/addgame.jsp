<%@page pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>游戏后台管理系统</title>
<link rel="stylesheet" href="css/backstage.css">
</head>

<body>
    <div class="head">
            <div class="logo fl"><a href="#"></a></div>
            <h3 class="head_text fr">极游后台管理系统</h3>
    </div>
    <div class="operation_user clearfix">
        <div class="link fl"><a href="#">极游</a><span>&gt;&gt;</span><a href="#">游戏管理</a></div>
        <div class="link fr">
            <a href="#" class="icon icon_i">首页</a><span></span><a href="#" class="icon icon_j">前进</a><span></span><a href="#" class="icon icon_t">后退</a><span></span><a href="#" class="icon icon_n">刷新</a><span></span><a href="#" class="icon icon_e">退出</a>
        </div>
    </div>
    <div class="content clearfix">
        <div class="main">
            <!--右侧内容-->
            <div class="cont">
                <div class="title">发布游戏</div>
                <div class="details">
                    <div class="details_operation clearfix">
                        <div class="bui_select">
                            <input type="button" value="添加游戏" class="add">
                        </div>
                        <div class="fr" >
                            <%@include file="seek.jsp" %>
                        </div>
                    </div>
                    <!--表格-->
                    <table class="table" cellspacing="0" cellpadding="0" >
                        <thead>
                            <tr>
                                <th width="15%">游戏名</th>
                                <th width="25%">热度排名</th>
                                <th width="35%">游戏类型</th>
                                <th width="35%">游戏描述</th>
                                <th width="35%">图片</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                            	<form action="addgames.cn" method="post">
	                                <td><input type="text" name="name"/></td>
	                                <td><input type="text" name="rank"/></td>
	                                <td><input type="text" name="type"/></td>
	                                <td><input type="text" name="describe"/></td>
	                                <td><input type="text" name="img"/></td>
	                                <td align="center">
	                                	<input type="submit" value="发布" class="btn">
	                                	<input type="button" value="删除" class="btn">
	                                </td>
                                </form>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <!--左侧列表-->
        <div class="menu" style="height:400px">
            <%@include file="menu.jsp" %>
        </div>
    </div>
</body>
</html>

