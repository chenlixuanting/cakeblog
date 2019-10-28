function timestamp2Date(timestamp) {
    var oldTime = (new Date(timestamp)).getTime();
    var curTime = new Date(oldTime).format("yyyy-MM-dd");
    return curTime;
}