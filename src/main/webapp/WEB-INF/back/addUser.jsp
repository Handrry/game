<%@page pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>游戏后台管理系统</title>
<link rel="stylesheet" href="css/backstage.css">
</head>

<body>
    <%@include file="top.jsp" %>
    <div class="content clearfix">
        <div class="main">
            <!--右侧内容-->
            <div class="cont">
                <div class="title">用户信息</div>
                <div class="details">
                    <div class="details_operation clearfix">
                        <div class="bui_select">
                            <input type="button" value="添&nbsp;&nbsp;加" class="add"
                            	onclick="location.href='addAdmin.cn'">
                        </div>
                        <div class="fr">
                            <div class="text">
                                <span>用户类型：</span>
                                <div class="bui_select">
                                    <select name="" id="" class="select">
                                        <option value="1">请选择</option>
                                        <option value="1">游客</option>
                                        <option value="1">会员</option>
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
                    <table class="table" cellspacing="0" cellpadding="0">
                        <thead>
                            <tr>
                                <th width="15%">邮箱</th>
                                <th width="15%">昵称</th>
                                <th width="25%">密码</th>
                                <th width="25%">热爱游戏</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<form action="addUser.cn" method="post">
                            <tr>
                                <td><input type="text" name="email"/></td>
                                <td><input type="text" name="nickName"/></td>
                                <td><input type="text" name="pwd"/></td>
                                <td><input type="text" name="games"/></td>
                                <td align="center">
                                	<input type="submit" value="确定" class="btn">
                                	<input type="button" value="删除" class="btn">
                                </td>
                            </tr>
                            </form>
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

