<%@page pageEncoding="utf-8"%>
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
                <div class="title">资讯信息</div>
                <div class="details">
                    <div class="details_operation clearfix">
                        <div class="bui_select">
                            <input type="button" value="添&nbsp;&nbsp;加" class="add" style="cursor:pointer"
                            	onclick="location.href='toAddinform.cn'">
                        </div>
                        <div class="fr">
                            <div class="text">
                                <span>资讯类型：</span>
                                <div class="bui_select">
                                    <select name="" id="" class="select">
                                        <option value="1">请选择</option>
                                        <option value="1">长篇新闻</option>
                                        <option value="1">短片新闻</option>
                                    </select>
                                </div>
                            </div>
                            <div class="text">
                                <span>申请时间：</span>
                                <div class="bui_select">
                                    <select name="" id="" class="select">
                                        <option value="1">请选择</option>
                                        <option value="1">最近一月</option>
                                        <option value="1">最近一年</option>
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
                                <th width="10%">编号</th>
                                <th width="15%">新闻名</th>
                                <th width="40%">内容</th>
                                <th width="15%">发布时间</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach var="i" items="${inform }">
                            <tr>
                                <td><input type="checkbox" id="c1" class="check"><label for="c1" class="label">${i.informatId }</label></td>
                                <td>${i.name }</td>
                                <td>${i.inform }</td>
                                <td><fmt:formatDate value="${i.upTime }" pattern="yyyy年MM月dd日 HH:mm:ss"/></td>
                                <td align="center">
                                	<input type="button" value="修改" class="btn">
                                	<input type="button" value="删除" class="btn" 
                                		onclick="location.href='deleteInform.cn?id=${i.informatId }'">
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

