<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>极游网站后台管理</title>
<link rel="stylesheet" href="css/backstage.css">
</head>

<body>
	<!-- 头部内容 -->
	<%@include file="top.jsp" %>
    <div class="content clearfix">
        <div class="main">
            <!--右侧内容-->
            <div class="cont">
                <div class="title">游戏信息管理</div>
                <div class="details">
                    <div class="details_operation clearfix">
                        <div class="bui_select">
                            <input type="button" value="添&nbsp;&nbsp;加" class="add" 
                            onclick="location.href='toAddgame.cn'" style="cursor:pointer;"/>
                        </div>
                        <div class="fr">
                            <!-- 搜索区 -->
                            <%@include file="seek.jsp" %>
                        </div>
                    </div>
                    <!--表格-->
                    <div style="height:400px;overflow:auto;">
                    <table class="table" cellspacing="0" cellpadding="0" >
                        <thead>
                            <tr>
                                <th width="15%">编号</th>
                                <th width="25%">名称</th>
                                <th width="35%">更新时间</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach var="g" items="${allGame }">
                            <tr>
                                <!--这里的id和for里面的c1 需要循环出来-->
                                <td><input type="checkbox" id="c1" class="check"><label for="c1" class="label">${g.game_id }</label></td>
                                <td>${g.name }</td>
                                <td><fmt:formatDate value="${g.gameTime }" pattern="yyyy年MM月dd日 HH:mm:ss"/></td>
                                <td align="center">
                                	<input type="button" value="修改" class="btn">
                                	<input type="button" value="删除" class="btn" 
                                		onclick="location.href='deletegame.cn?id=${g.game_id}'">
                                </td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    </div>
                </div>
            </div>
        </div>
        <!--左侧列表-->
        <div class="menu">
         	<%@include file="menu.jsp" %>
        </div>
    </div>
</body>
</html>

