<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>游戏网站后台管理</title>
<link rel="stylesheet" href="css/backstage.css">
</head>

<body>
    <%@include file="top.jsp" %>
    <div class="content clearfix">
        <div class="main">
            <!--右侧内容-->
            <div class="cont">
                <div class="title">留言信息</div>
                <div class="details">
                    <div class="details_operation clearfix">
                        <div class="bui_select">
                            <input type="button" value="全&nbsp;&nbsp;部" class="add" style="cursor:pointer">
                        </div>
                        <div class="fr">
                            <div class="text">
                                <span>留言时段：</span>
                                <div class="bui_select">
                                    <select name="" id="" class="select">
                                        <option value="0">请选择</option>
                                        <option value="1">最近一月</option>
                                        <option value="2">最近一年</option>
                                    </select>
                                </div>
                            </div>
                            <div class="text">
                                <span style="cursor:pointer;">搜索</span>
                                <input type="text" value="" class="search">
                            </div>
                        </div>
                    </div>
                    <!--表格-->
                    <div style="height:400px;overflow:auto;">
                    <table class="table" cellspacing="0" cellpadding="0">
                        <thead>
                            <tr>
                                <th width="15%">编号</th>
                                <th width="20%">留言人</th>
                                <th width="30%">内容</th>
                                <th width="15%">留言时间</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach var="m" items="${mess }">
                            <tr>
                                <td><input type="checkbox" id="c1" class="check"><label for="c1" class="label">${m.id }</label></td>
                                <td>${m.nickName }</td>
                                <td>${m.words }</td>
                                <td><fmt:formatDate value="${m.sayTime }" pattern="yyyy年MM月dd日 HH:mm:ss"/></td>
                                <td align="center">
                                	<input type="button" value="修改" class="btn">
                                	<input type="button" value="删除" class="btn" 
                                		onclick="location.href='deleteMsg.cn?id=${m.id }'">
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
        <div class="menu" style="height:400px">
            <%@include file="menu.jsp" %>
        </div>
    </div>
</body>
</html>

