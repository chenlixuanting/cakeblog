/**
 * 同步get请求
 */
var asyncGet = function (url, callback) {
    $.ajax({
        type: "GET",
        url: url,
        //将异步请求转为同步否则，layer会提前渲染导致请求来的数据无法填充
        async: false,
        success: function (result) {
            callback(result);
        }
    });
};

/**
 * 异步post请求
 * @param url
 * @param callback*/
var syncPost = function (url, data, callback) {
    $.ajax({
        type: "POST",
        url: url,
        data: data,
        success: function (result) {
            callback(result);
        }
    });
};