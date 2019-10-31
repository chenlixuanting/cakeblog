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
    <title>文章信息完善项管理</title>
    <link rel="stylesheet" type="text/css" href="assets/admin/layui/css/layui.css"/>
    <link rel="stylesheet" type="text/css" href="assets/admin/static/admin/css/admin.css"/>
</head>

<body>
<div class="layui-tab page-content-wrap">
    <ul class="layui-tab-title">
        <li class="layui-this"> 标签管理</li>
        <li class="layui"> 主题管理</li>
        <li class="layui"> 分类管理</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <div class="layui-form">
                <div class="layui-form-item">
                    <div class="layui-inline tool-btn">
                        <button class="layui-btn layui-btn-small layui-btn-normal hidden-xs" id="addLabelBtn"><i
                                class="layui-icon">&#xe654;</i></button>
                        <button class="layui-btn layui-btn-small layui-btn-warm hidden-xs"><i
                                class="iconfont">&#xe656;</i></button>
                    </div>
                    <div class="layui-inline">
                        <input type="text" name="title" required lay-verify="required" placeholder="请输入标题"
                               autocomplete="off"
                               class="layui-input">
                    </div>
                    <div class="layui-inline">
                        <select name="states" lay-filter="status">
                            <option value="">请选择一个状态</option>
                            <option value="010">显示</option>
                            <option value="021">隐藏</option>
                        </select>
                    </div>
                    <div class="layui-inline">
                        <button class="layui-btn layui-btn-normal" lay-submit="search">搜索</button>
                    </div>
                </div>
            </div>
            <table id="labelTable" lay-filter="labelTableFilter"></table>
            <script type="text/html" id="labelBar">
                <%--<a class="layui-btn layui-btn-normal layui-btn-sm " lay-event="detail">查看</a>--%>
                <a class="layui-btn layui-btn-sm" lay-event="edit">编辑</a>
                <a class="layui-btn layui-btn-danger layui-btn-sm " lay-event="del">删除</a>
            </script>
        </div>
        <div class="layui-tab-item layui">
            <div class="layui-form">
                <div class="layui-form-item">
                    <div class="layui-inline tool-btn">
                        <button class="layui-btn layui-btn-small layui-btn-normal hidden-xs" id="addTopicBtn"><i
                                class="layui-icon">&#xe654;</i></button>
                        <button class="layui-btn layui-btn-small layui-btn-warm hidden-xs"><i
                                class="iconfont">&#xe656;</i></button>
                    </div>
                    <div class="layui-inline">
                        <input type="text" name="title" required lay-verify="required" placeholder="请输入标题"
                               autocomplete="off"
                               class="layui-input">
                    </div>
                    <div class="layui-inline">
                        <select name="states" lay-filter="status">
                            <option value="">请选择一个状态</option>
                            <option value="010">显示</option>
                            <option value="021">隐藏</option>
                        </select>
                    </div>
                    <div class="layui-inline">
                        <button class="layui-btn layui-btn-normal" lay-submit="search">搜索</button>
                    </div>
                </div>
            </div>
            <table id="topicTable" lay-filter="topicTableFilter"></table>
            <script type="text/html" id="topicBar">
                <%--<a class="layui-btn layui-btn-normal layui-btn-sm " lay-event="detail">查看</a>--%>
                <a class="layui-btn layui-btn-sm" lay-event="edit">编辑</a>
                <a class="layui-btn layui-btn-danger layui-btn-sm " lay-event="del">删除</a>
            </script>
        </div>
        <div class="layui-tab-item layui">
            <div class="layui-form">
                <div class="layui-form-item">
                    <div class="layui-inline tool-btn">
                        <button class="layui-btn layui-btn-small layui-btn-normal hidden-xs" id="addTypeBtn"><i
                                class="layui-icon">&#xe654;</i></button>
                        <button class="layui-btn layui-btn-small layui-btn-warm hidden-xs"><i
                                class="iconfont">&#xe656;</i></button>
                    </div>
                    <div class="layui-inline">
                        <input type="text" name="title" required lay-verify="required" placeholder="请输入标题"
                               autocomplete="off"
                               class="layui-input">
                    </div>
                    <div class="layui-inline">
                        <select name="states" lay-filter="status">
                            <option value="">请选择一个状态</option>
                            <option value="010">显示</option>
                            <option value="021">隐藏</option>
                        </select>
                    </div>
                    <div class="layui-inline">
                        <button class="layui-btn layui-btn-normal" lay-submit="search">搜索</button>
                    </div>
                </div>
            </div>
            <table id="typeTable" lay-filter="typeTableFilter"></table>
            <script type="text/html" id="typeBar">
                <%--<a class="layui-btn layui-btn-normal layui-btn-sm " lay-event="detail">查看</a>--%>
                <a class="layui-btn layui-btn-sm" lay-event="edit">编辑</a>
                <a class="layui-btn layui-btn-danger layui-btn-sm " lay-event="del">删除</a>
            </script>
        </div>
    </div>
