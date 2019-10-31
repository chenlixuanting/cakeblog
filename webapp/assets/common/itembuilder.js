var builder = function (result) {

    var content = '';

    for (var i = 0; i < result.length; i++) {

        //随机获取item的显示样式
        switch (random()) {
            case 1:
                content += "<div class=\"post post-layout-list\" data-aos=\"fade-up\">\n" +
                    "                    <div class=\"status_list_item icon_kyubo\">\n" +
                    "                        <div class=\"status_user\"\n" +
                    "                             style=\"background-image: url(" + result[i].itemPictureUrl + ");\">\n" +
                    "                            <div class=\"status_section\">\n" +
                    "                                <a href=\"article/" + result[i].id + "\" class=\"status_btn\">" + result[i].title + "</a>\n" +
                    "                                <p class=\"section_p\">" + result[i].summary + "</p>\n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "                    </div>\n" +
                    "                </div>";
                break;
            case 2:
                content += "<div class=\"post post-layout-list\" data-aos=\"fade-up\">\n" +
                    "                    <div class=\"postnormal review \">\n" +
                    "                        <div class=\"post-container review-item\">\n" +
                    "                            <div class=\"row review-item-wrapper\">\n" +
                    "                                <div class=\"col-sm-3\">\n" +
                    "                                    <a rel=\"nofollow\" href=\"detail\">\n" +
                    "                                        <div class=\"review-item-img\"\n" +
                    "                                             style=\"background-image: url(" + result[i].itemPictureUrl + ");\"></div>\n" +
                    "                                    </a>\n" +
                    "                                </div>\n" +
                    "                                <div class=\"col-sm-9 flex-xs-middle\">\n" +
                    "                                    <div class=\"review-item-title\">\n" +
                    "                                        <a href=\"article/" + result[i].id + "\" rel=\"bookmark\">" + result[i].title + "</a>\n" +
                    "                                    </div>\n" +
                    "                                    <div class=\"review-item-creator\"><b>发布日期：</b>" + timestamp2Date(result[i].updatetime) + "</div>\n" +
                    "                                    <span class=\"review-item-info\"><b>总浏览量：</b>1203 reads</span>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    "                            <div class=\"review-bg-wrapper\">\n" +
                    "                                <div class=\"bg-blur\"\n" +
                    "                                     style=\"background-image: url(" + result[i].itemPictureUrl + ");\"></div>\n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "                        <div class=\"post-container\">\n" +
                    "                            <div class=\"entry-content\">\n" + result[i].summary +
                    "                            </div>\n" +
                    "                            <div class=\"post-footer\">\n" +
                    "                                <a class=\"gaz-btn primary\" href=\"\">READ MORE</a>\n" +
                    "                                <span class=\"total-comments-on-post pull-right\"><a href=\"\">31 Comments</a></span>\n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "                    </div>\n" +
                    "                </div>";
                break;
            case 3:
                content += " <div class=\"post post-layout-list js-gallery\" data-aos=\"fade-up\">\n" +
                    "                    <div class=\"post-album\">\n" +
                    "                        <div class=\"row content\">\n" +
                    "                            <div class=\"bg\"\n" +
                    "                                 style=\"background-image: url(" + result[i].itemPictureUrl + ");\"></div>\n" +
                    "                            <div class=\"contentext flex-xs-middle\">\n" +
                    "                                <div class=\"album-title\">\n" +
                    "                                    <a href=\"article/" + result[i].id + "\">" + result[i].title + "</a>\n" +
                    "                                </div>\n" +
                    "                                <h5 class=\"review-item-creator\"><b>发布日期：</b>" + timestamp2Date(result[i].updatetime) + "</h5>\n" +
                    "                                <div class=\"album-content\">" + result[i].summary + "</div>\n" +
                    "                            </div>\n" +
                    "                            <div class=\"album-thumb-width flex-xs-middle\">\n" +
                    "                                <div class=\"row album-thumb no-gutter\">\n" +
                    "                                    <div class=\"col-xs-4\"><img class=\"thumb\"\n" +
                    "                                                               src=\"assets/user/statics/images/IMG_0150-250x250.jpg\"/>\n" +
                    "                                    </div>\n" +
                    "                                    <div class=\"col-xs-4\"><img class=\"thumb\"\n" +
                    "                                                               src=\"assets/user/statics/images/IMG_0149-250x250.jpg\"/>\n" +
                    "                                    </div>\n" +
                    "                                    <div class=\"col-xs-4\"><img class=\"thumb\"\n" +
                    "                                                               src=\"assets/user/statics/images/IMG_0146-250x250.jpg\"/>\n" +
                    "                                    </div>\n" +
                    "                                    <div class=\"col-xs-4\"><img class=\"thumb\"\n" +
                    "                                                               src=\"assets/user/statics/images/IMG_0147-250x250.jpg\"/>\n" +
                    "                                    </div>\n" +
                    "                                    <div class=\"col-xs-4\"><img class=\"thumb\"\n" +
                    "                                                               src=\"assets/user/statics/images/IMG_0148-250x250.jpg\"/>\n" +
                    "                                    </div>\n" +
                    "                                    <div class=\"col-xs-4\">\n" +
                    "                                        <a href=\"\">5 pics</a>\n" +
                    "                                    </div>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "                    </div>\n" +
                    "                </div>";
                break;
            default:
        }
    }

    return content;
};

var random = function () {
    return Math.ceil(Math.random() * 3);      // 获取从1到10的随机整数 ，取0的概率极小
};

