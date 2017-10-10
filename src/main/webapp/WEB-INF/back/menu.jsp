<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<div class="cont">
    <div class="title">管理员:${user.admin_name }</div>
    <ul class="mList">
        <li>
            <h3><span>-</span>用户管理</h3>
            <dl>
                <dd><a href="backIndex.cn">管理员身份管理</a></dd>
                <dd><a href="tobackUser.cn">用户信息管理</a></dd>
            </dl>
        </li>
        <li>
            <h3><span>+</span>游戏管理</h3>
            <dl>
                <dd><a href="toControlGame.cn">游戏信息管理</a></dd>
                <dd><a href="tobackInform.cn">游戏新闻管理</a></dd>
                <dd><a href="toBackMsg.cn">玩家留言管理</a></dd>
            </dl>
        </li>
    </ul>
</div>



