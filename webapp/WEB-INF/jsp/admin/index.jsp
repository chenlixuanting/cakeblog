<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>"/>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <title>网站后台管理模版</title>
    <link rel="stylesheet" type="text/css" href="assets/admin/static/admin/layui/css/layui.css"/>
    <link rel="stylesheet" type="text/css" href="assets/admin/static/admin/css/admin.css"/>
</head>
<body>
<div class="main-layout" id='main-layout'>
    <!--侧边栏-->
    <div class="main-layout-side">
        <div class="m-logo">
        </div>
        <ul class="layui-nav layui-nav-tree" lay-filter="leftNav">

            <%--参照模板--%>
            <li class="layui-nav-item layui-nav-itemed">
                <a href="javascript:;"><i class="iconfont">&#xe607;</i>菜单管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;" data-url="admin/menu1" data-id='1' data-text="后台菜单"><span
                            class="l-line"></span>后台菜单</a></dd>
                    <dd><a href="javascript:;" data-url="admin/menu2" data-id='2' data-text="前台菜单"><span
                            class="l-line"></span>前台菜单</a></dd>
                </dl>
            </li>

            <%--网站首页管理--%>
            <li class="layui-nav-item layui-nav-itemed">
                <a href="javascript:;"><i class="iconfont">&#xe607;</i>网站首页管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;" data-url="admin/menu1" data-id='1' data-text="图片管理"><span
                            class="l-line"></span>图片管理</a></dd>
                    <dd><a href="javascript:;" data-url="admin/menu2" data-id='2' data-text="菜单管理"><span
                            class="l-line"></span>菜单管理</a></dd>
                </dl>
            </li>

            <%--网站后台管理--%>
            <li class="layui-nav-item layui-nav-itemed">
                <a href="javascript:;"><i class="iconfont">&#xe607;</i>网站后台管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;" data-url="admin/menu1" data-id='1' data-text="后台菜单"><span
                            class="l-line"></span>后台菜单</a></dd>
                    <dd><a href="javascript:;" data-url="admin/menu2" data-id='2' data-text="前台菜单"><span
                            class="l-line"></span>前台菜单</a></dd>
                </dl>
            </li>

            <%--文章管理--%>
            <li class="layui-nav-item">
                <a href="javascript:;"><i class="iconfont">&#xe608;</i>文章管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;" data-url="admin/article-info-manage" data-id='3'
                           data-text="完善信息项管理"><span class="l-line"></span>文章详细信息</a></dd>
                    <dd><a href="javascript:;" data-url="danye-list.html" data-id='9' data-text="单页管理"><span
                            class="l-line"></span>单页管理</a></dd>
                </dl>
            </li>

            <%--写博客--%>
            <li class="layui-nav-item">
                <a href="admin/write-blog" target="_blank"><i class="iconfont">&#xe604;</i>写博客</a>
            </li>

            <%--友情链接管理--%>
            <li class="layui-nav-item">
                <a href="javascript:;" data-url="admin/link" data-id='4' data-text="友情链接"><i
                        class="iconfont">&#xe603;</i>友情链接</a>
            </li>

            <li class="layui-nav-item">
                <a href="javascript:;" data-url="" data-id='5' data-text="个人信息"><i class="iconfont">&#xe606;</i>个人信息</a>
            </li>

            <li class="layui-nav-item">
                <a href="javascript:;" data-url="system.html" data-id='6' data-text="系统设置"><i
                        class="iconfont">&#xe60b;</i>系统设置</a>
            </li>
        </ul>
    </div>
    <!--右侧内容-->
    <div class="main-layout-container">
        <!--头部-->
        <div class="main-layout-header">
            <div class="menu-btn" id="hideBtn">
                <a href="javascript:;">
                    <span class="iconfont">&#xe60e;</span>
                </a>
            </div>
            <ul class="layui-nav" lay-filter="rightNav">
                <li class="layui-nav-item"><a href="javascript:;" data-url="email.html" data-id='4' data-text="邮件系统"><i
                        class="iconfont">&#xe603;</i></a></li>
                <li class="layui-nav-item">
                    <a href="javascript:;" data-url="admin-info.html" data-id='5' data-text="个人信息">超级管理员</a>
                </li>
                <li class="layui-nav-item"><a href="javascript:;">退出</a></li>
            </ul>
        </div>
        <!--主体内容-->
        <div class="main-layout-body">
            <!--tab 切换-->
            <div class="layui-tab layui-tab-brief main-layout-tab" lay-filter="tab" lay-allowClose="true">
                <ul class="layui-tab-title">
                    <li class="layui-this welcome">后台主页</li>
                </ul>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show" style="background: #f5f5f5;">
                        <!--1-->
                        <iframe src="admin/welcome" width="100%" height="100%" name="iframe" scrolling="auto"
                                class="iframe" framborder="0"></iframe>
                        <!--1end-->
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--遮罩-->
    <div class="main-mask">
    </div>
</div>
<script type="text/javascript">
    var scope = {
        link: 'admin/welcome'
    }
</script>
<script src="assets/admin/static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<script src="assets/admin/static/admin/js/common.js" type="text/javascript" charset="utf-8"></script>
<script src="assets/admin/static/admin/js/main.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