</div>
<script src="assets/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<script src="assets/admin/static/admin/js/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
<script>
    $(function () {
        //Demo
        layui.use(['form', 'element', 'table'], function () {

            var form = layui.form;
            var element = layui.element;
            var table = layui.table;

            form.render();

            //渲染标签table
            table.render({
                elem: '#labelTable'
                , height: 312
                , url: 'article/labels/pages' //数据接口
                , page: true //开启分页
                , cols: [[ //表头
                    {checkbox: true, fixed: true, width: '5%'},//表头
                    {field: 'id', title: 'ID', width: '10%', sort: true, fixed: 'left'},
                    {field: 'label', title: '标签名称', width: '20%', sort: true, fixed: 'left'},
                    {field: 'creatorName', title: '创建者', width: '20%', sort: true},
                    {
                        field: 'createtime',
                        title: '创建时间',
                        width: '15%',
                        sort: true,
                        templet: "<div>{{layui.util.toDateString(d.createtime, 'yyyy-MM-dd HH:mm:ss')}}</div>"
                    },
                    {
                        field: 'updatetime',
                        title: '更新时间',
                        width: '15%',
                        sort: true,
                        templet: "<div>{{layui.util.toDateString(d.createtime, 'yyyy-MM-dd HH:mm:ss')}}</div>"
                    },
                    {field: '', title: '操作', width: '15%', toolbar: "#labelBar"}
                ]]
            });

            //渲染主题table
            table.render({
                elem: '#topicTable'
                , height: 312
                , url: 'article/topics' //数据接口
                , page: true //开启分页
                , cols: [[ //表头
                    {checkbox: true, fixed: true, width: '5%'},//表头
                    {field: 'id', title: 'ID', width: '10%', sort: true, fixed: 'left'},
                    {field: 'topic', title: '主题名称', width: '20%', sort: true, fixed: 'left'},
                    {field: 'creatorName', title: '创建者', width: '20%', sort: true},
                    {
                        field: 'createtime',
                        title: '创建时间',
                        width: '15%',
                        sort: true,
                        templet: "<div>{{layui.util.toDateString(d.createtime, 'yyyy-MM-dd HH:mm:ss')}}</div>"
                    },
                    {
                        field: 'updatetime',
                        title: '更新时间',
                        width: '15%',
                        sort: true,
                        templet: "<div>{{layui.util.toDateString(d.createtime, 'yyyy-MM-dd HH:mm:ss')}}</div>"
                    },
                    {field: '', title: '操作', width: '15%', toolbar: "#topicBar"}
                ]]
            });

            //渲染分类table
            table.render({
                elem: '#typeTable'
                , height: 312
                , url: 'article/types' //数据接口
                , page: true //开启分页
                , cols: [[ //表头
                    {checkbox: true, fixed: true, width: '5%'},//表头
                    {field: 'id', title: 'ID', width: '10%', sort: true, fixed: 'left'},
                    {field: 'type', title: '分类名称', width: '20%', sort: true, fixed: 'left'},
                    {field: 'creatorName', title: '创建者', width: '20%', sort: true},
                    {
                        field: 'createtime',
                        title: '创建时间',
                        width: '15%',
                        sort: true,
                        templet: "<div>{{layui.util.toDateString(d.createtime, 'yyyy-MM-dd HH:mm:ss')}}</div>"
                    },
                    {
                        field: 'updatetime',
                        title: '更新时间',
                        width: '15%',
                        sort: true,
                        templet: "<div>{{layui.util.toDateString(d.createtime, 'yyyy-MM-dd HH:mm:ss')}}</div>"
                    },
                    {field: '', title: '操作', width: '15%', toolbar: "#typeBar"}
                ]]
            });

            /**
             * 点击添加标签按钮
             */
            $("#addLabelBtn").on('click', function () {

                //页面层
                var addLabelModel = layer.open({
                    type: 1,
                    title: "添加标签",
                    skin: 'layui-layer-rim', //加上边框
                    area: ['600px', '250px'], //宽高
                    content: '<div class="site-text site-block" style="width: 90%;height: 80%;margin-top: 20px;">\n' +
                    '    <form class="layui-form">\n' +
                    '        <div class="layui-form-item">\n' +
                    '            <label class="layui-form-label">标签名称</label>\n' +
                    '            <div class="layui-input-block">\n' +
                    '                <input type="text" name="label" required="" lay-verify="required" placeholder="请输入标签名称" autocomplete="off" class="layui-input">\n' +
                    '            </div>\n' +
                    '        </div>\n' +
                    '        <div class="layui-form-item">\n' +
                    '            <div class="layui-input-block">\n' +
                    '                <button class="layui-btn" lay-submit="" lay-filter="formDemo">立即提交</button>\n' +
                    '                <button type="reset" class="layui-btn layui-btn-primary">重置</button>\n' +
                    '            </div>\n' +
                    '        </div>\n' +
                    '    </form>\n' +
                    '</div>'
                });

                //重新渲染form，否则动态生成的content中的元素没有效果
                form.render();
                form.on('submit(formDemo)', function (data) {
                    $.ajax({
                        type: "POST",
                        url: "article/labels",
                        data: data.field,
                        success: function (msg) {
                            layer.msg(msg.message);
                            if (msg.code == 200) {
                                layer.close(addLabelModel);
                            }
                        }
                    });
                    return false;
                });
            });

            /**
             * 添加主题按钮
             */
            $("#addTopicBtn").on('click', function () {
                var addTopicModel = layer.open({
                    type: 1,
                    title: "添加标签",
                    skin: 'layui-layer-rim', //加上边框
                    area: ['600px', '250px'], //宽高
                    content: '<div class="site-text site-block" style="width: 90%;height: 80%;margin-top: 20px;">\n' +
                    '    <form class="layui-form">\n' +
                    '        <div class="layui-form-item">\n' +
                    '            <label class="layui-form-label">主题名称</label>\n' +
                    '            <div class="layui-input-block">\n' +
                    '                <input type="text" name="topic" required="" lay-verify="required" placeholder="请输入主题名称" autocomplete="off" class="layui-input">\n' +
                    '            </div>\n' +
                    '        </div>\n' +
                    '        <div class="layui-form-item">\n' +
                    '            <div class="layui-input-block">\n' +
                    '                <button class="layui-btn" lay-submit="" lay-filter="formDemo">立即提交</button>\n' +
                    '                <button type="reset" class="layui-btn layui-btn-primary">重置</button>\n' +
                    '            </div>\n' +
                    '        </div>\n' +
                    '    </form>\n' +
                    '</div>'
                });
                //重新渲染form，否则动态生成的content中的元素没有效果
                form.render();
                form.on('submit(formDemo)', function (data) {
                    $.ajax({
                        type: "POST",
                        url: "article/topics",
                        data: data.field,
                        success: function (msg) {
                            layer.msg(msg.message);
                            if (msg.code == 200) {
                                layer.close(addTopicModel);
                            }
                        }
                    });
                    return false;
                });
            });

            /**
             * 添加分类按钮
             */
            $("#addTypeBtn").on('click', function () {
                var addTypeModel = layer.open({
                    type: 1,
                    title: "添加标签",
                    skin: 'layui-layer-rim', //加上边框
                    area: ['600px', '250px'], //宽高
                    content: '<div class="site-text site-block" style="width: 90%;height: 80%;margin-top: 20px;">\n' +
                    '    <form class="layui-form">\n' +
                    '        <div class="layui-form-item">\n' +
                    '            <label class="layui-form-label">分类名称</label>\n' +
                    '            <div class="layui-input-block">\n' +
                    '                <input type="text" name="type" required="" lay-verify="required" placeholder="请输入分类名称" autocomplete="off" class="layui-input">\n' +
                    '            </div>\n' +
                    '        </div>\n' +
                    '        <div class="layui-form-item">\n' +
                    '            <div class="layui-input-block">\n' +
                    '                <button class="layui-btn" lay-submit="" lay-filter="formDemo">立即提交</button>\n' +
                    '                <button type="reset" class="layui-btn layui-btn-primary">重置</button>\n' +
                    '            </div>\n' +
                    '        </div>\n' +
                    '    </form>\n' +
                    '</div>'
                });
                //重新渲染form，否则动态生成的content中的元素没有效果
                form.render();
                form.on('submit(formDemo)', function (data) {
                    $.ajax({
                        type: "POST",
                        url: "article/types",
                        data: data.field,
                        success: function (msg) {
                            layer.msg(msg.message);
                            if (msg.code == 200) {
                                layer.close(addTypeModel);
                            }
                        }
                    });
                    return false;
                });
            });
        });
    });
</script>
</body>
</html>