<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>写博客</title>
    <link rel="stylesheet" type="text/css" href="assets/admin/mdeditor/css/editormd.css"/>
    <link rel="stylesheet" type="text/css" href="assets/admin/layui/css/layui.css">
</head>
<body>
<div id="test-editor">
    <textarea style="display:none;">### 关于 Editor.md
        **Editor.md** 是一款开源的、可嵌入的 Markdown 在线编辑器（组件），基于 CodeMirror、jQuery 和 Marked 构建。
    </textarea>
</div>
</body>
<script src="assets/admin/static/admin/js/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
<script src="assets/admin/mdeditor/editormd.js" type="text/javascript" charset="utf-8"></script>
<script src="assets/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<script src="assets/common/ajaxutil.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
    $(function () {

        layui.use(['upload', 'form', 'layer'], function () {

            var layer = layui.layer;
            var form = layui.form;
            var upload = layui.upload;

            var editor = editormd("test-editor", {
                width: "100%",
                height: "100%",
                theme: "default",
                previewTheme: "default",
                editorTheme: "3024-day",
                saveHTMLToTextarea: true,
                path: "assets/admin/mdeditor/lib/",
                imageUpload: true,
                imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
                imageUploadURL: "upload/blog-pic",
                toolbarIcons: function () {
                    // Or return editormd.toolbarModes[name]; // full, simple, mini
                    // Using "||" set icons align right.
                    return ["undo", "redo",
                        "|", "bold", "del", "italic", "quote", "ucwords", "uppercase", "lowercase",
                        "|", "h1", "h2", "h3", "h4", "h5", "h6",
                        "|", "list-ul", "list-ol", "hr",
                        "|", "link", "reference-link", "image", "code",
                        "|", "preformatted-text", "code-block", "table", "datetime", "emoji", "html-entities", "pagebreak", "goto-line",
                        "||", "post", "save", "fullscreen", "info", "watch", "preview", "watch", "clear", "search", "download"]
                },
                // 用于增加自定义工具栏的功能，可以直接插入HTML标签，不使用默认的元素创建图标
                toolbarCustomIcons: {
                    post: "<button id='postArticle' class='layui-btn layui-btn-normal'>发布文章</button>",
                    save: "<button id='saveArticle' class='layui-btn'>保存草稿</button>"
                },
                // 自定义工具栏按钮的事件处理
                toolbarHandlers: {
                    /**
                     * @param {Object}      cm         CodeMirror对象
                     * @param {Object}      icon       图标按钮jQuery元素对象
                     * @param {Object}      cursor     CodeMirror的光标对象，可获取光标所在行和位置
                     * @param {String}      selection  编辑器选中的文本
                     */
                    post: function (cm, icon, cursor, selection) {
//                        cm.replaceSelection("[" + selection + ":testIcon2](" + icon.html() + ")");
//                        console.log("testIcon2 =>", this, icon.html());
                    }
                },
                onload: function () {

                    console.log('onload', this);
                    this.fullscreen();

                    $("#postArticle").on('click', function () {
                        //页面层
                        layer.open({
                            type: 1,
                            title: "完善文章信息",
                            skin: 'layui-layer-rim', //加上边框
                            area: ['50%', '90%'], //宽高
                            content: dynamicContent()
                        });

                        //自定义验证规则
                        // form.verify({
                        //     title: function (value) {
                        //         if (value.length < 5) {
                        //             return '标题至少得5个字符啊';
                        //         }
                        //     },
                        //     password: [/(.+){6,12}$/, '密码必须6到12位'],
                        //     verity: [/(.+){6}$/, '验证码必须是6位'],
                        // });

                        //监听提交
                        form.on('submit(submitArticle)', function (data) {
                            syncPost("article/", data.field, function (result) {
                                layer.msg(result.message);
                            });
                            return false;
                        });

                        //重新渲染form，否则动态生成的content中的元素没有效果
                        form.render();

                        //普通图片上传
                        var uploadInst = upload.render({
                            elem: '#test1'
                            , url: 'upload/blog-pic'
                            , before: function (obj) {
                                //预读本地文件示例，不支持ie8
                                obj.preview(function (index, file, result) {
                                    $('#demo1').attr('src', result); //图片链接（base64）
                                });
                            }
                            , done: function (res) {
                                //如果上传失败
                                if (res.success == 0) {
                                    return layer.msg('上传失败');
                                }
                                //上传成功
                                $("#itemPicture").val(res.id);
                            }
                            , error: function () {
                                //演示失败状态，并实现重传
                                var demoText = $('#demoText');
                                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                                demoText.find('.demo-reload').on('click', function () {
                                    uploadInst.upload();
                                });
                            }
                        });

                    });
                    //this.unwatch();
                    //this.watch().fullscreen();
                    //this.setMarkdown("#PHP");
                    //this.width("100%");
                    //this.height(480);
                    //this.resize("100%", 640);
                }
            });


            var dynamicContent = function () {

                var labelsContent = "";
                var typesContent = "";
                var topicsContent = "";
                var articleContent = editor.getMarkdown();

                //通过ajax获取标签
                asyncGet("article/labels", function (data) {
                    if (data.code == 200) {
                        var length = data.data.length;
                        for (var i = 0; i < length; i++) {
                            labelsContent = labelsContent + "<option value=" + data.data[i].id + ">" + data.data[i].label + "</option>"
                        }
                    }
                });

                //通过ajax获取分类
                asyncGet("article/types", function (data) {
                    if (data.code == 200) {
                        var length = data.data.length;
                        for (var i = 0; i < length; i++) {
                            typesContent = typesContent + "<option value=" + data.data[i].id + ">" + data.data[i].type + "</option>"
                        }
                    }
                });

                //通过ajax获取主题
                asyncGet("article/topics", function (data) {
                    if (data.code == 200) {
                        var length = data.data.length;
                        for (var i = 0; i < length; i++) {
                            topicsContent = topicsContent + "<option value=" + data.data[i].id + ">" + data.data[i].topic + "</option>"
                        }
                    }
                });

                return '<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">\n' +
                    '    <legend>完善文章信息</legend>\n' +
                    '</fieldset>\n' +
                    '\n' +
                    '<div class="site-text site-block" style="width: 90%;height: 90%;">\n' +
                    '\n' +
                    '    <form class="layui-form">\n' +
                    '\n' +
                    '        <div class="layui-form-item">\n' +
                    '            <label class="layui-form-label">文章标题</label>\n' +
                    '            <div class="layui-input-block">\n' +
                    '                <input type="text" name="title" required="" lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">\n' +
                    '            </div>\n' +
                    '        </div>\n' +
                    '\n' +
                    '        <div class="layui-form-item">\n' +
                    '            <label class="layui-form-label">个人标签</label>\n' +
                    '            <div class="layui-input-block">\n' +
                    '                <select name="label" lay-verify="required">\n' +
                    '                    <option value=""></option>\n' + labelsContent +
                    '                </select>\n' +
                    '            </div>\n' +
                    '        </div>\n' +
                    '\n' +
                    '        <div class="layui-form-item">\n' +
                    '            <label class="layui-form-label">文章分类</label>\n' +
                    '            <div class="layui-input-block">\n' +
                    '                <select name="type" lay-verify="required">\n' +
                    '                    <option value=""></option>\n' + typesContent +
                    '                </select>\n' +
                    '            </div>\n' +
                    '        </div>\n' +
                    '\n' +
                    '        <div class="layui-form-item" style="display: none;">\n' +
                    '            <label class="layui-form-label">内容</label>\n' +
                    '            <textarea class="layui-input-block" name="content">\n' + articleContent +
                    '            </textarea>\n' +
                    '        </div>\n' +
                    '\n' +
                    '        <div class="layui-form-item">\n' +
                    '            <label class="layui-form-label">文章主题</label>\n' +
                    '            <div class="layui-input-block">\n' +
                    '                <select name="topic" lay-verify="required">\n' +
                    '                    <option value=""></option>\n' + topicsContent +
                    '                </select>\n' +
                    '            </div>\n' +
                    '        </div>\n' +
                    '\n' +
                    '        <div class="layui-form-item">\n' +
                    '            <label class="layui-form-label">文章标题图</label>\n' +
                    '            <div class="layui-input-block">\n' +
                    '<div class="layui-upload">\n' +
                    '  <button type="button" class="layui-btn" id="test1">上传图片</button>\n' +
                    '  <div class="layui-upload-list">\n' +
                    '    <img class="layui-upload-img" id="demo1" style="width:auto;height:auto;max-width:100%;max-height:100%;">\n' +
                    '    <p id="demoText"></p>\n' +
                    '                   <input type="text" name="itemPicture" id="itemPicture" style="display: none;">\n' +
                    '  </div>\n' +
                    '</div>\n' +
                    '            </div>\n' +
                    '        </div>\n' +
                    '\n' +
                    '        <div class="layui-form-item layui-form-text">\n' +
                    '            <label class="layui-form-label">文章简介</label>\n' +
                    '            <div class="layui-input-block">\n' +
                    '                <textarea name="summary" placeholder="请输入内容" class="layui-textarea"></textarea>\n' +
                    '            </div>\n' +
                    '        </div>\n' +
                    '\n' +
                    '        <div class="layui-form-item">\n' +
                    '            <div class="layui-input-block">\n' +
                    '                <button class="layui-btn" lay-submit="" lay-filter="submitArticle">立即提交</button>\n' +
                    '                <button type="reset" class="layui-btn layui-btn-primary">重置</button>\n' +
                    '            </div>\n' +
                    '        </div>\n' +
                    '\n' +
                    '    </form>\n' +
                    '</div>'
            };

        });

    });
</script>
</html>

